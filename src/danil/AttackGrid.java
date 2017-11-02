package danil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

/**
 Represents the player's own grid
 */
public class AttackGrid extends BattleGrid {
    private String name;
    private int enemyShipSunkPlayer1 = 0;
    private int enemyShipSunkPlayer2 = 0;
    private boolean isAttackGridListener=true;

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
                if(isAttackGridListener) {
                    Point i = panel.getLocation();
                    double xPos = (i.getX() / 20 + 1);
                    int x = (int) xPos;
                    double yPos = (i.getY() / 20 + 1);
                    int y = (int) yPos;

                    if (name.equals("Player1")) {
                        BattleShip.player1Data.setAttackData(x, y);

                        Coordinate hit = new Coordinate(x, y);
                        BattleShip.player2Data.attackShip(hit);

                        boolean success = BattleShip.player2Data.isHit(hit);
                        if (success) {
                            System.out.print("\nSuccess for Player1! Hit at (X: " + x + " Y: " + y + ")");
                            System.out.print("Player 2 fleet size: " + BattleShip.player2Data.shipsLeft());
                            panel.setBackground(Color.GREEN);
                        } else {
                            panel.setBackground(Color.WHITE);
                        }

                        boolean isSunk = BattleShip.player2Data.isSunk(hit);
                        if (isSunk) {
                            enemyShipSunkPlayer1++;
                            BattleShip.player1.enemyShipSunk.setText(Integer.toString(enemyShipSunkPlayer1));
                            JOptionPane.showMessageDialog(panel, "Player's 2 ship was sunk! Congratulations!");
                            String ownShipSunkPlayer2 = Integer.toString(BattleShip.player2Data.getNumberOfOwnShipSunk());
                            BattleShip.player2.ownShipSunk.setText(ownShipSunkPlayer2);
                        }
                        boolean lost = BattleShip.player2Data.isPlayerLost();
                        if (lost) {
                            JOptionPane.showMessageDialog(panel, "You(player 1) WON! Congratulations!");
                        }
                    }
                    if (name.equals("Player2")) {
                        BattleShip.player2Data.setAttackData(x, y);
                        Coordinate hit = new Coordinate(x, y);
                        BattleShip.player1Data.attackShip(hit);

                        boolean success = BattleShip.player1Data.isHit(hit);
                        if (success) {
                            panel.setBackground(Color.GREEN);
                            System.out.print("\nSuccess for Player2! Hit at (X: " + x + " Y: " + y + ")");
                            System.out.print("Player 1 fleet size: " + BattleShip.player1Data.shipsLeft());

                        } else {
                            panel.setBackground(Color.WHITE);
                        }

                        boolean isSunk = BattleShip.player1Data.isSunk(hit);
                        if (isSunk) {
                            enemyShipSunkPlayer2++;
                            BattleShip.player2.enemyShipSunk.setText(Integer.toString(enemyShipSunkPlayer2));
                            JOptionPane.showMessageDialog(panel, "Player's 1 ship was sunk! Congratulations!");
                            String ownShipSunkPlayer1 = Integer.toString(BattleShip.player1Data.getNumberOfOwnShipSunk());
                            BattleShip.player1.ownShipSunk.setText(ownShipSunkPlayer1);
                        }

                        boolean lost = BattleShip.player1Data.isPlayerLost();
                        if (lost) {
                            JOptionPane.showMessageDialog(panel, "You(player 2) WON! Congratulations!");
                        }
                    }


                }
            }
        });

        return panel;
    }
    public void setAttackGridListener (boolean attackGridListener){
        this.isAttackGridListener = attackGridListener;

    }

    public boolean getAttackGridListener() {
        return isAttackGridListener;
    }
}