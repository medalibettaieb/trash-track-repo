package tn.esprit.tt.services.training;

import javax.ejb.Singleton;

/**
 * Session Bean implementation class CharityCaddyServices
 */
@Singleton
public class CharityCaddyServices implements CharityCaddyServicesRemote, CharityCaddyServicesLocal {
 private int itemlist=0;
    /**
     * Default constructor. 
     */
    public CharityCaddyServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addItem() {
		itemlist++;
		System.out.println(itemlist);
		
	}

}
