public class Product {
    private String invoiceNo;
    private String stockCode;
    private String description;
    private int quantity;
    private String invoiceDate;
    private static double unitPrice;
    private String customerID;
    private String country;

    public Product(String invoiceNo, String stockCode, String description, int quantity, String invoiceDate, double unitPrice, String customerID, String country) {
        this.invoiceNo = invoiceNo;
        this.stockCode = stockCode;
        this.description = description;
        this.quantity = quantity;
        this.invoiceDate = invoiceDate;
        this.unitPrice = unitPrice;
        this.customerID = customerID;
        this.country = country;
    }

    public String getStockCode() {
        return stockCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public static double getUnitPrice() {
        return unitPrice;
    }

    public String getCountry() {
        return country;
    }

    public String toString() {
        return "Product: " +
        "Invoice No = " + invoiceNo + '\'' +
        ", Stock Code = " + stockCode + '\'' +
        ", Description = " + description + '\'' +
        ", Quantity = " + quantity + '\'' +
        ", Invoice Date = " + invoiceDate + '\'' +
        ", Unit Price = " + unitPrice + '\'' +
        ", Customer ID = " + customerID + '\'' +
        ", Country = " + country + '\'';
    }
}
