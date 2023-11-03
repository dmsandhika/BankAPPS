package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SigninController;
import model.btnPinModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class SignInUI extends JFrame {

	private btnPinModel btnModel;
	private JPanel contentPane;
	private JButton btnSignIn;
	private JButton btnSignUp;
	private JLabel lblUsernameSignIn;
	private JTextField txtUsernameSignIn;
	private JLabel lblPinNumberSignIn;
	private JTextField txtPin1SignIn;
	private JTextField txtPin2SignIn;
	private JTextField txtPin3SignIn;
	private JTextField txtPin4SignIn;
	private JButton btnPin1;
	private JButton btnPin2;
	private JButton btnPin3;
	private JButton btnPin4;
	private JButton btnPin5;
	private JButton btnPin6;
	private JButton btnPin7;
	private JButton btnPin8;
	private JButton btnPin9;
	private JButton btnPin10;
	private JButton btnReset;

	public JButton getBtnReset() {
		return btnReset;
	}

	public JTextField getTxtUsernameSignIn() {
		return txtUsernameSignIn;
	}

	public JTextField getTxtPin1SignIn() {
		return txtPin1SignIn;
	}

	public JTextField getTxtPin2SignIn() {
		return txtPin2SignIn;
	}

	public JTextField getTxtPin3SignIn() {
		return txtPin3SignIn;
	}

	public JTextField getTxtPin4SignIn() {
		return txtPin4SignIn;
	}

	public JButton getBtnPin1() {
		return btnPin1;
	}

	public JButton getBtnPin2() {
		return btnPin2;
	}

	public JButton getBtnPin3() {
		return btnPin3;
	}

	public JButton getBtnPin4() {
		return btnPin4;
	}

	public JButton getBtnPin5() {
		return btnPin5;
	}

	public JButton getBtnPin6() {
		return btnPin6;
	}

	public JButton getBtnPin7() {
		return btnPin7;
	}

	public JButton getBtnPin8() {
		return btnPin8;
	}

	public JButton getBtnPin9() {
		return btnPin9;
	}

	public JButton getBtnPin10() {
		return btnPin10;
	}

	public JButton getBtnSignIn() {
		return btnSignIn;
	}

	public JButton getBtnSignUp() {
		return btnSignUp;
	}

	public void registerListener(SigninController controller){
		btnSignIn.addActionListener(controller);
		btnSignUp.addActionListener(controller);
		btnPin1.addActionListener(controller);
		btnPin2.addActionListener(controller);
		btnPin3.addActionListener(controller);
		btnPin4.addActionListener(controller);
		btnPin5.addActionListener(controller);
		btnPin6.addActionListener(controller);
		btnPin7.addActionListener(controller);
		btnPin8.addActionListener(controller);
		btnPin9.addActionListener(controller);
		btnPin10.addActionListener(controller);
		btnReset.addActionListener(controller);
	}

	public void setTfPinSignIn(){
		if (txtPin1SignIn.getText().equals("")) {
			txtPin1SignIn.setText(btnModel.getTx());
		}
		else if (txtPin2SignIn.getText().equals("")) {
			txtPin2SignIn.setText(btnModel.getTx());
		}
		else if (txtPin3SignIn.getText().equals("")) {
			txtPin3SignIn.setText(btnModel.getTx());
		}
		else if (txtPin4SignIn.getText().equals("")) {
			txtPin4SignIn.setText(btnModel.getTx());
		}
	}

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				SignInUI frame = new SignInUI();
	// 				frame.setVisible(true);
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }

	/**
	 * Create the frame.
	 */
	public SignInUI(btnPinModel btnModel) {

		this.btnModel = btnModel;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrandLogo = new JLabel("");
		lblBrandLogo.setHorizontalAlignment(SwingConstants.CENTER);
		// lblBrandLogo.setIcon(new ImageIcon(SignInUI.class.getResource("/brandLogo.png")));
		lblBrandLogo.setBounds(173, 28, 75, 59);
		contentPane.add(lblBrandLogo);
		
		JLabel lblApplicationName = new JLabel("Banking Applicaton");
		lblApplicationName.setHorizontalAlignment(SwingConstants.CENTER);
		lblApplicationName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblApplicationName.setBounds(125, 100, 171, 34);
		contentPane.add(lblApplicationName);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.setBackground(Color.LIGHT_GRAY);
		btnSignIn.setBounds(125, 420, 163, 51);
		contentPane.add(btnSignIn);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBackground(Color.LIGHT_GRAY);
		btnSignUp.setBounds(125, 480, 163, 51);
		contentPane.add(btnSignUp);
		
		JLabel lblCopyRight = new JLabel("WELCOME TO MY BANK");
		lblCopyRight.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyRight.setBounds(104, 562, 220, 16);
		contentPane.add(lblCopyRight);
		
		lblUsernameSignIn = new JLabel("Username:");
		lblUsernameSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsernameSignIn.setBounds(87, 147, 85, 16);
		contentPane.add(lblUsernameSignIn);
		
		txtUsernameSignIn = new JTextField();
		txtUsernameSignIn.setColumns(10);
		txtUsernameSignIn.setBounds(184, 147, 140, 22);
		contentPane.add(txtUsernameSignIn);
		
		lblPinNumberSignIn = new JLabel("Pin number:");
		lblPinNumberSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinNumberSignIn.setBounds(87, 190, 85, 16);
		contentPane.add(lblPinNumberSignIn);
		
		txtPin1SignIn = new JTextField();
		txtPin1SignIn.setEditable(false);
		txtPin1SignIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtPin1SignIn.setColumns(10);
		txtPin1SignIn.setBackground(Color.LIGHT_GRAY);
		txtPin1SignIn.setBounds(184, 190, 26, 22);
		contentPane.add(txtPin1SignIn);
		
		txtPin2SignIn = new JTextField();
		txtPin2SignIn.setEditable(false);
		txtPin2SignIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtPin2SignIn.setColumns(10);
		txtPin2SignIn.setBackground(Color.LIGHT_GRAY);
		txtPin2SignIn.setBounds(222, 190, 26, 22);
		contentPane.add(txtPin2SignIn);
		
		txtPin3SignIn = new JTextField();
		txtPin3SignIn.setEditable(false);
		txtPin3SignIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtPin3SignIn.setColumns(10);
		txtPin3SignIn.setBackground(Color.LIGHT_GRAY);
		txtPin3SignIn.setBounds(260, 190, 26, 22);
		contentPane.add(txtPin3SignIn);
		
		txtPin4SignIn = new JTextField();
		txtPin4SignIn.setEditable(false);
		txtPin4SignIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtPin4SignIn.setColumns(10);
		txtPin4SignIn.setBackground(Color.LIGHT_GRAY);
		txtPin4SignIn.setBounds(298, 190, 26, 22);
		contentPane.add(txtPin4SignIn);

		btnPin1 = new JButton("1");
		btnPin1.setBackground(Color.LIGHT_GRAY);
		btnPin1.setBounds(133, 238, 47, 34);
		contentPane.add(btnPin1);
		
		btnPin2 = new JButton("2");
		btnPin2.setBackground(Color.LIGHT_GRAY);
		btnPin2.setBounds(183, 238, 47, 34);
		contentPane.add(btnPin2);
		
		btnPin3 = new JButton("3");
		btnPin3.setBackground(Color.LIGHT_GRAY);
		btnPin3.setBounds(233, 238, 47, 34);
		contentPane.add(btnPin3);
		
		btnPin4 = new JButton("4");
		btnPin4.setBackground(Color.LIGHT_GRAY);
		btnPin4.setBounds(133, 272, 47, 34);
		contentPane.add(btnPin4);
		
		btnPin5 = new JButton("5");
		btnPin5.setBackground(Color.LIGHT_GRAY);
		btnPin5.setBounds(183, 272, 47, 34);
		contentPane.add(btnPin5);
		
		btnPin6 = new JButton("6");
		btnPin6.setBackground(Color.LIGHT_GRAY);
		btnPin6.setBounds(233, 272, 47, 34);
		contentPane.add(btnPin6);
		
		btnPin7 = new JButton("7");
		btnPin7.setBackground(Color.LIGHT_GRAY);
		btnPin7.setBounds(133, 306, 47, 34);
		contentPane.add(btnPin7);
		
		btnPin8 = new JButton("8");
		btnPin8.setBackground(Color.LIGHT_GRAY);
		btnPin8.setBounds(183, 306, 47, 34);
		contentPane.add(btnPin8);
		
		btnPin9 = new JButton("9");
		btnPin9.setBackground(Color.LIGHT_GRAY);
		btnPin9.setBounds(233, 306, 47, 34);
		contentPane.add(btnPin9);
		
		btnPin10 = new JButton("0");
		btnPin10.setBackground(Color.LIGHT_GRAY);
		btnPin10.setBounds(183, 340, 47, 34);
		contentPane.add(btnPin10);
		
		btnReset = new JButton("Reset");
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(Color.GRAY);
		btnReset.setBounds(160, 385, 97, 25);
		contentPane.add(btnReset);
	}
}
