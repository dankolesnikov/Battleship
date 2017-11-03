package danil;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public class BattleShip implements GameState {
    private GameState beginningOfTheGame;
    private GameState middleOfTheGame;
    private GameState endOfTheGame;
    private GameState state;

    private PlayerData player1Data;
    private PlayerData player2Data;
    private PlayerScreen player1 ;
    private PlayerScreen player2;

    private BattleShip() {
        player1 = new PlayerScreen("Player1", true,this);
        player2 = new PlayerScreen("Player2", false,this);
        player1Data = new PlayerData(player1);
        player2Data = new PlayerData(player2);
        beginningOfTheGame = new BeginningOfTheGame(this, player1,player2);
        middleOfTheGame = new MiddleOfTheGame(this, player1,player2);
        endOfTheGame = new EndOfTheGame(this, player1,player2);

        this.state = beginningOfTheGame;
    }

    public static void main(String[] args) {
        BattleShip game = new BattleShip();
        game.player1Turn();
        game.player2turn();
    }

    public void player1Turn() {
        state.player1Turn();

    }


    // State
    public void player2turn() {
        state.player2turn();
    }

    public void setBeginningOfTheGame(GameState beginningOfTheGame) {
        this.beginningOfTheGame = beginningOfTheGame;
    }

    public GameState getBeginningOfTheGame() {
        return beginningOfTheGame;
    }

    public void setMiddleOfTheGame(GameState middleOfTheGame) {
        this.middleOfTheGame = middleOfTheGame;
    }

    public GameState getMiddleOfTheGame() {
        return middleOfTheGame;
    }

    public void setEndOfTheGame(GameState endOfTheGame) {
        this.endOfTheGame = endOfTheGame;
    }

    public GameState getEndOfTheGame() {
        return endOfTheGame;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return this.state;
    }

    public PlayerData getPlayer2Data() {
        return player2Data;
    }

    public PlayerData getPlayer1Data() {
        return player1Data;
    }

    public PlayerScreen getPlayer1() {
        return player1;
    }

    public PlayerScreen getPlayer2() {
        return player2;
    }
}