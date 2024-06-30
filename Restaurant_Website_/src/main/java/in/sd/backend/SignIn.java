package in.sd.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class SignIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String myemail=req.getParameter("email1");
    	String mypassword=req.getParameter("pass1");
    	
    	PrintWriter out=resp.getWriter();
    	resp.setContentType("text/html");
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details_db","root","Tuku24@#");
    		PreparedStatement ps=con.prepareStatement("SELECT*FROM details where email=? and password=?");
    		
    		ps.setString(1, myemail);
    		ps.setString(2, mypassword);
    		
    	ResultSet rs=ps.executeQuery();
    		if(rs.next()) {
    		   RequestDispatcher rd=req.getRequestDispatcher("/home2.html");
    		   rd.include(req, resp);
    		   HttpSession session=req.getSession();
    		   session.setAttribute("session_name", rs.getString("name"));
    		   session.setAttribute("session_email", rs.getString("email"));
    		   session.setAttribute("session_gender", rs.getString("gender"));
    		}
    		else {
    			out.print("<div style='position: absolute; top: 1.5rem; left: 50%; transform: translateX(-50%); font-size: 1.5em; color:blue;'>Email Id or Password is not matched</div>");

    			 RequestDispatcher rd=req.getRequestDispatcher("/sign_in.html");
      		   rd.include(req, resp);
    		}
    		
    	}
    	catch(Exception e) {
    		out.print("Exception:"+e.getMessage());
			 RequestDispatcher rd=req.getRequestDispatcher("/sign_in.html");
 		   rd.include(req, resp);
    	}
    }
}
