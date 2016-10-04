package tn.esprit.tt.services.training;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class SuperCaddyServices
 */
@Stateful
public class SuperCaddyServices implements SuperCaddyServicesRemote, SuperCaddyServicesLocal {
	private int itemlist = 0;

	/**
	 * Default constructor.
	 */
	public SuperCaddyServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addItem() {
		itemlist++;
		System.out.println(itemlist);

	}

}
