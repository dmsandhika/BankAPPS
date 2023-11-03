package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import connection.Koneksi;

public class Transaction extends User{
    private Connection conn;

    public Transaction(){
        try {
            conn = Koneksi.getConnection();    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "WARNING", JOptionPane.WARNING_MESSAGE);
            // TODO: handle exception
        }
    }

    public ResultSet setActivityData(int id_acc) throws Exception{
       
        String select = "select type, Date, Amount, description from transaction where id_acc=?" ;
        PreparedStatement stmt = conn.prepareStatement(select);
        stmt.setInt(1, id_acc);
        ResultSet resultSet = stmt.executeQuery();  
        return resultSet;
    }

    public void TransactionData(int id_acc, String type, int amount, String description){
        try {
            Date thisDate = new Date();
            SimpleDateFormat dateForm = new SimpleDateFormat("hh:mma-dd/MM/YY");
            String todayDate = dateForm.format(thisDate);

            String insertActivity = "insert into transaction (id_transaction, id_acc, type, Date, Amount, description) values (?,?,?,?,?,?)";
            PreparedStatement stmtInsert = conn.prepareStatement(insertActivity);
            stmtInsert.setInt(1, 0);
            stmtInsert.setInt(2, id_acc);
            stmtInsert.setString(3, type);
            stmtInsert.setString(4, todayDate);
            stmtInsert.setInt(5, amount);
            stmtInsert.setString(6, description);

            stmtInsert.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }

    public void Deposit(String username, int amount, int currSaldo){
        try {
            String UdateBalance = "Update acc_table set saldo=? where username=?";
            PreparedStatement stmtSetSaldo = conn.prepareStatement(UdateBalance);            
            
            stmtSetSaldo.setInt(1, currSaldo + amount);
            stmtSetSaldo.setString(2, username);
            
            stmtSetSaldo.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }
    
    public void Transfer(String username, int rekening, int amount, int userSaldo){
        try {
            int targetSaldo = 0;
            String getTargetSaldo = "select saldo from acc_table where noRek=?";
            String UpdateTargetBalance = "update acc_table set saldo=? where noRek=?";
            
            String UpdateAccBalance = "update acc_table set saldo=? where username=?";
            
            PreparedStatement stmtUpdateAccBalance = conn.prepareStatement(UpdateAccBalance);
            
            PreparedStatement stmtGetTargetSaldo = conn.prepareStatement(getTargetSaldo);
            stmtGetTargetSaldo.setInt(1, rekening);
            ResultSet resultSet = stmtGetTargetSaldo.executeQuery();
            PreparedStatement stmtTransfer = conn.prepareStatement(UpdateTargetBalance);
            
            
            if (resultSet.next()) {
                stmtUpdateAccBalance.setInt(1, userSaldo - amount);
                stmtUpdateAccBalance.setString(2, username);
                
                stmtUpdateAccBalance.executeUpdate();

                targetSaldo = resultSet.getInt("saldo");
                stmtTransfer.setInt(1, targetSaldo + amount);
                stmtTransfer.setInt(2, rekening);
    
                stmtTransfer.executeUpdate();
                
            }

        } catch (Exception e) {
            System.out.println(e);  
            // TODO: handle exception
        }
    }

    public void Withdraw(String username, int amount, int currSaldo){
        try {
            
            String UdateBalance = "Update acc_table set saldo=? where username=?";
                    
            PreparedStatement stmtSetSaldo = conn.prepareStatement(UdateBalance);
                
            stmtSetSaldo.setInt(1, currSaldo - amount);
            stmtSetSaldo.setString(2, username);
    
            stmtSetSaldo.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR, Trasfer Gagal", "WARNING", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
            // TODO: handle exception
        }
        
    }
    public static void main(String[] args) {
        Transaction transaction = new Transaction();
    }
}
