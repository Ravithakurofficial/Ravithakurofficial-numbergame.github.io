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
    private int randomNum;
    private int attempt = 5;
    private int a = 1;
    
    public random_guess() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        request.setAttribute("latestA", a);
        String minStr = request.getParameter("Min");
        String maxStr = request.getParameter("Max");
        String userGuessStr = request.getParameter("userguess");
        
        try {
            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);
            int userGuess = Integer.parseInt(userGuessStr);
            
            
            
            if (randomNum == 0) {
                Random randomValue = new Random();
                randomNum = randomValue.nextInt(max - min + 1) + min;
                System.out.println("Secret number is " + randomNum);
            }
            
            attempt--;
            if (randomNum != userGuess && randomNum > userGuess) {
                pw.println("<h1>your guess is low go for high Number</h1>");
                
            } else if (randomNum != userGuess && randomNum < userGuess) {
                pw.println("<h1>your guess is high go for low Number</h1>");
                
            } else if (randomNum == userGuess) {
                int a = 0;
                pw.println("<h1>Your Guess Is Correct</h1>");
                pw.println("<h3 style=\"color: blue;\"><a href = \"index.html\">Want to play again?</a></h3>");
                randomNum = 0;
            	attempt = 5;
            	
                
            } else {
                pw.println("<h1>problem</h1>");
            }
            
            if(attempt == 0) {
            	attempt = 5;
            	pw.println("<h1>Sorry You Are not able to guess</h1>");
            	pw.println("<h3 style=\"color: blue;\"><a href = \"index.html\">play again?<a/></h3>");
            	pw.println("<h2>Your Secret number is"+randomNum);
            	randomNum = 0;
            	}
            
        } catch (NumberFormatException e) {
            pw.println("<p>Invalid input. Please enter valid numbers.</p>");
        }
    }
}
