package in.sd.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email1");
        String newPassword = request.getParameter("pass1");

       
        String sql = "UPDATE details SET password = ? WHERE email = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details_db", "root", "Tuku24@#")) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, newPassword);
                statement.setString(2, email);

                int rowsUpdated = statement.executeUpdate();
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                if (rowsUpdated > 0) {
                	 out.print("<div style='text-align:center; margin-top:20px;'>");
                     out.print("<h2>Password updated successfully!</h2>");
                     out.print("</div>"); 
                    RequestDispatcher rd=request.getRequestDispatcher("/sign_in.html");
          		   rd.include(request, response);
                } else {
                    
                	out.print("<div style='text-align:center; margin-top:20px;'>");
                    out.print("<h2>Error: Email not found!</h2>");
                    out.print("</div>");
                    RequestDispatcher rd=request.getRequestDispatcher("/resetPassword.html");
           		   rd.include(request, response);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }
}

