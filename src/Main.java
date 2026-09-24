public class Main {
    public static void main(String[] args) {
        CampusGraph graph = new CampusGraph();

        graph.addLocation("Library");
        graph.addLocation("Computer Lab");
        graph.addLocation("Cafeteria");
        graph.addLocation("Main Building");
        graph.addLocation("Lecture Hall");

        graph.addConnection("Library", "Computer Lab");
        graph.addConnection("Computer Lab", "Cafeteria");
        graph.addConnection("Cafeteria", "Main Building");
        graph.addConnection("Main Building", "Lecture Hall");

        graph.bfsTraversal("Library");

        System.out.println("---");
        graph.bfsTraversal("Sports Complex"); // should fail - not found
    }
}