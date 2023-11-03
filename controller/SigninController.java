package controller;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

import javax.swing.*;

import connection.Koneksi;
import view.HomeUI;
import view.SignInUI;
import view.SignUpUI;
import model.User;
import model.btnPinModel;

public class SigninController implements ActionListener{

    private btnPinModel btnModel;
    private SignInUI view;  
    private HomeUI home;
    private SignUpUI signup;
    private HomeController homeCont;
    private SignupController signupCont;
    private static String username;
    private static int pin;

    public static String getUsername(){
        return username;
    }
    public static Integer getPin(){
        return pin;
    }

    public SigninController(SignInUI view, HomeUI home, SignUpUI signup, btnPinModel btnModel){
        this.view = view;   
        this.home = home;
        this.signup = signup; 
        this.btnModel = btnModel;
        homeCont = new HomeController(home);
        signupCont = new SignupController(signup, btnModel);
    }

    public void actionPerformed (ActionEvent e){
        if (e.getSource() == view.getBtnSignIn()) {
            username = view.getTxtUsernameSignIn().getText();
            String pin = view.getTxtPin1SignIn().getText() + view.getTxtPin2SignIn().getText() + view.getTxtPin3SignIn().getText() +
            view.getTxtPin4SignIn().getText();
            int pinACC = 0;
        
            if (username == "" || pin == "") {
                JOptionPane.showMessageDialog(view, "Masukkan Username dan Pin Anda", "ERROR",JOptionPane.WARNING_MESSAGE);

                view.getTxtUsernameSignIn().setText(null);
                view.getTxtPin1SignIn().setText(null);
                view.getTxtPin2SignIn().setText(null);
                view.getTxtPin3SignIn().setText(null);
                view.getTxtPin4SignIn().setText(null);
            }
            else if (pin == "" || pin.length()<4) {
                JOptionPane.showMessageDialog(view, "       Data Tidak Lengkap", "ERROR",JOptionPane.WARNING_MESSAGE);
                
                view.getTxtUsernameSignIn().setText(null);
                view.getTxtPin1SignIn().setText(null);
                view.getTxtPin2SignIn().setText(null);
                view.getTxtPin3SignIn().setText(null);
                view.getTxtPin4SignIn().setText(null);
            }
            else{
                User user = new User();
                pinACC = Integer.parseInt(pin);
                user.getUser(username, pinACC);
                if (user.getYes()==true) {
                    username = user.getUsername();
                    this.pin = pinACC;
                    view.dispose();
                    home.getLblNameValue().setText(user.getUsername());
                    home.getLblIdValue().setText(user.getRekening());
                    home.setVisible(true);
                    home.setResizable(false);
                    home.setLocationRelativeTo(null);
                }
                else{
                    JOptionPane.showMessageDialog(view, "  Username Atau Pin salah", "ERROR",JOptionPane.ERROR_MESSAGE);
                    
                    view.getTxtUsernameSignIn().setText(null);
                    view.getTxtPin1SignIn().setText(null);
                    view.getTxtPin2SignIn().setText(null);
                    view.getTxtPin3SignIn().setText(null);
                    view.getTxtPin4SignIn().setText(null);
                }
            }

            home.registerListenerHome(homeCont);
        }
        else if (e.getSource() == view.getBtnPin1()) {
            String pinNo = view.getBtnPin1().getText();
            btnModel.setTx(pinNo);
            view.setTfPinSignIn();
        }
        else if (e.getSource() == view.getBtnPin2()) {
            String pinNo = view.getBtnPin2().getText();
            btnModel.setTx(pinNo);
            view.setTfPinSignIn();
        }
        else if (e.getSource() == view.getBtnPin3()) {
            String pinNo = view.getBtnPin3().getText();
            btnModel.setTx(pinNo);
            view.setTfPinSignIn();
            
        }
        else if (e.getSource() == view.getBtnPin4()) {
            String pinNo = view.getBtnPin4().getText();
            btnModel.setTx(pinNo);
            view.setTfPinSignIn();
            
        }
        else if (e.getSource() == view.getBtnPin5()) {
            String pinNo = view.getBtnPin5().getText();
            btnModel.setTx(pinNo);
            view.setTfPinSignIn();
            
        }
        else if (e.getSource() == view.getBtnPin6()) {
            String pinNo = view.getBtnPin6().getText();
            btnModel.setTx(pinNo);
            view.setTfPinSignIn();
            
        }
        else if (e.getSource() == view.getBtnPin7()) {
            String pinNo = view.getBtnPin7().getText();
            btnModel.setTx(pinNo);
            view.setTfPinSignIn();
            
        }
        else if (e.getSource() == view.getBtnPin8()) {
            String pinNo = view.getBtnPin8().getText();
            btnModel.setTx(pinNo);
            view.setTfPinSignIn();
            
        }
        else if (e.getSource() == view.getBtnPin9()) {
            String pinNo = view.getBtnPin9().getText();
            btnModel.setTx(pinNo);
            view.setTfPinSignIn();
            
        }
        else if (e.getSource() == view.getBtnPin10()) {
            String pinNo = view.getBtnPin10().getText();
            btnModel.setTx(pinNo);
            view.setTfPinSignIn();
            
        }
        else if (e.getSource() == view.getBtnReset()) {
            view.getTxtUsernameSignIn().setText(null);
            view.getTxtPin1SignIn().setText(null);
            view.getTxtPin2SignIn().setText(null);
            view.getTxtPin3SignIn().setText(null);
            view.getTxtPin4SignIn().setText(null);
        }
        else if (e.getSource() == view.getBtnSignUp()) {
            view.setVisible(false);
            signup.setVisible(true);
            signup.setResizable(false);
            signup.setLocationRelativeTo(null);

            signup.registerListenerSignUp(signupCont);
        }
    }
}
