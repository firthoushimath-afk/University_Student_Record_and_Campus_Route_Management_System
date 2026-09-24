import java.util.Stack;

public class ActionStack {

    // Stack to store recent actions
    private Stack<String> actionHistory;

    // Constructor
    public ActionStack() {
        actionHistory = new Stack<>();
    }

    // Add a new action
    public void addAction(String action) {
        actionHistory.push(action);
        System.out.println("Action Added: " + action);
    }

    // Display all actions
    public void displayRecentActions() {

        if (actionHistory.isEmpty()) {
            System.out.println("No recent actions available.");
            return;
        }

        System.out.println("\n===== Recent Actions =====");

        for (int i = actionHistory.size() - 1; i >= 0; i--) {
            System.out.println(actionHistory.get(i));
        }
    }

    // Show latest action only
    public void showLatestAction() {

        if (actionHistory.isEmpty()) {
            System.out.println("No actions available.");
            return;
        }

        System.out.println("Latest Action: "
                + actionHistory.peek());
    }
}