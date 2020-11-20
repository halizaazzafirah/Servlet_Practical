import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/loginForm")

public class loginForm extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String id=request.getParameter("id");  
	    String password=request.getParameter("password");  
	          
	    if(LoginValidate.validate(id,password)){  
	        RequestDispatcher rd=request.getRequestDispatcher("ResultPage");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Failed to login");  
	        RequestDispatcher rd=request.getRequestDispatcher("Index.html");  
	        rd.include(request,response);  
	    }
	    out.close();
	}

}