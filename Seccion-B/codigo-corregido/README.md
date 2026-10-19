# Sección B — Código corregido (mínimo)

Solo se corrigen las tres violaciones principales identificadas:

- **SRP:** el método `sendReceipt()` sale de `ShoppingCart` y pasa a `ReceiptService`.
- **OCP:** el cálculo de IVA se delega polimórficamente a `Product.calculateIVA()`, sin `switch` en `IvaCalculator`. Los productos físicos admiten una tasa al construirse (por ejemplo 0, 0.12 o 0.15).
- **LSP:** `Product` contiene solo los atributos comunes; el peso pertenece a `PhysicalProduct`. `DigitalProduct` ya no hereda ni lanza una excepción en `getWeight()`.

La estructura replica la idea mostrada en las diapositivas del profesor: separar clases por responsabilidad, y hacer que cada subtipo implemente su cálculo.

## Compilación

```bash
javac *.java
```

El envío por correo es un ejemplo con comentario pendiente, como en el enunciado. No hay `Main` ni clases de prueba porque no son necesarias para mostrar las correcciones.
