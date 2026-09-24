public class StackQueueTest {

    public static void main(String[] args) {

        System.out.println("===== STACK TEST =====");

        ActionStack actionStack = new ActionStack();

        actionStack.addAction("Added Student S001");
        actionStack.addAction("Updated Student S002");
        actionStack.addAction("Deleted Student S003");

        actionStack.displayRecentActions();

        actionStack.showLatestAction();


        System.out.println("\n===== QUEUE TEST =====");

        ServiceQueue serviceQueue = new ServiceQueue();

        serviceQueue.addRequest("S001 - ID Card Request");
        serviceQueue.addRequest("S002 - Transcript Request");
        serviceQueue.addRequest("S003 - Registration Request");

        serviceQueue.displayPendingRequests();

        System.out.println("\nProcessing Requests...");

        serviceQueue.processNextRequest();
        serviceQueue.processNextRequest();

        System.out.println("\nRemaining Requests:");

        serviceQueue.displayPendingRequests();
    }
}