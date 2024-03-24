import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Count Vowels</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Enter a Word to Count Vowels</h2>");
            out.println("<form action='NewServlet' method='post'>");
            out.println("<input type='text' name='word' required>");
            out.println("<input type='submit' value='Count Vowels'>");
            out.println("</form>");
            String word = request.getParameter("word");
            if (word != null && !word.isEmpty()) {
                int vowelCount = countVowels(word);
                out.println("<p>Number of vowels in the word: " + vowelCount + "</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    private int countVowels(String word) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : word.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    public String getServletInfo() {
        return "Short description";
    }
}
