# survey
survey system

Survey: REST методы и инструкция по разворачиванию

Стандарт на методы API	2
Методы API для работы с Survey	2
Получить список опросов                                                                                                                 2
Получить один опрос по ID опроса	3
Создать опрос	3
Удалить опрос	4
Обновить опрос	4
Методы API для работы с Answer	4
Создать ответ	4
Инструкция по разворачиванию    5


СТАНДАРТ НА МЕТОДЫ API:
Список	
Экземпляр объекта	
Детализация объекта (список)	
Создание объекта	
Удаление объекта	
Изменение объекта	
Добавление детализации объекта	
Удаление детализации объекта	
Изменение детализации объекта	
Вызов метода объекта	


МЕТОДЫ API ДЛЯ РАБОТЫ С Survey
    1. Список
GET /survey/list
    request:
      
    response:
    [
       { 
        "id": 123,
        "name": "text...",
        "creationDate": "yyyy-MM-dd HH:mm:ss",
        "finishDate": "yyyy-MM-dd HH:mm:ss",
        "description": "description"
       },
       { 
        "id": 124,
        "name": "text...",
        "creationDate": "yyyy-MM-dd HH:mm:ss",
        "finishDate": "yyyy-MM-dd HH:mm:ss",
        "description": "description"
       }
    ]

    2. Экземпляр объекта
GET /survey/{id}

response:
       { 
        "id": 123,
        "name": "text...",
        "creationDate": "yyyy-MM-dd HH:mm:ss",
        "finishDate": "yyyy-MM-dd HH:mm:ss",
        "description": "description"
       }


    3. Создание объекта
POST /survey/create
request:
       { 
        "id": 123,
        "name": "text...",
        "creationDate": "yyyy-MM-dd HH:mm:ss",
        "finishDate": "yyyy-MM-dd HH:mm:ss",
        "description": "description"
       }
response: status 200

    4. Удаление объекта
DELETE /survey/{id}/delete

response: status 200

    5. Изменение объекта
PUT /survey/{id}/update
request:
       { 
        "id": 123,
        "name": "text...",
        "creationDate": "yyyy-MM-dd HH:mm:ss",
        "finishDate": "yyyy-MM-dd HH:mm:ss",
        "description": "description"
       }
response: status 200

Методы API для работы с Answer
    1. Создание объекта
       POST /answer/create
       request:
       { 
       "id": 123,
       "text": "text...",
       }
       response: status 200

 Инструкция по разорачиванию:
 Запуск локально: Запускаем приложение в IDE или собираем .jar, помещаем его в папку с сервером и запускаем сервер, открыть в браузере localhost на порту 8184 (прописан в настройках проекта)

Запуск через Docker: Устанавливаем Docker, Устанавливаем JVM , Собираем jar-архив, запускаем (всё это прописываем в Dockerfile ), docker build ... , docker run -p 8184:8184 …, или Собираем образы и запускаем контейнеры на удалённом сервере.


