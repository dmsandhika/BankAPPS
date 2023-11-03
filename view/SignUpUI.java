package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SignupController;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SignUpUI extends JFrame {

	private btnPinModel btnModel;
	private JPanel contentPane;
	private JTextField txtFieldUsername;
	private JTextField txtFieldPinNo1;
	private JTextField txtFieldPinNo2;
	private JTextField txtFieldPinNo3;
	private JTextField txtFieldPinNo4;
	private JButton btnBack;
	private JButton btnSignUp;
	private JButton btnPinNo1;
	private JButton btnPinNo2;
	private JButton btnPinNo3;
	private JButton btnPinNo4;
	private JButton btnPinNo5;
	private JButton btnPinNo6;
	private JButton btnPinNo7;
	private JButton btnPinNo8;
	private JButton btnPinNo9;
	private JButton btnPinNo0;
	private JButton btnReset;
	private JLabel lblShowError;
	
	public JButton getBtnReset() {
		return btnReset;
	}

	public JButton getBtnPinNo1() {
		return btnPinNo1;
	}

	public JButton getBtnPinNo2() {
		return btnPinNo2;
	}

	public JButton getBtnPinNo3() {
		return btnPinNo3;
	}

	public JButton getBtnPinNo4() {
		return btnPinNo4;
	}

	public JButton getBtnPinNo5() {
		return btnPinNo5;
	}

	public JButton getBtnPinNo6() {
		return btnPinNo6;
	}

	public JButton getBtnPinNo7() {
		return btnPinNo7;
	}

	public JButton getBtnPinNo8() {
		return btnPinNo8;
	}

	public JButton getBtnPinNo9() {
		return btnPinNo9;
	}

	public JButton getBtnPinNo0() {
		return btnPinNo0;
	}

	public JTextField getTxtFieldUsername() {
		return txtFieldUsername;
	}

	public JTextField getTxtFieldPinNo1() {
		return txtFieldPinNo1;
	}

	public JTextField getTxtFieldPinNo2() {
		return txtFieldPinNo2;
	}

	public JTextField getTxtFieldPinNo3() {
		return txtFieldPinNo3;
	}

	public JTextField getTxtFieldPinNo4() {
		return txtFieldPinNo4;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnSignUp() {
		return btnSignUp;
	}

	public void registerListenerSignUp(SignupController signupCont){
		btnSignUp.addActionListener(signupCont);
		btnBack.addActionListener(signupCont);
		btnPinNo0.addActionListener(signupCont);
		btnPinNo1.addActionListener(signupCont);
		btnPinNo2.addActionListener(signupCont);
		btnPinNo3.addActionListener(signupCont);
		btnPinNo4.addActionListener(signupCont);
		btnPinNo5.addActionListener(signupCont);
		btnPinNo6.addActionListener(signupCont);
		btnPinNo7.addActionListener(signupCont);
		btnPinNo8.addActionListener(signupCont);
		btnPinNo9.addActionListener(signupCont);
		btnReset.addActionListener(signupCont);
	}

	public void setTfPinSignUp(){
		if (txtFieldPinNo1.getText().equals("")) {
			txtFieldPinNo1.setText(btnModel.getTx());
		}
		else if (txtFieldPinNo2.getText().equals("")) {
			txtFieldPinNo2.setText(btnModel.getTx());
		}
		else if (txtFieldPinNo3.getText().equals("")) {
			txtFieldPinNo3.setText(btnModel.getTx());
		}
		else if (txtFieldPinNo4.getText().equals("")) {
			txtFieldPinNo4.setText(btnModel.getTx());
		}
	}

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				SignUpUI frame = new SignUpUI();
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
	public SignUpUI(btnPinModel btnModel) {

		this.btnModel = btnModel;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogoName = new JLabel("Banking Applicaton");
		lblLogoName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLogoName.setBounds(125, 158, 171, 34);
		contentPane.add(lblLogoName);
		
		JLabel lblCopyRight = new JLabel("WELCOME TO MY BANK");
		lblCopyRight.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyRight.setBounds(104, 562, 220, 16);
		contentPane.add(lblCopyRight);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(89, 234, 85, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPinNumber = new JLabel("Pin number:");
		lblPinNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinNumber.setBounds(89, 281, 85, 16);
		contentPane.add(lblPinNumber);
		
		txtFieldUsername = new JTextField();
		txtFieldUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (txtFieldUsername.getText().length() <= 2) {
					lblShowError.setText("*Username must contain at least 3 characters.");
				}
				else if (txtFieldPinNo4.getText().length()<=0) {
					lblShowError.setText("*Pin number must be filled.");
				}
				else if(txtFieldUsername.getText().length() >= 3 && txtFieldPinNo4.getText().length()>=0){
					lblShowError.setText("**Strong username & password**");
				}
			}
		});
		txtFieldUsername.setBounds(186, 231, 140, 22);
		contentPane.add(txtFieldUsername);
		txtFieldUsername.setColumns(10);
		
		lblShowError = new JLabel("*Username must contain at least 3 characters");
		lblShowError.setForeground(Color.RED);
		lblShowError.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowError.setBounds(75, 310, 288, 16);
		contentPane.add(lblShowError);
		
		txtFieldPinNo1 = new JTextField();
		txtFieldPinNo1.setBackground(Color.LIGHT_GRAY);
		txtFieldPinNo1.setEditable(false);
		txtFieldPinNo1.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldPinNo1.setBounds(186, 278, 26, 22);
		contentPane.add(txtFieldPinNo1);
		txtFieldPinNo1.setColumns(10);
		
		txtFieldPinNo2 = new JTextField();
		txtFieldPinNo2.setBackground(Color.LIGHT_GRAY);
		txtFieldPinNo2.setEditable(false);
		txtFieldPinNo2.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldPinNo2.setColumns(10);
		txtFieldPinNo2.setBounds(224, 278, 26, 22);
		contentPane.add(txtFieldPinNo2);
		
		txtFieldPinNo3 = new JTextField();
		txtFieldPinNo3.setBackground(Color.LIGHT_GRAY);
		txtFieldPinNo3.setEditable(false);
		txtFieldPinNo3.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldPinNo3.setColumns(10);
		txtFieldPinNo3.setBounds(262, 278, 26, 22);
		contentPane.add(txtFieldPinNo3);
		
		txtFieldPinNo4 = new JTextField();
		txtFieldPinNo4.setBackground(Color.LIGHT_GRAY);
		txtFieldPinNo4.setEditable(false);
		txtFieldPinNo4.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldPinNo4.setColumns(10);
		txtFieldPinNo4.setBounds(300, 278, 26, 22);
		contentPane.add(txtFieldPinNo4);
		
		btnPinNo1 = new JButton("1");
		btnPinNo1.setBackground(Color.LIGHT_GRAY);
		btnPinNo1.setBounds(143, 365, 47, 34);
		contentPane.add(btnPinNo1);
		
		btnPinNo2 = new JButton("2");
		btnPinNo2.setBackground(Color.LIGHT_GRAY);
		btnPinNo2.setBounds(193, 365, 47, 34);
		contentPane.add(btnPinNo2);
		
		btnPinNo3 = new JButton("3");
		btnPinNo3.setBackground(Color.LIGHT_GRAY);
		btnPinNo3.setBounds(243, 365, 47, 34);
		contentPane.add(btnPinNo3);
		
		btnPinNo4 = new JButton("4");
		btnPinNo4.setBackground(Color.LIGHT_GRAY);
		btnPinNo4.setBounds(143, 399, 47, 34);
		contentPane.add(btnPinNo4);
		
		btnPinNo5 = new JButton("5");
		btnPinNo5.setBackground(Color.LIGHT_GRAY);
		btnPinNo5.setBounds(193, 399, 47, 34);
		contentPane.add(btnPinNo5);
		
		btnPinNo6 = new JButton("6");
		btnPinNo6.setBackground(Color.LIGHT_GRAY);
		btnPinNo6.setBounds(243, 399, 47, 34);
		contentPane.add(btnPinNo6);
		
		btnPinNo7 = new JButton("7");
		btnPinNo7.setBackground(Color.LIGHT_GRAY);
		btnPinNo7.setBounds(143, 433, 47, 34);
		contentPane.add(btnPinNo7);
		
		btnPinNo8 = new JButton("8");
		btnPinNo8.setBackground(Color.LIGHT_GRAY);
		btnPinNo8.setBounds(193, 433, 47, 34);
		contentPane.add(btnPinNo8);
		
		btnPinNo9 = new JButton("9");
		btnPinNo9.setBackground(Color.LIGHT_GRAY);
		btnPinNo9.setBounds(243, 433, 47, 34);
		contentPane.add(btnPinNo9);
		
		btnPinNo0 = new JButton("0");
		btnPinNo0.setBackground(Color.LIGHT_GRAY);
		btnPinNo0.setBounds(193, 467, 47, 34);
		contentPane.add(btnPinNo0);
		
		JLabel lblPinInstruction = new JLabel("Please use the pin pad to fill in the pin number.");
		lblPinInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinInstruction.setBounds(75, 336, 288, 16);
		contentPane.add(lblPinInstruction);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignUp.setBackground(Color.LIGHT_GRAY);
		btnSignUp.setBounds(169, 514, 97, 25);
		contentPane.add(btnSignUp);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(323, 13, 97, 25);
		contentPane.add(btnReset);
	}
}
