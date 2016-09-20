package tn.esprit.tt.services;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class CompanyServices
 */
@Stateless
public class CompanyServices implements CompanyServicesRemote, CompanyServicesLocal {

	/**
	 * Default constructor.
	 */
	public CompanyServices() {
	}

	@Override
	public void findAllCompanies() {
		System.out.println("hello from stateless ...");

	}

}
