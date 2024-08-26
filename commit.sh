#!/bin/bash

# Paso 1: Agregar todos los cambios al área de staging
git add .

# Paso 2: Solicitar al usuario que elija el nivel de importancia del commit
echo "Selecciona el nivel de importancia del commit:"
echo "1. LOW"
echo "2. MEDIUM"
echo "3. HIGH"
read input

case $input in
    1)
      level="LOW"
      ;;
    2)
      level="MEDIUM"
      ;;
    3)
      level="HIGH"
      ;;
    *)
      echo "Opción no válida. Abortando commit."
      exit 1
      ;;
esac

# Paso 3: Solicitar al usuario que escriba el mensaje de commit
echo "Escribe el mensaje de commit:"
read message

# Paso 4: Realizar el commit con la etiqueta y mensaje proporcionados
git commit -m "[$level] $message"
git push
# Paso 5: Preguntar al usuario si desea hacer push de los cambios
#echo "¿Deseas hacer push de los cambios? (s/n)"
#read push_answer

#if [ "$push_answer" = "s" ] || [ "$push_answer" = "S" ]; then
#    git push
#    echo "Cambios subidos con éxito."
#else
#    echo "Commit realizado. No se ha hecho push."
#fi
