package controllers.interfaces;

import java.security.MessageDigest;

import dao.impl.file.ClaimImpl;
import dao.interfaces.ClaimDao;
import dao.interfaces.UserDao;
import dao.model.Policy;
import dao.model.User;
import dao.model.Vehicle;

public interface RegisterController {
//	//ClaimDao cd = new ClaimImpl();
//
//	private UserDao uDao = new UserImpl();
//
//	public boolean register(User u) {
//		if(uDao.getUserByUserName(u.getUserName())!=null){
//			System.out.println("The user name is already registered!");
//			return false;
//		}
//		else{
//			System.out.println("Welcom to register!");
//			uDao.addUser(u);
//			String password = u.getPassword();
//			MessageDigest pw = MessageDigest.getInstance("SHA-256");
//		}
//	}
    boolean addUser(String userName,String password, String email,String firstName,String lastName,String birthday,
                    String occupation,String address, String licenseDate);
    boolean addVehicle(Vehicle v);
    boolean addPolicy(Policy p);

	

	

}
