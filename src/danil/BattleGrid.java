package danil;

import javax.swing.*;
import java.awt.*;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public abstract class BattleGrid extends JPanel {
    private JPanel temp;
    JPanel self;

    public BattleGrid() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        self = new JPanel();
        self.setLayout(new GridLayout(0,10));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temp = getCell();
                self.add(temp);
            }
        }
        this.add(self);
    }

    //return the cell that selected at point p
    public JPanel getComponentAt( Point p) {
        Component comp = null;
        for (Component child : self.getComponents()) {
            if (child.getBounds().contains(p)) {
                comp = child;
            }
        }
        return (JPanel)comp;
    }

    protected abstract JPanel getCell();
}