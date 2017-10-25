package danil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class PlayerScreen extends JFrame {
    public PlayerScreen(String name,int size, boolean show) {
        super(name);
        super(size);
        this.setLayout(new BorderLayout());
        this.add(new SelfGrid(name), BorderLayout.EAST);
        this.add(new AttackGrid(name), BorderLayout.WEST);
        this.add(new JLabel(name), BorderLayout.NORTH);
        JButton next = new JButton("next");
        Box horizontalBox = Box.createHorizontalBox();
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(name.equals("Player1")){
                    size=BattleShip.player1Data.shipsLeft();
                    hideScreen();
                    BattleShip.getPlayer2().showScreen();
                }
                if(name.equals("Player2")){
                    size=BattleShip.player2Data.shipsLeft();
                    hideScreen();
                    BattleShip.getPlayer1().showScreen();
                }
            }
        });
        int s = 6;
        horizontalBox.add(new JLabel("Status for: "+name));
        horizontalBox.add(new JLabel("\nNumber of my ships left: "+s));
        this.add(next, BorderLayout.CENTER);
        this.add(horizontalBox, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(show);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showScreen(){
        this.setVisible(true);
    }

    public void hideScreen() {
        size=BattleShip.player1Data.shipsLeft();

        this.setVisible(false);
    }

//    public SelfGrid getSelfGridPlayer1(){
//        for(Component child : this.getComponents()){
//            if(child.getName().equals("Player1") && ){
//
//            }
//
//        }
//    }

}