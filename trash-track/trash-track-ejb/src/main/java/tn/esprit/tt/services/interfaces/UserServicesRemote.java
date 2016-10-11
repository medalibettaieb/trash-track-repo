package tn.esprit.tt.services.interfaces;

import javax.ejb.Remote;

import tn.esprit.tt.persistence.User;

@Remote
public interface UserServicesRemote {
	void addUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	User findUserById(Integer idUser);

}
