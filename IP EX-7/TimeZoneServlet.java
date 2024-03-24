import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayTimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String userTimezone = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_timezone")) {
                    userTimezone = cookie.getValue();
                    break;
                }
            }
        }
        response.setContentType("text/html");
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone(userTimezone));
        String currentTime = sdf.format(currentDate);
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Current Time</title></head><body>");
        out.println("<h2>Current Time in Your Timezone (" + userTimezone + "):</h2>");
        out.println("<p>" + currentTime + "</p>");
        out.println("</body></html>");
    }
}
