package mBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.tt.persistence.Customer;
import tn.esprit.tt.persistence.User;
import tn.esprit.tt.services.interfaces.UserServicesLocal;

@ManagedBean
@SessionScoped
public class LoginBean {
	// Models
	private User user = new User();
	private Boolean loggedInAsCompany = false;
	private Boolean loggedInAsCustomer = false;
	private Boolean identifidUser;
	// Injection Of Dependency
	@EJB
	private UserServicesLocal userServicesLocal;

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	// Recall services
	public String doLogin() {
		String navaigateTo = "";
		User userLoggedIn = userServicesLocal.findUserByLogin(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			identifidUser = true;
			if (userLoggedIn instanceof Customer) {
				loggedInAsCustomer = true;
				navaigateTo = "/pages/customerHome/home?faces-redirect=true";
			} else {
				loggedInAsCompany = true;
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

	public Boolean getLoggedInAsCompany() {
		return loggedInAsCompany;
	}

	public void setLoggedInAsCompany(Boolean loggedInAsCompany) {
		this.loggedInAsCompany = loggedInAsCompany;
	}

	public Boolean getLoggedInAsCustomer() {
		return loggedInAsCustomer;
	}

	public void setLoggedInAsCustomer(Boolean loggedInAsCustomer) {
		this.loggedInAsCustomer = loggedInAsCustomer;
	}

	public Boolean getIdentifidUser() {
		return identifidUser;
	}

	public void setIdentifidUser(Boolean identifidUser) {
		this.identifidUser = identifidUser;
	}

}
