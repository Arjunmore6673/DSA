package codingninja.object4.tickTack;

public class Player {
    String playerName;
    char symbol;

    public Player(String playerName, char symbol) {
        setPlayerName(playerName);
        setSymbol(symbol);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        if (!playerName.isEmpty())
            this.playerName = playerName;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        if (symbol != '\0')
            this.symbol = symbol;
    }
}
