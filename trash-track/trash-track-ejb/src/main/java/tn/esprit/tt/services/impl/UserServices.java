package tn.esprit.tt.services.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public void saveOrUpdate(User user) {
		entityManager.merge(user);
	}

	@Override
	public User findUserByLogin(String login, String password) {
		User user = null;
		String jpql = "SELECT u FROM User u WHERE u.login=:param1 AND u.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("user not found");
		}

		return user;
	}

}
