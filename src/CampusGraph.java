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
 * ------------
 * Represents the university campus as a graph data structure.
 *
 * - Campus locations (e.g. Library, Cafeteria) are VERTICES.
 * - Roads / direct connections between locations are EDGES.
 *
 * Implementation: Adjacency List, using a HashMap where:
 *   key   = a location name (String)
 *   value = a List of locations directly connected to that location
 *
 * Supports: adding/removing locations, adding/removing connections,
 * displaying all connections, and BFS traversal.
 *
 * Author: M.I.M. Amhar - Student ID: 23DA2-0515
 * Responsibility: Graph Implementation, Campus Location/Connection
 * Management, BFS Traversal.
 */
public class CampusGraph {

    // Adjacency list storing each location and its list of direct neighbours
    private Map<String, List<String>> adjacencyList;

    /**
     * Constructor: creates an empty campus graph with no locations.
     */
    public CampusGraph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Adds a new campus location (vertex) to the graph.
     * @param location the name of the location to add
     * Prints "Error: Location Already Exists" if the location is a duplicate.
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
     * Removes a campus location (vertex) from the graph, along with
     * any connections other locations have pointing to it.
     * @param location the name of the location to remove
     * Prints "Location Not Found" if the location does not exist.
     */
    public void removeLocation(String location) {
        if (!adjacencyList.containsKey(location)) {
            System.out.println("Location Not Found");
            return;
        }

        adjacencyList.remove(location);

        // Clean up dangling references to the removed location
        for (List<String> connections : adjacencyList.values()) {
            connections.remove(location);
        }

        System.out.println("Location removed: " + location);
    }

    /**
     * Adds a two-way connection (edge) between two campus locations.
     * @param location1 first location
     * @param location2 second location
     * Prints "Cannot Create Connection" if either location does not exist.
     */
    public void addConnection(String location1, String location2) {
        if (!adjacencyList.containsKey(location1) || !adjacencyList.containsKey(location2)) {
            System.out.println("Cannot Create Connection");
            return;
        }

        if (!adjacencyList.get(location1).contains(location2)) {
            adjacencyList.get(location1).add(location2);
        }
        if (!adjacencyList.get(location2).contains(location1)) {
            adjacencyList.get(location2).add(location1);
        }

        System.out.println("Connection added: " + location1 + " <-> " + location2);
    }

    /**
     * Removes a two-way connection (edge) between two campus locations.
     * @param location1 first location
     * @param location2 second location
     * Prints "Cannot Create Connection" if either location does not exist.
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
     * Displays every campus location and its list of direct connections.
     * Prints "No Locations Available" if the graph has no locations at all.
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
     * Performs a Breadth-First Search (BFS) traversal starting from the
     * given location, visiting the campus network level by level.
     * @param startLocation the location to begin the traversal from
     * Prints "Location Not Found" if the starting location does not exist.
     */
    public void bfsTraversal(String startLocation) {
        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println("Location Not Found");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startLocation);
        queue.add(startLocation);

        System.out.println("BFS Traversal starting from " + startLocation + ":");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);

            for (String neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    /**
     * Temporary utility method - prints how many locations are currently
     * in the graph. Used during development/testing.
     */
    public void printGraph() {
        System.out.println("Graph currently has " + adjacencyList.size() + " locations.");
    }
}