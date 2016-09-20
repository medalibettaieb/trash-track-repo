package tn.esprit.tt.services;

import javax.ejb.Local;

@Local
public interface CompanyServicesLocal {
	void findAllCompanies();
}
