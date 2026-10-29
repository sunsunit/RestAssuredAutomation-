public class ProductRequest {
 
    private String name;
    private ProductData data;
 
    public ProductRequest() {
    }
 
    public ProductRequest(String name, ProductData data) {
        this.name = name;
        this.data = data;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public ProductData getData() {
        return data;
    }
 
    public void setData(ProductData data) {
        this.data = data;
    }
}

