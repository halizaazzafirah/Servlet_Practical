import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/ResultPage")

public class ResultPage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    out.println("Welcome user!");
	    
	  
	    boolean login=false;
	    Connection conn=null;
	    Statement statement=null;
	    
	    String id=request.getParameter("id");  
	    String password=request.getParameter("password");
	      
	    try {
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?serverTimezone=UTC", "root", "1234");
            PreparedStatement stmt = conn.prepareStatement("select * from students where id=? and password=?");
            stmt.setString(1, id);
            stmt.setString(2, password);
            ResultSet rs =stmt.executeQuery();
            if(rs.next()){
        		login=true;
        	}
      
	    	} catch(Exception e){
	    	  out.println(e.getMessage());
	     	}
    
    
	    if(login){
	    	try{ 
            statement=conn.createStatement();
            ResultSet rs=statement.executeQuery("select id, science, mathematic, physic from marks");
            out.println("<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n"
            		  + "<html>\n" + "<head><title></title></head>\n" + "<body bgcolor = \"#f0f0f0\">\n" 
                      + "<h2>" + "Student Marks" + "</h2>");
            
            out.println("<table border=\"1\">"
                      + "<tr>"
                      + "<th>ID</th>"
                      + "<th>Science</th>"
                      + "<th>Mathematic</th>"
                      + "<th>Physic</th>"
                      + "<th>Average</th>"
                      + "</tr>");
            
            while(rs.next()){
          	  int average=(rs.getInt("science")+ rs.getInt("mathematic")+ rs.getInt("physic"))/3;
          	  
          	out.println("<tr>"
          			  + "<td>" + rs.getString("id") + "</td>"
          			  + "<td>" + rs.getString("science") + "</td>"
          			  + "<td>" + rs.getString("mathematic") + "</td>"
          			  + "<td>" + rs.getString("physic") + "</td>"
          			  + "<td>" + average + "</td>"
          			  + "</tr>");
            }
            out.println("</table>" + "</body>" + "</html>");
	    }
        catch(Exception e) {
            e.printStackTrace();
        	}
	    }
	}
}