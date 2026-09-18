import java.time.LocalDate;

public class InventoryItem {

    private BaseProduct baseProduct;
    private String brand;
    private double quantity;
    private double pricePaid;
    private LocalDate entryDate;
    private LocalDate internalExpirationDate;
    private LocalDate labelExpirationDate;

    // TODO: Construtor principal que recebe a data de entrada e calcula a InternalRotationDays automaticamente usando o BaseProduct

    //TODO: Criar o segundo construtor (sobrecarga) que recebe também a data do rótulo

    //TODO:  TODO: Implementar o método para dar baixa/consumir quantidade no estoque (deductQuantity

    //TODO:  TODO: Implementar o método de checagem para ver se o item precisa entrar no alerta de giro



}