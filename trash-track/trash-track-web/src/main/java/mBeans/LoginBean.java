package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.tt.persistence.Customer;
import tn.esprit.tt.persistence.User;
import tn.esprit.tt.services.interfaces.UserServicesLocal;

@ManagedBean
public class LoginBean {
	// Models
	private User user = new User();
	// Injection Of Dependency
	@EJB
	private UserServicesLocal userServicesLocal;

	// Recall services
	public String doLogin() {
		User userLoggedIn = userServicesLocal.findUserByLogin(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			if (userLoggedIn instanceof Customer) {
				System.out.println("c");
			} else {
				System.out.println("C");
			}
		}
		return "";

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
