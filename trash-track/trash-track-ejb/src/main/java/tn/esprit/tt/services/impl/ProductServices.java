package tn.esprit.tt.services.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.tt.persistence.Company;
import tn.esprit.tt.persistence.Product;
import tn.esprit.tt.services.interfaces.ProductServicesLocal;
import tn.esprit.tt.services.interfaces.ProductServicesRemote;
import tn.esprit.tt.services.interfaces.UserServicesLocal;

/**
 * Session Bean implementation class ProductServices
 */
@Stateless
public class ProductServices implements ProductServicesRemote, ProductServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private UserServicesLocal userServicesLocal;

	/**
	 * Default constructor.
	 */
	public ProductServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addProduct(Product product, Integer idCompany) {
		Company companyFound = (Company) userServicesLocal.findUserById(idCompany);

		product.setCompany(companyFound);

		entityManager.merge(product);
	}

}
