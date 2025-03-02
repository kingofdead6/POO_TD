public class Main {
    public static void main(String[] args) {
        GrandParent gp = new GrandParent(2);
        Parent p = new Parent (3,5) ;
        Child c = new Child(7,5 ,11); // we need a value for z as well and it should be from child not parent
        gp.printMethod();
        p.printMethod();  // displays the gp method cause its inherited from it 
        c.printMethod();
        gp.display(); // grandparent doesnt have a display method so its added
        p.display(); 
        c.display();
        gp = p ;
        gp.printMethod();
        gp.display();
    }
 }


 /* this is the total output of the program 
  * Print method in GrandParent
  * Print method in GrandParent
  * Print method in Child
  * GrandParent x: 2
  * GrandParent y: 30
  * GrandParent x: 3
  * GrandParent y: 30
  * Parent x: 20
  * Parent y: 5
  * GrandParent x: 7
  * GrandParent y: 30
  * Parent x: 20
  * Parent y: 5
  * Child x: 50
  * Child z: 11
  * Child y: 5
  * Print method in GrandParent
  * GrandParent x: 3
  * GrandParent y: 30
  * Parent x: 20
  * Parent y: 5
  */
