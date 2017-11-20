package danil;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public class BattleShip implements GameState {
    private GameState beginningOfTheGame; //begin of the game AttackGrid is OFF and SelfGrid is ON
    private GameState middleOfTheGame; //middle of the game AttackGrid is ON and SelfGrid is OFF
    private GameState endOfTheGame; // end the game when one of the player win
    private GameState state;
    private boolean takeTurnAttack; // make sure each player can only attack ONCE

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
        endOfTheGame = new EndOFTheGame(this, player1,player2);
        this.state = beginningOfTheGame; //set the state of the game to be the beginning of the game
    }

    public static void main(String[] args) {
        BattleShip game = new BattleShip();
        game.player1Turn();
        game.player2turn();
    }

    public void player1Turn() {
        state.player1Turn();

    }

    public void player2turn() {
        state.player2turn();
    }

    // method to transfer the game from beginning to middle of the game
    public GameState getMiddleOfTheGame() {
        return middleOfTheGame;
    }

    // method to transfer the game from middle to the end of the game
    public GameState getEndOfTheGame() {
        return endOfTheGame;
    }

    // method to set the state of the game to the desired state
    public void setState(GameState state) {
        this.state = state;
    }

    public void setTakeTurnAttack(boolean isPlayerTurn){
        this.takeTurnAttack = isPlayerTurn;
    }

    public boolean getTakeTurnAttack() {
        return takeTurnAttack;
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