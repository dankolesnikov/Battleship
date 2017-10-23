package danil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danil on 10/22/17.
 */
public class Cell extends JPanel {
    int x;
    int y;

    Cell(int x, int y){
        this.x =x;
        this.y = y;

    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

}
