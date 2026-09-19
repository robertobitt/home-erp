import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("===HomeERP - Teste  de controle de estoque (PCP) ===\n");
        // 1. Criar os produtos base (BaseProduct)
        // Arroz: Giro interno de 30 dias | Alerta com 5 dias de antecedência
        BaseProduct arroz = new BaseProduct("Arroz agulhinha","grãos","kg", 30, 5);

        // Leite: Giro interno de 10 dias | Alerta com 3 dias de antecedência
        BaseProduct leite = new BaseProduct("Leite Integral","laticíneos","L", 30, 5, 5.0,20.0);

        //Local dates of entered
        LocalDate dataDeEntrada = LocalDate.now();

        InventoryItem loteArroz = new InventoryItem(arroz, "Tio João", 5, 25.90, dataDeEntrada);

        //Overload constructor
        LocalDate validadeRotuloLeite = dataDeEntrada.plusDays(7);
        InventoryItem loteLeite = new InventoryItem(leite, "Parmalat", 12, 4.50, dataDeEntrada, validadeRotuloLeite);

        //show the infos about batch dates
        System.out.println("---Lote de arroz criado---");
        System.out.println("Produto: " + loteArroz.getBaseProduct().getName());
        System.out.println("Quantidade em estoque " + loteArroz.getQuantity() + " " + loteArroz.getBaseProduct().getUnitOfMeasure());
        System.out.println("Data de entrada " + loteArroz.getEntryDate());
        System.out.println("Validade interna " + loteArroz.getInternalExpirationDate());

        System.out.println("Teste de baixa em estoque");
        System.out.println("Dar baixa de 2" + loteArroz.getBaseProduct().getUnitOfMeasure() + loteArroz.getBaseProduct().getName());
        loteArroz.deductQuantity(2.0);
        System.out.println("Estoque atualizado de arroz: " + loteArroz.getQuantity() + loteArroz.getBaseProduct().getUnitOfMeasure());

        //Alert test
        System.out.println("--- Teste de alerta PCP (Validades) ---");
        LocalDate dataSimuladaFuturo = dataDeEntrada.plusDays(26);
        System.out.println("Simulando verificação no dia: " + dataSimuladaFuturo);

        boolean arrozPrecisaGiro = loteArroz.isEarlyWarningTrigged(dataSimuladaFuturo);
        System.out.println("Arroz precisa de alerta de giro? " + (arrozPrecisaGiro ? "SIM - ⚠⚠ Consumir ou será descartado ⚠⚠" : "NãO✅"));

        }
}