package tn.esprit.tt.services.interfaces;

import javax.ejb.Remote;

import tn.esprit.tt.persistence.Company;
import tn.esprit.tt.persistence.User;

@Remote
public interface UserServicesRemote {

	void saveOrUpdate(User user);

	void deleteUser(User user);

	User findUserById(Integer idUser);

	Company findMostActiveCompany();

	void subscribeToProduct(Integer idUser, Integer idProduct, Integer duration);

	User findUserByLogin(String login, String password);

}
