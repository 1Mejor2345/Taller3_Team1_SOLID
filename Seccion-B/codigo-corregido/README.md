# ESPOL - Taller SOLID, Seccion B

Solución guiada por las clases del profesor (diapositivas de SRP 15-17, OCP 20-23, LSP 25-30, ISP 32-37 y DIP 39-41). Enunciado: 03TallerSOLID-1.3, páginas 2-3.

## Violaciones
- **SRP**: ShoppingCart enviaba recibos y administraba el carrito.
- **OCP**: IvaCalculator usaba un switch por cada categoría.
- **LSP**: DigitalProduct arrojaba UnsupportedOperationException en getWeight.
- **ISP**: mejora complementaria, separando el peso en la interfaz Weighable.
- **DIP**: no es una violación inequívoca en el original; la solución introduce abstracciones de envío y política tributaria.

## Rediseño
- ShoppingCart administra los productos y el subtotal.
- ReceiptFormatter construye el texto, ReceiptService coordina y ReceiptSender abstrae el envío.
- TaxPolicy modela el impuesto; PercentageTaxPolicy lo implementa sin usar switch.
- Product contiene atributos comunes, PhysicalProduct implementa Weighable y DigitalProduct no declara getWeight.

## Cómo compilar

```bash
javac *.java
java Main
java -ea PruebasSOLID
```

Salida esperada: subtotal $570.00, IVA $79.80, total $649.80.
Las tasas 0%, 12% y 15% se reproducen solo como ejemplo del taller, no como tasas vigentes.

El correo se simula en consola. A diferencia del código original, esta carpeta contiene un programa compilable.
