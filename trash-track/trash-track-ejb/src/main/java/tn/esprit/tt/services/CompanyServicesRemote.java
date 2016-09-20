package tn.esprit.tt.services;

import javax.ejb.Remote;

@Remote
public interface CompanyServicesRemote {
	void findAllCompanies();
}
