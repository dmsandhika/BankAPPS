package AppsDriver;

import java.util.ArrayList;

import javax.swing.JButton;

// import model.Account;
// import model.Customer;
// import model.DataController;
// import listener.OpeningApplicationActionListener;
// import listener.SignUpOperationActionListener;
import view.HomeUI;
import view.SignInUI;
import view.SignUpUI;

public class MyApplication {

	public static void main(String[] args) {
		
		
		SignInUI uiSignIn = new SignInUI();
		uiSignIn.setVisible(true);
		uiSignIn.setResizable(false);
		// DataController dc = new DataController();
		
		// OpeningApplicationActionListener listenerForSignInUI = new OpeningApplicationActionListener(uiSignIn,dc);
		
		JButton btnSignUp = uiSignIn.getBtnSignUp();
		// btnSignUp.addActionListener(listenerForSignInUI);
		
		JButton btnSignIn = uiSignIn.getBtnSignIn();
		// btnSignIn.addActionListener(listenerForSignInUI);
		
		JButton btnPin0 = uiSignIn.getBtnPin10();
		// btnPin0.addActionListener(listenerForSignInUI);
		
		JButton btnPin1 = uiSignIn.getBtnPin1();
		// btnPin1.addActionListener(listenerForSignInUI);
		
		JButton btnPin2 = uiSignIn.getBtnPin2();
		// btnPin2.addActionListener(listenerForSignInUI);
		
		JButton btnPin3 = uiSignIn.getBtnPin3();
		// btnPin3.addActionListener(listenerForSignInUI);
		
		JButton btnPin4 = uiSignIn.getBtnPin4();
		// btnPin4.addActionListener(listenerForSignInUI);
		
		JButton btnPin5 = uiSignIn.getBtnPin5();
		// btnPin5.addActionListener(listenerForSignInUI);
		
		JButton btnPin6 = uiSignIn.getBtnPin6();
		// btnPin6.addActionListener(listenerForSignInUI);
		
		JButton btnPin7 = uiSignIn.getBtnPin7();
		// btnPin7.addActionListener(listenerForSignInUI);
		
		JButton btnPin8 = uiSignIn.getBtnPin8();
		// btnPin8.addActionListener(listenerForSignInUI);
		
		JButton btnPin9 = uiSignIn.getBtnPin9();
		// btnPin9.addActionListener(listenerForSignInUI);
		
		JButton btnReset = uiSignIn.getBtnReset();
		// btnReset.addActionListener(listenerForSignInUI);
		

	}

}
