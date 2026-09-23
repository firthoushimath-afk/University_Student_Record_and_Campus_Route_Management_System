import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * CampusGraph
 * Represents the university campus as a graph.
 * Campus locations are vertices, and roads/connections are edges.
 * Implemented using an Adjacency List (HashMap of Lists).
 */
public class CampusGraph {

    // Adjacency list: each location maps to a list of directly connected locations
    private Map<String, List<String>> adjacencyList;

    // Constructor: initializes an empty graph
    public CampusGraph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Adds a new campus location (vertex) to the graph.
     * If the location already exists, prints an error and does nothing.
     */
    public void addLocation(String location) {
        if (adjacencyList.containsKey(location)) {
            System.out.println("Error: Location Already Exists");
            return;
        }
        adjacencyList.put(location, new ArrayList<>());
        System.out.println("Location added: " + location);
    }

        /**
     * Removes a campus location (vertex) from the graph.
     * Also removes it from every other location's connection list,
     * so no leftover/dangling connections remain.
     * If the location does not exist, prints an error.
     */
    public void removeLocation(String location) {
        if (!adjacencyList.containsKey(location)) {
            System.out.println("Location Not Found");
            return;
        }

        // Remove the location itself (and its own connection list)
        adjacencyList.remove(location);

        // Remove this location from every other location's list of connections
        for (List<String> connections : adjacencyList.values()) {
            connections.remove(location);
        }

        System.out.println("Location removed: " + location);
    }

        /**
     * Adds a connection (edge) between two campus locations.
     * Since campus roads are two-way, the connection is added in both directions.
     * If either location does not exist, prints an error and does nothing.
     */
    public void addConnection(String location1, String location2) {
        if (!adjacencyList.containsKey(location1) || !adjacencyList.containsKey(location2)) {
            System.out.println("Cannot Create Connection");
            return;
        }

        // Avoid adding a duplicate connection
        if (!adjacencyList.get(location1).contains(location2)) {
            adjacencyList.get(location1).add(location2);
        }
        if (!adjacencyList.get(location2).contains(location1)) {
            adjacencyList.get(location2).add(location1);
        }

        System.out.println("Connection added: " + location1 + " <-> " + location2);
    }

    // Temporary test method - we will replace this later
    public void printGraph() {
        System.out.println("Graph currently has " + adjacencyList.size() + " locations.");
    }
}