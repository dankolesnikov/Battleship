package danil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;

import danil.PlayerData;
import danil.BattleGrid;

/**
Represents the player's own grid
*/
public class SelfGrid extends BattleGrid {
    private int NUMBER_OF_SHIP = 5;
    private int count = 0;
    private String name;
    private Point secondNextPoint = new Point(0,0);
    private JPanel secondNextCell = null;
    private Point thirdNextPoint = new Point(0,0);
    private JPanel thirdNextCell = null;

    public SelfGrid(String name) {
        super();
        this.name = name;

    }

    public void getComp2(Point newPoint){
        secondNextCell = this.getComponentAt(newPoint);
    }

    public void getComp3(Point newPoint){
        thirdNextCell = this.getComponentAt(newPoint);
    }

    @Override
    protected JPanel getCell()
    {

        JPanel firstCell = new JPanel();
        firstCell.setBackground(Color.black);
        firstCell.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        firstCell.setPreferredSize(new Dimension(20, 20)); // for demo purposes only
        firstCell.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //firstCell.setBackground(Color.CYAN);

                Point i = firstCell.getLocation();
                double xPos = (i.getX()/20+1);
                int x = (int) xPos;
                double yPos = (i.getY()/20+1);
                int y = (int) yPos;

                double xPos2 = (i.getX()/20+2);
                int x2 = (int) xPos2;
                double yPos2 = (i.getY()/20+1);
                int y2 = (int) yPos2;

                double xPos3 = (i.getX()/20+3);
                int x3 = (int) xPos3;
                double yPos3 = (i.getY()/20+1);
                int y3 = (int) yPos3;

                secondNextPoint = new Point((int)(i.getX()+20),(int)(i.getY()));
                thirdNextPoint = new Point((int)(i.getX()+40),(int)(i.getY()));
                getComp2(secondNextPoint);
                getComp3(thirdNextPoint);

                if(secondNextCell != null && thirdNextCell != null && !secondNextCell.getBackground().equals(Color.CYAN)
                        && !thirdNextCell.getBackground().equals(Color.CYAN) && count < NUMBER_OF_SHIP) {
                    if(name.equals("Player1")){
                        System.out.print("\n***"+name+"***");
                        System.out.print("\nPlayer1: selfData array to 1 at  (X: "+x+" Y: "+y+")");
                        System.out.print("\nPlayer1: selfData array to 1 at  (X: "+x2+" Y: "+y2+")");
                        System.out.print("\nPlayer1: selfData array to 1 at  (X: "+x3+" Y: "+y3+")");
                      //  BattleShip.player1Data.setSelfData(x,y);
                       // BattleShip.player1Data.setSelfData(x2,y2);
                       // BattleShip.player1Data.setSelfData(x3,y3);
                    }
                    if(name.equals("Player2")){
                        System.out.print("\nPlayer2: selfData array to 1 at  (X: "+x+" Y: "+y+")");
                        System.out.print("\nPlayer2: selfData array to 1 at  (X: "+x2+" Y: "+y2+")");
                        System.out.print("\nPlayer2: selfData array to 1 at  (X: "+x3+" Y: "+y3+")");
                        BattleShip.player2Data.setSelfData(x,y);
                        BattleShip.player2Data.setSelfData(x2,y2);
                        BattleShip.player2Data.setSelfData(x3,y3);
                        System.out.print("\nPlayer 1 SelfData:\n");
                        BattleShip.player1Data.printSelfData();
                        System.out.print("\nPlayer 2 SelfData:\n");
                        BattleShip.player2Data.printSelfData();
                    }
                    count++;
                    firstCell.setBackground(Color.CYAN);
                    secondNextCell.setBackground(Color.CYAN);
                    thirdNextCell.setBackground(Color.CYAN);
                }
            }
        });
        return firstCell;
    }
}