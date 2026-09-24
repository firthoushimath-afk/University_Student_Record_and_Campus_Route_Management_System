public class Main {
    public static void main(String[] args) {
        CampusGraph graph = new CampusGraph();

        graph.addLocation("Library");
        graph.addLocation("Sports Complex"); // added but never connected to anything

        graph.bfsTraversal("Sports Complex"); // isolated node - should just print itself
    }
}