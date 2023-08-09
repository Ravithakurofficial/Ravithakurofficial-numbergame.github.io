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
    private int randomNum; // Store the generated random number
    
    public random_guess() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
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
            
            if (randomNum != userGuess && randomNum > userGuess) {
                pw.println("low");
            } else if (randomNum != userGuess && randomNum < userGuess) {
                pw.println("high");
            } else if (randomNum == userGuess) {
                int a = 0;
                pw.println(a);
            } else {
                pw.println("problem");
            }
        } catch (NumberFormatException e) {
            pw.println("<p>Invalid input. Please enter valid numbers.</p>");
        }
    }
}
