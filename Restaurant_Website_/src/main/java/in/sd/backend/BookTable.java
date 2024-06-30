package in.sd.backend;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/download")


	
public class BookTable extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String bookingId = request.getParameter("bookingId");

        response.setContentType("text/html");
        response.setHeader("Content-Disposition", "attachment;filename=booking_confirmation.html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Booking Confirmation</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 20px; }");
            out.println(".confirmation { border: 1px solid #ddd; padding: 20px; border-radius: 5px; max-width: 600px; margin: auto; }");
            out.println(".confirmation h2, .confirmation h3 { color: #333; }");
            out.println(".confirmation h2 { border-bottom: 2px solid #ddd; padding-bottom: 10px; margin-bottom: 20px; }");
            out.println(".confirmation p { font-size: 16px; line-height: 1.5; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='confirmation'>");
            out.println("<h2>Booking Confirmation</h2>");
            out.println("<h3>Hi " + name + ",</h3>");
            out.println("<p>Your reservation at Calcutta 64 is confirmed!</p>");
            out.println("<p><strong>Where:</strong> Sector 5, Salt Lake</p>");
            out.println("<p><strong>Date:</strong> " + date + "</p>");
            out.println("<p><strong>Time:</strong> " + time + "</p>");
            out.println("<p><strong>Booking ID:</strong> " + bookingId + "</p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}