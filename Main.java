package Task10;
import java.io.IOException;
import static java.lang.System.*;

public class Main {
     public static void main(String[] args) {
         String txtfile = "data/data.txt";
         try {
             AudioBookApp app = new AudioBookApp(txtfile);
             AudioBook shortest = app.getShortestBook();
             if(shortest != null) {
                 out.println("Shortest book: ");
                 shortest.displayInfo();
             }
             out.printf("\nBooks published btw 2010-2020: %d \n\n", app.countBooks());
             app.randomBookList();
         }catch(IOException ioe) {
             out.printf("Perhaps missing text file: %s/%s? \n",
                     new Main().getClass().getPackage().getName(), txtfile);
         }
     }//End of main method
}//End of class Main