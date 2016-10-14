package tn.esprit.tt.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.tt.persistence.Product;

@Remote
public interface ProductServicesRemote {
	void addProduct(Product product, Integer idCompany);

	String findCompanyLogoByProductId(Integer idProduct);

	List<Product> findAllProductsByCompanyId(Integer idCompany);

	Product findProductById(Integer idProduct);

}
