# 🧠 Resumen Teórico: Java y Estructuras de Datos

## 1. POO: Conceptos Básicos

### Clase vs. Objeto
* **Clase:** Es el plano, molde o plantilla. No existe en la memoria de ejecución (es solo definición).
* **Objeto:** Es la instancia concreta creada a partir de la clase (usando `new`). Ocupa espacio en memoria y tiene estado.

### Encapsulamiento
* Es la técnica de ocultar el estado interno del objeto para protegerlo.
* **Cómo se aplica:** Definiendo atributos como `private` y exponiéndolos mediante métodos `public` (Getters y Setters).
* **Objetivo:** Validar datos antes de asignarlos y reducir el acoplamiento.

### Sobrecarga vs. Sobreescritura
* **Sobrecarga (Overloading):** Ocurre en la **misma clase**. Es tener métodos con el mismo nombre pero **distintos parámetros** (cantidad o tipo).
* **Sobreescritura (Overriding):** Ocurre en **herencia** (subclases). Es redefinir un método del padre con la **misma firma** (mismo nombre y parámetros). Se usa `@Override`.

### Paso por Valor
* Java siempre pasa copias de los valores.
* Cuando pasas un objeto a un método, pasas una **copia de la referencia** (la dirección de memoria).
* **Consecuencia:** Si modificas los atributos del objeto adentro del método, el cambio se ve afuera (porque apuntan al mismo lugar). Si reasignas la variable (`v = new Auto()`), no afecta al original.

---

## 2. Relaciones y Abstracción

### Herencia (`extends`)
* Relación **"ES UN"**. (Ej: El Auto ES UN Vehículo).
* Permite reutilizar código y atributos de la clase padre.

### Polimorfismo
* Capacidad de un objeto de ser tratado como si fuera de su clase padre o una interfaz.
* Permite flexibilidad: guardar `Auto` y `Moto` dentro de una misma lista de tipo `Vehiculo`.

### Clase Abstracta (`abstract class`)
* Relación: **"ES UN"** (Herencia).
* Es una base incompleta. **No se puede instanciar** (no podés hacer `new`).
* Puede tener métodos con código (para reutilizar) y métodos abstractos (para obligar a implementar).
* **Regla:** Una clase solo puede heredar de **UNA** clase abstracta.

### Interfaz (`interface`)
* Relación: **"PUEDE HACER"** (Comportamiento/Habilidad).
* Es un contrato puro. Solo define **qué** se debe hacer, no **cómo**.
* No tiene atributos de estado (solo constantes).
* **Regla:** Una clase puede implementar **MÚLTIPLES** interfaces.

---

## 3. Manejo de Errores (Excepciones)

### Jerarquía
* **Error:** Fallos graves de la JVM (memoria llena, desbordamiento de pila). No se pueden recuperar.
* **Exception:** Fallos del programa que debemos gestionar.

### Bloques de Control
* **Try:** Envuelve el código que puede fallar.
* **Catch:** Captura el error para evitar que el programa se cierre inesperadamente.
* **Finally:** Se ejecuta **SIEMPRE**, haya error o no. Se usa para cerrar recursos (conexiones a BD, Scanners, archivos).

---

## 4. Estructuras de Datos (EL NÚCLEO)

### A. ArrayList (Lista Dinámica basada en Array)
* **Estructura:** Un bloque de memoria **contiguo** (elementos uno al lado del otro, como una caja de huevos).
* **Lectura `get(i)`:** **MUY RÁPIDA O(1)**. Calcula matemáticamente la posición y salta directo.
* **Insertar/Borrar (Inicio o Medio):** **LENTA O(n)**. Requiere **desplazar** todos los elementos siguientes para hacer lugar o tapar el hueco.
* **Uso:** 99% de los casos (cuando lees más de lo que modificas en el medio).

### B. LinkedList (Lista Enlazada basada en Nodos)
* **Estructura:** Nodos dispersos en memoria conectados por referencias (`next`).
* **Lectura `get(i)`:** **LENTA O(n)**. No puede saltar. Tiene que "caminar" nodo por nodo desde el inicio (`head`).
* **Insertar/Borrar (Inicio o Final):** **MUY RÁPIDA O(1)**. Solo requiere cambiar referencias (punteros). No mueve elementos.
* **Uso:** 1% de los casos (Pilas, Colas).

---

## 5. Lógica de Implementación (Cómo funcionan por dentro)

### En Lista Estática (Array)
* **Insertar en el medio:** Lógica de **"Mover a la derecha"**. Se usa un bucle hacia atrás para copiar el elemento actual en el siguiente (`i+1`) y liberar el espacio.
* **Eliminar del medio:** Lógica de **"Mover a la izquierda"**. Se usa un bucle hacia adelante para copiar el elemento siguiente (`i+1`) en el actual (`i`) y tapar el hueco.

### En Lista Enlazada (Nodos)
* **Insertar al Inicio (`addFirst`):** Lógica de **"Re-enganchar"**.
    1. El `nuevoNodo` apunta al `head` actual.
    2. La etiqueta `head` se mueve al `nuevoNodo`.
* **Recorrer:** Se usa un puntero temporal (`actual`) y un bucle `while (actual != null)` que avanza con `actual = actual.next`.

---

## 6. Funcionalidades Modernas

### Recursividad
* Una función que se llama a sí misma.
* **Componente 1 (Caso Base):** La condición de salida. Si falta, ocurre un `StackOverflowError`.
* **Componente 2 (Paso Recursivo):** La llamada a sí misma con un dato más pequeño.

### Lambdas (`->`)
* Funciones anónimas para escribir código conciso.
* **`forEach`:** Para recorrer listas.
* **`removeIf`:** Para borrar elementos que cumplan una condición.

### Equals y HashCode
* **`==`**: Compara **referencia de memoria** (¿Son el mismo objeto físico?).
* **`.equals()`**: Compara **contenido** (¿Tienen los mismos datos?). Debe ser redefinido.
* **Regla:** Si redefines `equals`, debes redefinir `hashCode` para que las colecciones (`HashSet`, `HashMap`) funcionen bien.
