import java.time.LocalDate;

public class InventoryItem {

    private BaseProduct baseProduct;
    private String brand;
    private double quantity;
    private double pricePaid;
    private LocalDate entryDate;
    private LocalDate internalExpirationDate;
    private LocalDate labelExpirationDate;

    //Construtor principal que recebe a data de entrada e calcula a InternalRotationDays automaticamente usando o BaseProduct
    public InventoryItem(BaseProduct baseProduct, String brand, double quantity, double pricePaid, LocalDate entryDate){
        this.baseProduct = baseProduct;
        this.brand = brand;
        this.quantity = quantity;
        this.pricePaid = pricePaid;
        this.entryDate = entryDate;

        this.internalExpirationDate = entryDate.plusDays(baseProduct.getInternalRotationDays());
        this.labelExpirationDate = null; //to add label date expiration
    }

    //Segundo construtor (sobrecarga) que recebe também a data do rótulo
    public InventoryItem(BaseProduct baseProduct, String brand, double quantity, double pricePaid, LocalDate entryDate, LocalDate labelExpirationDate) {
        this(baseProduct, brand, quantity, pricePaid, entryDate);
        this.labelExpirationDate = labelExpirationDate;
    }
    //Reduces the quantity of the stock item.
    //Validates if the amount is positive and does not exceed available stock.
public void deductQuantity(double amount){
        if (amount < 0){
            System.out.println("A quantidade a ser deduzida deve ser maior que zero");
            return;
        }
        if (amount > this.quantity){
            System.out.println("Erro: A quantidade deduzida (" + amount + ") não pode ser maior que o estoque atual (" + this.quantity + ")");
            return;
        }
        this.quantity -= amount;
    }
    //Checks if the item has entered the early warning window based on the current date.
    //Uses PCP logic to prevent the stock degradation.

    public boolean isEarlyWarningTrigged(LocalDate currentDate){
        if (!currentDate.isBefore(this.internalExpirationDate)){
            return true;
        }
        LocalDate warningThresholdDate = this.internalExpirationDate.minusDays(this.baseProduct.getEarlyWarningDays());
        return !currentDate.isBefore(warningThresholdDate);
    }

    public BaseProduct getBaseProduct() {
        return baseProduct;
    }

    public void setBaseProduct(BaseProduct baseProduct) {
        this.baseProduct = baseProduct;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getInternalExpirationDate() {
        return internalExpirationDate;
    }

    public void setInternalExpirationDate(LocalDate internalExpirationDate) {
        this.internalExpirationDate = internalExpirationDate;
    }

    public LocalDate getLabelExpirationDate() {
        return labelExpirationDate;
    }

    public void setLabelExpirationDate(LocalDate labelExpirationDate) {
        this.labelExpirationDate = labelExpirationDate;
    }
}