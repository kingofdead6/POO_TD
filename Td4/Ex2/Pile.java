import java.util.*;
class Pile {
private Deque<Character> pile = new ArrayDeque<Character>();
public void push(char x) {
    pile.addLast(x);
}

public char pop() throws EmptyStackException { 
   if (this.isEmpty()) throw new EmptyStackException();
     return pile.removeLast(); 
}
public boolean isEmpty() {
    return this.pile.size() == 0; 
}
}
class EmptyStackException extends Exception {}