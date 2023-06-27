import java.util.*;

public class TableUtil {
    static ArrayList<Table> moves = new ArrayList<>();

    static ArrayList<Table> getMoves(){
        return moves;
    }

    static void generateMoves(Table table){
        // ArrayList<Table> moves = new ArrayList<Table>();
        ArrayList<Cube> currentTable = table.getCubes();
        ArrayList<Cube> copyOfTable = new ArrayList<Cube>(currentTable);

        int X = 1;
        int Y = 1;
        int K = table.getK();

        for(Cube cube : currentTable){
            int backupX = cube.getPosX();
            int backupY = cube.getPosY();

            for(Y = 1; Y <= 3; Y++){
                for(X = 1; X <= 4*K; X++){
                    cube.setPosX(X);
                    cube.setPosY(Y);
                    if(cube.isValid(copyOfTable) && cube.isFree(copyOfTable)){
                        table.setCubes(currentTable);
                        moves.add(table);
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
    }
}
