To run script which creates database and set privileges execute commands below:
    Once load mysql:
        docker pull mysql:latest
        Install Database Navigator plugin and connects to mysql: root pass, DB see in command below, user:root. Pay attention to port, it needs to set as in command below, or use your own.
When starts to work:
    If didn't remove container in previous session. remove it now
        docker stop mysql_hometask5
        docker rm mysql_hometask5
docker run -d --name mysql_hometask5 -e MYSQL_ROOT_PASSWORD=11111 -e MYSQL_DATABASE=db -e MYSQL_USER=userok -e MYSQL_PASSWORD=passwordok -p 3308:3306 mysql:latest
Just a check, execution is optional:
    docker ps --filter name=mysql_hometask5 --format "table {{.Names}}\t{{.Status}}"
Copy in a docker container and execute file which creates the database and table inside + sets privileges.
    docker cp .\db_init.sql mysql_hometask5:/db_init.sql
    cmd
    docker exec -i mysql_hometask5 mysql -u root -p11111 < db_init.sql
When you finished work or before each session if didn't do it in previous:
    docker stop mysql_hometask5
    docker rm mysql_hometask5

Liquibase, command below need to run each time after docker container was up(commands above).
To run database changeset in Maven console run `mvn clean package` or setup `mvn` util for terminal, maybe need just set Environmental variables.
Liquibase config see in `liquibase.properties` file in resources.
`mvn clean package` will start execute list of changes in db/changelog/db.changelog-master.yaml, 

For rollbacks
    mvn liquibase:rollback -Dliquibase.propertyFile=src/main/resources/liquibase.properties -Dliquibase.rollbackCount=2
    mvn liquibase:update -Dliquibase.propertyFile=src/main/resources/liquibase.properties
    mvn liquibase:rollback -Dliquibase.propertyFile=src/main/resources/liquibase.properties -Dliquibase.rollbackDate=2024-12-14T01:24:00
    mvn liquibase:update -Dliquibase.propertyFile=src/main/resources/liquibase.properties


