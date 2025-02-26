import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getAllMatches")
public class GetMatchesServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        MatchmakingContext context = MatchmakingContext.getInstance();
        ArrayList<Match> matches = context.getAllMatches();
        Gson g = new Gson();
        String json = g.toJson(matches);
        response.setContentType("application/json");
        try {
            response.getWriter().write(json);
        } catch (IOException ex) {
            System.err.println("Error writing JSON response in GetMatchesServlet: " + ex.getMessage());
        }
    }
}
