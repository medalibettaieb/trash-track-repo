package tn.esprit.tt.services.interfaces;

import javax.ejb.Local;

import tn.esprit.tt.persistence.Company;
import tn.esprit.tt.persistence.User;

@Local
public interface UserServicesLocal {

	void saveOrUpdate(User user);

	void deleteUser(User user);

	User findUserById(Integer idUser);

	User findUserByLogin(String login, String password);

	Company findMostActiveCompany();

	void subscribeToProduct(Integer idUser, Integer idProduct, Integer duration);

}
