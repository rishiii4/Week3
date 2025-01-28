package linkedlist.taskscheduler;

public class TaskScheduler {
    private TaskNode head = null;
    private TaskNode tail = null;
    private TaskNode current = null; // For viewing the current task

    // Add a task at the beginning of the circular list
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Make it circular
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Update tail's next pointer to the new head
        }
    }

    // Add a task at the end of the circular list
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Make it circular
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Update tail's next pointer to the head
        }
    }

    // Add a task at a specific position in the circular list
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        TaskNode current = head;
        for (int i = 1; i < position - 1 && current.next != head; i++) {
            current = current.next;
        }
        newTask.next = current.next;
        current.next = newTask;
        if (current == tail) {
            tail = newTask; // Update tail if inserted at the end
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        TaskNode current = head;
        TaskNode previous = tail; // Start with tail for circular traversal
        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head; // Update tail's next pointer
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous; // Update tail if the last node is removed
                    }
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (current == null) {
            current = head; // Start from the head if not already set
        }
        if (current == null) {
            System.out.println("Task list is empty.");
        } else {
            System.out.println("Current Task: [ID: " + current.taskId + ", Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate + "]");
            current = current.next; // Move to the next task
        }
    }

    // Display all tasks in the list starting from the head
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        TaskNode current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
    public void searchTasksByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        TaskNode current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName +
                        ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }

    // Main method for testing the task scheduler
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();

        // Add tasks
        taskScheduler.addTaskAtBeginning(1, "Frontend", 1, "2025-01-31");
        taskScheduler.addTaskAtEnd(2, "Backend", 2, "2025-02-15");
        taskScheduler.addTaskAtEnd(3, "Testing", 3, "2025-03-01");
        taskScheduler.addTaskAtPosition(2, 4, "Database", 1, "2025-01-28");

        // Display all tasks
        System.out.println("All Tasks:");
        taskScheduler.displayAllTasks();

        // View current task and move to next
        System.out.println("\nViewing tasks sequentially:");
        taskScheduler.viewCurrentTask();
        taskScheduler.viewCurrentTask();
        taskScheduler.viewCurrentTask();

        // Search tasks by priority
        System.out.println("\nTasks with priority 1:");
        taskScheduler.searchTasksByPriority(1);

        // Remove a task
        taskScheduler.removeTaskById(4);

        // Display all tasks after removal
        System.out.println("\nAll Tasks after removal:");
        taskScheduler.displayAllTasks();
    }
}

