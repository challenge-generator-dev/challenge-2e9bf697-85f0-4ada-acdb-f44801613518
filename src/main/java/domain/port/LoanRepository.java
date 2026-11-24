package domain.port;

import domain.model.Loan;
import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida para la persistencia de préstamos.
 *
 * <p>Vive en la capa de dominio: el dominio define qué necesita del almacenamiento
 * y la capa de infraestructura (por ejemplo {@code LoanJpaRepository}) provee la implementación.
 * El dominio nunca depende de JPA ni de Spring.
 *
 * <p>El tipo {@code Loan} pertenece al paquete {@code domain.model}. Ese paquete debe
 * existir en el proyecto para que esta interfaz compile.
 */
public interface LoanRepository {

    /**
     * Persiste un préstamo nuevo o actualiza uno existente y devuelve la versión guardada.
     */
    Loan save(Loan loan);

    /**
     * Busca un préstamo por su identificador.
     *
     * @return el préstamo si existe; vacío en caso contrario.
     */
    Optional<Loan> findById(Long id);

    /**
     * Devuelve todos los préstamos registrados.
     */
    List<Loan> findAll();

    /**
     * Devuelve los préstamos asociados a un cliente.
     */
    List<Loan> findByClientId(Long clientId);

    /**
     * Elimina el préstamo con el identificador indicado. No falla si no existe.
     */
    void deleteById(Long id);
}