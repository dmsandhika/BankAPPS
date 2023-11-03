package AppsDriver;

import java.util.ArrayList;

import javax.swing.JButton;

import controller.SigninController;
import model.btnPinModel;
import view.HomeUI;
import view.SignInUI;
import view.SignUpUI;

public class BankApplication {

	public static void main(String[] args) {
		
		btnPinModel btnModel = new btnPinModel();
		SignInUI uiSignIn = new SignInUI(btnModel);
		SignUpUI signup = new SignUpUI(btnModel);
		HomeUI home = new HomeUI();
		SigninController controller = new SigninController(uiSignIn, home, signup, btnModel);
		uiSignIn.setVisible(true);
		uiSignIn.setResizable(false);
		uiSignIn.setLocationRelativeTo(null);
		uiSignIn.registerListener(controller);

	}

}
