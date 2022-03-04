Para construir la imagen:
docker build -t monolito .

Para ejecutar la imagen:
docker run -p 8080:8080 -e "PROFILE=local o prd" -t monolito