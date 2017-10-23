 package danil;

 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
        import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
 import java.util.*;
 import java.util.List;

 public abstract class BattleGrid extends JPanel {

    public BattleGrid() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel self = new JPanel();
        List cells = new ArrayList();

        self.setLayout(new GridLayout(0,10));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                self.add(getCell());
            }
        }
        this.add(self);



    }
    
    protected abstract JPanel getCell();
}