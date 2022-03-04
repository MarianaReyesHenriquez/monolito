Práctica 5 - Incluir todo lo necesario para subir el proyecto a K8s

Para construir la imagen:
docker build -t monolito .

Para ejecutar la imagen:
docker run -p 8080:8080 -e "PROFILE=local o prd" -t monolito
