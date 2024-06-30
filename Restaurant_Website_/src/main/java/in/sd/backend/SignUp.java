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

@SuppressWarnings("serial")
@WebServlet("/registration")
public class SignUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        String myname = req.getParameter("name1");
        String myemail = req.getParameter("email1");
        String mypassword = req.getParameter("pass1");
        String mygender = req.getParameter("gender1");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details_db", "root", "Tuku24@#");

            // Check if the email already exists
            PreparedStatement checkStmt = con.prepareStatement("SELECT COUNT(*) FROM details WHERE email = ?");
            checkStmt.setString(1, myemail);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                out.print("<div style='position: absolute; top: 1.5rem; left: 50%; transform: translateX(-50%); font-size: 1.5em; color:red;'>Email already registered. Please sign in.</div>");
                RequestDispatcher rd = req.getRequestDispatcher("/sign_in.html");
                rd.include(req, resp);
            } else {
                // Insert new user details
                PreparedStatement ps = con.prepareStatement("INSERT INTO details VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, myname);
                ps.setString(2, myemail);
                ps.setString(3, mypassword);
                ps.setString(4, mygender);
                ps.setString(5, null);
                int count = ps.executeUpdate();
                if (count > 0) {
                    out.print("<div style='position: absolute; top: 1.5rem; left: 50%; transform: translateX(-50%); font-size: 1.5em; color:blue;'>Signed Up Successfully!</div>");
                    RequestDispatcher rd = req.getRequestDispatcher("/sign_in.html");
                    rd.include(req, resp);
                } else {
                    out.print("<div style='position: absolute; top: 1.5rem; left: 50%; transform: translateX(-50%); font-size: 1.5em; color:red;'>Unsuccessful, Try Again</div>");
                    RequestDispatcher rd = req.getRequestDispatcher("/sign_up.html");
                    rd.include(req, resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<div style='position: absolute; top: 1.5rem; left: 50%; transform: translateX(-50%); font-size: 1.5em;'>Exception: " + e.getMessage() + "</div>");
            RequestDispatcher rd = req.getRequestDispatcher("/sign_up.html");
            rd.include(req, resp);
        }
    }
}
