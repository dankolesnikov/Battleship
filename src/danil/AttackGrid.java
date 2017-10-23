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
                //String lol = BattleShip.player1.getTitle();
                // System.out.print("***"+name+"***");
                if(name.equals("Player1")){
                    BattleShip.player1Data.setAttackData(x,y);
                    System.out.print("\nPlayer1: Set attackData array to 1 at    (X: "+x+" Y: "+y+")");
                    boolean success = BattleShip.player2Data.isHit(x,y);
                    if(success){
                        System.out.print("\nSuccess for Player1! Hit at     (X: "+x+" Y: "+y+")");
                        panel.setBackground(Color.GREEN);
                    }
                    else{
                        panel.setBackground(Color.WHITE);
                        System.out.print("\nMiss for Player 1!");
                    }
                    if(BattleShip.player2Data.isLoser()){
                        System.out.print("Player 1 is WINNER! Congratulations.");
                        JOptionPane.showMessageDialog(panel,"Player 1 WON!");
                    }
                }
                if(name.equals("Player2")){
                    BattleShip.player2Data.setAttackData(x,y);
                    System.out.print("\nPlayer2: Set attackData array to 1 at    (X: "+x+" Y: "+y+")");
                    System.out.print("\nPlayer 1 SelfData:\n");
                    BattleShip.player1Data.printSelfData();
                    System.out.print("\nPlayer 2 SelfData:\n");
                    BattleShip.player2Data.printSelfData();
                    System.out.print("\nPlayer 2 Attack Data:\n");
                    BattleShip.player2Data.printAttackData();
                    boolean success = BattleShip.player1Data.isHit(x,y);
                    if(success){
                        panel.setBackground(Color.GREEN);
                        System.out.print("\nSuccess for Player2! Hit at     (X: "+x+" Y: "+y+")");
                    }
                    else{
                        System.out.print("\nFailure!");
                        panel.setBackground(Color.WHITE);
                    }
                    if(BattleShip.player1Data.isLoser()){
                        System.out.print("Player 2 is WINNER! Congratulations.");
                        JOptionPane.showMessageDialog(panel,"Player 2 WON!");
                    }
                }



            }
        });

        return panel;
    }
}