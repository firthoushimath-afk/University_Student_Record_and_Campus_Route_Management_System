public class Main {
    public static void main(String[] args) {
        CampusGraph graph = new CampusGraph();

        graph.addLocation("Library");
        graph.addLocation("Computer Lab");
        graph.addLocation("Cafeteria");

        graph.addConnection("Library", "Computer Lab");
        graph.addConnection("Computer Lab", "Cafeteria");

        graph.removeConnection("Library", "Computer Lab"); // should succeed
        graph.removeConnection("Library", "Sports Complex"); // should fail - doesn't exist

        graph.printGraph();
    }
}