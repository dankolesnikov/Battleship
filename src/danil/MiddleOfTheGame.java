package danil;

public class MiddleOfTheGame implements GameState{
    private BattleShip battleShip;

    MiddleOfTheGame(BattleShip battleShip){
        this.battleShip = battleShip;
    }

    public void player1Turn (){
        System.out.println("middle of the game player 1 ");
        System.out.println("if player 1 win, switch to end of the game ");
        //if statement to switch
        //battleShip.setState(battleShip.getEndOfTheGame());

    }
    public void player2turn (){
        System.out.println("middle of the game player 2 ");
        System.out.println("if player 2 win, switch to end of the game ");
        //if statement to switch
        //battleShip.setState(battleShip.getEndOfTheGame());



    }



}
