package tn.esprit.tt.services.interfaces;

import javax.ejb.Remote;

import tn.esprit.tt.persistence.Product;

@Remote
public interface ProductServicesRemote {
	void addProduct(Product product, Integer idCompany);

}
