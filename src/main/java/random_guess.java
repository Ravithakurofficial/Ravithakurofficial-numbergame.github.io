import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

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
        String Userstr = request.getParameter("userguess");
        
        try {
            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);
            int userin = Integer.parseInt(Userstr);
            
            
            pw.println("<h1>Welcome to the Guessing Game!</h1>");
            //pw.println("Entered minimum number: " + min);
            //pw.println("Entered maximum number: " + max);
            //pw.println("user guess"+userin);
            Random randomValue = new Random();
            int random = randomValue.nextInt(max - min + 1) + min;
            pw.println("Secret number is " +random);
            
            if(random != userin && random > userin){
            	pw.println("your guess is low");
            }
            else if(random != userin && random < userin) {
            	pw.println("Your guess is high");
            }
            else if(random == userin) {
            	pw.println("Your guess is correct");
            }
            else {
            	pw.println("other problem");
            }
        } catch (NumberFormatException e) {
            pw.println("<p>Invalid input. Please enter valid numbers.</p>");
        }
    }
}
