# Sección B — Código corregido (mínimo)

Se corrigen las tres violaciones principales identificadas:

- **SRP:** el método `sendReceipt()` sale de `ShoppingCart` y pasa a `ReceiptService`.
- **OCP:** el cálculo de IVA se delega polimórficamente a `Product.calculateIVA()`, sin `switch` en `IvaCalculator`. Los productos físicos admiten una tasa al construirse (por ejemplo 0, 0.12 o 0.15).
- **LSP:** `Product` contiene solo los atributos comunes; el peso pertenece a `PhysicalProduct`. `DigitalProduct` ya no hereda ni lanza una excepción en `getWeight()`.
 