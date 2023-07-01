import java.util.*;

public class Node {
    private Table state;
    private Double pathCost;
    private Node parent;
    private ArrayList<Node> children;

    public Node(Table state, Double pathCost, Node parent){
        this.state = state;
        this.pathCost = pathCost;
        this.parent = parent;
        this.children = new ArrayList<Node>();
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

    public ArrayList<Node> getChildren(){
        return this.children;
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

    //TODO: calculateCost()
    private static Double calculateCost(Node starting, Node next){
        // up: cost = y' - y
        // down: cost = 0.5(y - y')
        // same: cost = 0.75

        Double cost = null;

        

        return cost;
    }

    //TODO: gerateChildren()
    public void generateChildren(){
        ArrayList<Table> allMoves = state.generateMoves();

        for(Table state : allMoves){
            Node child = new Node(state, , this)
        }
    } 
}
