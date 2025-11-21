# 🚀 Resumen Final: Java Avanzado, Colecciones y Excepciones

## 1. Organización y Tipos de Datos

### Organización del Código
* **Paquetes (`package`):** Son carpetas lógicas que agrupan clases relacionadas. Su función principal es crear un **Namespace** (espacio de nombres) para evitar conflictos si dos clases se llaman igual en librerías distintas.
* **Importación (`import`):** Es la instrucción para utilizar una clase que vive en otro paquete.

### Modelado de Problemas
* Se basa en representar entidades reales como **Clases**.
* Las relaciones se definen por:
    * **Herencia ("Es Un"):** Una clase adquiere propiedades de otra.
    * **Composición/Agregación ("Tiene Un"):** Una clase tiene a otra como atributo (ej: Un `Curso` tiene una `List<Alumno>`).

### Wrappers (Clases Envolventes) 📦
* **Definición:** Son Clases (`Integer`, `Double`, `Boolean`) que envuelven a los tipos primitivos (`int`, `double`, `boolean`).
* **¿Por qué existen?** Las Colecciones (`ArrayList`, etc.) **SOLO guardan Objetos**, no primitivos. Además, los Wrappers permiten valores `null`.
* **Autoboxing:** Java convierte automáticamente Primitivo → Wrapper.
* **Unboxing:** Java convierte automáticamente Wrapper → Primitivo.

---

## 2. UNIDAD 4: Estructuras de Datos y Colecciones

### Concepto: TAD (Tipo Abstracto de Dato)
* Es la definición teórica de **QUÉ** hace una estructura (sus operaciones: insertar, borrar, buscar), sin importar **CÓMO** está programada por dentro.

### Tipos de Listas (Conceptuales)
* **Lista Estática:** Tamaño fijo en memoria (Array). Rápida lectura, imposible redimensionar.
* **Lista Dinámica:** Crece según demanda.
* **Doblemente Enlazada:** Cada nodo conoce al siguiente y al **anterior** (permite recorrer en ambas direcciones).
* **Circular:** El último nodo apunta al primero (no tiene fin).

### Java Collections Framework (JCF) 📚

**A. Interfaz LIST (Ordenada, permite duplicados)**
* **`ArrayList`:**
    * Basada en Array redimensionable.
    * **Lectura:** Muy rápida O(1) por índice.
    * **Escritura:** Lenta en el medio (debe desplazar elementos).
    * **Uso:** 90% de los casos.
* **`LinkedList`:**
    * Basada en Nodos doblemente enlazados.
    * **Lectura:** Lenta O(n) (debe recorrer).
    * **Escritura:** Muy rápida en extremos (inicio/fin).
    * **Uso:** Pilas, Colas.

**B. Interfaz SET (Sin orden garantizado, NO permite duplicados)**
* **`HashSet`:**
    * Basada en Tabla Hash.
    * **Velocidad:** Extremadamente rápida para buscar e insertar.
    * **Orden:** Aleatorio (no se puede confiar en el orden).
* **`TreeSet`:**
    * Basada en Árbol Rojo-Negro.
    * **Orden:** Mantiene los elementos **ordenados naturalmente** (alfabético o numérico).
    * **Velocidad:** Más lenta que HashSet.

**C. Interfaz MAP (Clave-Valor)**
* **`HashMap`:**
    * Guarda pares (Key, Value).
    * Las claves son un `Set` (únicas) y los valores una `Collection`.
    * Acceso casi instantáneo a cualquier valor si tienes la clave.

**D. PriorityQueue**
* Cola de prioridad. Los elementos salen no por orden de llegada, sino por su "importancia" (orden natural o definido por Comparator).

### Herramientas de Colecciones
* **Iteradores (`Iterator`):** Objeto que permite recorrer una colección y **eliminar** elementos de forma segura durante el recorrido (evita errores de concurrencia).
* **`Comparable` vs `Comparator`:**
    * **Comparable:** Se implementa en la clase (método `compareTo`). Define el "orden natural" del objeto.
    * **Comparator:** Es una clase externa o lambda. Define criterios de ordenamiento flexibles (ej: ordenar por DNI, luego por Apellido).
* **`equals()` y `hashCode()`:**
    * Son vitales para `HashSet` y `HashMap`.
    * Si dos objetos son `equals()`, **deben** tener el mismo `hashCode()`. Si no, las colecciones fallan al buscar o eliminar.

---

## 3. UNIDAD 5: Excepciones y Persistencia

### Diferencias Clave
* **Error:** Fallos graves e irrecuperables de la JVM (ej. `OutOfMemoryError`). No se deben capturar.
* **Excepción:** Eventos esperables que el programa puede manejar y recuperarse (ej. archivo no encontrado, dato inválido).

### Jerarquía de Excepciones
1.  **Throwable:** La clase padre de todo.
2.  **Exception (Checked):** El compilador **te obliga** a manejarlas (`try-catch` o `throws`). Suelen ser fallos externos (IO, SQL).
3.  **RuntimeException (Unchecked):** El compilador **no obliga** a manejarlas. Suelen ser errores de lógica del programador (DivisionPorCero, NullPointer).

### Bloques de Control
* **`try`:** Envuelve el código riesgoso.
* **`catch`:** Atrapa la excepción y ejecuta código de recuperación.
* **`finally`:** Se ejecuta **SIEMPRE**. Se usa obligatoriamente para liberar recursos (cerrar archivos, base de datos) para evitar fugas de memoria.

### Propagación y Generación
* **`throw` (Lanzar):** Es una acción. Se usa **dentro** del método para disparar una excepción manualmente. (Ej: `throw new MiError();`).
* **`throws` (Avisar):** Es una declaración. Se usa en la **firma** del método para avisar que ese método *podría* lanzar una excepción y que quien lo llame debe hacerse cargo.

### Excepciones Personalizadas
* Se crean heredando de `Exception` (si quieres que sea obligatoria de manejar) o `RuntimeException`.
* Siempre deben tener un constructor que reciba el mensaje y llame a `super(mensaje)`.
