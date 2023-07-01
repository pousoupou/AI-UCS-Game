import java.util.*;

public class UCS {
    private LinkedList<Node> searchFrontier;
    private ArrayList<Node> closedSet;
    private ArrayList<String> path;
    private double totalCost;
    private int steps;

    public UCS(){
        searchFrontier = new LinkedList<Node>();
        closedSet = new ArrayList<Node>();
        path = new ArrayList<String>();
        totalCost = 0;
        steps = 0;
    }

    /**
     * algorithm:
     * 
     * https://www.youtube.com/watch?v=dRMvK76xQJI
     * 
     * general node: N
     * 
     * is N a goal state? 
     * if YES 
     * 1.   -> print the path and total cost
     * if NO
     * 1.   -> check if the node is in the closedSet
     * 2.   -> expand the node, check if its children are in the closedSet, add its children to the searchFrontier and add it to the closedSet
     * 3.   -> calculate the total cost of each child
     * 4.   -> choose the cheapest node
     * 5.   -> repeat algorithm
     */

     
}
