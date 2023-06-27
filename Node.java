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
}
