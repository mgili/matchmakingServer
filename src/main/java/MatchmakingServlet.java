
import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createMatch")
public class MatchmakingServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String matchId = request.getParameter("id");
        String port = request.getParameter("port");
        if(matchId == null || matchId.isEmpty() || port == null || port.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Match match = new Match(request.getRemoteAddr(), Integer.parseInt(port), matchId);
        MatchmakingContext context = MatchmakingContext.getInstance();
        if(context.getAllMatches().contains(match)) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return;
        }
        context.addMatch(match);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
