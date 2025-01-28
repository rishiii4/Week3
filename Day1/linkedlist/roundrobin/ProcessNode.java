package linkedlist.roundrobin;

class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    // Constructor to initialize a process node
    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
