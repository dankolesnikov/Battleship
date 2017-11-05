package danil;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public class EndOFTheGame implements GameState {
    private BattleShip battleShip;
    private PlayerScreen player1;
    private PlayerScreen player2;

    EndOFTheGame(BattleShip battleShip, PlayerScreen player1, PlayerScreen player2){
        this.battleShip = battleShip;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void player1Turn (){
        System.out.println("end of the game player 1 ");
        System.exit(0);
    }
    public void player2turn (){
        System.out.println("end of the game player 2 ");
        System.exit(0);
    }
}