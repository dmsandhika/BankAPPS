package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.HomeController;
import model.Transaction;
import model.User;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class HomeUI extends JFrame {

	private JPanel contentPane;
	private JPanel mainDetails;
	private JPanel transferPanel;
	private JPanel depositPanel;
	private JPanel withdrawPanel;
	private JPanel homePanel;
	private JPanel header;
	private JScrollPane scrollPane;
	private JLayeredPane layeredPane;
	private JTextField txtTransferAmount;
	private JTextField txtDescription;
	private JTextField txtDepositAmount;
	private JTextField txtDepositDescription;
	private JTextField txtWithdrawAmount;
	private JTextField txtWithdrawDescription;
	private JButton btnDepositTo;
	private JLabel lblCustomerId;
	private JLabel lblId;
	private JButton btnWithdrawFrom;
	
	private JButton btnAccount;
	private JButton btnHome;
	private JButton btnTransfer;
	private JButton btnDeposit;
	private JButton btnWithdraw;
	
	private JLabel lblNameValue;
	private JLabel lblIdValue;
	private JLabel lblBank;
	private JLabel lblUsernameACC;
	private JButton btnLogOut;
	
	private JTextField txtTransferTo;
	private JButton btnTransferPanel;
	private JTable mainTable;
	
	private JLabel lblNoRek;
	private JLabel lblMainBalancePanel;

	public JLabel getlblUsernameACC(){
		return lblUsernameACC;
	}
	
	public JLabel getlblNoRek() {
		return lblNoRek;
	}

	public JLabel getLblMainBalancePanel() {
		return lblMainBalancePanel;
	}

	public JTable getMainTable() {
		return mainTable;
	}

	public JTextField gettransferTo() {
		return txtTransferTo;
	}

	public JButton getBtnTransferPanel() {
		return btnTransferPanel;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}

	public JLabel getLblNameValue() {
		return lblNameValue;
	}

	public JLabel getLblIdValue() {
		return lblIdValue;
	}

	public JButton getBtnAccount() {
		return btnAccount;
	}

	public JButton getBtnHome(){
		return btnHome;
	}

	public JButton getBtnTransfer(){
		return btnTransfer;
	}

	public JButton getBtnDeposit(){
		return btnDeposit;
	}
	
	public JButton getBtnWithdraw(){
		return btnWithdraw;
	}

	public JButton getBtnWithdrawFrom() {
		return btnWithdrawFrom;
	}

	public JTextField getTxtAmountTo() {
		return txtTransferAmount;
	}

	public JTextField getTxtDescription() {
		return txtDescription;
	}

	public JTextField getTxtDepositAmount() {
		return txtDepositAmount;
	}

	public JTextField getTxtWithdrawAmount() {
		return txtWithdrawAmount;
	}

	public JButton getBtnDepositTo() {
		return btnDepositTo;
	}

	public JLayeredPane getlayeredPane(){
		return layeredPane;
	}

	public JPanel getmainDetails(){
		return mainDetails;
	}

	public JPanel gettransferPanel(){
		return transferPanel;
	}

	public JPanel getdepositPanel(){
		return depositPanel;
	}

	public JPanel getwithdrawPanel(){
		return withdrawPanel;
	}

	public JPanel gethomePanel(){
		return homePanel;
	}

	public JPanel getheader(){
		return header;
	}

	public JLabel getlblBank(){
		return lblBank;
	}

	public void registerListenerHome(HomeController homeCont){
		btnLogOut.addActionListener(homeCont);
		btnAccount.addActionListener(homeCont);
		btnHome.addActionListener(homeCont);
		btnDeposit.addActionListener(homeCont);
		btnTransfer.addActionListener(homeCont);
		btnWithdraw.addActionListener(homeCont);
		btnTransferPanel.addActionListener(homeCont);
		btnDepositTo.addActionListener(homeCont);
		btnWithdrawFrom.addActionListener(homeCont);
	}

	// /**
	//  * Launch the application.
	//  */

	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				HomeUI frame = new HomeUI();
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
	public HomeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		header = new JPanel();
		header.setBackground(Color.LIGHT_GRAY);
		header.setBounds(0, 0, 480, 55);
		contentPane.add(header);
		header.setLayout(null);
		
		lblBank = new JLabel("MY BANK");
		lblBank.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBank.setHorizontalAlignment(SwingConstants.CENTER);
		lblBank.setBounds(0, 13, 480, 29);
		header.add(lblBank);
		
		JPanel footer = new JPanel();
		footer.setLayout(null);
		footer.setBackground(Color.LIGHT_GRAY);
		footer.setBounds(0, 561, 480, 55);
		contentPane.add(footer);

		
		JPanel main = new JPanel();
		main.setBounds(0, 56, 480, 505);
		contentPane.add(main);
		main.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 480, 505);
		main.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		homePanel = new JPanel();
		layeredPane.add(homePanel, "name_198307436532320");
		homePanel.setLayout(null);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setBackground(Color.GRAY);
		btnLogOut.setBounds(193, 301, 97, 25);
		homePanel.add(btnLogOut);

		JLabel lblCustomerName = new JLabel("Nama:");
		lblCustomerName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerName.setBounds(38, 220, 146, 16);
		homePanel.add(lblCustomerName);
		
		JLabel lblCustomerIdNumber = new JLabel("Rekening:");
		lblCustomerIdNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerIdNumber.setBounds(58, 250, 146, 16);
		homePanel.add(lblCustomerIdNumber);
		
		lblNameValue = new JLabel("Customer Name:");
		lblNameValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameValue.setBounds(250, 220, 146, 16);
		homePanel.add(lblNameValue);
		
		lblIdValue = new JLabel("Customer Id Number:");
		lblIdValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdValue.setBounds(250, 250, 146, 16);
		homePanel.add(lblIdValue);
		
		JLabel lblAppName = new JLabel("anking Application");
		lblAppName.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppName.setBounds(46, 13, 422, 141);
		homePanel.add(lblAppName);
		
		JLabel lblNewLabel = new JLabel("B");
		lblNewLabel.setFont(new Font("UD Digi Kyokasho NP-B", Font.PLAIN, 55));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(58, 13, 41, 141);
		homePanel.add(lblNewLabel);
		
		transferPanel = new JPanel();
		layeredPane.add(transferPanel, "name_494513101293348");
		transferPanel.setLayout(null);
		
		JLabel lblTo = new JLabel("No Rekening:");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(211, 45, 80, 29);
		transferPanel.add(lblTo);
		
		txtTransferTo = new JTextField();
		txtTransferTo.setBounds(177, 87, 145, 29);
		transferPanel.add(txtTransferTo);
		
		JLabel lblAmountTransfer = new JLabel("Jumlah:");
		lblAmountTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountTransfer.setBounds(94, 174, 80, 29);
		transferPanel.add(lblAmountTransfer);
		
		JLabel lblDescription = new JLabel("Keterangan:");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(106, 222, 80, 29);
		transferPanel.add(lblDescription);
		
		txtTransferAmount = new JTextField();
		txtTransferAmount.setBounds(222, 177, 150, 22);
		transferPanel.add(txtTransferAmount);
		txtTransferAmount.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setBounds(222, 225, 150, 22);
		transferPanel.add(txtDescription);
		txtDescription.setColumns(10);
		
		btnTransferPanel = new JButton("Transfer");
		btnTransferPanel.setBackground(Color.LIGHT_GRAY);
		btnTransferPanel.setBounds(222, 260, 97, 25);
		transferPanel.add(btnTransferPanel);
		
		depositPanel = new JPanel();
		layeredPane.add(depositPanel, "name_494522781661989");
		depositPanel.setLayout(null);
		
		JLabel lblDepositAmount = new JLabel("Jumlah :");
		lblDepositAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepositAmount.setBounds(80, 109, 65, 31);
		depositPanel.add(lblDepositAmount);

		txtDepositAmount = new JTextField();
		txtDepositAmount.setBounds(190, 109, 192, 31);
		depositPanel.add(txtDepositAmount);
		txtDepositAmount.setColumns(10);
		
		btnDepositTo = new JButton("Deposit");
		btnDepositTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDepositTo.setBackground(Color.LIGHT_GRAY);
		btnDepositTo.setBounds(190, 165, 97, 25);
		depositPanel.add(btnDepositTo);
		
		withdrawPanel = new JPanel();
		layeredPane.add(withdrawPanel, "name_497875154538863");
		withdrawPanel.setLayout(null);
		
		JLabel lblWithdrawAmount = new JLabel("Jumlah :");
		lblWithdrawAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWithdrawAmount.setBounds(80, 109, 65, 31);
		withdrawPanel.add(lblWithdrawAmount);
		
		txtWithdrawAmount = new JTextField();
		txtWithdrawAmount.setColumns(10);
		txtWithdrawAmount.setBounds(190, 109, 192, 31);
		withdrawPanel.add(txtWithdrawAmount);
		
		btnWithdrawFrom = new JButton("Withdraw");
		btnWithdrawFrom.setBackground(Color.LIGHT_GRAY);
		btnWithdrawFrom.setBounds(190, 165, 97, 25);
		withdrawPanel.add(btnWithdrawFrom);
		
		mainDetails = new JPanel();
		layeredPane.add(mainDetails, "name_495151309015368");
		mainDetails.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(54, 13, 369, 122);
		mainDetails.add(panel);
		panel.setLayout(null);

		
		lblNoRek = new JLabel("No Rekening");
		lblNoRek.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNoRek.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoRek.setBounds(0, 0, 369, 29);
		panel.add(lblNoRek);
		
		lblMainBalancePanel = new JLabel("Rp 00,00");
		lblMainBalancePanel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMainBalancePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainBalancePanel.setBounds(0, 30, 369, 66);
		panel.add(lblMainBalancePanel);
		
		lblUsernameACC = new JLabel("Username");
		lblUsernameACC.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsernameACC.setBounds(0, 93, 369, 29);
		panel.add(lblUsernameACC);
		
		JLabel lblTransaction = new JLabel("Aktivitas");
		lblTransaction.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaction.setBounds(0, 164, 480, 30);
		mainDetails.add(lblTransaction);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 194, 480, 312);
		mainDetails.add(scrollPane);
		
		mainTable = new JTable();
		mainTable.setModel(new DefaultTableModel(
			new String[] {
				"Transaksi", "Tanggal", "Jumlah", "Deskripsi"
			},0
		));
		mainTable.getColumnModel().getColumn(0).setPreferredWidth(84);
		mainTable.getColumnModel().getColumn(1).setPreferredWidth(133);
		mainTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		mainTable.getColumnModel().getColumn(3).setPreferredWidth(289);
		scrollPane.setViewportView(mainTable);
		
		btnAccount = new JButton("Akun");
		btnAccount.setBackground(Color.LIGHT_GRAY);
		btnAccount.setBounds(96, 0, 97, 55);
		footer.add(btnAccount);
		
		btnTransfer = new JButton("Transfer");
		btnTransfer.setBackground(Color.LIGHT_GRAY);
		btnTransfer.setBounds(192, 0, 97, 55);
		footer.add(btnTransfer);
		
		btnDeposit = new JButton("Setor Tunai");
		btnDeposit.setBackground(Color.LIGHT_GRAY);
		btnDeposit.setBounds(288, 0, 100, 55);
		footer.add(btnDeposit);
		
		btnWithdraw = new JButton("Tarik Tunai");
		btnWithdraw.setBackground(Color.LIGHT_GRAY);
		btnWithdraw.setBounds(383, 0, 97, 55);
		footer.add(btnWithdraw);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(0, 0, 97, 55);
		footer.add(btnHome);
		btnHome.setBackground(Color.LIGHT_GRAY);
	}
}
