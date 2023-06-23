import java.util.*;

public class MainGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Cube> list = new ArrayList<Cube>();

        Table table = new Table();

        int K = 0;

        System.out.print("ENTER K: ");
        K = input.nextInt();
        System.out.println();

        //TODO: Randomize the list
        // Initialize a list with K cubes on the table (ordered)
        for(int i = 1; i <= 3 * K; i++){
            Cube cube = new Cube(i, i, 1);
            list.add(cube);

            table.addCube(cube);
        }

        table.printTable();
    }
}
