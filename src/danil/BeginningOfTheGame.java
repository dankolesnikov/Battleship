package danil;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public class BeginningOfTheGame implements GameState {
    private BattleShip battleShip;
    private PlayerScreen player1;
    private PlayerScreen player2;

    BeginningOfTheGame(BattleShip battleShip,PlayerScreen player1,PlayerScreen player2){
        this.player1 = player1;
        this.player2 = player2;
        this.battleShip = battleShip;
    }

    public void player1Turn (){
        //player2.getSelfGrid().setSelfGridListener(true);
        player1.getSelfGrid().setSelfGridListener(true);

        System.out.println("Begginng of the Game for player 1");
    }
    public void player2turn (){
        player2.getSelfGrid().setSelfGridListener(true);

        System.out.println("Begginng of the Game for player 2");
        battleShip.setState(battleShip.getMiddleOfTheGame());
    }

}