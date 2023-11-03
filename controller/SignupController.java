package controller;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import AppsDriver.BankApplication;
import model.User;
import model.btnPinModel;
import view.SignInUI;
import view.SignUpUI;

import java.awt.event.ActionEvent;

public class SignupController implements ActionListener{
    
    private SignUpUI signup;
    private btnPinModel btnModel;
    private BankApplication main = new BankApplication();

    public SignupController (SignUpUI signup, btnPinModel btnModel){
        this.signup = signup;
        this.btnModel = btnModel;
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == signup.getBtnBack()) {
            signup.setVisible(false);
            main.main(null);
        }
        else if (e.getSource() == signup.getBtnPinNo1()) {
            String pinNo = signup.getBtnPinNo1().getText();
            btnModel.setTx(pinNo);
            signup.setTfPinSignUp();
        }
        else if (e.getSource() == signup.getBtnPinNo2()) {
            String pinNo = signup.getBtnPinNo2().getText();
            btnModel.setTx(pinNo);
            signup.setTfPinSignUp();
        }
        else if (e.getSource() == signup.getBtnPinNo3()) {
            String pinNo = signup.getBtnPinNo3().getText();
            btnModel.setTx(pinNo);
            signup.setTfPinSignUp();
            
        }
        else if (e.getSource() == signup.getBtnPinNo4()) {
            String pinNo = signup.getBtnPinNo4().getText();
            btnModel.setTx(pinNo);
            signup.setTfPinSignUp();
            
        }
        else if (e.getSource() == signup.getBtnPinNo5()) {
            String pinNo = signup.getBtnPinNo5().getText();
            btnModel.setTx(pinNo);
            signup.setTfPinSignUp();
            
        }
        else if (e.getSource() == signup.getBtnPinNo6()) {
            String pinNo = signup.getBtnPinNo6().getText();
            btnModel.setTx(pinNo);
            signup.setTfPinSignUp();
            
        }
        else if (e.getSource() == signup.getBtnPinNo7()) {
            String pinNo = signup.getBtnPinNo7().getText();
            btnModel.setTx(pinNo);
            signup.setTfPinSignUp();
            
        }
        else if (e.getSource() == signup.getBtnPinNo8()) {
            String pinNo = signup.getBtnPinNo8().getText();
            btnModel.setTx(pinNo);
            signup.setTfPinSignUp();
            
        }
        else if (e.getSource() == signup.getBtnPinNo9()) {
            String pinNo = signup.getBtnPinNo9().getText();
            btnModel.setTx(pinNo);
            signup.setTfPinSignUp();
            
        }
        else if (e.getSource() == signup.getBtnPinNo0()) {
            String pinNo = signup.getBtnPinNo0().getText();
            btnModel.setTx(pinNo);
            signup.setTfPinSignUp();
            
        }
        else if (e.getSource() == signup.getBtnReset()) {
            signup.getTxtFieldUsername().setText(null);
            signup.getTxtFieldPinNo1().setText(null);
            signup.getTxtFieldPinNo2().setText(null);
            signup.getTxtFieldPinNo3().setText(null);
            signup.getTxtFieldPinNo4().setText(null);
        }
        else if (e.getSource() == signup.getBtnSignUp()) {
            
            String username = signup.getTxtFieldUsername().getText();
            String pin = signup.getTxtFieldPinNo1().getText() + signup.getTxtFieldPinNo2().getText() + signup.getTxtFieldPinNo3().getText() +
                         signup.getTxtFieldPinNo4().getText();  
            int pinAcc = 0;
            try {
                if (username.equals("") || pin.equals("")) {
                    JOptionPane.showMessageDialog(signup, "Masukkan Username dan Pin", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else if (username.length()<=3) {
                    JOptionPane.showMessageDialog(signup, "Masukkan Username Minimal 4 Karakter", "ERROR", JOptionPane.ERROR_MESSAGE);            
                }
                else if (username == "" || pin.length()<=3) {
                    JOptionPane.showMessageDialog(signup, "Data Tidak Lengkap", "ERROR", JOptionPane.ERROR_MESSAGE);            
                    
                }
                else {
                    User user = new User();
                    pinAcc = Integer.parseInt(pin);
                    user.setUser(username, pinAcc);
                    if (user.getYes()==true) {
                        JOptionPane.showMessageDialog(signup, "Informasi Berhasil Disimpan", "Info Message", JOptionPane.INFORMATION_MESSAGE);
                        signup.setVisible(false);
                        main.main(null);
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(signup, "Username Sudah Ada", "Warning", JOptionPane.WARNING_MESSAGE);
                        signup.getTxtFieldUsername().setText(null);
                        signup.getTxtFieldPinNo1().setText(null);
                        signup.getTxtFieldPinNo2().setText(null);
                        signup.getTxtFieldPinNo3().setText(null);
                        signup.getTxtFieldPinNo4().setText(null);
                    }
                }
            } catch (Exception er) {
                JOptionPane.showMessageDialog(signup, er, "ERROR", JOptionPane.WARNING_MESSAGE);
                // TODO: handle exception
            }

        }
    }
}
