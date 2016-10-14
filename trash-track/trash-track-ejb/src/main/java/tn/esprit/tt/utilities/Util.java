package tn.esprit.tt.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.tt.persistence.Company;
import tn.esprit.tt.persistence.Customer;
import tn.esprit.tt.persistence.Product;
import tn.esprit.tt.services.interfaces.ProductServicesLocal;
import tn.esprit.tt.services.interfaces.UserServicesLocal;

/**
 * Session Bean implementation class Util
 */
@Singleton
@LocalBean
@Startup
public class Util {
	@EJB
	private UserServicesLocal userServicesLocal;
	@EJB
	private ProductServicesLocal productServicesLocal;

	/**
	 * Default constructor.
	 */
	public Util() {
	}

	@PostConstruct
	public void initDB() {
		Customer customer = new Customer("salah", "manar");
		Customer customer2 = new Customer("saliha", "nasr");

		Company company = new Company("candy-trash", "ay haja");

		Product product = new Product("saboon");
		product.setCompany(company);

		userServicesLocal.addUser(customer);
		userServicesLocal.addUser(customer2);
		userServicesLocal.addUser(company);

		// productServicesLocal.addProduct(product,
		// userServicesLocal.updateUser(company).getId());
		productServicesLocal.addProductWithoutIdCompany(product);
	}
}
