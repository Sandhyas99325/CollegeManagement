package appmain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import dao.StudentLoginDetailsDao;
import daoimpl.StudentLoginDetailsDaoImpl;
import model.StudentUserDetails;
import repository.StudentLoginDetailsDaoRes;

public class StudentInterface {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("*********Hello User****************");
		String user1= br.readLine();
		System.out.println("    Welcome to Student Administration-   ");
		System.out.println("*************************************************");
		System.out.println("1: Contact US");
		System.out.println("2: About US");
		System.out.println("3: Sign up");
		System.out.println("4: Sign In");
		System.out.println("5: Exit");
		System.out.println("*************************************************************");
		char ch=' ';
		StudentLoginDetailsDao LoginDao=new StudentLoginDetailsDaoImpl();
		String username,firstname,lastname,password, location, mobileno;
		do {
			System.out.println("What you do wish to check from the above list.....");
		
		
			Scanner sn=new Scanner(System.in);
			int option=sn.nextInt();
		
			switch(option)
			{
				case 1: 
					
					break;
				case 2: 
					
					break;
							
				case 3:System.out.println("Enter the details to signup....");
				
				
						System.out.println("Enter the First Name-->");
						firstname=sn.next();
						System.out.println("Enter the Last Name-->");
						lastname=sn.next();
						System.out.println("Enter the Location-->");
						location=sn.next();
						System.out.println("Enter the Username-->");
						username=sn.next();
						System.out.println("Enter the Password-->");
						password=sn.next();
						System.out.println("Enter the MobileNO-->");
						mobileno=sn.next();
						StudentUserDetails userd=new StudentUserDetails();
						userd.setFirstName(firstname);
						userd.setLastName(lastname);
						userd.setLocation(location);
						userd.setMobileno(mobileno);
						userd.setUsername(username);
						userd.setPassword(password);
						
					LoginDao.signUp(userd);
					break;
				case 4:
					System.out.println("Enter the Username-->");
					String usern=sn.next();
					System.out.println("Enter the Password-->");
					String pass=sn.next();
					StudentUserDetails details=new StudentUserDetails();
					details.setUsername(usern);
					details.setPassword(pass);
					boolean res=LoginDao.signIn(details);
					if(res){
						System.out.println("Login success...........");
						while(true){
						System.out.println("-------------------------------------------------------");
						System.out.println("***********  Welcome to the Student managment **********");
						System.out.println("-------------------------------------------------------");
						System.out.println("1. ADD students");
						System.out.println("2. DELETE students");
						System.out.println("3. Modify students");
						System.out.println("4. View All students");
						System.out.println("5. Sign out");
						System.out.println(" Please enter your choice:--");
						int c= Integer.parseInt(br.readLine());
						if(c==1)
						{
							//Add student
							System.out.println("Please Enter the student roll no-->");
							int sid=br.read();
							System.out.println("Please Enter the student Name-->");
							String sname=br.readLine();
							System.out.println("Please Enter the student Age-->");
							String age=br.readLine();
							System.out.println("Please Enter the student Residence-->");
							String address=br.readLine();
							//create studentuserdetails object
							StudentUserDetails st= new StudentUserDetails(sid,sname,age,address);
							boolean ans= StudentLoginDetailsDao.insertStudentRecord(st);
							if(ans){
								System.out.println("Student Record Inserted Succcessfully....");
								System.out.println("Student Record:" +st);
							}
							else{
								System.out.println("Something went wrong ....");
								System.out.println("Please Try Again ....");
								
							}
							
						}
						else if(c==2)
						{
							//Delete student
							System.out.println("Enter the Student Id to Delete:->");
							int userId= Integer.parseInt(br.readLine());
							boolean f= StudentLoginDetailsDaoRes.deleteStudentRecord(userId);
							if(f){
								System.out.println("Student Id:" +userId+"Record Deleted.....");
							}
							else{
								System.out.println("Something Went Wrong ....Try Again ");
							}
						}
						else if(c==3){
							//Display Student
							StudentLoginDetailsDao.showAllStudentRecord();
						}
						else if(c==4)
						{
							//Update Student
							System.out.println("1. Update Name:-");
							System.out.println("2. Update Age:-");
							System.out.println("3. Update Residence:-");
							int val= Integer.parseInt(br.readLine());
							if(val==1){
								//Update Student Name
								System.out.println("Enter the name to Update....");
								String name = br.readLine();
								System.out.println("Enter Student Id to identify student-->");
								int id=Integer.parseInt(br.readLine());
								StudentUserDetails st = new StudentUserDetails();
								st.setSname(name);
								boolean f= StudentLoginDetailsDao.updateStudentRecord(val,name,id,st);
								if(f)
								{
									System.out.println("Student Name Updated Successfully..");
								}
								else{
									System.out.println("Something Went Wrong Please ...Please try Again...");
									
								}
							}
							else if(val==2){
								//Update Student age
								System.out.println("Enter the Age to Update....");
								String age = br.readLine();
								System.out.println("Enter Student Id to identify student-->");
								int id=Integer.parseInt(br.readLine());
								StudentUserDetails st = new StudentUserDetails();
								st.setAge(age);
								boolean f= StudentLoginDetailsDao.updateStudentRecord(val,age,id,st);
								if(f)
								{
									System.out.println("Student Age Updated Successfully..");
								}
								else{
									System.out.println("Something Went Wrong Please ...Please try Again...");
									
								}
						
							}
							else if(val==3){
								//Update Student Address
								System.out.println("Enter the Residence to Update....");
								String address = br.readLine();
								System.out.println("Enter Student Id to identify student-->");
								int id=Integer.parseInt(br.readLine());
								StudentUserDetails st = new StudentUserDetails();
								st.setAddress(address);
								boolean f= StudentLoginDetailsDao.updateStudentRecord(val,address,id,st);
								if(f)
								{
									System.out.println("Student Address Updated Successfully..");
								}
								else{
									System.out.println("Something Went Wrong Please ...Please try Again...");
									
								}
							}
							else{
								System.out.println("Hey You Have not updated Anything...Please choose option Correctly...");
								
							}			
						}
						else if(c==4){
							//Exit
							System.out.println("Thank You For Using ... "+user1);
							break;
						}
						else{
						}
						}
						}
						
						
					else 
						System.out.println("Login failed.....");
					break;
				case 5:
					System.exit(0);
				default: System.out.println("Enter the valid option-->");
			}
				
		ch=sn.next().charAt(0);
		
	  }while(ch=='y'||ch=='Y');
			
	}
	
}





