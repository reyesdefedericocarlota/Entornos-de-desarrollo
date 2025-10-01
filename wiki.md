# Git y GitHub
## **¿Qué es Git?**
Git es un sistema de control de versiones distribuido. Esto significa que cada persona que trabaja con Git tiene una copia completa del repositorio, con todo su historial.

  👉 Sirve para: 
  - Guardar el progreso de un proyecto.
  - Colaborar en equipo sin sobrescribir el trabajo de otros.
  - Volver a versiones anteriores si algo falla.

## **Configuración inicial**
Antes de empezar, hay que configurar nuestro nombre y correo (para identificar los commits que hagamos):
```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tuemail@example.com"
```
- `--global` significa que la configuración aplica a todos tus repositorios.

## **Creación y clonación de repositorios
- Si quieres empezar un proyecto desde cero: 
  ```bash
  git init 
  ```
  👉 Esto crea una carpeta oculta .git donde Git guardará todo el historial.

- Si ya existe un repositorio en internet (por ejemplo, en GitHub):
  ```bash
  git clone URL
  ```
  👉 Descargas el proyecto completo con todo su historial.

## **Estado y seguimieto de archivos**
Cuando modificas archivos, Git los puede ver en 3 estados:
1. Untracked → archivos nuevos que Git aún no sigue.

2. Staged → archivos listos para hacer commit.

3. Committed → ya guardados en el historial.

Comandos útiles:
  ```bash
  git status   # Muestra en qué estado están tus archivos
git add archivo   # Añade un archivo al área de preparación (staging)
git add .         # Añade todos los archivos modificados
  ```
  ## **Guardar cambios con commits**
  Un commit es como una foto del proyecto en un momento dado.
  ```bash
  git commit -m "Descripción de lo que hiciste"
  ```
  👉 Ejemplo:
  `git commit -m "Corrige bug en login"`
  
  Si ya habías añadido antes los archivos al staging y solo quieres hacer todo en un paso:
   ```bash
  git commit -am "Mensaje"
  ```
  ⚠️ Esto solo funciona con archivos que Git ya seguía.

## **Ramas (branches)**
Las ramas permiten trabajar en líneas de desarrollo independientes.

- Ver ramas:
  
 ```bash
  git branch
  ```
- Crear una nueva rama: 
  
 ```bash
  git branch nueva-rama
  ```

- Cambiar de rama
  
 ```bash
 git checkout nueva-rama
  ``` 

- Crear y cambiar de una sola vez:
  
 ```bash
git checkout -b nueva-rama
  ``` 

- Fusionar (merge):
  
 ```bash
git merge nombre-rama
  ``` 
👉 Esto une los cambios de otra rama a la actual.

- Eliminar rama:

 ```bash
git branch -d nombre-rama
  ``` 

## **Repositorios remotos**

- Conectar un repositorio local a uno remoto:

 ```bash
git remote add origin URL
  ``` 

- Subir cambios:

 ```bash
git push origin main
  ``` 

- Descargar cambios de otros:

 ```bash
git pull origin main
  ``` 

`pul` = `fetch + merge` (trae los cambios y los integra).

- Solo descargar (sin integrar todavía):
 ```bash
git fetch
  ``` 

## **Deshacer cambios**
A veces nos equivocamos y necesitamos volver atrás:

- Descartar cambios en un archivo:

```bash
git checkout -- archivo
````
- Quitar un archivo del staging (sin borrarlo):

```bash
git reset archivo
```
- Deshacer el último commit, pero mantener los cambios en archivos:
  
```bash
  git reset --soft HEAD~1
````
- Deshacer el último commit y también los cambios:

```bash
  git reset --hard HEAD~1
````
⚠️ ¡Cuidado! El `--hard` borra los cambios sin posibilidad de recuperarlos fácilmente.

- Revertir un commit específico (crea un nuevo commit que lo cancela):

```bash
git revert ID_COMMIT
````
## **Consultar historial**

- Ver todos los commits:
```bash
git log
````
- Ver historial resumido y gráfico:
```bash
  git log --oneline --graph
```
- Ver qué cambió en los archivos:
```bash
git diff          # Cambios no añadidos
git diff --staged # Cambios ya en staging
````

# **Guardar cambios temporales (stash)**
Cuando tienes cambios sin terminar pero necesitas cambiar de rama o actualizar:
```bash
git stash         # Guarda tus cambios de forma temporal
git stash list    # Muestra la lista de stashes
git stash pop     # Recupera los cambios guardados
git stash drop    # Borra el stash
````
# **Flujo de trabajo típico**
1. Clonar el proyecto:
```bash
git clone URL
````
2. Traer los últimos cambios:
```bash
git pull
````
3. Trabajar en una rama:
```bash
git checkout -b mi-rama
````
4. Guardar cambios:
```bash
git add .
git commit -m "Implementa nueva funcionalidad"
````
5. Subir los cambios
```bash
git push origin mi-rama
````
6. Hacer un pull request en GitHub (para que revisen y fusionen tu código).


  