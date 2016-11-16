package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.tt.persistence.Customer;
import tn.esprit.tt.persistence.User;
import tn.esprit.tt.services.interfaces.UserServicesRemote;

public class TestLogin {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context.lookup(
				"trash-track-ear/trash-track-ejb/UserServices!tn.esprit.tt.services.interfaces.UserServicesRemote");

		User user = userServicesRemote.findUserByLogin("c1", "");
		if (user!=null) {
			if (user instanceof Customer) {
				System.out.println("customer");
			}
			else {
				System.out.println("company");
			}
		}

	}

}
