package linkedlist.undoredo;

class TextState {
    String textContent; // The text content at this state
    TextState prev; // Pointer to the previous state
    TextState next; // Pointer to the next state

    // Constructor to initialize a text state
    public TextState(String textContent) {
        this.textContent = textContent;
        this.prev = null;
        this.next = null;
    }
}

