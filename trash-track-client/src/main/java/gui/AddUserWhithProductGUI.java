package gui;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.tt.persistence.Product;
import tn.esprit.tt.persistence.User;
import tn.esprit.tt.services.interfaces.UserServicesRemote;

public class AddUserWhithProductGUI {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context.lookup(
				"trash-track-ear/trash-track-ejb/UserServices!tn.esprit.tt.services.interfaces.UserServicesRemote");

		User user = new User("sala7");
		
		Product product=new Product("p1");
		
		List<Product> products=new ArrayList<>();
		products.add(product);
		
		user.linkProductsToThisUser(products);

		userServicesRemote.addUser(user);

	}

}
