package danil;

/**
 * Created by danil on 10/22/17.
 */

public class PlayerData {
    static int[][] attackData = new int[11][11];
    static int[][] selfData = new int[11][11];

    public static void setAttackData(int x, int y){
            attackData[x][y]=1;
    }

    public static void setSelfData(int x, int y){
        if(selfData[x][y]==1){
            System.out.print("Overlap");
            // TODO: Display an error message of overlap
        }
        else{
            selfData[x][y]= 1;
        }
    }

    public static boolean isHit(int x, int y){

        if(selfData[x][y]==1){
            return true;
        }
        else{
            return false;
        }
    }

    public void getAttackData(int x, int y){
    }

    public int getSelfData(int x, int y){
        int result = selfData[x][y];
        return result;

    }
}
