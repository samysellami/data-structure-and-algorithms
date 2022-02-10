// Stack implementation in Java

class Stack {
    private int arr[];
    private int top;
    private int capacity;
  
    // Creating a stack
    Stack(int size) {
        capacity = size;
        top = -1;
        arr = new int[size];
    }
  
    // Add elements into stack
    public void push(int x) {
        if (isFull()){
            System.out.println("Overflow, doubling the capacity");
            doubleCapacity();
        }
        arr[++top] = x;
    }
    
  
    // Remove element from stack
    public int pop() {
        if (isEmpty()){
            System.out.println("Impossible to pop, Empty stack");
            System.exit(1);
        }
        return arr[top--];
    }
  
    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }
  
    // Check if the stack is empty
    public Boolean isEmpty() {
        return top == -1;
    }
  
    // Check if the stack is full
    public Boolean isFull() {
        return size() == capacity;
    }
  
    public int peek(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            System.exit(1);
        }
        return arr[top];
      }

    
    // Double the capacity of this stack.  Call only when full,
    private void doubleCapacity() {
        int newCapacity = this.capacity << 1;
        if (newCapacity < 0)
          throw new IllegalStateException("Sorry, stack too big");
        int newArr[] = new int[newCapacity];
        System.arraycopy(this.arr, 0, newArr, 0, this.capacity);
        this.arr = newArr;
        this.capacity = newCapacity;
    }
  
    public void printStack() {
      for (int i = 0; i <= top; i++) {
        System.out.println(arr[i]);
      }
    }
  
    public static void main(String[] args) {
      Stack stack = new Stack(5);
  
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(4);
      stack.push(4);
  
      stack.pop();
      System.out.println("\nAfter popping out");
  
      stack.printStack();
  
    }
  }