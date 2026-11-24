# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/infrastructure/adapter/PostgreSQLSchemaAdapter.java` — La pieza p2 (Implementación de esquema PostgreSQL normalizado, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/infrastructure/entity/LoanEntity.java` — La pieza p4 (Mapeo de entidad JPA a tabla normalizada, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | server | Java | Spring Data JPA, PostgreSQL |
| `infra-local` | (raiz) | support | infra | Compose local | PostgreSQL |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2

### Brecha de conocimiento
Implementa un proceso de normalización en una base de datos según las formas normales y ha usado un modelo Entidad-Relación.

### Reto
- Tema: Diseño e Implementación de un Modelo de Datos Normalizado
- Seniority: advanced-l2
- Tipo: practical
- Título: Normalización de Modelo de Datos en una Base de Datos
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Diseño del Modelo Entidad-Relación — objetivo: Crear un modelo Entidad-Relación coherente con los requerimientos del sistema de gestión de préstamos. — entregable (NO resolver): Diagrama Entidad-Relación normalizado en formato PlantUML o similar, con entidades, atributos, relaciones y restricciones de normalización documentadas.
- Fase 2: Implementación del Modelo en PostgreSQL — objetivo: Implementar el modelo Entidad-Relación normalizado en una base de datos PostgreSQL. — entregable (NO resolver): Base de datos PostgreSQL con el modelo de datos normalizado implementado.
- Fase 3: Integración con Spring Data JPA — objetivo: Integrar el modelo de datos normalizado con la lógica de negocio utilizando Spring Data JPA. — entregable (NO resolver): Aplicación Spring Boot con el modelo de datos normalizado integrado y la lógica de negocio implementada.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/infrastructure/entity/ClientEntity.java ===
package infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, unique = true, length = 20)
    private String identificationNumber;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanEntity> loans;

    // Constructors
    public ClientEntity() {
    }

    public ClientEntity(String name, String lastName, String identificationNumber, LocalDate birthDate, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<LoanEntity> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanEntity> loans) {
        this.loans = loans;
    }
}

// === ARCHIVO: src/main/java/domain/port/LoanRepository.java ===
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

// === ARCHIVO: src/main/java/domain/port/ClientRepository.java ===
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

// === ARCHIVO: src/main/java/infrastructure/adapter/LoanJpaRepository.java ===
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

// === ARCHIVO: src/main/java/infrastructure/adapter/ClientJpaRepository.java ===
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

// === ARCHIVO: src/main/java/infrastructure/adapter/PostgreSQLSchemaAdapter.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.adapter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLSchemaAdapter {

    private final Connection connection;

    public PostgreSQLSchemaAdapter(Connection connection) {
        this.connection = connection;
    }

    public void createSchema() {
      throw new UnsupportedOperationException("TODO(reto): createSchema");
    }

    public void createLoanTable() {
      throw new UnsupportedOperationException("TODO(reto): createLoanTable");
    }

    public void createPaymentTable() {
      throw new UnsupportedOperationException("TODO(reto): createPaymentTable");
    }

    public void createClientTable() {
      throw new UnsupportedOperationException("TODO(reto): createClientTable");
    }

    public void applyNormalization() {
      throw new UnsupportedOperationException("TODO(reto): applyNormalization");
    }

    private void executeSql(String sql) {
      throw new UnsupportedOperationException("TODO(reto): executeSql");
    }

    public String generateSchemaScript() {
      throw new UnsupportedOperationException("TODO(reto): generateSchemaScript");
    }
}

