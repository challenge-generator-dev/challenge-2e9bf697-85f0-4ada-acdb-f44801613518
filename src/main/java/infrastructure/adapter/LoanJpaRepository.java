package infrastructure.adapter;

import domain.model.Loan;
import domain.port.LoanRepository;
import infrastructure.entity.ClientEntity;
import infrastructure.entity.LoanEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de salida que implementa el puerto LoanRepository sobre JPA.
 * Usa EntityManager directamente para no depender de repositorios Spring Data auxiliares.
 */
@Repository
public class LoanJpaRepository implements LoanRepository {

    private final EntityManager entityManager;

    public LoanJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Loan save(Loan loan) {
        LoanEntity entity = mapToEntity(loan);
        if (loan.id() == null) {
            entityManager.persist(entity);
        } else {
            entity = entityManager.merge(entity);
        }
        entityManager.flush();
        return mapToDomain(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Loan> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(entityManager.find(LoanEntity.class, id))
                .map(this::mapToDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Loan> findAll() {
        return entityManager
                .createQuery("select l from LoanEntity l order by l.id", LoanEntity.class)
                .getResultList().stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Loan> findByClientId(Long clientId) {
        return entityManager
                .createQuery("select l from LoanEntity l where l.client.id = :clientId order by l.id",
                        LoanEntity.class)
                .setParameter("clientId", clientId)
                .getResultList().stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        LoanEntity entity = entityManager.find(LoanEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    private LoanEntity mapToEntity(Loan loan) {
        LoanEntity entity = new LoanEntity();
        entity.setId(loan.id());
        entity.setAmount(loan.amount());
        entity.setStartDate(loan.startDate());
        entity.setEndDate(loan.endDate());
        entity.setInterestRate(loan.interestRate());
        entity.setClient(clientReference(loan.clientId()));
        return entity;
    }

    private Loan mapToDomain(LoanEntity entity) {
        Long clientId = entity.getClient() != null ? entity.getClient().getId() : null;
        return new Loan(
                entity.getId(),
                entity.getAmount(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getInterestRate(),
                clientId
        );
    }

    /*
     * Referencia ligera al cliente por su identificador: JPA resuelve la relacion
     * contra la tabla de clientes sin cargar el agregado completo.
     */
    private ClientEntity clientReference(Long clientId) {
        if (clientId == null) {
            return null;
        }
        ClientEntity client = new ClientEntity();
        client.setId(clientId);
        return client;
    }
}