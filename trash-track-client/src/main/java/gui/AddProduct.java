package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.tt.persistence.Product;
import tn.esprit.tt.services.interfaces.ProductServicesRemote;

public class AddProduct {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProductServicesRemote productServicesRemote = (ProductServicesRemote) context.lookup(
				"trash-track-ear/trash-track-ejb/ProductServices!tn.esprit.tt.services.interfaces.ProductServicesRemote");

		Product product = new Product("saboon");

		productServicesRemote.addProduct(product, 3);
	}

}
