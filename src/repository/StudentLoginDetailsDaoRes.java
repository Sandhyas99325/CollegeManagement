package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.MyConnection;
import model.StudentUserDetails;

public class StudentLoginDetailsDaoRes {
	
	Connection connection=null;
	Statement statement=null;
	ResultSet resultset=null;
	PreparedStatement pstmt;
	public StudentLoginDetailsDaoRes() throws SQLException
	{
		connection=MyConnection.getConnection();
		statement=connection.createStatement();
	}
	
	public boolean signUp(StudentUserDetails user) throws SQLException {
		// TODO Auto-generated method stub
	
	int r=statement.executeUpdate("insert into userdetails values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getLocation()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getMobileno()+"')");
	if(r==1)
	{
	return true;
	}else
		return false;

	}
	public boolean signIn(StudentUserDetails user) throws SQLException {
		// TODO Auto-generated method stub
		
		
		String tuser=user.getUsername();
		String pass=user.getPassword();
		resultset=statement.executeQuery("select *from userdetails where username='"+tuser+"' and password='"+pass+"'");
		if(resultset.next())
		{
		return true;
		}else
			return false;
	}
      public static boolean insertStudentRecord(StudentUserDetails st)
      {
    	  boolean f= false;
    	  try{
    		   Connection con= MyConnection.getConnection();
    		   String query = "insert into students(sid,sname,age,location)values(?,?,?,?)";
    		 PreparedStatement  pstmt= con.prepareStatement(query);
    		 //set the values of parameters
    		   pstmt.setInt(1, st.getSid()); 
    		   pstmt.setString(2, st.getSname()); 
    		   pstmt.setString(3, st.getAge()); 
    		   pstmt.setString(4, st.getAddress()); 
    		   //execute
    		   pstmt.executeUpdate();
    		   f=true;
    		   
    	  }catch(Exception e){
    		  
    	  }
    	  return f;
      }
      public static boolean deleteStudentRecord(int userId)
      {
    	  boolean f= false;
    	  try{
    		   Connection con = MyConnection.getConnection();
    		   String query = "delete from students where sid=?";
    		  PreparedStatement pstmt= con.prepareStatement(query);
    		  //set the value of parameters
    		   pstmt.setInt(1, userId); 
    		   //execute
    		   pstmt.executeUpdate();
    		   f=true;
    		   
    	  }catch(Exception e){
    		  
    	  }
    	  return f;
      }
      public static void  showAllStudentRecord()
      {
    	  boolean f= false;
    	  try{ 
    		     Connection con=MyConnection.getConnection();
    		   String query = "select *from students";
    		 Statement st=con.createStatement();
    			ResultSet resultset = st.executeQuery(query);
    			 while(resultset.next()){
    				 int sid= resultset.getInt(1);
    				  String sname = resultset.getString(2);
    				  String sage= resultset.getString(3);
    				  String address= resultset.getString("address");
    				  System.out.println("Student Id:"+sid +"\n Student Name : "+sname +"\n Student Age:"+sage+ "\n Student Address "+address);
    				 System.out.println("-------------------------------------------------------------------------------------");
    			 }
    		   
    	  }catch(Exception e){
    		  
    	  }
    	 
      }
	public static boolean updateStudentRecord(int val,String toUpdate,int id,StudentUserDetails s)
	{
		boolean f = false;
		try
		{
			 Connection connection= MyConnection.getConnection();
			 if(val==1)
			 {
				 //Update Student Name
				 String query = "update student set sname=? where sid=?";
				PreparedStatement pstmt= connection.prepareStatement(query);
				 pstmt.setString(1, toUpdate);
				 pstmt.setInt(2, id);
				 //execute
				 pstmt.executeUpdate();
				 f=true;
			 }
			 else if(val==2){
				 //Update Student Age
				 String query = "update student set age=? where sid=?";
				PreparedStatement pstmt= connection.prepareStatement(query);
				 pstmt.setString(1, toUpdate);
				 pstmt.setInt(2, id);
				 //execute
				 pstmt.executeUpdate();
				 f=true;

			 }
			 else if(val==3){
				 //Update Student Address
			 String query = "update student set Address=? where sid=?";
			PreparedStatement pstmt= connection.prepareStatement(query);
			 pstmt.setString(1, toUpdate);
			 pstmt.setInt(2, id);
			 //execute
			 pstmt.executeUpdate();
			 f=true;
			 }
			 else{
				 
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
	return f;
	}
	
	public boolean updateUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}
}
