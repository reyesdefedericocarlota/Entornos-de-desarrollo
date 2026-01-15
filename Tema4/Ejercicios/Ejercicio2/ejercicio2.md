## Ejercicio 2. Mejora de legibilidad y documentación de código JavaScript

En este ejercicio continuarás trabajando sobre código JavaScript funcional, pero con un doble objetivo. Por un lado, deberás mejorar la legibilidad del código aplicando buenas prácticas de nomenclatura y estructura. Por otro, deberás documentar el código utilizando JSDoc cuando el comportamiento de las funciones sea lo suficientemente claro.

Este ejercicio enlaza directamente con el anterior: primero se entiende el código, luego se mejora su forma y, finalmente, se documenta.

### 2.1. Indicaciones generales

- No cambies el comportamiento del programa.
- No añadas nueva funcionalidad.
- Mejora los nombres de funciones y variables si es necesario.
- Aplica una convención de nomenclatura coherente y adecuada a JavaScript.
- Documenta únicamente cuando entiendas bien qué hace el código.
- Utiliza JSDoc para documentar funciones.
- No añadas comentarios explicativos dentro del cuerpo de las funciones.

### 2.2. Código A

```javascript
function g(a, b) {
  let r = [];
  for (let i = 0; i < a.length; i++) {
    if (a[i] > b) {
      r.push(a[i]);
    }
  }
  return r;
}
```

Este código recibe una colección de valores y devuelve un nuevo conjunto de datos en función de una condición.

### 2.3. Código B

```javascript
function h(x) {
  let t = 0;
  for (let i = 0; i < x.length; i++) {
    t = t + x[i];
  }
  return t / x.length;
}
```

Este código realiza un cálculo sobre una lista de números y devuelve un resultado numérico.

### 2.4. Código C

```javascript
function k(a, b, c) {
  if (a === b || a === c || b === c) {
    return false;
  }
  if (a > b && a > c) {
    return a;
  }
  if (b > a && b > c) {
    return b;
  }
  return c;
}
```

Este código compara varios valores y devuelve un resultado en función de una serie de condiciones.

### 2.5. Instrucciones

1. Reescribe cada uno de los fragmentos de código mejorando su legibilidad.
2. Cambia los nombres de funciones y variables para que reflejen claramente su propósito.
3. Aplica una estructura clara y coherente al código.
4. Añade documentación JSDoc a las funciones una vez hayas comprendido su comportamiento.
5. Asegúrate de que el código final es fácil de leer, entender y mantener.

Este ejercicio refuerza la idea de que un buen código no solo funciona, sino que también se entiende y puede ser utilizado por otros desarrolladores sin necesidad de analizar su implementación interna.
