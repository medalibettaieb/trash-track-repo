package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.tt.services.interfaces.UserServicesRemote;

public class AddSubscriptionGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context.lookup(
				"trash-track-ear/trash-track-ejb/UserServices!tn.esprit.tt.services.interfaces.UserServicesRemote");

		userServicesRemote.subscribeToProduct(1, 1, 3);

	}

}
