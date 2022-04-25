public class PlugBoard {
    private int[] plugBoard;

    public PlugBoard() {
        this.plugBoard = new int[26];
        for(int i = 0; i < plugBoard.length; i++) {
            plugBoard[i] = i;
        }
    }

    public boolean isConnected(int a) {
        return plugBoard[a] != a;
    }

    public void connect(int a, int b) {
        if(!isConnected(a) && !isConnected(b)) {
            plugBoard[a] = b;
            plugBoard[b] = a;
        }
    }

    public void disconnect(int a, int b) {
        if(isConnected(a) && isConnected(b)) {
            plugBoard[a] = a;
            plugBoard[b] = b;
        }
    }

    public void resetConnections() {
        for(int i = 0; i < plugBoard.length; i++) {
            plugBoard[i] = i;
        }
    }

    public int get(int a) {
        return plugBoard[a];
    }
}
