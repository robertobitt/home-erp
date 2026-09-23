import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== INICIANDO TESTE DO HOME ERP COM SQLITE ===");

        // Instanciando a DAO através da interface (DIP - Inversão de Dependência)
        ProductDAO productDAO = new ProductDAOImpl();

        // 1. CRIAÇÃO (INSERT)
        System.out.println("\n--- 1. Salvando produtos no banco ---");
        Product p1 = new Product(null, "Detergente Neutro", "Lava louças 500ml", 2.80, 50);
        Product p2 = new Product(null, "Sabão em Pó", "Lava roupas 1kg", 18.90, 20);

        productDAO.save(p1);
        productDAO.save(p2);

        System.out.println("Produto 1 salvo com ID: " + p1.getId());
        System.out.println("Produto 2 salvo com ID: " + p2.getId());

        // 2. BUSCA POR ID (SELECT WHERE id = ?)
        System.out.println("\n--- 2. Buscando produto por ID ---");
        Optional<Product> buscado = productDAO.findById(p1.getId());
        buscado.ifPresentOrElse(
                p -> System.out.println("Produto encontrado: " + p),
                () -> System.out.println("Produto não encontrado!")
        );

        // 3. ATUALIZAÇÃO (UPDATE)
        System.out.println("\n--- 3. Atualizando preço e quantidade ---");
        p1.setPrice(3.20);
        p1.setQuantity(45);
        boolean atualizou = productDAO.update(p1);
        System.out.println("Atualização realizada? " + atualizou);

        // 4. LISTAGEM GERAL (SELECT *)
        System.out.println("\n--- 4. Listando todos os produtos ---");
        List<Product> todos = productDAO.findAll();
        for (Product p : todos) {
            System.out.println(p);
        }

        // 5. EXCLUSÃO (DELETE)
        System.out.println("\n--- 5. Deletando um produto pelo ID ---");
        boolean deletou = productDAO.deleteById(p2.getId());
        System.out.println("Deletado com sucesso? " + deletou);

        // LISTAGEM FINAL
        System.out.println("\n--- Listagem Final no Banco ---");
        for (Product p : productDAO.findAll()) {
            System.out.println(p);

            System.out.println("\n=== TESTES CONCLUÍDOS COM SUCESSO! ===");

            //Restante

            System.out.println("+++++ 1.TESTE DO SISTEMA HOMEERP (EM MEMÓRIA) +++++");


            System.out.println("===HomeERP - Teste  de controle de estoque (PCP) ===\n");

            BaseProduct arroz = new BaseProduct("Arroz Agulhinha", "Grãos", "kg", 30, 5);

            BaseProduct leite = new BaseProduct("Leite Integral", "Laticínios", "L", 10, 5, 5.0, 20.0);

            BaseProduct pimenta = new BaseProduct("Pimenta do Reino", "Temperos", "g", 180, 15);

            //testar depois alterações
            //pimenta.setName("pimenta dedo de moça");

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
}