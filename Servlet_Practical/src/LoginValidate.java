import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
  
public class LoginValidate {  
	
public static boolean validate(String id,String password){  
	
boolean status=false;  
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?serverTimezone=UTC", "root", "1234");  
		      
			PreparedStatement ps=conn.prepareStatement("select * from students where id=? and password=?");  
			
				ps.setString(1,id);  
				ps.setString(2,password);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e)
			
	{System.out.println(e);
		
	}  
		return status; 
		
		}  
}  