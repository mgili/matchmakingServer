import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/chooseMatch")
public class ChooseMatch extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String matchId = request.getParameter("id");
        if(matchId == null || matchId.isEmpty()){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        MatchmakingContext context = MatchmakingContext.getInstance();
        Match match = context.getMatch(matchId);
        if(match == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        context.removeMatch(match);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
