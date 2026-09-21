import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void printGeneralStock() {
        System.out.println("=====RELATÓRIO GERAL DE ESTOQUE CONSOLIDADO=====");

        if (items.isEmpty()) {
            System.out.println("Não há nada no estoque");
            return;
        }

        Map<BaseProduct, Double> stockTotals = new HashMap<>();

        for (InventoryItem item : items) {
            BaseProduct product = item.getBaseProduct();
            Double currentTotals = stockTotals.getOrDefault(product, 0.0);
            stockTotals.put(product, currentTotals + item.getQuantity());
        }
        for (Map.Entry<BaseProduct, Double> entry : stockTotals.entrySet()) {
            BaseProduct product = entry.getKey();
            double totalQuantity = entry.getValue();

            System.out.print("- " + product.getName() + ": " + totalQuantity + " " + product.getUnitOfMeasure());

            if (product.getMinQuantity() != null) {
                if (totalQuantity < product.getMinQuantity()) {
                    System.out.println("ALERTA! ABAIXO DO ESTOQUE MÍNIMO DE: " + product.getMinQuantity() + product.getUnitOfMeasure());
                } else {
                    System.out.println(" ESTOQUE OK");
                }
            } else {
                System.out.println(" Sem Limite mínimo definido");
            }
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

    public List<InventoryItem> getItems() {
        return items;
    }
}