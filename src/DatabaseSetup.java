import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Statement;

public class DatabaseSetup {

    public static void createTables(){
        String sqlProducts = """
                CREATE TABLE IF NOT EXISTS products (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                name TEXT NOT NULL,
                                brand TEXT NOT NULL,
                                unit_of_measure TEXT NOT NULL,
                                min_quantity REAL DEFAULT 0.0,
                                max_quantity REAL DEFAULT 0.0
                            );
                """;

        String sqlInventoryItems = """
                CREATE TABLE IF NOT EXISTS inventory_items (
                                id INTEGER PRIMARY KEY AUTOINCREMENT,
                                product_id INTEGER NOT NULL,
                                quantity REAL NOT NULL,
                                entry_date TEXT NOT NULL,
                                expiration_date TEXT NOT NULL,
                                FOREIGN KEY (product_id)  REFERENCES products(id) ON DELETE CASCADE
                                );
                """;

        try (Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement()
        ){

            stmt.execute("PRAGMA foreign_keys = ON;");

            stmt.execute(sqlProducts);
            stmt.execute(sqlInventoryItems);

            System.out.println("Tabelas 'products' e 'inventory_items' verificadas/criadas com sucesso!");

        } catch (SQLException e){
            System.out.println("Erro ao criar tabelas no banco de dados: " + e.getMessage());
        }
    }
}