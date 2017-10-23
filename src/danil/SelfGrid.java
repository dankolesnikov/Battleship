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
    private String name;
    public SelfGrid(String name) {
        super();
        this.name = name;

    }


    @Override
    protected JPanel getCell()
    {

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        panel.setPreferredSize(new Dimension(20, 20)); // for demo purposes only
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.setBackground(Color.CYAN);

                Point i = panel.getLocation();
                double xPos = (i.getX()/20+1);
                int x = (int) xPos;
                double yPos = (i.getY()/20+1);
                int y = (int) yPos;
                if(name.equals("Player1")){
                    System.out.print("\nPlayer1: selfData array to 1 at  (X: "+x+" Y: "+y+")");
                    BattleShip.player1Data.setSelfData(x,y); // But which player?
                }
                if(name=="Player2"){
                    System.out.print("\nPlayer2: Set selfData array to 1 at  (X: "+x+" Y: "+y+")");
                    BattleShip.player2Data.setSelfData(x,y); // But which player?

                }
            }
        });
        return panel;
    }
}