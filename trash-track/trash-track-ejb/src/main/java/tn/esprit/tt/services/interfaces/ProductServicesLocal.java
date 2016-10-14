package tn.esprit.tt.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.tt.persistence.Product;

@Local
public interface ProductServicesLocal {
	void addProduct(Product product, Integer idCompany);

	String findCompanyLogoByProductId(Integer idProduct);

	List<Product> findAllProductsByCompanyId(Integer idCompany);

	Product findProductById(Integer idProduct);

	void addProductWithoutIdCompany(Product product);

}
