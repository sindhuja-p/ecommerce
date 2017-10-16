package com.backend.DAO;

import java.util.List;

import com.backend.model.User;





public interface UserDAO {
	
	public boolean saveUser(User  user);
	public List getAllUser();
	/*public List<Users> list();
	  public List<Users> getUserById(int userid);
	  public void removeUserById(int user_id);
	  public Users getUser(int userid);
	  public List getAllUser();
	  public Users get(String email);
*/
}

