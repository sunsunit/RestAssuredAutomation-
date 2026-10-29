public class ProductData {
 
    private int year;
    private int price;
    private String type;
 
    // Default constructor
    public ProductData() {
    }
 
    // Parameterized constructor
    public ProductData(int year, int price, String type) {
        this.year = year;
        this.price = price;
        this.type = type;
    }
 
    // Getters and setters
    public int getYear() {
        return year;
    }
 
    public void setYear(int year) {
        this.year = year;
    }
 
    public int getPrice() {
        return price;
    }
 
    public void setPrice(int price) {
        this.price = price;
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
}