package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.tt.persistence.User;
import tn.esprit.tt.services.interfaces.UserServicesRemote;

public class AddUserGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context.lookup(
				"trash-track-ear/trash-track-ejb/UserServices!tn.esprit.tt.services.interfaces.UserServicesRemote");

		User user = new User("sala7");

		userServicesRemote.addUser(user);

	}

}
