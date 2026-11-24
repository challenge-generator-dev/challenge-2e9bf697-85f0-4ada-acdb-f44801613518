# Normalización de Modelo de Datos en una Base de Datos

El sistema de gestión de préstamos de un banco requiere un modelo de datos normalizado para mejorar la eficiencia y reducir redundancias. Debes diseñar un modelo Entidad-Relación y aplicar las formas normales para normalizar las tablas, identificando entidades, atributos y relaciones. El objetivo es prevenir anomalías de inserción, actualización y eliminación.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Diseño e Implementación de un Modelo de Datos Normalizado |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Diseño del Modelo Entidad-Relación

**Objetivo:** Crear un modelo Entidad-Relación coherente con los requerimientos del sistema de gestión de préstamos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- El diagrama debe incluir al menos 3 entidades principales del dominio de préstamos (ej: Cliente, Préstamo, Pago).
- Documentar en el diagrama las formas normales aplicadas (1FN, 2FN, 3FN) y cómo se resolvieron las dependencias parciales/transitivas.
- Incluir una justificación breve (en comentarios del diagrama) de por qué el modelo cumple con las formas normales.
- Validar que el modelo evita anomalías de inserción, actualización y eliminación mediante ejemplos concretos en la documentación.

**Entregable:** Diagrama Entidad-Relación normalizado en formato PlantUML o similar, con entidades, atributos, relaciones y restricciones de normalización documentadas.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda las formas normales y su propósito.
- Considera cómo las relaciones entre entidades pueden afectar la normalización.

</details>

### Fase 2: Implementación del Modelo en PostgreSQL

**Objetivo:** Implementar el modelo Entidad-Relación normalizado en una base de datos PostgreSQL.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Crea las tablas en PostgreSQL según el modelo Entidad-Relación normalizado.
- Aplica las restricciones necesarias para mantener la integridad de los datos.
- Realiza pruebas para verificar que las tablas están correctamente normalizadas y que no hay redundancias ni anomalías.

**Entregable:** Base de datos PostgreSQL con el modelo de datos normalizado implementado.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza las herramientas de PostgreSQL para crear y gestionar las tablas.
- Aplica las restricciones de integridad referencial y otros tipos de restricciones necesarias.

</details>

### Fase 3: Integración con Spring Data JPA

**Objetivo:** Integrar el modelo de datos normalizado con la lógica de negocio utilizando Spring Data JPA.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configura Spring Data JPA para conectar con la base de datos PostgreSQL.
- Crea las clases de entidad y los repositorios necesarios para interactuar con las tablas.
- Implementa la lógica de negocio para realizar operaciones CRUD en las entidades.
- Realiza pruebas para verificar que la integración funciona correctamente.

**Entregable:** Aplicación Spring Boot con el modelo de datos normalizado integrado y la lógica de negocio implementada.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza las anotaciones de Spring Data JPA para mapear las clases de entidad a las tablas de la base de datos.
- Implementa los métodos de los repositorios para realizar operaciones CRUD.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es un modelo Entidad-Relación y por qué es importante en la normalización de datos?
- **paraQueSirve**: ¿Para qué sirve aplicar las formas normales en un modelo de datos?
- **comoSeUsa**: ¿Cómo se utiliza Spring Data JPA para integrar un modelo de datos con la lógica de negocio?
- **erroresComunes**: ¿Cuáles son los errores comunes al normalizar un modelo de datos y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica el diseño y la implementación de un modelo de datos normalizado?

## Criterios de Evaluacion

- Diseño de un modelo Entidad-Relación coherente con los requerimientos.
- Aplicación adecuada de las formas normales para reducir redundancias y prevenir anomalías.
- Implementación correcta del modelo de datos en PostgreSQL.
- Integración exitosa del modelo de datos con la lógica de negocio utilizando Spring Data JPA.

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Diseño del Modelo Entidad-Relación | Modelado Entidad-Relación con normalización hasta 3FN | — | El diagrama Entidad-Relación incluye entidades, atributos y relaciones coherentes con el dominio de préstamos.; El modelo está normalizado al menos hasta 3FN, con justificación documentada.; Se identifican y resuelven dependencias parciales y transitivas en el modelo. | — | — |
| f2 — Implementación del Modelo en PostgreSQL | Implementación de esquema PostgreSQL normalizado | `src/main/java/infrastructure/adapter/PostgreSQLSchemaAdapter.java:postgresql_schema.loan_tables` | La base de datos PostgreSQL contiene tablas con esquemas que corresponden al modelo Entidad-Relación normalizado.; Las restricciones de integridad (PK, FK, unique, not null) están correctamente definidas.; Las tablas cumplen con las formas normales documentadas en la fase f1. | — | — |
| f2 — Implementación del Modelo en PostgreSQL | Definición de tablas normalizadas con restricciones | `src/main/java/infrastructure/adapter/PostgreSQLSchemaAdapter.java:postgresql_table.loan` | La base de datos PostgreSQL contiene tablas con esquemas que corresponden al modelo Entidad-Relación normalizado.; Las restricciones de integridad (PK, FK, unique, not null) están correctamente definidas.; Las tablas cumplen con las formas normales documentadas en la fase f1. | — | — |
| f3 — Integración con Spring Data JPA | Mapeo de entidad JPA a tabla normalizada | `src/main/java/infrastructure/entity/LoanEntity.java:LoanEntity` | Las entidades JPA mapean correctamente a las tablas PostgreSQL normalizadas.; Las relaciones entre entidades (OneToMany, ManyToOne) están correctamente definidas y respetan las formas normales.; La lógica de negocio implementada maneja casos de error relacionados con violaciones de integridad del modelo. | — | — |
| f3 — Integración con Spring Data JPA | Lógica de negocio con validación de integridad del modelo | — | Las entidades JPA mapean correctamente a las tablas PostgreSQL normalizadas.; Las relaciones entre entidades (OneToMany, ManyToOne) están correctamente definidas y respetan las formas normales.; La lógica de negocio implementada maneja casos de error relacionados con violaciones de integridad del modelo. | — | — |

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Diseñó un modelo Entidad‑Relación coherente con los requerimientos y normalizó las tablas de manera adecuada. Identificó entidades, atributos y relaciones, y aplicó las formas normales para reducir redundancias y prevenir anomalías de inserción, actualización y eliminación | sin ubicar | Restriccion no verificada en sin ubicar |

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | server | Java | Spring Data JPA, PostgreSQL |
| `infra-local` | (raiz) | support | infra | Compose local | PostgreSQL |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
