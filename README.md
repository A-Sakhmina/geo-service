# Сервис отправки локализованных сообщений

В классе Main, создается тестовая отправка сообщения в консоль

## Задание.[Тестирование сервиса отправки сообщений](https://github.com/netology-code/jd-homeworks/blob/master/mocks/task1/README.md)
Код на тесты по [ссылке ](https://github.com/A-Sakhmina/netology_javacore_mocks_geo-service/tree/master/src/test/java/ru/netology/sender)



### Задача
Написать тесты для класса `MessageSenderImpl`.
### Что нужно сделать
* Написать тесты для проверки языка отправляемого сообщения (класс MessageSender) с использованием Mockito:
  1. Поверить, что MessageSenderImpl всегда отправляет только русский текст, если ip относится к российскому сегменту адресов.
  2. Поверить, что MessageSenderImpl всегда отправляет только английский текст, если ip относится к американскому сегменту адресов.
* Написать тесты для проверки определения локации по ip (класс GeoServiceImpl)
  1.Проверить работу метода public Location byIp(String ip)
* Написать тесты для проверки возвращаемого текста (класс LocalizationServiceImpl)
  1. Проверить работу метода public String locale(Country country)
