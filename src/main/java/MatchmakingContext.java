import java.util.ArrayList;

public class MatchmakingContext {
    
    private static MatchmakingContext instance = null;
    private final ArrayList<Match> matches = new ArrayList<>();
    private MatchmakingContext() {
    }

    public static MatchmakingContext getInstance() {
        if (instance == null) {
            instance = new MatchmakingContext();
        }
        return instance;
    }
    
    public ArrayList<Match> getAllMatches() {
        return matches;
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public void removeMatch(Match match) {
        matches.remove(match);
    }

    public synchronized Match getMatch(String matchID) {
        for (Match match : matches) {
            if (match.getMatchID().equals(matchID)) {
                return match;
            }
        }
        return null;
    }
}
