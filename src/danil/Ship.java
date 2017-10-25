package danil;

/**
 * Created by danil on 10/23/17.
 */
public class Ship {
    Coordinate a;
    Coordinate b;
    Coordinate c;

    boolean Ahit;
    boolean Bhit;
    boolean Chit;

    Ship(Coordinate a,Coordinate b,Coordinate c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isPointHit(Coordinate hit){
        if(hit.getX() == a.getX()&&hit.getY() == a.getY()){
            return true;
        }
        else if(hit.getX() == b.getX()&&hit.getY() == b.getY()){
            return true;
        }
        else if(hit.getX() == c.getX()&&hit.getY() == c.getY()){
            return true;
        }
        return false;
    }
    public void Hit(Coordinate hit){
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
    public void printShip(){
        String result = "A("+a.getX()+", "+a.getY()+")"+" B("+b.getX()+", "+b.getY()+") C("+c.getX()+", "+c.getY()+")";
        System.out.print(result);
    }
}
