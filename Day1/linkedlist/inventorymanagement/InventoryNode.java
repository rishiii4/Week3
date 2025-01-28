package linkedlist.inventorymanagement;
class InventoryNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    InventoryNode next;

    // Constructor to initialize an inventory node
    public InventoryNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

