# Introducción a Git y GitHub: Ejercicios

Este repositorio contiene los ejercicios de un taller introductorio a **Git** y **GitHub**. El taller cubre los contenidos de la **Unidad Didáctica 1**.

Cada ejercicio que implique crear un *commit* incluye una ilustración que muestra cómo debe verse el árbol de commits del repositorio al finalizar dicho ejercicio.

> 💡 **Nota:** En las ilustraciones, el número dentro de cada commit corresponde al número del ejercicio en el que fue creado.

---

## #1 Configuración inicial

¡Configura tu nombre, correo electrónico y editor de texto!

Ejemplo de configuración:

```bash
git config --global user.name "Luis Miguel"
git config --global user.email "luismiguelfranco.prof@stemgranada.com"
```

Tras realizar la configuración, puedes ejecutar el siguiente comando para ver todos los parámetros globales establecidos:

```bash
git config --global --list
```

❓ **Pregunta**: ¿Para qué sirve establecer el parámetro `--global`? ¿Funcionaría si no lo ponemos?

--global sirve para asegurar que la configuración que hemos realizado sirve para todos los proyectos en los que trabajemos con ese ordenador. Si no lo ponemos también funcionaría y la configuración que hubieramos puesto se aplicaría solamente al proyecto específico que vayamos a realizar.


---

## #2 Primer repositorio local

Crea un nuevo repositorio en un directorio llamado `git-workshop`.

```bash
 mkdir git-workshop
 git init

```

Crea los archivos `README.md` y `Jose.txt`. Por ahora, no es necesario que contengan texto.

```bash
touch README.md Jose.txt

```

Agrega ambos archivos al *staging area* y realiza el **primer commit** del repositorio.

```bash
git add README.md Jose.txt
git commit -m "Subo archivos README.md y Jose.txt"

```

---

## #3 Correcciones básicas

¿Tu nombre no es *Jose*? Vamos a cambiar el nombre del archivo para que coincida con el tuyo.

El objetivo es **reescribir el commit anterior** para que el archivo `Jose.txt` pase a llamarse `<tu-nombre>.txt`, por ejemplo `Pablo.txt` o `Teresa.txt`.

```bash
git mv Jose.txt Carlota.txt
git commit --amend -m "Renombra Jose.txt a Carlota.txt"
```
> ✅ **Respuesta:** Al usar `git commit --amend`, se **reescribe el commit anterior**, incluyendo el cambio de nombre del archivo. Esto es exactamente lo que se solicita en el ejercicio.También se puede lograr el mismo resultado eliminando el archivo anterior (`Jose.txt`), añadiendo el nuevo (`<tu-nombre>.txt`) y realizando un nuevo commit, aunque esto generaría un commit adicional en lugar de modificar el anterior.

```bash
git rm Jose.txt
git add Carlota.txt
git commit -m "Elimina Jose.txt y agrega Carlota.txt"
```

---

## #4 Crear ramas

Crea una nueva rama llamada `yo++` y cámbiate a ella.
Mientras estés en esa rama, escribe una o dos oraciones sobre ti en el archivo `.txt` con tu nombre.

Cuando termines de redactar, agrega los cambios al *staging area* y realiza un commit.

```bash
git checkout -b yo++
nano Carlota.txt (Me llamo Carlota Reyes de Federico.
Tengo 22 años.)
git add Carlota.txt
git commit -m "Añado descripción personal en Carlota.txt"
```

Ahora regresa al primer commit del repositorio usando `git checkout master`. Crea otra rama llamada `taller-info` y cámbiate a ella.

En el archivo `README.md`, escribe una o dos oraciones sobre el taller. Agrega los cambios al *staging area* y realiza un commit.

```bash
git checkout master
git checkout -b taller-info

nano README.md (Este taller es una introducción práctica a Git y GitHub.
Aprendemos a gestionar repositorios, ramas, commits y colaboración en equipo.)

git add README.md
git commit -m "Añade descripción del taller en README.md"
```

> ℹ️ Inspecciona el estado actual del repositorio con: `git log --oneline --all --graph`. Observa que el repositorio ahora contiene tres commits: uno apuntado por `master`, otro por `taller-info` y el tercero por `yo++`.

❓ **Pregunta**: Desde la rama `taller-info`, ¿el archivo `.txt` con tu nombre tiene contenido o está vacío? ¿Por qué crees que es así?

El archivo `Carlota.txt` está vacío en la rama `taller-info`. Esto ocurre porque los cambios realizados en la rama `yo++` (donde se añadió la descripción personal) no existen en la rama `taller-info`, ya que ambas ramas se crearon a partir de commits distintos y sus historias aún no se han fusionado.

