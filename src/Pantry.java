import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pantry {

    private List<InventoryItem> items;

    public Pantry() {
        this.items = new ArrayList<>();
    }

    public void addLot(InventoryItem item) {
        this.items.add(item);
        System.out.println("Lote de " + item.getBaseProduct().getName() + " (" + item.getBrand() + ") " + "adicionado a despensa.");

    }

    public void printStockByLot() {
        System.out.println("=== RELATÓRIO: ESTOQUE DETALHADO POR LOTE ===");
        if (items.isEmpty()) {
            System.out.println("A despensa está vazia.");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            InventoryItem item = items.get(i);
            System.out.println("Lote #" + (i + 1) + " | " + item.getBaseProduct().getName() + " (" + item.getBrand() + ") - Qtd: " + item.getQuantity() + item.getBaseProduct().getUnitOfMeasure() + " | Data Entrada: " + item.getEntryDate() + " | Validade Interna: " + item.getInternalExpirationDate());
        }
    }

    public List<InventoryItem> getWarningItems(LocalDate currentDate) {
        List<InventoryItem> warningList = new ArrayList<>();

        for (InventoryItem item : items) {
            if (item.isEarlyWarningTrigged(currentDate)) {
                warningList.add(item);
            }
        }
        return warningList;
    }
    public List<InventoryItem> getItems(){
        return items;
    }
}