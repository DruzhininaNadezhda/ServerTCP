Приложение, демонстрирующее взаимодействие клиента и сервера при помощи 
передачи строкового сообщения от клиента к серверу.
Приложение состоит из двух частей:
• Сервер. Сервер ожидает строковое сообщение от клиента. При получении сообщения
фиксирует время приёма, печатает время, сообщение и адрес клиента на экран и
отправляет время приёма клиенту.
• Клиент. Запрашивает у пользователя строку, после чего отправляет её на сервер. Адрес
сервера задаётся через параметр командной строки. После отправки строки клиент
получает от сервера время приёма сообщения, печатает его и завершает работу.
Протокол TCP/IP