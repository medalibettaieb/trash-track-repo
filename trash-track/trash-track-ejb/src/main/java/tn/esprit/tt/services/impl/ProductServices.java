package tn.esprit.tt.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	}

	@Override
	public void addProduct(Product product, Integer idCompany) {
		Company companyFound = (Company) userServicesLocal.findUserById(idCompany);

		product.setCompany(companyFound);

		entityManager.merge(product);
	}

	@Override
	public String findCompanyLogoByProductId(Integer idProduct) {
		Product productFound = findProductById(idProduct);
		Company company = (Company) productFound.getCompany();
		return company.getLogo();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProductsByCompanyId(Integer idCompany) {
		String jpql = "SELECT p FROM Product p WHERE p.company.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idCompany);
		return query.getResultList();
	}

	@Override
	public Product findProductById(Integer idProduct) {
		return entityManager.find(Product.class, idProduct);
	}

	@Override
	public void addProductWithoutIdCompany(Product product) {
		entityManager.merge(product);
	}

}
