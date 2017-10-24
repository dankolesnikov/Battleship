package danil;

public class BeginningOfTheGame implements GameState {
    private BattleShip battleShip;

    BeginningOfTheGame(BattleShip battleShip){
        this.battleShip = battleShip;
    }

    public void player1Turn (){
        System.out.println("Begginng of the Game for player 1");
    }
    public void player2turn (){
        System.out.println("Begginng of the Game for player 2");
        battleShip.setState(battleShip.getMiddleOfTheGame());
    }

}
