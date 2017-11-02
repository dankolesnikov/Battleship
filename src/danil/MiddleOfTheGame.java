package danil;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public class MiddleOfTheGame implements GameState{
    private BattleShip battleShip;
    private PlayerScreen player1;
    private PlayerScreen player2;

    MiddleOfTheGame(BattleShip battleShip,PlayerScreen player1,PlayerScreen player2){
        this.battleShip = battleShip;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void player1Turn (){
        player1.getSelfGrid().setSelfGridListener(false);
        player1.getAttackGrid().setAttackGridListener(true);

        System.out.println("middle of the game player 1 ");
        //System.out.println("if player 1 win, switch to end of the game ");
        //if statement to switch
        //battleShip.setState(battleShip.getEndOfTheGame());

    }
    public void player2turn (){
        player2.getSelfGrid().setSelfGridListener(false);
        player2.getAttackGrid().setAttackGridListener(true);
        System.out.println("middle of the game player 2 ");
        //System.out.println("if player 2 win, switch to end of the game ");
        //if statement to switch
        //battleShip.setState(battleShip.getEndOfTheGame());



    }



}