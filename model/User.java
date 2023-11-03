package model;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.CellEditor;
import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import connection.Koneksi;

public class User {

    private boolean yes;
    private String username, pin, rekening;
    private int saldo, id_acc;
    private Connection conn;

    public Boolean getYes(){
        return yes;
    }

    public String getUsername(){
        return username;
    }

    public String getpin(){
        return pin;
    }

    public String getRekening(){
        return rekening;
    }

    public Integer getSaldo(){
        return saldo;
    }

    public int getIdAcc(){
        return id_acc;
    }

    public User(){
        try {
            conn = Koneksi.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "WARNING", JOptionPane.WARNING_MESSAGE);
            // TODO: handle exception
        }
    }

    public void setUser(String username, int pin){

        Random random = new Random();
        String setRek = "";
        int rekening;

        for (int i = 0; i <= 8; i++) {
            setRek += Integer.toString(1+random.nextInt(7));
        }

        rekening = Integer.parseInt(setRek);

        try {

            String select = "select *from acc_table where username=?";
            String insertAcc = "insert into acc_table (id_acc,username,pin,noRek,saldo) values (?,?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(insertAcc);
            PreparedStatement stmtCekUsername = conn.prepareStatement(select);
            stmtCekUsername.setString(1, username);
            ResultSet resultSet = stmtCekUsername.executeQuery();


            if (resultSet.next()) {
                this.yes = false;                                        
            }
            else{
                stmt.setInt(1, 0);
                stmt.setString(2, username);
                stmt.setInt(3, pin);
                stmt.setInt(4, rekening);
                stmt.setInt(5, 0);
                
                stmt.executeUpdate();
                // stmt.close();
                this.yes = true;

            }
            // conn.close();
        

            
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }

    }

    public void getUser(String username, int pin){
        try {
            String select = "select *from acc_table where username=? and pin=?";
            PreparedStatement stmt = conn.prepareStatement(select);
            stmt.setString(1, username);
            stmt.setInt(2, pin);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                this.username = resultSet.getString("username");
                this.pin = Integer.toString(resultSet.getInt("pin"));
                this.rekening = Integer.toString(resultSet.getInt("noRek"));
                this.saldo = resultSet.getInt("saldo");
                this.id_acc = resultSet.getInt("id_acc");
                this.yes = true;
            }

            // conn.close();
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
        
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUser("suiiii", 2222);
    }
}
