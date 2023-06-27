import java.util.*;

public class Table {
    private ArrayList<Table> moves;
    private ArrayList<Cube> list;
    private int K;

    public Table(int K){
        this.K = K;
        this.moves = new ArrayList<Table>();
        this.list = new ArrayList<Cube>();
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
        this.list.add(cube);
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
        ArrayList<Cube> currentTable = this.getCubes();
        ArrayList<Cube> copyOfTable = new ArrayList<Cube>(currentTable);

        int X = 1;
        int Y = 1;
        int K = this.getK();

        for(Cube cube : currentTable){
            int backupX = cube.getPosX();
            int backupY = cube.getPosY();

            for(Y = 1; Y <= 3; Y++){
                for(X = 1; X <= 4*K; X++){
                    cube.setPosX(X);
                    cube.setPosY(Y);
                    if(cube.isValid(copyOfTable) && cube.isFree(copyOfTable)){
                        Table table = new Table(K);
                        table.setCubes(currentTable);
                        
                        this.moves.add(table);
                    }else{
                        cube.setPosX(backupX);
                        cube.setPosY(backupY);
                        continue;
                    }
                }
            }
            cube.setPosX(backupX);
            cube.setPosY(backupY);
        }
        return this.moves;
    }

    public Boolean isGoalState(){
        int K = this.getCubes().size()/3;
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
        int i = 0;
        int J = 0;
        int K = 0;

        // System.out.println(this.getCubes().get(0).getPosX());

        for(Cube cube : this.getCubes()){
            System.out.println("The cube with ID: " + cube.getID() + " is in X: " + cube.getPosX() + " Y: " + cube.getPosY());
        }

        // ArrayList<Cube> list = this.getCubes();
        // while(i < list.size()){
        //     if(list.get(i).getPosY() == 3){
        //         System.out.print(list.get(i).getID() + " ");
        //         J++;
        //         if(J == 3){
        //             System.out.println();
        //         }
        //     }else if(list.get(i).getPosY() == 2){
        //         System.out.print(list.get(i).getID() + " ");
        //         K++;
        //         if(K == 3){
        //             System.out.println();
        //         }
        //     }else{
        //         System.out.print(list.get(i).getID() + " ");
        //     }
        //     i++;
        // }
        System.out.println();
    }
}
