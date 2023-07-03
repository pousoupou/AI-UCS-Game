import java.util.*;

public class Node {
    private Table state;
    private Double pathCost;
    private double cost;
    private Node parent;
    private ArrayList<Node> children;

    //TODO: check line 15
    public Node(Table state, Node parent){
        this.state = state;
        this.parent = parent;
        this.children = new ArrayList<Node>();
        this.cost = calculateCost(parent, this);
    }

    public Table getState(){
        return this.state;
    }

    public Double getPathCost(){
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

    public void setPathCost(Double pathCost){
        this.pathCost = pathCost;
    }

    public void setParent(Node parent){
        this.parent = parent;
    }

    //TODO: handle null nodes
    private static Double calculateCost(Node starting, Node next){
        // up: cost = y' - y
        // down: cost = 0.5(y - y')
        // same: cost = 0.75

        ArrayList<Cube> startingState = new ArrayList<Cube>();
        ArrayList<Cube> nextState = new ArrayList<Cube>();
        
        double cost = 0;
        int xDifference = 0;
        int yDifference = 0;

        startingState = starting.getState().getCubes();
        nextState = next.getState().getCubes();

        for(int i = 0; i < nextState.size(); i++){
            xDifference = Math.abs(nextState.get(i).getPosX() - startingState.get(i).getPosX());
            yDifference = Math.abs(nextState.get(i).getPosY() - startingState.get(i).getPosY());
        }

        if(xDifference != 0){
            cost = 0.75;
        }else if(yDifference > 0){
            cost = (double)yDifference;
        }else if(yDifference < 0){
            cost = 0.5 * yDifference;
        }else {
            cost = -1;
        }
        return cost;
    }

    public void generateChildren(){
        ArrayList<Table> allStates = this.state.generateMoves();

        for(Table state : allStates){
            Node child = new Node(state, this);
            this.setPathCost(calculateCost(this, child));

            children.add(child);
        }
    } 
}
