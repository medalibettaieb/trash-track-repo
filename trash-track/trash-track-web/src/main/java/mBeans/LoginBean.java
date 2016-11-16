package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.tt.persistence.Customer;
import tn.esprit.tt.persistence.User;
import tn.esprit.tt.services.interfaces.UserServicesLocal;

@ManagedBean
@SessionScoped
public class LoginBean {
	// Models
	private User user = new User();
	// Injection Of Dependency
	@EJB
	private UserServicesLocal userServicesLocal;

	// Recall services
	public String doLogin() {
		String navaigateTo = "";
		User userLoggedIn = userServicesLocal.findUserByLogin(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			if (userLoggedIn instanceof Customer) {
				navaigateTo = "/pages/customerHome/home?faces-redirect=true";
			} else {
				navaigateTo = "/pages/companyHome/home?faces-redirect=true";
			}
		} else {
			navaigateTo = "/horreur?faces-redirect=true";
		}
		return navaigateTo;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
