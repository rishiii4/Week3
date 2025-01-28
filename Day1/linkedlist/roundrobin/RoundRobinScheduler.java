package linkedlist.roundrobin;

public class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode tail;

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Make it circular
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular structure
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }
        ProcessNode current = head;
        ProcessNode prev = tail;
        do {
            if (current.processId == processId) {
                if (current == head && current == tail) { // Only one process
                    head = tail = null;
                } else if (current == head) { // Removing head
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) { // Removing tail
                    prev.next = head;
                    tail = prev;
                } else { // Removing in-between process
                    prev.next = current.next;
                }
                System.out.println("Process " + processId + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Process " + processId + " not found.");
    }

    // Simulate the round-robin scheduling
    public void simulateScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }
        ProcessNode current = head;
        int time = 0;
        double totalWaitingTime = 0, totalTurnAroundTime = 0;
        int processCount = 0;

        System.out.println("\nRound Robin Scheduling:");
        do {
            if (current.burstTime > 0) {
                int executionTime = Math.min(current.burstTime, timeQuantum);
                System.out.println("Executing Process " + current.processId +
                        " for " + executionTime + " units.");
                time += executionTime;
                current.burstTime -= executionTime;

                if (current.burstTime == 0) { // Process completed
                    System.out.println("Process " + current.processId +
                            " completed at time " + time + ".");
                    totalTurnAroundTime += time;
                    totalWaitingTime += time - executionTime;
                    processCount++;
                    removeProcess(current.processId); // Remove completed process
                }
            }
            current = current.next; // Move to the next process
        } while (head != null);

        // Calculate and display average waiting and turnaround times
        if (processCount > 0) {
            System.out.println("\nAverage Waiting Time: " +
                    (totalWaitingTime / processCount));
            System.out.println("Average Turnaround Time: " +
                    (totalTurnAroundTime / processCount));
        }
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        ProcessNode current = head;
        System.out.println("Processes in the queue:");
        do {
            System.out.println("Process ID: " + current.processId +
                    ", Burst Time: " + current.burstTime +
                    ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    // Main method for testing
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes
        scheduler.addProcess(1, 8, 1);
        scheduler.addProcess(2, 4, 2);
        scheduler.addProcess(3, 9, 3);
        scheduler.addProcess(4, 5, 2);

        // Display processes
        scheduler.displayProcesses();

        // Simulate round-robin scheduling with a time quantum of 3
        scheduler.simulateScheduling(3);
    }
}

