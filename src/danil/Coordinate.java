package danil;

/**
 * Created by danil on 10/23/17.
 */
public class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String toString(){
        return "X=" + x + " and Y=" + y;
    }

}
