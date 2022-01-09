package daoimpl;

import java.sql.SQLException;

import dao.StudentLoginDetailsDao;
import model.StudentUserDetails;
import repository.StudentLoginDetailsDaoRes;


public  class StudentLoginDetailsDaoImpl implements StudentLoginDetailsDao{

	
	StudentLoginDetailsDaoRes loginDetailsDaoRes=null;
	
	public StudentLoginDetailsDaoImpl()
	{
		try {
			loginDetailsDaoRes=new StudentLoginDetailsDaoRes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in repository"+e.getMessage());
		}
	}
	
	public boolean signUp(StudentUserDetails user) {
		// TODO Auto-generated method stub
		
		try {
			return loginDetailsDaoRes.signUp(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in sign up"+e.getMessage());
			return false;
		}
	}

	public boolean signIn(StudentUserDetails user) {
		// TODO Auto-generated method stub
		try {
			return loginDetailsDaoRes.signIn(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	//@Override
	public boolean updateUser(String username) {
		return loginDetailsDaoRes.updateUser(username);
		
	}

	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		return loginDetailsDaoRes.deleteUser(username);
		
	}

}
