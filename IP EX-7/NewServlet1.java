import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet1 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Book> books = new ArrayList<>();
            books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
            books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
            books.add(new Book("1984", "George Orwell"));
            books.add(new Book("Pride and Prejudice", "Jane Austen"));
            books.add(new Book("The Catcher in the Rye", "J.D. Salinger"));
            String sortType = request.getParameter("sortType");
            if (sortType.equals("title")) {
                Collections.sort(books, Comparator.comparing(Book::getTitle));
            } else if (sortType.equals("author")) {
                Collections.sort(books, Comparator.comparing(Book::getAuthor));
            }
            out.println("<html><head><title>Sorted Books</title></head><body>");
            out.println("<h2>Sorted Books</h2>");
            out.println("<ul>");
            books.forEach((book) -> {
                out.println("<li>" + book.getTitle() + " by " + book.getAuthor() + "</li>");
            });
            out.println("</ul>");
            out.println("</body></html>");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    public String getServletInfo() {
        return "Short description";
    }
}

class Book {
    private final String title;
    private final String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
}
