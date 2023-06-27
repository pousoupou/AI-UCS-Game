import java.util.*;

public class MainGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int K = 0;
        
        System.out.print("ENTER K: ");
        K = input.nextInt();
        System.out.println();

        Table table = new Table(K);

        //TODO: Randomize the list
        // Initialize a list with K cubes on the table (ordered)
        for(int i = 1; i <= 3 * K; i++){
            Cube cube = new Cube(i, i, 1);
            table.addCube(cube);
        }
        table.printTable();

        System.out.println();

        ArrayList<Table> moves = new ArrayList<Table>();

        moves = table.generateMoves();

        for(Table move : moves){
            move.printTable();
        }
    }
}
