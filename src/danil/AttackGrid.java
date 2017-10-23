package danil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import danil.BattleShip;

/**
Represents the player's own grid
*/
public class AttackGrid extends BattleGrid {
    private String name;

    public AttackGrid(String name) {
        super();
        this.name = name;
        
    }

    @Override
    protected JPanel getCell()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        panel.setPreferredSize(new Dimension(20, 20)); // for demo purposes only

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.setBackground(Color.WHITE);
                Point i = panel.getLocation();
                double xPos = (i.getX()/20+1);
                int x = (int) xPos;
                double yPos = (i.getY()/20+1);
                int y = (int) yPos;
                if(name.equals("Player1")){
                    BattleShip.player1Data.setAttackData(x,y);
                    System.out.print("\nPlayer1: Set attackData array to 1 at    (X: "+x+" Y: "+y+")");
                    boolean success = BattleShip.player1Data.isHit(x,y);
                    if(success){
                        System.out.print("\nSuccess! Hit at     (X: "+x+" Y: "+y+")");
                        panel.setBackground(Color.GREEN);

                        // TODO: Display a success message
                    }
                    else{
                        panel.setBackground(Color.WHITE);
                        System.out.print("\nFailure!");
                        // TODO: Display a failure message
                    }
                }
                if(name.equals("Player2")){
                    BattleShip.player2Data.setAttackData(x,y);
                    System.out.print("\nPlayer2: Set attackData array to 1 at    (X: "+x+" Y: "+y+")");
                    boolean success = BattleShip.player2Data.isHit(x,y);
                    if(success){
                        panel.setBackground(Color.GREEN);
                        System.out.print("\nSuccess! Hit at     (X: "+x+" Y: "+y+")");
                        // TODO: Display a success message
                    }
                    else{
                        System.out.print("\nFailure!");
                        panel.setBackground(Color.WHITE);

                        // TODO: Display a failure message
                    }
                }



            }
        });

        return panel;
    }
}