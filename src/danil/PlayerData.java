package danil;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by danil on 10/22/17.
 */

public class PlayerData {
    private int[][] attackData = new int[11][11];
    private int[][] selfData = new int[11][11];

    ArrayList<Ship> fleet = new ArrayList<>();

    public int shipsLeft(){
        int temp = fleet.size();
        System.out.print(temp);
        return temp;
    }

    public void attackShip(Coordinate hitCord) {
        Iterator itr = fleet.iterator();
        while (itr.hasNext()){
            Ship temp = (Ship)itr.next();
            temp.Hit(hitCord); // Hit the point in the ship
        }
    }

    // Boolean method returns true if the Ship was sunk
    public boolean isSunk(Coordinate hitCord){
        for (int i=0;i<=fleet.size();i++){
            Ship temp = fleet.get(i);
            if(temp.isShipSunk()){
                System.out.println("Ship sunk!"+fleet.size() + " more ship to go");
                fleet.remove(i);
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public boolean isPlayerLost(){
        if(fleet.size()==0){
            return true;
        }
        else{
            return false;
        }
    }

    public void addShip(Coordinate a,Coordinate b,Coordinate c){
        fleet.add(new Ship(a,b,c));
    }

    public void printFleet(){
        System.out.print("printFleet called");
        Iterator itr2 = fleet.iterator();
        while (itr2.hasNext()){
            Ship temp = (Ship)itr2.next();
            System.out.println(temp.printShip());
        }
    }

    public void setAttackData(int x, int y) {
        attackData[x][y] = 1;
    }


    public void setSelfData(int x, int y){
        if(selfData[x][y]==1){
            System.out.print("Overlap");
        }
        else{
            selfData[x][y]=1;
        }
    }

    public boolean isHit(int x, int y){

        if(selfData[x][y]==1){
            return true;
        }
        else{
            return false;
        }
    }

    // For Debugging
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


    public void getAttackData(int x, int y){
    }

    public int getSelfData(int x, int y){
        int result = selfData[x][y];
        return result;

    }
}
