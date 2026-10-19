# Sección B — Carrito de compras y principios SOLID

- **codigo-original/**: transcripción de los ejemplos de las páginas 2 y 3; sus errores se mantienen, por lo que no se espera que compile.
- **codigo-corregido/**: versión funcional en Java con el rediseño SOLID, main y pruebas.

## Principios
- SRP: enviar recibos queda en ReceiptService.
- OCP: IvaCalculator usa TaxPolicy y elimina el switch.
- LSP: DigitalProduct deja de redefinir getWeight para lanzar una excepción.
- ISP: capacidad Weighable solo para productos con peso.
- DIP: las dependencias de envío e impuestos se expresan mediante abstracciones.

## Ejecución

```bash
cd Seccion-B/codigo-corregido
javac *.java
java Main
java -ea PruebasSOLID
```

Los porcentajes de impuestos se utilizan únicamente como parte del ejemplo académico.
