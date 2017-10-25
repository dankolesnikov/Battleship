package danil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
                Point i = panel.getLocation();
                double xPos = (i.getX()/20+1);
                int x = (int) xPos;
                double yPos = (i.getY()/20+1);
                int y = (int) yPos;

                if(name.equals("Player1")){
                    BattleShip.player1Data.setAttackData(x,y);
                    Coordinate hit = new Coordinate(x,y);
                    BattleShip.player2Data.attackShip(hit);

                    boolean success = BattleShip.player2Data.isHit(hit);
                    if(success){
                        System.out.print("\nSuccess for Player1! Hit at (X: "+x+" Y: "+y+")");
                        System.out.print("Player 2 fleet size: "+BattleShip.player2Data.shipsLeft());
                        panel.setBackground(Color.GREEN);
                    }
                    else{
                        panel.setBackground(Color.WHITE);
                    }

                    boolean isSunk = BattleShip.player2Data.isSunk(hit);
                    if(isSunk){
                        JOptionPane.showMessageDialog(panel,"Player's 2 ship was sunk! Congratulations!");

                    }
                    boolean lost = BattleShip.player2Data.isPlayerLost();
                    if(lost){
                        JOptionPane.showMessageDialog(panel,"You(player 1) WON! Congratulations!");
                    }
                }
                if(name.equals("Player2")){
                    BattleShip.player2Data.setAttackData(x,y);
                    Coordinate hit = new Coordinate(x,y);
                    BattleShip.player1Data.attackShip(hit);

                    boolean success = BattleShip.player1Data.isHit(hit);
                    if(success){
                        panel.setBackground(Color.GREEN);
                        System.out.print("\nSuccess for Player2! Hit at (X: "+x+" Y: "+y+")");
                        System.out.print("Player 1 fleet size: "+BattleShip.player1Data.shipsLeft());

                    }
                    else{
                        panel.setBackground(Color.WHITE);
                    }

                    boolean isSunk = BattleShip.player1Data.isSunk(hit);
                    if(isSunk){
                        JOptionPane.showMessageDialog(panel,"Player's 1 ship was sunk! Congratulations!");
                    }

                    boolean lost = BattleShip.player1Data.isPlayerLost();
                    if(lost){
                        JOptionPane.showMessageDialog(panel,"You(player 2) WON! Congratulations!");
                    }
                }



            }
        });

        return panel;
    }
}