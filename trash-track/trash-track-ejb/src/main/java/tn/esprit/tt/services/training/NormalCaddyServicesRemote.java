package tn.esprit.tt.services.training;

import javax.ejb.Remote;

@Remote
public interface NormalCaddyServicesRemote {
	int getNum();

	void setNum();
}
