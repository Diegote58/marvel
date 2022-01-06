# Marvel Project

Rest api that makes two services available, one allows obtaining information from the characters comics collaborators: Iron Man and Captain America; the other service provides us with the heroes with whom they have interacted in each comic.
In addition to these 2 services, there is a scheduled process every 20 minutes that synchronizes collaborators and heroes from the marvel database with our database.

## Requeriments
- Java 8
- PostgresSQL (14)


## Database (Postgres)
1. Crear base de datos con el nombre "marvel".
2. You can find the configuration of DB on application.properties to change name or credentials
3. run application.

## To run code
1. Download repository on your workspace
2. run ./assemble.sh
3. run ./avengers.sh 


1. GET collaborators by character
http://localhost:80/marvel/collaborators/ironman
http://localhost:80/marvel/collaborators/capamerica

2. GET characters and comics by Character
http://localhost:80/marvel/characters/ironman
http://localhost:80/marvel/characters/capamerica

3. You can change {localhost:80} to {test.spring.mx}
    - add test.albo.mx in etc/hosts
    - 127.0.0.1 test.albo.mx

## JAR
1. You can find your JAR at {projectPath}/target

