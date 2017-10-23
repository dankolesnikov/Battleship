package danil;

public class BattleShip implements GameState {
    private GameState beginningOfTheGame;
    private GameState middleOfTheGame;
    private GameState endOfTheGame;
    private GameState state;

    static PlayerData player1Data = new PlayerData();
    static PlayerData player2Data = new PlayerData();
<<<<<<< HEAD
    static PlayerScreen player1 = new PlayerScreen("Player1", true);
    static PlayerScreen player2 = new PlayerScreen("Player2", true);
=======
    PlayerScreen player1 = new PlayerScreen("Player1", true);
    PlayerScreen player2 = new PlayerScreen("Player2", true);
>>>>>>> pr/2

    private BattleShip(){
        beginningOfTheGame = new BeginningOfTheGame(this);
        middleOfTheGame = new MiddleOfTheGame(this);
        endOfTheGame = new EndOFTheGame(this);

<<<<<<< HEAD

=======
        this.state = beginningOfTheGame;
    }

    public static void main(String[] args) {
        BattleShip game = new BattleShip();
        game.player1Turn();
        game.player2turn();
        game.player1Turn();
        game.player2turn();
        game.player1Turn();
        game.player2turn();
>>>>>>> pr/2

    }

    public void player1Turn (){
        state.player1Turn();

    }
    public void player2turn (){
        state.player2turn();
    }

    public void setBeginningOfTheGame(GameState beginningOfTheGame){
        this.beginningOfTheGame = beginningOfTheGame;
    }
    public GameState getBeginningOfTheGame (){
        return beginningOfTheGame;
    }
    public void setMiddleOfTheGame(GameState middleOfTheGame){
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

    public void setState(GameState state){
        this.state = state;
    }
    public GameState getState(){
        return this.state;
    }

}