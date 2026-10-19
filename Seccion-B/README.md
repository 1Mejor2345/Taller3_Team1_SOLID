# Sección B — Principios SOLID

## Violaciones y solución

- **SRP:** `ShoppingCart` administra productos y envía recibos. Son motivos de cambio distintos: modificar el correo no debería afectar al carrito. Se mueve `sendReceipt()` a `ReceiptService`; el carrito conserva los productos y su total.
- **OCP:** el `switch` de `IvaCalculator` obliga a modificarlo al agregar otra regla de IVA. Ahora delega en `Product.calculateIVA()` y cada subtipo implementa el cálculo. Una regla nueva puede agregarse con otra subclase sin cambiar el calculador.
- **LSP:** `DigitalProduct.getWeight()` lanza una excepción donde se esperaba un peso. Se deja en `Product` lo común y se mueve el peso a `PhysicalProduct`. Así, los dos tipos pueden usarse como `Product` sin exigirles una operación incompatible.

## Qué hace la solución

`Product` reúne nombre, precio y el cálculo abstracto del IVA. `PhysicalProduct` agrega peso y una tasa; `DigitalProduct` no tiene peso y devuelve IVA cero, igual que el caso digital del original, que no entra en ningún `case`.

Las tasas del taller se conservan al construir productos físicos: libro `0`, ropa `0.12` y tecnología `0.15`. `IvaCalculator` delega el cálculo, `ShoppingCart` agrega, elimina y suma precios, y `ReceiptService` contiene el envío ilustrativo. El total suma precios; el IVA se calcula aparte.

También se añadieron las importaciones, la inicialización de la lista, el constructor y la suma del carrito.

## Enfoque del profesor

Se sigue la separación de responsabilidades de `Employee` (diapositivas 16–17), el cálculo por polimorfismo de las figuras (22–23) y la sustitución sin tratar casos especiales en el cliente (25–30). Para el peso se ajusta la jerarquía: un producto digital no tiene peso físico. No se necesitan patrones adicionales.

## Compilación

Desde la raíz del repositorio:

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -encoding UTF-8 -Xlint:all -d build Seccion-B/codigo-corregido/*.java
```

Las seis clases corregidas compilan sin errores ni advertencias con JDK 25. También se comprobaron los totales, la eliminación, el IVA y un nuevo subtipo. No hay `main`; es un ejemplo de rediseño.

El original se conserva para comparar. Tiene tres errores de compilación: falta importar `List` y hay dos usos de `price` sin declarar. Además, la lista, el constructor y el total están incompletos; estos son problemas de funcionamiento.

Compila las carpetas por separado: ambas tienen clases con los mismos nombres y sin paquetes. Si el IDE incluye las dos como fuentes, puede marcar clases duplicadas.
