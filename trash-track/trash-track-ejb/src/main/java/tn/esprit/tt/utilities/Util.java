package tn.esprit.tt.utilities;

import java.util.ArrayList;
import java.util.List;

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
		customer.setLogin("c1");
		customer.setPassword("c1");
		Customer customer2 = new Customer("saliha", "nasr");
		customer2.setLogin("c2");
		customer2.setPassword("c2");

		Company company = new Company("candy-trash", "ay haja");
		company.setLogin("C");
		company.setPassword("C");

		Product product = new Product("saboon");
		product.setCompany(company);

		Product product2 = new Product("javel");
		product2.setCompany(company);

		List<Product> products = new ArrayList<>();
		products.add(product);
		products.add(product2);

		company.linkProductsToThisUser(products);

		userServicesLocal.saveOrUpdate(customer);
		userServicesLocal.saveOrUpdate(customer2);
		userServicesLocal.saveOrUpdate(company);

	}
}
