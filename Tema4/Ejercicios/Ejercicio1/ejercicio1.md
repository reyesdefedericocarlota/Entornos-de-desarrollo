## Ejercicio 1. Mejora de legibilidad en código JavaScript

A continuación se presentan dos fragmentos de código JavaScript funcionales, pero escritos con una calidad baja o muy baja. Ambos programas funcionan correctamente, pero resultan difíciles de leer, entender y mantener.

El objetivo de este ejercicio es **mejorar la legibilidad del código** aplicando los conocimientos vistos durante el primer trimestre y reforzados en esta unidad.

### 1.1. Indicaciones generales

- No cambies el comportamiento del programa.
- No añadas nueva funcionalidad.
- Mejora los nombres de variables y funciones.
- Aplica una convención de nomenclatura coherente.
- Ordena el código si es necesario.
- Elimina ambigüedades y mejora la claridad general.
- No añadas comentarios innecesarios para explicar lo obvio.

### 1.2. Código A

```javascript
function f(a, b, c) {
  let r = 0;
  if (a > 0) {
    if (b > 0) {
      r = a + b;
    } else {
      r = a - c;
    }
  } else {
    if (c > 0) {
      r = b + c;
    } else {
      r = 0;
    }
  }
  return r;
}
```

Este código realiza una serie de comprobaciones y devuelve un valor numérico en función de los parámetros recibidos.

### 1.3. Código B

```javascript
function calc(x, y) {
  let t = 0;
  for (let i = 0; i < x.length; i++) {
    if (x[i] > y) {
      t = t + x[i];
    }
  }
  return t;
}
```

Este código recorre un array de números y realiza un cálculo acumulativo bajo una condición determinada.

### 1.4. Instrucciones

1. Reescribe cada uno de los fragmentos de código mejorando su legibilidad.
2. Asegúrate de que el código sigue funcionando exactamente igual que el original.
3. Aplica nombres descriptivos que permitan entender qué hace el código sin necesidad de analizar su lógica interna.
4. Utiliza una convención de nomenclatura coherente y adecuada a JavaScript.
5. Comprueba que el código resultante es fácil de leer y mantener.

Este ejercicio no busca una única solución correcta. Se valorará especialmente la claridad, la coherencia y la aplicación consciente de los principios de clean code.