// === ARCHIVO: src/main/java/infrastructure/entity/LoanEntity.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "loan", schema = "loan_schema")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @NotNull(message = "El cliente es obligatorio")
    private ClientEntity client;

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser positivo")
    private BigDecimal amount;

    @Column(name = "interest_rate", nullable = false, precision = 5, scale = 4)
    @NotNull(message = "La tasa de interés es obligatoria")
    @DecimalMin(value = "0.0", message = "La tasa de interés no puede ser negativa")
    @DecimalMax(value = "1.0", message = "La tasa de interés no puede exceder 1")
    private BigDecimal interestRate;

    @Column(name = "start_date", nullable = false)
    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status", nullable = false, length = 20)
    @NotBlank(message = "El estado es obligatorio")
    @Size(max = 20, message = "El estado no puede exceder 20 caracteres")
    private String status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PaymentEntity> payments = new ArrayList<>();

    public LoanEntity() {
    }

    public LoanEntity(ClientEntity client, BigDecimal amount, BigDecimal interestRate,
                      LocalDate startDate, LocalDate endDate, String status) {
        this.client = client;
        this.amount = amount;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentEntity> payments) {
        this.payments = payments;
    }

    public void addPayment(PaymentEntity payment) {
      throw new UnsupportedOperationException("TODO(reto): addPayment");
    }

    public void removePayment(PaymentEntity payment) {
      throw new UnsupportedOperationException("TODO(reto): removePayment");
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: reto
  datasource:
    url: ${POSTGRES_URL:jdbc:postgresql://localhost:5432/loan_db}
    username: ${POSTGRES_USER:app_user}
    password: ${POSTGRES_PASSWORD:}
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  jpa:
    hibernate:
      ddl-auto: none
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
        jdbc:
          batch_size: 20
        order_inserts: true
        order_updates: true
    open-in-view: false
  sql:
    init:
      mode: never
      schema-locations: classpath:schema.sql
      data-locations: classpath:data.sql

server:
  port: ${SERVER_PORT:8080}
  shutdown: graceful

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
      base-path: /actuator
  endpoint:
    health:
      show-details: when_authorized
      probes:
        enabled: true
  health:
    db:
      enabled: true
    diskspace:
      enabled: true
  metrics:
    export:
      prometheus:
        enabled: true

logging:
  level:
    root: INFO
    com.example: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    org.springframework.web: DEBUG
    org.springframework.jdbc: DEBUG
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"

app:
  schema:
    name: ${SCHEMA_NAME:loan_management}
  security:
    jwt:
      secret: ${JWT_SECRET:}
      expiration: 3600000
  loan:
    max-amount: 100000.00
    min-amount: 1000.00
    default-interest-rate: 0.15
    max-term-months: 60
  payment:
    grace-period-days: 5
    late-fee-percentage: 0.05

// === ARCHIVO: src/main/java/Application.java ===
package com.example.reto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * Punto de entrada del sistema de gestión de préstamos.
 * Arquitectura en capas: domain (modelo y puertos), infrastructure (adaptadores y entidades JPA).
 * El escaneo de componentes y de repositorios cubre los paquetes de cada capa.
 */
@SpringBootApplication(scanBasePackages = {"com.example.reto", "domain", "infrastructure"})
@EnableJpaRepositories(basePackages = "infrastructure")
@EntityScan(basePackages = "infrastructure.entity")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// === ARCHIVO: src/main/java/resources/application.yml ===
# Configuración de la aplicación de gestión de préstamos.
# Las credenciales se leen de variables de entorno del servidor; nunca se escriben aquí.
spring:
  application:
    name: reto-prestamos

  datasource:
    # Valores por defecto apuntan a infra-local; en otro entorno se sobreescriben por variables.
    url: ${DB_URL:jdbc:postgresql://localhost:5432/prestamos}
    username: ${DB_USERNAME:prestamos}
    password: ${DB_PASSWORD:prestamos}
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: ${DB_POOL_SIZE:10}

  jpa:
    # El esquema se crea con el script SQL normalizado (fase 2); Hibernate solo valida el mapeo.
    hibernate:
      ddl-auto: validate
    open-in-view: false
    show-sql: false
    properties:
      hibernate:
        format_sql: true
        jdbc:
          time_zone: UTC

  jackson:
    serialization:
      write-dates-as-timestamps: false

management:
  endpoints:
    web:
      exposure:
        include: health,info
  endpoint:
    health:
      show-details: when-authorized

server:
  port: ${SERVER_PORT:8080}

// === ARCHIVO: src/main/java/domain/model/Client.java ===
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

// === ARCHIVO: src/main/java/domain/model/Loan.java ===
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

// === ARCHIVO: docker-compose.yml ===
# Infraestructura local del reto. SOLO desarrollo: credenciales de ejemplo (local-dev-only), puertos en loopback.
# Levantar: docker compose up -d --wait
name: infra-local
services:
  postgres:
    image: "postgres:16.4-alpine"
    ports:
      - "127.0.0.1:5432:5432"
    environment:
      POSTGRES_USER: "app"
      POSTGRES_PASSWORD: "local-dev-only"
      POSTGRES_DB: "app"
    volumes:
      - "./infra-local/postgres/init.sql:/docker-entrypoint-initdb.d/init.sql:ro"
    healthcheck:
      test: ["CMD-SHELL","pg_isready -U app -d app"]
      interval: 10s
      timeout: 5s
      retries: 10
      start_period: 10s


// === ARCHIVO: infra-local/README.md ===
# Infraestructura local

Servicios de soporte para el reto, definidos en `docker-compose.yml` (raiz del repo).

```bash
docker compose up -d --wait
```

| Servicio | Imagen | Puertos (host) |
|---|---|---|
| PostgreSQL | `postgres:16.4-alpine` | 5432 |

Credenciales: solo de desarrollo local (`local-dev-only`, `local`). No son secretos ni deben reutilizarse.
Los scripts de `infra-local/` (tablas, topics) se ejecutan con el compose en estado healthy.


// === ARCHIVO: infra-local/postgres/init.sql ===
-- DDL de ejemplo; se ejecuta al crear el volumen de PostgreSQL. Ajustalo a tu modelo.
CREATE TABLE IF NOT EXISTS items (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

```