---

## #5 *Merge* fast-forward de ramas

Colócate en la rama `master` e incorpora los cambios de la rama `yo++` mediante un *merge*.

```bash
git checkout master
git merge yo++
```

---

## #6 *Merge* recursive de ramas

Permaneciendo en la rama `master`, incorpora los cambios de la rama `taller-info` mediante un *merge*.

```bash
git merge taller-info
```
> ✅ **Respuesta:** En este caso, Git realiza un **merge recursive**, ya que las ramas `master` y `taller-info` se desarrollaron en paralelo y tienen commits distintos. Git combina ambos historiales creando un **nuevo commit de fusión** que une los cambios de las dos ramas.

> Al crearse el nuevo commit de fusión la terminal abre vim para que edites el mensaje del commit. Para editarlo pulsa "i", luego "esc" y luego ":wq" y enter.

---

## #7 Aparición de conflictos al realizar *merge*

En la rama `master`, modifica la primera línea del archivo `README.md`, agrega los cambios al *staging area* y realiza un commit.

```bash
nano README.md
git add README.md
git commit -m "Modifico descripción del taller en README.md"
```

Ahora colócate en la rama `taller-info`, modifica la primera línea de `README.md` (de forma distinta a la anterior), agrega los cambios al *staging area* y realiza un commit.

```bash
git checkout taller-info
nano README.md
git add README.md
git commit -m "Modifico descripción del taller en README.md"
```

Luego, regresa a la rama `master` e incorpora los cambios de `taller-info` mediante un *merge*. Git debería reportar que ha ocurrido un **conflicto** que requiere ser resuelto manualmente.

```bash
git checkout master
git merge taller-info
```

❓ **Pregunta**: ¿Por qué ocurrió un conflicto en este caso?

> ✅ **Respuesta**: El conflicto ocurrió porque **ambas ramas modificaron la misma línea del mismo archivo (`README.md`) de manera diferente**. Git no puede decidir automáticamente qué cambio conservar, por lo que marca el archivo como en conflicto y requiere que el usuario lo edite manualmente para elegir o combinar los cambios.

---

## #8 Resolución de conflictos de *merge*

Abre en tu editor de texto el archivo con el conflicto (`README.md`). Elimina los marcadores de conflicto (`<<<<<<<`, `=======`, `>>>>>>>`) y edita el contenido según cómo quieras que quede el archivo final.

Una vez termines la edición, agrega los cambios al *staging area* y ejecuta `git merge --continue`. También puedes hacer directamente un nuevo commit con el mensaje correspondiente, como se indica a continuación:

```bash
nano README.md
git add README.md
git commit -m "Resolución del conflicto en README.md"
```

> ✅ **Respuesta:** Al resolver un conflicto, Git no puede asumir cuál versión es la correcta. Por eso marca las diferencias y deja al usuario decidir qué conservar, eliminar o combinar. Una vez el archivo se edita y se confirma con un nuevo commit, el *merge* se completa correctamente.

---

## #9 Primer repositorio de GitHub

Crea un repositorio público en **GitHub** con el nombre `<tu-nombre>-intro-git`, por ejemplo: `carlota-intro-git`.

Creamos el repositorio en GitHub, luego realizamos este comando que es para enlazar el repositorio local con el remoto: 

```bash
git remote add origin https://github.com/usuario/repo.git
```

❓ **Pregunta**: ¿Cómo o en qué es GitHub diferente a Git?

> ✅ **Respuesta**: **Git** es un sistema de control de versiones distribuido que se ejecuta localmente en tu equipo y permite gestionar el historial de cambios de un proyecto.En cambio, **GitHub** es una **plataforma en línea** que utiliza Git y ofrece herramientas para alojar repositorios, colaborar con otros usuarios, revisar código y gestionar proyectos de forma remota.

---

## #10 Sube tus cambios a GitHub

Empuja (*push*) los cambios de tu rama `master` a GitHub para que los demás también puedan ver tu repositorio.

```bash
git push origin master
```

❓ **Pregunta**: Tras realizar *push* de `master`, ¿puedes también ver en GitHub tus ramas `taller-info` y `yo++`?

> ✅ **Respuesta**: No, solo la rama `master` se sube a GitHub con el comando anterior. Las ramas `taller-info` y `yo++` permanecen solo en tu repositorio local hasta que las subas explícitamente usando:

```bash
git push origin taller-info
git push origin yo++

```
> Cada rama debe enviarse individualmente si deseas que aparezca en GitHub.