package linkedlist.undoredo;

public class UndoRedoTextEditor {
    private TextState head;
    private TextState currentState;
    private final int maxHistorySize;
    private int currentSize;

    // Constructor
    public UndoRedoTextEditor(int maxHistorySize) {
        this.head = null;
        this.currentState = null;
        this.maxHistorySize = maxHistorySize;
        this.currentSize = 0;
    }

    // Add a new text state
    public void addState(String newText) {
        TextState newState = new TextState(newText);

        // If the list is empty
        if (head == null) {
            head = newState;
            currentState = newState;
        } else {
            // If we're not at the most recent state, discard forward history
            if (currentState.next != null) {
                currentState.next = null;
            }

            // Add the new state at the end
            currentState.next = newState;
            newState.prev = currentState;
            currentState = newState;

            // Remove the oldest state if history exceeds the max size
            if (currentSize == maxHistorySize) {
                head = head.next;
                head.prev = null;
            } else {
                currentSize++;
            }
        }
        System.out.println("State added: " + newText);
    }

    // Undo to the previous state
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo performed. Current state: " + currentState.textContent);
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    // Redo to the next state
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo performed. Current state: " + currentState.textContent);
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    // Display the current state
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current state: " + currentState.textContent);
        } else {
            System.out.println("No text states available.");
        }
    }

    // Display all states (for debugging purposes)
    public void displayAllStates() {
        TextState temp = head;
        System.out.println("All states in history:");
        while (temp != null) {
            System.out.println("- " + temp.textContent);
            temp = temp.next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        UndoRedoTextEditor editor = new UndoRedoTextEditor(5); // History limited to 5 states

        // Simulating text editing
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! How");
        editor.addState("Hello, World! How are");
        editor.addState("Hello, World! How are you?");
        editor.displayCurrentState();

        // Performing undo
        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        // Performing redo
        editor.redo();
        editor.redo();
        editor.displayCurrentState();

        // Adding a new state (should discard oldest state due to history limit)
        editor.addState("Hello, World! How are you doing?");
        editor.displayAllStates();
    }
}

