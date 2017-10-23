package danil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class PlayerScreen extends JFrame {
    public PlayerScreen(String name, boolean show) {
        super(name);
        this.setLayout(new BorderLayout());
        
        this.add(new SelfGrid(name), BorderLayout.EAST);
        this.add(new AttackGrid(name), BorderLayout.WEST);
        this.add(new JLabel(name), BorderLayout.NORTH);
        JButton next = new JButton("next");
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(name.equals("Player1")){
                    hideScreen();
                    BattleShip.getPlayer2().showScreen();
                }
                if(name.equals("Player2")){
                    hideScreen();
                    BattleShip.getPlayer1().showScreen();
                }
            }
        });
        this.add(next, BorderLayout.CENTER);
        this.pack();
        this.setVisible(show);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showScreen(){
        this.setVisible(true);
    }

    public void hideScreen() {
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