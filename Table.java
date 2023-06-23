import java.util.*;

public class Table {
    private ArrayList<Cube> list;

    public Table(){
        list = new ArrayList<Cube>();
    }

    public ArrayList<Cube> getCubes(){
        return this.list;
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
