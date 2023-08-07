

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/index.html")

/**
 * Servlet implementation class Random_guess
 */
public class Random_guess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Random_guess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter pw = response.getWriter();
	        String min = request.getParameter("Min");
	        String max = request.getParameter("Max");
	        
	        int mi = Integer.parseInt(min);
	        int ma = Integer.parseInt(max);
	        
	        pw.println("enter numbers are "+mi);
	        pw.println("enter numbers are "+ma);
	        
	        
	        
	}

}
