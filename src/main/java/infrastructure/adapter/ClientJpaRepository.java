package infrastructure.adapter;

import domain.model.Client;
import domain.port.ClientRepository;
import infrastructure.entity.ClientEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de salida que implementa el puerto ClientRepository sobre JPA.
 * Usa EntityManager directamente para no depender de repositorios Spring Data auxiliares.
 */
@Repository
public class ClientJpaRepository implements ClientRepository {

    private final EntityManager entityManager;

    public ClientJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Client save(Client client) {
        ClientEntity entity = mapToEntity(client);
        if (client.id() == null) {
            entityManager.persist(entity);
        } else {
            entity = entityManager.merge(entity);
        }
        entityManager.flush();
        return mapToDomain(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(entityManager.find(ClientEntity.class, id))
                .map(this::mapToDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        TypedQuery<ClientEntity> query =
                entityManager.createQuery("select c from ClientEntity c order by c.id", ClientEntity.class);
        return query.getResultList().stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findByIdentificationNumber(String identificationNumber) {
        return entityManager
                .createQuery("select c from ClientEntity c where c.identificationNumber = :identificationNumber",
                        ClientEntity.class)
                .setParameter("identificationNumber", identificationNumber)
                .getResultStream()
                .findFirst()
                .map(this::mapToDomain);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        ClientEntity entity = entityManager.find(ClientEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    private ClientEntity mapToEntity(Client client) {
        ClientEntity entity = new ClientEntity();
        entity.setId(client.id());
        entity.setName(client.name());
        entity.setLastName(client.lastName());
        entity.setIdentificationNumber(client.identificationNumber());
        entity.setBirthDate(client.birthDate());
        entity.setEmail(client.email());
        entity.setPhone(client.phone());
        return entity;
    }

    private Client mapToDomain(ClientEntity entity) {
        return new Client(
                entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getIdentificationNumber(),
                entity.getBirthDate(),
                entity.getEmail(),
                entity.getPhone()
        );
    }
}