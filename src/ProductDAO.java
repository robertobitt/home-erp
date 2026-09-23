import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    // Create (Criar / Salvar)
    Product save(Product product);

    // Ler
    Optional<Product> findById(Long id);

    List<Product> findAll();

    // Update (Atualizar)
    boolean update(Product product);

    // Delete (Excluir)
    boolean deleteById(Long id);
}