package tn.esprit.tt.services.interfaces;

import javax.ejb.Local;

import tn.esprit.tt.persistence.User;

@Local
public interface UserServicesLocal {
	void addUser(User user);

	User updateUser(User user);

	void deleteUser(User user);

	User findUserById(Integer idUser);
}
