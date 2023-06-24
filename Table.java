import java.util.*;

public class Table {
    private ArrayList<Cube> list;
    private int K;

    public Table(int K){
        this.K = K;
        list = new ArrayList<Cube>();
    }

    public int getK(){
        return this.K;
    }

    public ArrayList<Cube> getCubes(){
        return this.list;
    }

    public void setCubes(ArrayList<Cube> list){
        this.list = list;
    }

    public void addCube(Cube cube){
        list.add(cube);
    }

    public Integer getByID(int ID){
        for(Cube cube : list){
            if(cube.getID() == ID){
                return list.indexOf(cube);
            }
        }
        return null;
    }

    public ArrayList<Table> generateMoves(){
        ArrayList<Table> moves = new ArrayList<Table>();
        ArrayList<Cube> currentBoard = this.getCubes();

        int X = 1;
        int Y = 1;
        int K = this.getK();
        int index = 0;

        for(Cube cube : currentBoard){
            int backupX = cube.getPosX();
            int backupY = cube.getPosY();

            for(Y = 1; Y <= 3; Y++){
                for(X = 1; X <= 4*K; X++){
                    if(Y > 1 && X > K){
                        continue;
                    }
                    if(cube.isFree(currentBoard)){
                        cube.setPosX(X);
                        cube.setPosY(Y);
    
                        moves.get(index).addCube(cube);
                        index++;
                    }else if(!cube.isValid(currentBoard)){
                        cube.setPosX(backupX);
                        cube.setPosY(backupY);
                        continue;
                    }
                }
            }
        }
        return moves;
    }

    public Boolean isGoalState(){
        int K = list.size()/3;
        int i = 0;
        for(Cube cube : list){
            if(cube.getPosX() == ((cube.getID() - 1) % K + 1) && cube.getPosY() == ((cube.getID() - 1) / K + 1)){
                i++;
            }
            if(i == 3 * K){
                return true;
            }
        }
        return false;
    }

    public void printTable(){
        int  i = 0;
        int J = 0;
        int K = 0;

        while(i < list.size()){
            if(list.get(i).getPosY() == 3){
                System.out.print(list.get(i).getID() + " ");
                J++;
                if(J == 3){
                    System.out.println();
                }
            }else if(list.get(i).getPosY() == 2){
                System.out.print(list.get(i).getID() + " ");
                K++;
                if(K == 3){
                    System.out.println();
                }
            }else{
                System.out.print(list.get(i).getID() + " ");
            }
            i++;
        }
        System.out.println();
    }
}
