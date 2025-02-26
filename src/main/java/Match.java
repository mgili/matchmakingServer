public class Match {
    
    private final String hostAddress;
    private final int hostPort;
    private final String id;

    public Match(String hostAddress, int hostPort, String id) {
        this.hostAddress = hostAddress;
        this.hostPort = hostPort;
        this.id = id;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public int getHostPort() {
        return hostPort;
    }

    public String getMatchID() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Match other) {
            return this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
