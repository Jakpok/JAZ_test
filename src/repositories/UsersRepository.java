package repositories;

import main.webapp.User;

public interface UsersRepository {

	void add(User user);
	int count();
	User getUserByName(String username);
	User[] getAllUsers();
	void updateUser(User user);
}
