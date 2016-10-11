package tn.esprit.tt.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.tt.persistence.User;
import tn.esprit.tt.services.interfaces.UserServicesLocal;
import tn.esprit.tt.services.interfaces.UserServicesRemote;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
	}

	@Override
	public User findUserById(Integer idUser) {
		return entityManager.find(User.class, idUser);

	}

}
