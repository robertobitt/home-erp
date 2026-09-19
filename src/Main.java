import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("===HomeERP - Teste  de controle de estoque (PCP) ===\n");
        // 1. Criar os produtos base (BaseProduct)
        // Arroz: Giro interno de 30 dias | Alerta com 5 dias de antecedência
        BaseProduct arroz = new BaseProduct("Arroz Agulhinha","Grãos","kg", 30, 5);

        // Leite: Giro interno de 10 dias | Alerta com 3 dias de antecedência
        BaseProduct leite = new BaseProduct("Leite Integral","Laticíneos","L", 30, 5, 5.0,20.0);

        // Pimenta: Usando o construtor secundário (sem min/max informados -> defaults to null)
        BaseProduct pimenta = new BaseProduct("Pimenta do Reino","Temperos", "g", 180, 15 );

        //Local dates of entered
        LocalDate dataDeEntrada = LocalDate.now();


        InventoryItem loteArroz = new InventoryItem(arroz, "Camil", 5, 25.90, dataDeEntrada);

        //Overload constructor
        LocalDate validadeRotuloLeite = dataDeEntrada.minusDays(8);
        InventoryItem loteLeite = new InventoryItem(leite, "Parmalat", 12, 4.50, dataDeEntrada, validadeRotuloLeite);

        InventoryItem lotePimenta = new InventoryItem(pimenta, "Kitano", 100.0, 8.50, dataDeEntrada);

        Pantry despensa = new Pantry();
        System.out.println("Cadastrando lotes na despensa");
        despensa.addLot(loteArroz);
        despensa.addLot(loteLeite);
        despensa.addLot(lotePimenta);

        despensa.printStockByLot();

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