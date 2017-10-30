package deitel.exercises;

/**
 (Manipulating a Stream<Invoice>) Use the class Invoice provided in the exercises folder
 with this chapter’s examples to create an array of Invoice objects. Use the sample data shown in
 Fig. 17.20. Class Invoice includes four properties—a PartNumber (type int), a PartDescription
 (type String), a Quantity of the item being purchased (type int) and a Price (type double). Perform the following queries on the array of Invoice objects and display the results:
 a) Use lambdas and streams to sort the Invoice objects by PartDescription, then display
 the results.
 b) Use lambdas and streams to sort the Invoice objects by Price, then display the results.
 c) Use lambdas and streams to map each Invoice to its PartDescription and Quantity,
 sort the results by Quantity, then display the results.
 d) Use lambdas and streams to map each Invoice to its PartDescription and the value of
 the Invoice (i.e., Quantity * Price). Order the results by Invoice value.
 e) Modify Part (d) to select the Invoice values in the range $200 to $500
 */
public class Invoice {
    private int partNumber;
    private String partDescription;
    private int quantity;
    private double price;

    public Invoice(int partNumber, String partDescription, int quantity, double price) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.price = price;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "partNumber=" + partNumber +
                ", partDescription='" + partDescription + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
