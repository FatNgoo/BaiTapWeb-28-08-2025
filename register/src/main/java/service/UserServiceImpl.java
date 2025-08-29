package service;

import dao.UserDAO;
import dao.UserDaoImplement;
import model.User;

public class UserServiceImpl implements UserService {

	UserDaoImplement userDao = new UserDaoImplement();
	
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}
	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
				return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new User(0, email, username, fullname, password, "0", 0, phone, date));
			return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}
}
