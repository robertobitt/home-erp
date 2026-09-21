import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===HomeERP - Teste  de controle de estoque (PCP) ===\n");

        BaseProduct arroz = new BaseProduct("Arroz Agulhinha", "Grãos", "kg", 30, 5);

        BaseProduct leite = new BaseProduct("Leite Integral", "Laticínios", "L", 10, 5, 5.0, 20.0);

        BaseProduct pimenta = new BaseProduct("Pimenta do Reino", "Temperos", "g", 180, 15);


        //Local dates of entered
        LocalDate dataDeEntrada = LocalDate.now();


        InventoryItem loteArroz = new InventoryItem(arroz, "Camil", 5, 25.90, dataDeEntrada);

        //Overload constructor
        LocalDate validadeRotuloLeite = dataDeEntrada.plusDays(30);

        LocalDate dataEntradaLeite = dataDeEntrada.minusDays(8);

        InventoryItem loteLeite = new InventoryItem(leite, "Parmalat", 12, 4.50, dataEntradaLeite, validadeRotuloLeite);

        InventoryItem lotePimenta = new InventoryItem(pimenta, "Kitano", 100.0, 8.50, dataDeEntrada);

        Pantry despensa = new Pantry();
        System.out.println("Cadastrando lotes na despensa");
        despensa.addLot(loteArroz);
        despensa.addLot(loteLeite);
        despensa.addLot(lotePimenta);

        //Show detailed report by lot
        despensa.printStockByLot();

        despensa.printGeneralStock();

        System.out.println("\n=== RELATÓRIO: ITENS EM ALERTA DE GIRO (PCP) ===");
        List<InventoryItem> itensEmAlerta = despensa.getWarningItems(dataDeEntrada);

        if (itensEmAlerta.isEmpty()) {
            System.out.println("Não há itens em alerta no momento");
        } else {
            System.out.println("ATENÇÃO: Os seguintes lotes estão próximos do limite de validade: ");
            for (InventoryItem item : itensEmAlerta) {
                System.out.println(" - " + item.getBaseProduct().getName() + " - " + item.getBrand() + " Val: " + item.getInternalExpirationDate() + " Qtde: " + item.getQuantity() + item.getBaseProduct().getUnitOfMeasure());
            }
        }
    }
}