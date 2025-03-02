package Ex4;

public class Main {
    public static void main(String args[]) { 
        Person P1 = new Person();  
        Person P2 = new DistinguishedAdult(); 
        Adult P3 = new DistinguishedAdult();  
        Person P4 = new Baby(); 
        Young P5 = new Teen();  
        Child P6 = new Infant(); 
        Infant P7 = new Infant();  
        Child P8 = new Baby(); 
        P1.speak();
        P2.speak();
        P3.speak();    
        P4.speak();
        P5.speak();
        P6.speak();
        P7.speak();
        P8.speak(); 
        Young[] e = new Young[5];
        e[0] = (Young) P4; // ? Baby is a Young
        e[1] = P5;         // ? Teen is a Young
        e[2] = P6;         // ? Infant is a Child, thus Young
        e[3] = P7;         // ? Infant is a Young
        e[4] = P8;         // ? Baby is a Young

        for (int i = 0; i < e.length; i++) {
            e[i].speak();
            /* 
             * mamma
             * hi!
             * Goo goo, ga ga!
             * Goo goo, ga ga!
             * mamma
             */
        }
    }
}





/* 
 ? the output of the file  is : 
 * hum
 * My dear friends, hello!
 * My dear friends, hello!
 * mamma
 * hi!
 * Goo goo, ga ga!
 * Goo goo, ga ga!
 * mamma
 */



 /* 
   ? c) No changes needed; all assignments are valid as is.
 */