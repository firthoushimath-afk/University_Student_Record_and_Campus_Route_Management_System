import java.util.LinkedList;
import java.util.Queue;

public class ServiceQueue {

    // Queue to store service requests
    private Queue<String> serviceRequests;

    // Constructor
    public ServiceQueue() {
        serviceRequests = new LinkedList<>();
    }

    // Add a new service request
    public void addRequest(String request) {
        serviceRequests.offer(request);
        System.out.println("Request Added: " + request);
    }

    // Process next request (FIFO)
    public void processNextRequest() {

        if (serviceRequests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        String processedRequest = serviceRequests.poll();

        System.out.println("Processing Request: "
                + processedRequest);
    }

    // Display all pending requests
    public void displayPendingRequests() {

        if (serviceRequests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        System.out.println("\n===== Pending Service Requests =====");

        for (String request : serviceRequests) {
            System.out.println(request);
        }
    }
}