package in.sd.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signout")
public class SignOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session if it exists
            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req, resp);
        } else {
        	RequestDispatcher rd = req.getRequestDispatcher("/home2.html");
            rd.include(req, resp);
        }
        
        
    }
}
