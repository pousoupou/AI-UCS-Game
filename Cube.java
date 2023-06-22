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

    public Boolean isFree(ArrayList<Cube> list){
        Iterator<Cube> it = list.iterator();
        while(it.hasNext()){
            Cube cube = it.next();
            if(this.getID() == cube.getID()){
                continue;
            }
            if(this.getPosX() == cube.getPosX() && this.getPosY() <= cube.getPosY()){
                return false;
            }
        }
        return true;
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

    public Boolean isValid(ArrayList<Cube> list){
        int K = list.size()/3;

        // out of bounds check
        if(this.getPosX() < 1 || this.getPosY() < 1 || this.getPosY() > 3){
            return false;
        }
        if(this.getPosY() == 1 && this.getPosX() > 4*K){
            return false;
        }

        // Check if on Y > 1, X is greater than K
        if(this.getPosY() > 1 && this.getPosX() > K){
            return false;
        }
        for(Cube cube : list){
            // Check if this cube coincides with an other cube
            if(this.getPosX() == cube.getPosX() && this.getPosY() == cube.getPosY() && this.getID() != cube.getID()){
                return false;
            }
        }
        if(isInAir(list)){
            return false;
        }
        return true;
    }
}