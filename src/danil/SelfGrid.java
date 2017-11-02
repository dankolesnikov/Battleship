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
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

/**
 Represents the player's own grid
 */
public class SelfGrid extends BattleGrid {
    private String gridType = "selfGrid";
    private boolean isSelfGridListener;
    private int NUMBER_OF_SHIP = 5;
    private int count = 0;
    private String name;
    private Point firstPoint = new Point(0,0);
    private Point secondNextPoint = new Point(0,0);
    private JPanel secondNextCell = null;
    private Point thirdNextPoint = new Point(0,0);
    private JPanel thirdNextCell = null;
    private BattleShip battleShip;
    private JPanel thePanel = null;


    public SelfGrid(String name,BattleShip battleShip) {
        super();
        this.name = name;
        this.battleShip = battleShip;
    }

    public void getJpanel(Point newPoint){
        thePanel = this.getComponentAt(newPoint);
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
                if(isSelfGridListener) {
                    firstPoint = firstCell.getLocation();
                    double xPos = (firstPoint.getX()/20+1);
                    int x = (int) xPos;
                    double yPos = (firstPoint.getY()/20+1);
                    int y = (int) yPos;

                    double xPos2 = (firstPoint.getX()/20+2);
                    int x2 = (int) xPos2;
                    double yPos2 = (firstPoint.getY()/20+1);
                    int y2 = (int) yPos2;

                    double xPos3 = (firstPoint.getX()/20+3);
                    int x3 = (int) xPos3;
                    double yPos3 = (firstPoint.getY()/20+1);
                    int y3 = (int) yPos3;


                    System.out.print("\nLocation (X: " + x + " Y: " + y + ")");

                    secondNextPoint = new Point((int)(firstPoint.getX()+20),(int)(firstPoint.getY()));
                    thirdNextPoint = new Point((int)(firstPoint.getX()+40),(int)(firstPoint.getY()));
                    Coordinate a = new Coordinate(x,y);
                    Coordinate b = new Coordinate(x2,y2);
                    Coordinate c = new Coordinate(x3,y3);

                    getComp2(secondNextPoint);
                    getComp3(thirdNextPoint);

                    if(name.equals("Player1")){
                        battleShip.getPlayer1Data().addShip(a,b,c); // Create new ship object
                        draw();
                    }
                    if(name.equals("Player2")){
                        battleShip.getPlayer2Data().addShip(a,b,c); // Create new ship object
                        draw();
                    }
                }
            }
        });
        return firstCell;
    }

    public int panelXToNumber(Point p){
        double tempX = p.getLocation().getX()/20+1;
        int x = (int) tempX;
        return x;
    }
    public int panelYToNumber(Point p){
        double tempX = p.getLocation().getY()/20+1;
        int x = (int) tempX;
        return x;
    }
    public void setSelfGridListener (boolean selfGridListener){
        this.isSelfGridListener = selfGridListener;
    }

    public void draw(){

        int[][] temp=null;
        if(name.equals("Player1")){
            temp = battleShip.getPlayer1Data().getSelfData();
        }
        else if(name.equals("Player2")){
            temp = battleShip.getPlayer2Data().getSelfData();
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++)
            {
                if(temp[i][j]==1){
                    int x = numberToPanel(i);
                    int y = numberToPanel(j);
                    Point p = new Point(x,y);
                    getJpanel(p);
                    thePanel.setBackground(Color.CYAN);
                }
                else if(temp[i][j]==2){
                    int x = numberToPanel(i);
                    int y = numberToPanel(j);
                    Point p = new Point(x,y);
                    getJpanel(p);
                    thePanel.setBackground(Color.black);
                }
            }
        }
    }

    public int numberToPanel(int s){
        int temp = (s-1)*20;
        return temp;
    }


    public boolean getSelfGridListener() {
        return isSelfGridListener;
    }
    public String getGridType(){
        return gridType;
    }
}