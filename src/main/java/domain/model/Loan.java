package domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Prestamo otorgado a un cliente. Solo conserva la referencia al cliente por identificador,
 * manteniendo el agregado desacoplado de la infraestructura.
 */
public record Loan(
        Long id,
        BigDecimal amount,
        LocalDate startDate,
        LocalDate endDate,
        BigDecimal interestRate,
        Long clientId) {

    public Loan {
        Objects.requireNonNull(amount, "El monto del prestamo es obligatorio");
        Objects.requireNonNull(startDate, "La fecha de inicio es obligatoria");
        if (amount.signum() <= 0) {
            throw new IllegalArgumentException("El monto del prestamo debe ser positivo");
        }
        if (endDate != null && endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior al inicio");
        }
    }

    public Loan withId(Long newId) {
        return new Loan(newId, amount, startDate, endDate, interestRate, clientId);
    }
}