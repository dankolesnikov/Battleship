package danil;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public class PlayerData {

    private int[][] attackData = new int[11][11];
    private int[][] selfData = new int[11][11];
    private int numberOfShipSunk = 0;

    private ArrayList<Ship> fleet = new ArrayList<>();

    /* Methods called from AttackGrid class */

    // setAttackData sets 2D array attackData based on input x,y coordinates
    public void setAttackData(int x, int y) {
        attackData[x][y] = 1;
    }

    public int getNumberOfOwnShipSunk() {
        return numberOfShipSunk;
    }

    public ArrayList<Ship> getFleet(){
        return fleet;
    }

    // attackShip searched goes through the array and tries to attack every point of every ship. If there is a match it will be marked in the ship object
    public void attackShip(Coordinate hitCord) {
        Iterator itr = fleet.iterator();
        while (itr.hasNext()){
            Ship temp = (Ship)itr.next();
            temp.Hit(hitCord); // Hit the point in the ship
        }
    }

    // isHit returns true if there is a ship at the point that was hit
    public boolean isHit(Coordinate point){
        for (int i=0;i<fleet.size();){
            Ship temp = fleet.get(i);
            if(temp.isPointHit(point)){
                System.out.print("Point was hit!");
                return true;
            }
            else{
                i++; // increase the counter if the the ship i didn't contain a point

            }
        }
        return false; // must return false because
    }

    // isPlayerLost determines if the player lost based on the fleet arraylist size
    public boolean isPlayerLost(){
        if(fleet.size()==0){
            return true; // Player lost
        }
        else{
            return false;
        }
    }

    // Boolean method returns true if the Ship was sunk
    public boolean isSunk(Coordinate hitCord){
        for (int i=0;i<fleet.size();){
            Ship temp = fleet.get(i);
            if(temp.isShipSunk()){
                numberOfShipSunk++;
                fleet.remove(i);
                System.out.println("\nShip sunk! "+shipsLeft() + " more ship to go");
                return true;
            }
            else{
                i++; // increase the counter if the ship wasn't sunk
            }
        }
        return false;
    }

    /* Methods called from SelfGrid class */
    public void setSelfData(Coordinate cord){
        int x = cord.getX();
        int y = cord.getY();
        if(selfData[x][y]==1){
            System.out.print("Overlap");
        }
        else{
            selfData[x][y]=1;
        }
    }

    // Returns data from selfData 2D array
    public int[][] getSelfData(){

    }

    // Creates a new ship and adds to the fleet array
    public void addShip(Coordinate a,Coordinate b,Coordinate c){
        fleet.add(new Ship(a,b,c));
        setSelfData(a);
        setSelfData(b);
        setSelfData(c);
    }

    // returns number of ships left
    public int shipsLeft(){
        int temp = fleet.size();
        return temp;
    }
    // returns the fleet
    public void printFleet(){
        System.out.print("printFleet called");
        Iterator itr2 = fleet.iterator();
        while (itr2.hasNext()){
            Ship temp = (Ship)itr2.next();
            //System.out.println(temp.printShip());
        }
    }


    /* For Debugging */
    public void printSelfData(){
        for (int i = 1; i < selfData.length; i++) {
            for (int j = 1; j < selfData[i].length; j++) {
                System.out.print(selfData[j][i] + " ");
            }
            System.out.println();
        }
    }
    public void printAttackData(){
        for (int i = 1; i < attackData.length; i++) {
            for (int j = 1; j < attackData[i].length; j++) {
                System.out.print(attackData[j][i] + " ");
            }
            System.out.println();
        }
    }

}
