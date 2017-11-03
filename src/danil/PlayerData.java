package danil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public class PlayerData {
    private PlayerScreen player;

    private int[][] attackData = new int[11][11];
    private int[][] selfData = new int[11][11];
    private int numberOfShipSunk = 0;

    private ArrayList<Ship> fleet = new ArrayList<>();

    PlayerData( PlayerScreen player){
        this.player = player;

    }

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
    public void setSelfData(Coordinate a, Coordinate b, Coordinate c){
        selfData[a.getX()][a.getY()]=1;
        selfData[b.getX()][b.getY()]=1;
        selfData[c.getX()][c.getY()]=1;
    }

    // Returns data from selfData 2D array
    public int[][] getSelfData(){
        return selfData;
    }

    // Creates a new ship and adds to the fleet array
    public void addShip(Coordinate a,Coordinate b,Coordinate c){

        if(isEdge(a, b, c)){
            System.out.print("Preventing adding a ship: fleet is full or user clicked too close to the edge");
        }
        else {
            if (isOvelap(a, b, c)) {  //MINH-BREAK ERROR WHICH GIVE 2 units ships
                if(isOvelapAtRotatePoint(a,b,c)){
                    System.out.print("Deleting horizontal ship and creating a new vertical ship");
                    deleteShip(a, b, c);
                    addVerticalShip(a, b, c);
                }
                else {
                    System.out.print("not the right place to rotate");

                }

            } else if(shipsLeft() < 5){
                System.out.print("Adding new ship");
                fleet.add(new Ship(a, b, c));
                setSelfData(a, b, c);
            }

        }
    }

    public boolean isEdge(Coordinate a,Coordinate b, Coordinate c){
        if(a.getX()==10||a.getX()==9||b.getX()==10){
            System.out.print("Edge");
            return true;
        }
        return false;
    }

    public void deleteShip(Coordinate a, Coordinate b, Coordinate c){
        Ship temp = new Ship(a, b, c);
        // Traverse ArrayList fleet
        for(int i=0; i<fleet.size();i++){
            if(fleet.get(i).compareShip(temp)){
                fleet.remove(i);
                System.out.print("\nShip was deleted from fleet");
            }
        }
        // Traverse 2D array selfData and change 1's to 0's
        for (int i = 0; i < selfData.length; i++) {
            for (int j = 0; j < selfData.length; j++) {
                if(i==a.getX()&&j==a.getY()){
                    System.out.print("\nFound 1st point");
                    player.getSelfGrid().drawBlack(i,j);
                    setCell(i,j,0);
                }
                if(i==b.getX()&&j==b.getY()){
                    System.out.print("Found 2nd point");
                    player.getSelfGrid().drawBlack(i,j);
                    setCell(i,j,0);
                }
                if(i==c.getX()&&j==c.getY()){
                    System.out.print("Found 3rd point");
                    player.getSelfGrid().drawBlack(i,j);
                    setCell(i,j,0);
                }
            }
        }

    }

    public void setCell(int x, int y, int input){
        selfData[x][y]=input;
    }

    public void addVerticalShip(Coordinate a, Coordinate b, Coordinate c){

        Coordinate aNew = new Coordinate(a.getX(), a.getY());
        Coordinate bNew = new Coordinate(a.getX(), a.getY() + 1);
        Coordinate cNew = new Coordinate(a.getX(), a.getY() + 2);

        fleet.add(new Ship(aNew, bNew, cNew));
        setSelfData(aNew, bNew, cNew);

    }

    public int getDataFromCell(int x, int y){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(i == x && j ==y){
                    return selfData[i][j];
                }
            }
        }
        return -1;
    }
    public boolean isOvelapAtTail(Coordinate a, Coordinate b, Coordinate c){
        boolean isA = false;
        boolean isB = false;
        boolean isC = false;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++)
            {
                if((a.getX()==i&&a.getY()==j)){
                    if(getDataFromCell(i,j) == 1){
                        isA = true;
                    }
                    else{
                        isA = false;
                    }
                }
                if(b.getX()==i&&b.getY()==j){
                    if(getDataFromCell(i,j) == 1){
                        isB = true;
                    }
                    else{
                        isB = false;
                    }
                }
                if(c.getX()==i&&c.getY()==j){
                    if(getDataFromCell(i,j) == 1){
                        isC = true;
                    }
                    else{
                        isC = false;
                    }
                }
            }
        }

        if(isB || isC){
            return true;
        }

        return false;
    }
    public boolean isOvelapAtRotatePoint(Coordinate a, Coordinate b, Coordinate c){
        boolean isA = false;
        boolean isB = false;
        boolean isC = false;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++)
            {
                if((a.getX()==i&&a.getY()==j)){
                    if(getDataFromCell(i,j) == 1){
                        isA = true;
                    }
                    else{
                        isA = false;
                    }
                }
                if(b.getX()==i&&b.getY()==j){
                    if(getDataFromCell(i,j) == 1){
                        isB = true;
                    }
                    else{
                        isB = false;
                    }
                }
                if(c.getX()==i&&c.getY()==j){
                    if(getDataFromCell(i,j) == 1){
                        isC = true;
                    }
                    else{
                        isC = false;
                    }
                }
            }
        }

        if(isA){
            return true;
        }

        return false;
    }

    public boolean isOvelap(Coordinate a, Coordinate b, Coordinate c){
        boolean isA = false;
        boolean isB = false;
        boolean isC = false;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++)
            {
                if((a.getX()==i&&a.getY()==j)){
                    if(getDataFromCell(i,j) == 1){
                        isA = true;
                    }
                    else{
                        isA = false;
                    }
                }
                if(b.getX()==i&&b.getY()==j){
                    if(getDataFromCell(i,j) == 1){
                        isB = true;
                    }
                    else{
                        isB = false;
                    }
                }
                if(c.getX()==i&&c.getY()==j){
                    if(getDataFromCell(i,j) == 1){
                        isC = true;
                    }
                    else{
                        isC = false;
                    }
                }
            }
        }

        if(isA || isB || isC){
            return true;
        }

        return false;
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