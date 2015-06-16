package controllers;

import java.security.MessageDigest;

import dao.impl.file.ClaimImpl;
import dao.interfaces.ClaimDao;
import dao.interfaces.UserDao;
import dao.model.User;

public class RegisterController {
	//ClaimDao cd = new ClaimImpl();
	
	private UserDao uDao = new UserImpl();

	public boolean register(User u) {
		if(uDao.getUserByUserName(u.getUserName())!=null){
			System.out.println("The user name is already registered!");
			return false;
		}
		else{
			System.out.println("Welcom to register!");
			uDao.addUser(u);
			String password = u.getPassword();
			MessageDigest pw = MessageDigest.getInstance("SHA-256");
		}
	}
	
	

	

}
