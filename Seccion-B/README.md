# Sección B — Principios SOLID

- **codigo-original/**: código de las páginas 2 y 3 del taller, sin modificar (intencionalmente puede no compilar).
- **codigo-corregido/**: rediseño mínimo en seis clases Java, solo para **SRP, OCP y LSP**.

## Correcciones

1. SRP: separar `ReceiptService` de `ShoppingCart`.
2. OCP: `IvaCalculator` delega en `Product.calculateIVA()` (polimorfismo).
3. LSP: `getWeight()` solo en `PhysicalProduct`, nunca en `DigitalProduct`.

Para compilar la carpeta corregida: `cd Seccion-B/codigo-corregido && javac *.java`.

Se conserva el enfoque de ejemplos de las diapositivas de Diseño de Software ESPOL.
