package danil;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public class Ship {

    Coordinate a;
    Coordinate b;
    Coordinate c;

    // Boolean should be true if the point was hit by another player
    boolean aHit;
    boolean bHit;
    boolean cHit;

    // Constructor
    Ship(Coordinate a,Coordinate b,Coordinate c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //compare ships to check if they are the same
    public boolean compareShip(Ship ship){
        if(ship.getA().compareCoord(this.a) && ship.getB().compareCoord(this.b) && ship.getC().compareCoord(this.c)){
            return true;
        }
        return false;
    }

    public Coordinate getA() {
        return a;
    }

    public Coordinate getB() {
        return b;
    }

    public Coordinate getC() {
        return c;
    }

    // Sets booleans to true if the
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

    //call hit to attack the ship
    public void Hit(Coordinate hit){
        if(hit.getY() == a.getY() && hit.getX() == a.getX()){
            aHit =true;
        }
        if(hit.getY() == b.getY() && hit.getX() == b.getX()){
            bHit =true;
        }
        if(hit.getY() == c.getY() && hit.getX() == c.getX()){
            cHit =true;
        }
    }

    //check if the ship is sunk
    public boolean isShipSunk(){
        if(aHit && bHit && cHit){
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