package danil;

/**
 * Created by danil on 10/23/17.
 */
public class Ship {
    Coordinate a;
    Coordinate b;
    Coordinate c;

    boolean Ahit=false;
    boolean Bhit=false;
    boolean Chit=false;

    Ship(Coordinate a,Coordinate b,Coordinate c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void isHit(Coordinate hit){
        if(hit.getY() == a.getY() && hit.getX() == a.getX()){
            Ahit=true;
        }
        if(hit.getY() == b.getY() && hit.getX() == b.getX()){
            Bhit=true;
        }
        if(hit.getY() == c.getY() && hit.getX() == c.getX()){
            Chit=true;
        }
    }

    public boolean isShipSunk(){
        if(Ahit&&Bhit&&Chit){
            return true;
        }
        else{
            return false;
        }
    }

    // Debugging functions
    public String printShip(){
        return "\na cord. "+ a.toString() + "\nb cord. "+ b.toString() +"\nc cord. " +c.toString();
    }
}
