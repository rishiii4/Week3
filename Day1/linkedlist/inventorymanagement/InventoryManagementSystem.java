package linkedlist.inventorymanagement;

public class InventoryManagementSystem {
    private InventoryNode head;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            InventoryNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Add an item at a specific position
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        InventoryNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position exceeds the size of the inventory.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Remove an item by Item ID
    public void removeById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }
        InventoryNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityById(int itemId, int newQuantity) {
        InventoryNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID or Item Name
    public void searchItem(int itemId, String itemName) {
        InventoryNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.itemId == itemId || current.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: [Name: " + current.itemName + ", ID: " + current.itemId +
                        ", Quantity: " + current.quantity + ", Price: $" + current.price + "]");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No matching item found.");
        }
    }

    // Calculate the total value of the inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        InventoryNode current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Sort the inventory based on Item Name or Price
    public void sortInventory(String sortBy, boolean ascending) {
        if (head == null || head.next == null) {
            return; // No sorting needed for an empty or single-item list
        }
        head = mergeSort(head, sortBy, ascending);
    }

    private InventoryNode mergeSort(InventoryNode node, String sortBy, boolean ascending) {
        if (node == null || node.next == null) {
            return node;
        }
        InventoryNode middle = getMiddle(node);
        InventoryNode nextToMiddle = middle.next;
        middle.next = null;

        InventoryNode left = mergeSort(node, sortBy, ascending);
        InventoryNode right = mergeSort(nextToMiddle, sortBy, ascending);

        return merge(left, right, sortBy, ascending);
    }

    private InventoryNode merge(InventoryNode left, InventoryNode right, String sortBy, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        boolean condition;
        if (sortBy.equalsIgnoreCase("name")) {
            condition = ascending ? left.itemName.compareToIgnoreCase(right.itemName) <= 0 :
                    left.itemName.compareToIgnoreCase(right.itemName) > 0;
        } else {
            condition = ascending ? left.price <= right.price : left.price > right.price;
        }

        if (condition) {
            left.next = merge(left.next, right, sortBy, ascending);
            return left;
        } else {
            right.next = merge(left, right.next, sortBy, ascending);
            return right;
        }
    }

    private InventoryNode getMiddle(InventoryNode node) {
        if (node == null) {
            return null;
        }
        InventoryNode slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items in the inventory
    public void displayAllItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        InventoryNode current = head;
        while (current != null) {
            System.out.println("Item Name: " + current.itemName + ", ID: " + current.itemId +
                    ", Quantity: " + current.quantity + ", Price: $" + current.price);
            current = current.next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Add items
        inventory.addAtEnd("Laptop", 101, 10, 800.50);
        inventory.addAtBeginning("Mouse", 102, 50, 15.75);
        inventory.addAtPosition(2, "Keyboard", 103, 30, 25.00);

        // Display all items
        System.out.println("All Items:");
        inventory.displayAllItems();

        // Update quantity
        inventory.updateQuantityById(101, 8);

        // Search items
        System.out.println("\nSearch for Item with ID 101:");
        inventory.searchItem(101, "");

        // Calculate total value
        System.out.println("\nCalculating total inventory value:");
        inventory.calculateTotalValue();

        // Sort inventory by price in ascending order
        System.out.println("\nSorting inventory by Price in ascending order:");
        inventory.sortInventory("price", true);
        inventory.displayAllItems();

        // Remove an item
        inventory.removeById(102);

        // Display all items after removal
        System.out.println("\nAll Items after removal:");
        inventory.displayAllItems();
    }
}

