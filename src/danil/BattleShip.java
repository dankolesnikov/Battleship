package danil;

public class BattleShip {
    private GameState state;

    private BattleShip(GameState state){
        this.state = state;
    }

    static PlayerData player1Data = new PlayerData();
    static PlayerData player2Data = new PlayerData();

    public static void main(String[] args) {

        PlayerScreen player1 = new PlayerScreen("Player1", true);
        PlayerScreen player2 = new PlayerScreen("Player2", true);

        BattleShip b1 = new BattleShip(new BeginningOfTheGame());
        b1.nextState(player1,player2,player1Data,player2Data);

        b1.setState(new MiddleOfTheGame());
        b1.nextState(player1,player2,player1Data,player2Data);

    }


    public void nextState(PlayerScreen player1, PlayerScreen player2, PlayerData player1Data, PlayerData player2Data){
        state.nextState(this,player1,player2,player1Data,player2Data);
    }

    public void setState(GameState state){
        this.state = state;
    }

    public GameState getState(){
        return this.state;
    }

}