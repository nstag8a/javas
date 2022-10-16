package Task10;

public class AudioBook extends Book {
    private double length;
    
    public AudioBook(String name, int year, double length) {
        super(name, year);
        this.setLength(length);
    }
    public void displayInfo() {
        System.out.printf("Book name: %s \nPublish year: %d\nLength(hours): %.1f\n", getName(), getYear(), length);
    }
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}