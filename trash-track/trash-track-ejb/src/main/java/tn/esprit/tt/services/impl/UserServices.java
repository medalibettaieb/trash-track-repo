package tn.esprit.tt.services.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.tt.persistence.Company;
import tn.esprit.tt.persistence.Product;
import tn.esprit.tt.persistence.SubscriptionDetail;
import tn.esprit.tt.persistence.User;
import tn.esprit.tt.services.interfaces.ProductServicesLocal;
import tn.esprit.tt.services.interfaces.UserServicesLocal;
import tn.esprit.tt.services.interfaces.UserServicesRemote;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private ProductServicesLocal productServicesLocal;

	/**
	 * Default constructor.
	 */
	public UserServices() {
	}

	@Override
	public void addUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public User updateUser(User user) {
		return entityManager.merge(user);
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
	}

	@Override
	public User findUserById(Integer idUser) {
		return entityManager.find(User.class, idUser);

	}

	@Override
	public Company findMostActiveCompany() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void subscribeToProduct(Integer idUser, Integer idProduct, Integer duration) {
		User user = findUserById(idUser);
		Product product = productServicesLocal.findProductById(idProduct);
		SubscriptionDetail subscriptionDetail = new SubscriptionDetail(duration, user, product);
		entityManager.merge(subscriptionDetail);
	}

}
