public class Main {
    public static void main(String[] args) {
        CampusGraph graph = new CampusGraph();

        graph.addLocation("Library");
        graph.addLocation("Computer Lab");
        graph.addLocation("Cafeteria");

        graph.addConnection("Library", "Computer Lab"); // should succeed
        graph.addConnection("Computer Lab", "Cafeteria"); // should succeed
        graph.addConnection("Library", "Sports Complex"); // should fail - Sports Complex doesn't exist

        graph.printGraph();
    }
}