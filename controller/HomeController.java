package controller;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

import AppsDriver.BankApplication;
import connection.Koneksi;
import model.Transaction;
import model.User;
import view.HomeUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeController implements ActionListener{
    
    private BankApplication main = new BankApplication();
    private HomeUI home;
    private User user;
    private Transaction transaction;
    private boolean cek;
    DefaultTableModel model = new DefaultTableModel();

    public HomeController(HomeUI home){
        this.home = home;  
        
        user = new User();
        transaction = new Transaction();
        user.getUser(SigninController.getUsername(),SigninController.getPin());
        model = (DefaultTableModel) home.getMainTable().getModel();
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == home.getBtnLogOut()) {
            home.dispose();
            main.main(null);
        }
        else if (e.getSource() == home.getBtnAccount()) {
            user.getUser(SigninController.getUsername(),SigninController.getPin());
            home.getlblNoRek().setText(user.getRekening());
            home.getlblUsernameACC().setText(user.getUsername());
            home.getLblMainBalancePanel().setText("Rp " + user.getSaldo());
            home.getMainTable();
            model.setRowCount(0);
            try {
                ResultSet rs = transaction.setActivityData(user.getIdAcc());
                while (rs.next()) {
                    String[] rows = {rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4)};
                    model.addRow(rows);              
                }
                home.getMainTable().setModel(model);
                
            } catch (Exception er) {
                System.out.println(er);
                // TODO: handle exception
            }
            
            home.getlayeredPane().removeAll();
            home.getlayeredPane().add(home.getmainDetails());
            home.getlayeredPane().repaint();
            home.getlayeredPane().revalidate();
            home.getlblBank().setText("AKUN");
            home.getheader().add(home.getlblBank());
            home.gettransferTo().setText("");
            home.getTxtAmountTo().setText("");
            home.getTxtDescription().setText("");
            home.getTxtDepositAmount().setText("");
            home.getTxtWithdrawAmount().setText("");
        }
        else if (e.getSource() == home.getBtnHome()) {
            home.getlayeredPane().removeAll();
            home.getlayeredPane().add(home.gethomePanel());
            home.getlayeredPane().repaint();
            home.getlayeredPane().revalidate();
            home.getlblBank().setText("MY BANK");
            home.getheader().add(home.getlblBank());
            home.gettransferTo().setText("");
            home.getTxtAmountTo().setText("");
            home.getTxtDescription().setText("");
            home.getTxtDepositAmount().setText("");
            home.getTxtWithdrawAmount().setText("");
            model.setRowCount(0);
        }
        else if (e.getSource() == home.getBtnTransfer()) {
            home.getlayeredPane().removeAll();
            home.getlayeredPane().add(home.gettransferPanel());
            home.getlayeredPane().repaint();
            home.getlayeredPane().revalidate();
            home.getlblBank().setText("TRANSFER");
            home.getheader().add(home.getlblBank());
            home.getTxtDepositAmount().setText("");
            home.getTxtWithdrawAmount().setText("");
            model.setRowCount(0);
            
        }
        else if (e.getSource() == home.getBtnDeposit()) {            
            home.getlayeredPane().removeAll();
            home.getlayeredPane().add(home.getdepositPanel());
            home.getlayeredPane().repaint();
            home.getlayeredPane().revalidate();
            home.getlblBank().setText("SETOR TUNAI");
            home.getheader().add(home.getlblBank());
            home.getTxtAmountTo().setText("");
            home.gettransferTo().setText("");
            home.getTxtDescription().setText("");
            home.getTxtWithdrawAmount().setText("");
            model.setRowCount(0);
            
        }
        else if (e.getSource() == home.getBtnWithdraw()) {
            home.getlayeredPane().removeAll();
            home.getlayeredPane().add(home.getwithdrawPanel());
            home.getlayeredPane().repaint();
            home.getlayeredPane().revalidate();
            home.getlblBank().setText("TARIK TUNAI");
            home.getheader().add(home.getlblBank());
            home.gettransferTo().setText("");
            home.getTxtAmountTo().setText("");
            home.getTxtDescription().setText("");
            home.getTxtDepositAmount().setText("");
            model.setRowCount(0);
            
        }
        else if (e.getSource() == home.getBtnDepositTo()) {
            int deposit = Integer.parseInt(home.getTxtDepositAmount().getText());
            transaction.Deposit(SigninController.getUsername(), deposit, user.getSaldo());
            transaction.TransactionData(user.getIdAcc(), home.getBtnDepositTo().getText(), deposit, "");
            JOptionPane.showMessageDialog(home, "Setor Tunai Berhasil", "Info", JOptionPane.INFORMATION_MESSAGE);
            home.getTxtDepositAmount().setText("");
            model.setRowCount(0);
            
        }
        else if (e.getSource() == home.getBtnTransferPanel()) {
            int amount = Integer.parseInt(home.getTxtAmountTo().getText());
            int rekening = Integer.parseInt(home.gettransferTo().getText());
            String description = home.getTxtDescription().getText();

            if (amount >= user.getSaldo() || user.getSaldo() <= 50000 || (user.getSaldo()-amount)<50000) {
                JOptionPane.showMessageDialog(home, "Saldo Tidak Mencukupi", "WARNING", JOptionPane.WARNING_MESSAGE);
                home.getTxtAmountTo().setText("");
                home.gettransferTo().setText("");
                home.getTxtDescription().setText("");
                
            }else {
                transaction.Transfer(SigninController.getUsername(), rekening, amount, user.getSaldo());
                transaction.TransactionData(user.getIdAcc(), home.getBtnTransferPanel().getText(), amount, "To: " + rekening +" : "+ description);
                JOptionPane.showMessageDialog(home, "Transfer Berhasil", "Info", JOptionPane.INFORMATION_MESSAGE);
                home.getTxtAmountTo().setText("");
                home.gettransferTo().setText("");
                home.getTxtDescription().setText("");
                
            }
            model.setRowCount(0);
            
        }
        else if (e.getSource() == home.getBtnWithdrawFrom()) {
            int amount = Integer.parseInt(home.getTxtWithdrawAmount().getText());

            if (amount >= user.getSaldo() || user.getSaldo() <= 50000 || (user.getSaldo()-amount)<50000) {
                JOptionPane.showMessageDialog(home, "Saldo Tidak Mencukupi", "WARNING", JOptionPane.WARNING_MESSAGE);
                home.getTxtWithdrawAmount().setText("");
                
            }else {
                transaction.Withdraw(SigninController.getUsername(), amount, user.getSaldo());
                transaction.TransactionData(user.getIdAcc(), home.getBtnWithdrawFrom().getText(), amount, "");
                JOptionPane.showMessageDialog(home, "Tarik Tunai Berhasil", "Info", JOptionPane.INFORMATION_MESSAGE);
                home.getTxtWithdrawAmount().setText("");

            }
            model.setRowCount(0);
            
        }
    }
}
