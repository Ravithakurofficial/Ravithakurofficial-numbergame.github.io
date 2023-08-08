import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/random_guess")
public class random_guess extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public random_guess() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String minStr = request.getParameter("Min");
        String maxStr = request.getParameter("Max");
        
        try {
            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);
            
            pw.println("<h1>Welcome to the Guessing Game!</h1>");
            pw.println("Entered minimum number: " + min);
            pw.println("Entered maximum number: " + max);
            
            // Perform any other logic here
            
        } catch (NumberFormatException e) {
            pw.println("<p>Invalid input. Please enter valid numbers.</p>");
        }
    }
}
