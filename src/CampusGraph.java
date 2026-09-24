import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
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

        /**
     * Removes a connection (edge) between two campus locations.
     * Since roads are two-way, the connection is removed in both directions.
     * If either location does not exist, prints an error and does nothing.
     */
    public void removeConnection(String location1, String location2) {
        if (!adjacencyList.containsKey(location1) || !adjacencyList.containsKey(location2)) {
            System.out.println("Cannot Create Connection");
            return;
        }

        adjacencyList.get(location1).remove(location2);
        adjacencyList.get(location2).remove(location1);

        System.out.println("Connection removed: " + location1 + " <-> " + location2);
    }

        /**
     * Displays all campus locations and their direct connections.
     * If the graph has no locations at all, prints a message instead.
     */
    public void displayConnections() {
        if (adjacencyList.isEmpty()) {
            System.out.println("No Locations Available");
            return;
        }

        for (String location : adjacencyList.keySet()) {
            List<String> connections = adjacencyList.get(location);
            System.out.println(location + " -> " + connections);
        }
    }

        /**
     * Performs a Breadth-First Search (BFS) traversal of the campus graph,
     * starting from the given location.
     * Visits the starting location first, then all its direct neighbours,
     * then their neighbours, and so on - level by level.
     */
    public void bfsTraversal(String startLocation) {
        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println("Location Not Found");
            return;
        }

        Set<String> visited = new HashSet<>();   // tracks locations already visited
        Queue<String> queue = new LinkedList<>(); // holds locations waiting to be visited

        visited.add(startLocation);
        queue.add(startLocation);

        System.out.println("BFS Traversal starting from " + startLocation + ":");

        while (!queue.isEmpty()) {
            String current = queue.poll(); // remove and get the front of the queue
            System.out.println(current);

            // Visit each neighbour of the current location
            for (String neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    // Temporary test method - we will replace this later
    public void printGraph() {
        System.out.println("Graph currently has " + adjacencyList.size() + " locations.");
    }
}