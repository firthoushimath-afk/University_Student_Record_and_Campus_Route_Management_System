import java.util.HashMap;
import java.util.Map;

/**
 * CampusGraph
 * Represents the university campus as a graph.
 * Campus locations are vertices, and roads/connections are edges.
 * Implemented using an Adjacency List (HashMap of Lists).
 */
public class CampusGraph {

    // Adjacency list: each location maps to a list of directly connected locations
    private Map<String, java.util.List<String>> adjacencyList;

    // Constructor: initializes an empty graph
    public CampusGraph() {
        adjacencyList = new HashMap<>();
    }

    // Temporary test method - we will replace this later
    public void printGraph() {
        System.out.println("Graph currently has " + adjacencyList.size() + " locations.");
    }
}