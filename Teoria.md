# 🚀 Machete Final: POO, Estructuras y Control de Flujo

## 1. POO: Abstracción y Diseño

### Encapsulamiento 🛡️
* **Definición:** Ocultar los datos internos de una clase y exponer solo las operaciones seguras.
* **Mecanismo:** Atributos `private` y acceso mediante métodos `public` (Getters/Setters).

### Clase Abstracta vs. Interfaz
* **Clase Abstracta:**
    * **Relación:** "ES UN" (Herencia).
    * **Contenido:** Puede tener métodos con código (para reutilizar) y métodos abstractos.
    * **Restricción:** Solo se puede heredar (`extends`) de **una** clase abstracta.
* **Interfaz:**
    * **Relación:** "PUEDE HACER" (Contrato).
    * **Contenido:** Solo define la firma de métodos (no tiene atributos de estado).
    * **Restricción:** Se pueden implementar (`implements`) **múltiples** interfaces.

### `equals()` y `hashCode()`
* **`==`:** Compara si dos objetos son la **misma referencia** en memoria.
* **`.equals()`:** Debe ser redefinido para comparar el **contenido lógico** (ej. la patente).
* **`hashCode()`:** Debe ser redefinido junto con `equals()`. Es vital para que funcionen colecciones tipo `Set` y `Map`.

---

## 2. Tipos de Datos y Wrappers 📦

### Wrappers (`Integer` vs. `int`)
* **`int`:** Tipo **primitivo**. Rápido, simple, no puede ser `null`.
* **`Integer`:** **Clase Objeto** (Wrapper).
* **Propósito:** Permite almacenar primitivos en colecciones (ej. `ArrayList<Integer>`) y usar el valor `null` (ausencia de valor).
* **Autoboxing/Unboxing:** La conversión entre `int` e `Integer` se hace automáticamente.

### `static` y `final`
* **`static`:** El miembro pertenece a la **Clase**, no a un objeto. Se comparte entre todas las instancias (Ej: `flota` de vehículos).
* **`final`:** Indica inmutabilidad. Una variable `final` no puede cambiar su valor.

---

## 3. Estructuras de Datos Lineales

### La Lógica de Rendimiento (Array vs. Nodo)

| Operación | ArrayList (Array) | LinkedList (Nodo) | Lógica Detrás |
| :--- | :--- | :--- | :--- |
| **Acceso (`get(i)`)** | **RÁPIDO (O(1))** 🚀 | LENTO (O(n)) 🐢 | Array salta directo. Nodo debe "caminar" desde `head`. |
| **Insertar/Borrar (Inicio)** | LENTO (O(n)) 🐢 | **RÁPIDO (O(1))** 🚀 | Array debe "desplazar todo". Nodo solo re-engancha `head`. |

### `ArrayList` (La Implementación con Arrays)
* **Ventaja:** Velocidad de lectura por índice.
* **Lógica `insertar`:** Requiere **"mover a la derecha"** (bucle `for` hacia atrás) para crear un hueco.
* **Lógica `remove`:** Requiere **"mover a la izquierda"** (bucle `for` hacia adelante) para tapar el hueco.

### `LinkedList` (La Implementación con Nodos) ⛓️
* **Estructura:** Cada **`Node`** guarda el dato y un puntero **`next`** al siguiente. La lista solo conoce el `head` (inicio) y el `tail` (final).
* **Lógica `addFirst`:** Es instantánea. `nuevo.next = head;` y `head = nuevo;` (Dos re-enganches).
* **Recorrido:** Se usa un puntero temporal (`actual`) con un bucle `while (actual != null)` para ir avanzando (`actual = actual.next`).

### `Set` (Conjuntos)
* **Concepto:** Colección que **garantiza unicidad** (no permite duplicados).
* **`LinkedHashSet`:** Mantiene el requisito de unicidad del `Set` y, además, **mantiene el orden de inserción**.

---

## 4. Algoritmos y Control de Flujo

### Recursividad 🔄
* Una función que se llama a sí misma para resolver un sub-problema más simple.
* **Componentes Vitales:**
    1.  **Caso Base:** La condición de salida que detiene la recursión (si no está, da `StackOverflowError`).
    2.  **Paso Recursivo:** La llamada a sí misma con el problema achicándose (ej. `indice + 1`).

### Lambdas y Streams (`->`)
* **Lambda:** Función anónima (`(param) -> { código }`) que simplifica la sintaxis.
* **`forEach(v -> ...)`:** Uso de la Interfaz Funcional `Consumer` para recorrer la lista.
* **`removeIf(v -> ...)`:** Uso de la Interfaz Funcional `Predicate` para eliminar elementos que cumplan una condición (`return true`).

### Excepciones y Propagación
* **Propagación:** Cuando un método no quiere manejar una excepción, la delega al llamador con la palabra clave **`throws`** en la firma del método.
* **`throw`:** Se usa dentro del código para **lanzar** una excepción manualmente (ej. `throw new DuracionInvalidaException(...)`). Esto corta la ejecución de inmediato.
* **`finally`:** Se ejecuta **SIEMPRE**, haya ocurrido un `try-catch` o no. Es para liberar recursos.
