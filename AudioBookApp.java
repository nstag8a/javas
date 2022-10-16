package Task10;
import java.io.IOException;
import static java.lang.System.*;
import java.util.concurrent.ThreadLocalRandom;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;
import java.nio.file.Files;

public class AudioBookApp {
	 private List<AudioBook> bookList;
	 public List<AudioBook> getBookList() {
	 return bookList;
	 }
	 public AudioBookApp(String filename) throws IOException {
	 bookList = new LinkedList<>();
	 readData(filename);
	 }
	 public void readData(String filename) throws IOException {
		 bookList = new LinkedList<>();
		 Path path = Paths.get(filename);
		 List<String> lines = Files.readAllLines(path);
		 for (String line : lines) {
			 String[] items = line.split(",");
			 String name = items[0];
			 int year = Integer.parseInt(items[1]);
			 double length = Double.parseDouble(items[2]);
			 AudioBook aud = new AudioBook(name, year, length);
			 bookList.add(aud);
	 		}
	 }
	 public AudioBook getShortestBook() {
		 AudioBook ab = bookList.get(0);
		 double length = ab.getLength();
		 for (AudioBook a : bookList) {
			 if (a.getLength() < length) {
				 length = a.getLength();
				 ab = a;
			 } 
		 }
		return ab;
	 }
	 public int countBooks() {
		 int count = 0;
		 int firstb = 2010;
		 int lastb = 2020;
		 
		 if(bookList != null && bookList.size() > 0) {
		 for (AudioBook aud : bookList) {
			 if (aud.getYear() > firstb && aud.getYear() < lastb); 
				 count ++;
			 }
		 
		}return count;
		
	 }
	 public void randomBookList() { 
		 List<AudioBook> b1 = new LinkedList<>();
		 List<AudioBook> b2 = new LinkedList<>();
		 List<AudioBook> b3 = new LinkedList<>();

		 for (AudioBook a : bookList) {
		 	 int ran = ThreadLocalRandom.current().nextInt(0,4);
		 	 if (ran == 1) {
		 		 b1.add(a);
		 	 }
		 	 else if (ran == 2) {
		 		 b2.add(a);
		 	 }else{
		 		 b3.add(a);
		 	 }
		 }
	 out.println(b1.size() + " book/s in list number #" + 1 +".");
	 for (AudioBook aud : b1) {
		 out.printf("%s %d %.1f\n", aud.getName(), aud.getYear(), aud.getLength());
	 }
	 out.println("\n" + b2.size() + " book/s in list number #" + 2 +".");
	 for (AudioBook aud : b2) {
		 out.printf("%s %d %.1f\n", aud.getName(), aud.getYear(), aud.getLength());
	 }
	 out.println("\n" + b3.size() + " book/s in list number #" + 3 +".");
	 for (AudioBook aud : b3) {
		 out.printf("%s %d %.1f\n", aud.getName(), aud.getYear(), aud.getLength());
	 }
	 
	 }
}
