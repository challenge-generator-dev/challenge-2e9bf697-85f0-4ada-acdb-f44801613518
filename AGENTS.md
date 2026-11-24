# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Normalización de Modelo de Datos en una Base de Datos**.

| | |
|---|---|
| Tema | Diseño e Implementación de un Modelo de Datos Normalizado |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar con separación de dominio e infraestructura |
| Tiempo estimado | 8 horas |

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | server | Java | Spring Data JPA, PostgreSQL |
| `infra-local` | (raiz) | support | infra | Compose local | PostgreSQL |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web
- org.springframework.boot:spring-boot-starter-test
- org.postgresql:postgresql
- org.springframework.boot:spring-boot-configuration-processor
- org.springframework.boot:spring-boot-starter-actuator
- org.springframework.boot:spring-boot-starter-data-jpa
- org.springframework.boot:spring-boot-starter-validation

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Segui el orden de arranque del mapa de componentes (infraestructura local primero) y corre `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q` desde la raiz: mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Diseño del Modelo Entidad-Relación**: Diagrama Entidad-Relación normalizado en formato PlantUML o similar, con entidades, atributos, relaciones y restricciones de normalización documentadas.
- **Fase 2 — Implementación del Modelo en PostgreSQL**: Base de datos PostgreSQL con el modelo de datos normalizado implementado.
- **Fase 3 — Integración con Spring Data JPA**: Aplicación Spring Boot con el modelo de datos normalizado integrado y la lógica de negocio implementada.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/infrastructure/adapter/PostgreSQLSchemaAdapter.java` — La pieza p2 (Implementación de esquema PostgreSQL normalizado, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/infrastructure/entity/LoanEntity.java` — La pieza p4 (Mapeo de entidad JPA a tabla normalizada, fase f3) vive aqui: este archivo es su unico dueno (blueprint v2).

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Diseño del Modelo Entidad-Relación | Modelado Entidad-Relación con normalización hasta 3FN | — | El diagrama Entidad-Relación incluye entidades, atributos y relaciones coherentes con el dominio de préstamos.; El modelo está normalizado al menos hasta 3FN, con justificación documentada.; Se identifican y resuelven dependencias parciales y transitivas en el modelo. | — | — |
| f2 — Implementación del Modelo en PostgreSQL | Implementación de esquema PostgreSQL normalizado | `src/main/java/infrastructure/adapter/PostgreSQLSchemaAdapter.java:postgresql_schema.loan_tables` | La base de datos PostgreSQL contiene tablas con esquemas que corresponden al modelo Entidad-Relación normalizado.; Las restricciones de integridad (PK, FK, unique, not null) están correctamente definidas.; Las tablas cumplen con las formas normales documentadas en la fase f1. | — | — |
| f2 — Implementación del Modelo en PostgreSQL | Definición de tablas normalizadas con restricciones | `src/main/java/infrastructure/adapter/PostgreSQLSchemaAdapter.java:postgresql_table.loan` | La base de datos PostgreSQL contiene tablas con esquemas que corresponden al modelo Entidad-Relación normalizado.; Las restricciones de integridad (PK, FK, unique, not null) están correctamente definidas.; Las tablas cumplen con las formas normales documentadas en la fase f1. | — | — |
| f3 — Integración con Spring Data JPA | Mapeo de entidad JPA a tabla normalizada | `src/main/java/infrastructure/entity/LoanEntity.java:LoanEntity` | Las entidades JPA mapean correctamente a las tablas PostgreSQL normalizadas.; Las relaciones entre entidades (OneToMany, ManyToOne) están correctamente definidas y respetan las formas normales.; La lógica de negocio implementada maneja casos de error relacionados con violaciones de integridad del modelo. | — | — |
| f3 — Integración con Spring Data JPA | Lógica de negocio con validación de integridad del modelo | — | Las entidades JPA mapean correctamente a las tablas PostgreSQL normalizadas.; Las relaciones entre entidades (OneToMany, ManyToOne) están correctamente definidas y respetan las formas normales.; La lógica de negocio implementada maneja casos de error relacionados con violaciones de integridad del modelo. | — | — |

## Pruebas de aceptacion y ubicacion de la logica

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

La logica de cada pieza va en su archivo; no la muevas a otro.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Diseñó un modelo Entidad‑Relación coherente con los requerimientos y normalizó las tablas de manera adecuada. Identificó entidades, atributos y relaciones, y aplicó las formas normales para reducir redundancias y prevenir anomalías de inserción, actualización y eliminación | sin ubicar | Restriccion no verificada en sin ubicar |

## Lo que falta y tenes que completar

No se detectaron huecos: estan los archivos declarados, el boilerplate del stack y ninguna referencia quedo colgando. Igual corre el comando de verificacion — que los archivos existan no garantiza que compilen.

### Presentes (16)

- `pom.xml`
- `src/main/java/infrastructure/entity/ClientEntity.java`
- `src/main/java/domain/port/LoanRepository.java`
- `src/main/java/domain/port/ClientRepository.java`
- `src/main/java/infrastructure/adapter/LoanJpaRepository.java`
- `src/main/java/infrastructure/adapter/ClientJpaRepository.java`
- `src/main/java/infrastructure/adapter/PostgreSQLSchemaAdapter.java`
- `src/main/java/infrastructure/entity/LoanEntity.java`
- `src/main/resources/application.yml`
- `src/main/java/Application.java`
- `src/main/java/resources/application.yml`
- `src/main/java/domain/model/Client.java`
- `src/main/java/domain/model/Loan.java`
- `docker-compose.yml`
- `infra-local/README.md`
- `infra-local/postgres/init.sql`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/main/java/com/bank/loan/domain/model` (ausente)
- `src/main/java/com/bank/loan/domain/port` (ausente)
- `src/main/java/com/bank/loan/domain/service` (ausente)
- `src/main/java/com/bank/loan/infrastructure/adapter` (ausente)
- `src/main/java/com/bank/loan/infrastructure/config` (ausente)
- `src/main/java/com/bank/loan/infrastructure/entity` (ausente)
- `src/main/resources` (presente)
- `src/test/java/com/bank/loan` (ausente)

## Verificacion

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- Cada componente vive en su carpeta: instala y compila dentro de ella, y no muevas archivos entre componentes.
- Respeta los contratos entre componentes (endpoints, topics) tal como estan declarados en el mapa de componentes.
- El patron es **capas estándar con separación de dominio e infraestructura**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced L2
- Brecha que el reto ataca: Implementa un proceso de normalización en una base de datos según las formas normales y ha usado un modelo Entidad-Relación.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
