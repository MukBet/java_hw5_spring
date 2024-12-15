# Проверяем и удаляем существующий контейнер
if (docker ps -a --filter "name=mysql_hometask5" --format "{{.Names}}" | Select-String "mysql_hometask5") {
    Write-Host "Stopping and removing existing container..."
    docker stop mysql_hometask5 | Out-Null
    docker rm mysql_hometask5 | Out-Null
}

# Создаем новый контейнер
Write-Host "Starting a new MySQL container..."
docker run -d --name mysql_hometask5 `
    -e MYSQL_ROOT_PASSWORD=11111 `
    -e MYSQL_DATABASE=db `
    -e MYSQL_USER=userok `
    -e MYSQL_PASSWORD=passwordok `
    -p 3308:3306 mysql:latest

# Ждем, пока контейнер инициализируется
Write-Host "Waiting for MySQL container to initialize..."
Start-Sleep -Seconds 3

# Проверяем статус контейнера
Write-Host "Checking container status..."
docker ps --filter "name=mysql_hometask5" --format "table {{.Names}}\t{{.Status}}"

# Копируем SQL файл в контейнер
Write-Host "Copying db_init.sql into the container..."
docker cp .\db_init.sql mysql_hometask5:/db_init.sql
Write-Host "Waiting for MySQL container to initialize..."
Start-Sleep -Seconds 3

# Выполняем SQL файл
Write-Host "Executing SQL script inside the container..."
cmd /c "docker exec -i mysql_hometask5 mysql -u root -p11111<.\db_init.sql"

