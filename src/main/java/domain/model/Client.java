package domain.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Cliente del banco. Es un modelo de dominio puro: no conoce persistencia ni transporte.
 */
public record Client(
        Long id,
        String name,
        String lastName,
        String identificationNumber,
        LocalDate birthDate,
        String email,
        String phone) {

    public Client {
        Objects.requireNonNull(name, "El nombre del cliente es obligatorio");
        Objects.requireNonNull(lastName, "El apellido del cliente es obligatorio");
        Objects.requireNonNull(identificationNumber, "El numero de identificacion es obligatorio");
        if (identificationNumber.isBlank()) {
            throw new IllegalArgumentException("El numero de identificacion no puede estar vacio");
        }
    }

    public Client withId(Long newId) {
        return new Client(newId, name, lastName, identificationNumber, birthDate, email, phone);
    }
}