# Ejercicio 3 — Análisis

**Integrantes:** Miguel Angel Montenegro Sepulveda y Sephiroth Leonardo Mota Arismendi

## a) ¿Cuál es la limitación de Singleton frente a DIP, y cómo se resuelve?

El problema es que las clases que necesitan el Singleton terminan llamando directamente a `ConsecutivoFactura.getInstancia()` adentro de su propio código, entonces quedan acopladas a esa clase concreta y no a una abstracción (una interfaz), que es lo que pide DIP. Se resuelve pasándole la instancia ya creada por el constructor o por parámetro (inyección de dependencias), en vez de que cada clase la vaya a buscar por su cuenta.

## b) ¿En cuántos lugares del proyecto debe aparecer getInstancia()? ¿Cuáles?

Debería aparecer en un solo lugar: donde se "arma" o se inyecta la aplicación (por ejemplo en el `main` o en la clase que configura todo al inicio). No debe llamarse `getInstancia()` regado en varias clases distintas del sistema.

## c) Singleton y Builder usan los dos un constructor privado. ¿Para qué sirve en cada uno?

**Singleton:** sirve para que nadie por fuera pueda hacer `new ConsecutivoFactura()`, así se garantiza que exista una sola instancia en todo el programa.

**Builder:** sirve para que nadie pueda crear una `Compra` directamente (sin pasar por el Builder), así se obliga a que siempre pase por las validaciones antes de quedar creada.

## d) De estas clases de su proyecto, ¿cuál llevaría Builder y cuál no?

- **Asiento(fila, numero):** no necesita Builder, son solo dos datos obligatorios y no hay nada opcional que combinar.
- **Funcion:** sí podría llevar Builder, porque tiene varios datos (película, sala, horario, precio) y algunos podrían ser opcionales.
- **Combo:** no, normalmente tiene pocos atributos y no cambia mucho de una compra a otra.
- **Cliente:** no es obligatorio, solo tendría sentido si maneja muchos datos opcionales (teléfono, correo, etc.); si son pocos datos, un constructor normal alcanza.

## e) ConfiguracionCine es Singleton y el Builder de Compra necesita el IVA que ella guarda. ¿El Builder debe llamar a ConfiguracionCine.getInstancia() por dentro? ¿Por qué?

No debería llamarlo directamente por dentro, porque ahí se cae en el mismo problema del punto a): el Builder queda pegado a esa clase concreta. Es mejor que el IVA se lo pasen al Builder desde afuera (como parámetro, por ejemplo `conIva(double iva)`), así el Builder no depende de cómo esté hecha la configuración por dentro.