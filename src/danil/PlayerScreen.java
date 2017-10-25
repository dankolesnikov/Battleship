package danil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class PlayerScreen extends JFrame {
    int size;
    public PlayerScreen(String name, boolean show) {
        super(name);
        this.setLayout(new BorderLayout());
        this.add(new SelfGrid(name), BorderLayout.EAST);
        this.add(new AttackGrid(name), BorderLayout.WEST);
        this.add(new JLabel(name), BorderLayout.NORTH);
        JButton next = new JButton("next");
        Box horizontalBox = Box.createHorizontalBox();

        horizontalBox.add(new JLabel("Status for: "+name));
        horizontalBox.add(new JLabel(" Ship left: "));

        JLabel shipLeft = new JLabel(Integer.toString(size));
        horizontalBox.add(shipLeft);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(name.equals("Player1")){
                    size=BattleShip.player1Data.shipsLeft();
                    System.out.println("******play1 shipleft in playesscreen" + size);
                    shipLeft.setText(Integer.toString(size));
                    hideScreen();
                    BattleShip.getPlayer2().showScreen();

                }
                if(name.equals("Player2")){
                    size=BattleShip.player2Data.shipsLeft();
                    System.out.println("******play2 shipleft in playesscreen" + size);
                    shipLeft.setText(Integer.toString(size));

                    hideScreen();
                    BattleShip.getPlayer1().showScreen();


                }
            }
        });

        // int s = 6;

//        horizontalBox.add(new JLabel("Status for: "+name));
//        JLabel shipLeft = new JLabel(Integer.toString(size));
//        horizontalBox.add(shipLeft);

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