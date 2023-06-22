import java.util.*;

public class Cube{
    private int ID;
    private int posX;
    private int posY;

    public Cube(int ID, int posX, int posY){
        this.ID = ID;
        this.posX = posX;
        this.posY = posY;
    }

    public int getID(){
        return this.ID;
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public Boolean isInAir(ArrayList<Cube> list){
        if(this.getPosY() == 1){
            return false;
        }

        for(Cube cube: list){
            if(this.getID() == cube.getID()){
                continue;
            }
            if(this.getPosX() == cube.getPosX() && this.getPosY() == (cube.getPosY() + 1)){
                return false;
            }
        }
        return true;
    }
}