package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.tt.services.CompanyServicesRemote;

public class TestCompanyServices {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "trash-track-ear/trash-track-ejb/CompanyServices!tn.esprit.tt.services.CompanyServicesRemote";
			CompanyServicesRemote companyServicesRemote = (CompanyServicesRemote) context.lookup(jndiName);

			companyServicesRemote.findAllCompanies();

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
