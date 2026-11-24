package domain.port;

import domain.model.Client;

import java.util.List;
import java.util.Optional;

/**
 * Puerto de salida definido por el dominio. La infraestructura lo implementa;
 * el dominio nunca depende de la implementacion JPA.
 */
public interface ClientRepository {

    Client save(Client client);

    Optional<Client> findById(Long id);

    List<Client> findAll();

    Optional<Client> findByIdentificationNumber(String identificationNumber);

    void deleteById(Long id);
}