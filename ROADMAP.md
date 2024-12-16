
## Testing
Run in Command Prompt terminal, otherwise use another syntax for commands below!!!
1. Send a valid request to create a new todo:
   ```shell
    curl.exe --location "http://localhost:8888/todos" --header "Content-Type: application/json" --data "{\"title\":\"Wake up\",\"dueDate\":\"2024-12-16T11:30:00\",\"priority\":\"LOW\"}"
    ```
2. Send a valid request to update an existed todo
      ```shell
    curl.exe --request PUT --location "http://localhost:8888/todos/1" --header "Content-Type: application/json" --data "{\"title\":\"Wake up early\",\"description\":\"A lot of ....\",\"dueDate\":\"2024-12-16T10:30:00\",\"status\":\"TODO\"}"
   ```
   next update for the same row
      ```shell
    curl.exe --request PUT --location "http://localhost:8888/todos/1" --header "Content-Type: application/json" --data "{\"title\":\"Wake up early\",\"dueDate\":\"2024-12-16T10:30:00\",\"priority\":\"HIGH\",\"status\":\"IN_QA_HANDS\"}"
    ```
3. Get list of changes
    ```shell
    curl.exe --location "http://localhost:8888/todos/1/history" --header "Content-Type: application/json"
    ```
4. Detele task
    ```shell
    curl.exe --request DELETE --location "http://localhost:8888/todos/1" --header "Content-Type: application/json"
    ```
5. Not set optional Priority field 
    ```shell
    curl.exe --location "http://localhost:8888/todos" --header "Content-Type: application/json" --data "{\"title\":\"Wake up\",\"dueDate\":\"2024-12-16T11:30:00\"}"
    ```
6. Not set required dueDate field
    ```shell
    curl.exe --location "http://localhost:8888/todos" --header "Content-Type: application/json" --data "{\"title\":\"Wake up\"}"
7. Not set required title field
    ```shell
    curl.exe --location "http://localhost:8888/todos" --header "Content-Type: application/json" --data "{\"dueDate\":\"2024-12-16T11:30:00\"}"
8. Not set data at all
    ```shell
    curl.exe --location "http://localhost:8888/todos" --header "Content-Type: application/json" --data "{}"
9. Detele not existed task
    ```shell
    curl.exe --request DELETE --location "http://localhost:8888/todos/0" --header "Content-Type: application/json"
    ```
10. Send a valid request to update not existed todo
      ```shell
    curl.exe --request PUT --location "http://localhost:8888/todos/0" --header "Content-Type: application/json" --data "{\"title\":\"Wake up early\",\"description\":\"A lot of ....\",\"dueDate\":\"2024-12-16T10:30:00\",\"status\":\"TODO\"}"
11. Send a not valid request to update an existed todo
      ```shell
    curl.exe --location "http://localhost:8888/todos" --header "Content-Type: application/json" --data "{\"title\":\"Wake up\",\"dueDate\":\"2024-12-16T11:30:00\",\"priority\":\"LOW\"}"
    ```
    Do not forgot to change ID below after request above
    ```shell
    curl.exe --request PUT --location "http://localhost:8888/todos/4" --header "Content-Type: application/json" --data "{\"title\":\"Wake up early updated\",\"description\":\"\",\"dueDate\":\"2024-12-17T14:30:00\",\"status\":\"s\"}"
12. Few tasks added
       ```shell
    curl.exe --location "http://localhost:8888/todos" --header "Content-Type: application/json" --data "{\"title\":\"Task 1\",\"dueDate\":\"2024-12-16T11:30:01\",\"priority\":\"LOW\"}"
    ```
       ```shell
    curl.exe --location "http://localhost:8888/todos" --header "Content-Type: application/json" --data "{\"title\":\"Ta2\",\"dueDate\":\"2024-12-16T12:30:00\",\"priority\":\"HIGH\"}"
    ```
       ```shell
    curl.exe --location "http://localhost:8888/todos" --header "Content-Type: application/json" --data "{\"title\":\"3\",\"dueDate\":\"2024-12-16T01:30:00\",\"priority\":\"MAYBE_SOME_DAY\"}"
    ```
13. Update tasks above, do not forgot to change ID of todo
    ```shell
    curl.exe --request PUT --location "http://localhost:8888/todos/6" --header "Content-Type: application/json" --data "{\"title\":\"Changed title\",\"description\":\"...\",\"dueDate\":\"2024-12-16T10:30:00\",\"status\":\"TODO\"}"
    ```
    ```shell
    curl.exe --request PUT --location "http://localhost:8888/todos/6" --header "Content-Type: application/json" --data "{\"title\":\"Changed title\",\"description\":\"...\",\"dueDate\":\"2024-12-16T10:30:00\",\"status\":\"TODO\",\"priority\":\"LOW\"}"
    ```
       ```shell
    curl.exe --request PUT --location "http://localhost:8888/todos/7" --header "Content-Type: application/json" --data "{\"title\":\"Changed title\",\"description\":\"...\",\"dueDate\":\"2024-12-16T10:30:00\",\"status\":\"IN_QA_HANDS\"}"
    ```
    ```shell
    curl.exe --request PUT --location "http://localhost:8888/todos/8" --header "Content-Type: application/json" --data "{\"title\":\"Changed title\",\"description\":\"...\",\"dueDate\":\"2024-12-16T10:30:00\",\"status\":\"IN_QA_HANDS\",\"priority\":\"CRITICAL\"}"
    ```
14. Find oll history for one todo
    ```shell
    curl.exe --location "http://localhost:8888/todos/6/history" --header "Content-Type: application/json"
    ```
16. Task to update with wrong status
   ```shell
   curl.exe --request PUT --location "http://localhost:8888/todos/8" --header "Content-Type: application/json" --data "{\"title\":\"Task 1\",\"dueDate\":\"2024-12-16T11:30:01\",\"status\":\"LOWi\"}"
   ```
17. end

