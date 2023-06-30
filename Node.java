import java.util.*;

public class Node {
    private Table state;
    private Double pathCost;
    private Node parent;

    public Node(Table state, Double pathCost, Node parent){
        this.state = state;
        this.pathCost = pathCost;
        this.parent = parent;
    }

    public Table getState(){
        return this.state;
    }

    public Double getCost(){
        return this.pathCost;
    }

    public Node getParent(){
        return this.parent;
    }

    public void setState(Table state){
        this.state = state;
    }

    public void setCost(Double pathCost){
        this.pathCost = pathCost;
    }

    public void setParent(Node parent){
        this.parent = parent;
    }

    //TODO: gerateChildren()
    

    //TODO: calculateCost()

}
