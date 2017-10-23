package danil;

import java.util.Arrays;

/**
 * Created by danil on 10/22/17.
 */

public class PlayerData {
     int[][] attackData = new int[11][11];
     int[][] selfData = new int[11][11];
     int count=0;

    public void setAttackData(int x, int y){
            attackData[x][y]=1;
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
            count++;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isLoser(){
        if(count>=15){
            return true;
        }
        else{
            return false;
        }

    }

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
