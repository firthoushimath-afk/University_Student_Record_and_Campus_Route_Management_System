/**
 * Main - Demonstration of the CampusGraph module.
 * Author: M.I.M. Amhar - Student ID: 23DA2-0515
 * Responsibility: Graph Implementation, Campus Location/Connection
 * Management, BFS Traversal.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("===== CAMPUS GRAPH DEMONSTRATION =====\n");

        CampusGraph graph = new CampusGraph();

        System.out.println("-- Empty Graph Check --");
        graph.displayConnections(); // No Locations Available

        System.out.println("\n-- Adding Campus Locations --");
        graph.addLocation("Library");
        graph.addLocation("Computer Lab");
        graph.addLocation("Cafeteria");
        graph.addLocation("Main Building");
        graph.addLocation("Lecture Hall");
        graph.addLocation("Library"); // duplicate - should show error

        System.out.println("\n-- Adding Campus Connections --");
        graph.addConnection("Library", "Computer Lab");
        graph.addConnection("Computer Lab", "Cafeteria");
        graph.addConnection("Cafeteria", "Main Building");
        graph.addConnection("Main Building", "Lecture Hall");
        graph.addConnection("Library", "Sports Complex"); // invalid - doesn't exist

        System.out.println("\n-- Displaying Campus Connections --");
        graph.displayConnections();

        System.out.println("\n-- Removing a Connection --");
        graph.removeConnection("Library", "Computer Lab");
        graph.displayConnections();

        System.out.println("\n-- Re-adding Connection for Traversal Demo --");
        graph.addConnection("Library", "Computer Lab");

        System.out.println("\n-- BFS Traversal from Library --");
        graph.bfsTraversal("Library");

        System.out.println("\n-- Removing a Location --");
        graph.removeLocation("Cafeteria");
        graph.displayConnections();

        System.out.println("\n-- Attempting to Remove Non-Existent Location --");
        graph.removeLocation("Sports Complex"); // Location Not Found

        System.out.println("\n===== END OF DEMONSTRATION =====");
    }
}