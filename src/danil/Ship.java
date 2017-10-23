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

    public String printShip(){
        return "\na cord. "+ a.toString() + "\nb cord. "+ b.toString() +"\nc cord. " +c.toString();

    }
    public void isHit(Coordinate hit){
        if(hit.getY() == a.getY() && hit.getX() == a.getX()){
            System.out.print("Hit at a\n");
            Ahit=true;
        }
        if(hit.getY() == b.getY() && hit.getX() == b.getX()){
            System.out.print("Hit at b\n");
            Bhit=true;
        }
        if(hit.getY() == c.getY() && hit.getX() == c.getX()){
            System.out.print("Hit at c\n");
            Chit=true;
        }
    }


    //public  boolean getSunk
    public boolean isShipSunk(){
        if(Ahit&&Bhit&&Chit){
            System.out.print("Ship sunk!");
            return true;
        }
        else{
            return false;
        }
    }
}
