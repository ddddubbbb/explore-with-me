# java-explore-with-me

## Этап 1. Сервис статистики
<details> <summary> ТЗ. Часть 1 </summary> 

Первый этап — реализация сервиса статистики.

На первом этапе необходимо:
1. Реализовать сервис статистики в соответствии со спецификацией:
   [ewm-stats-service.json](https://raw.githubusercontent.com/yandex-praktikum/java-explore-with-me/main/ewm-stats-service-spec.json).
2. Реализовать HTTP-клиент для работы с сервисом статистики.
3. Подготовить сборку проекта.
4. Определиться с тематикой дополнительной функциональности, которую вы будете реализовывать.

### Базовые требования
Разработка должна вестись в публичном репозитории, созданном на основе
[шаблона](https://github.com/yandex-praktikum/java-explore-with-me).

Весь код первого этапа разместите в отдельной ветке с именем `stat_svc`.

### Что будет проверяться

* Работающая сборка проекта:
    * проект компилируется без ошибок;
    * сервис статистики успешно запускается в докер-контейнере;
    * экземпляр PostgreSQL для сервиса статистики успешно запускается в докер-контейнере.
* Корректная работа сервиса статистики:
    * все эндпоинты отрабатывают в соответствии со спецификацией;
    * данные успешно сохраняются и выгружаются из базы данных;
    * реализован HTTP-клиент сервиса статистики.,
</details>  

## Этап 2. Основной сервис
<details> <summary> ТЗ. Часть 2 </summary>  

Пришло время реализации основного сервиса! Для начала просмотрите ещё раз техническое задание и изучите
[спецификацию API основного сервиса](https://raw.githubusercontent.com/yandex-praktikum/java-explore-with-me/main/ewm-main-service-spec.json).

### Базовые требования
Реализация должна вестись в отдельной ветке с именем `main_svc`. Эта ветка должна основываться на ветке `main`,
в которую слиты изменения предыдущего этапа.

### Что будет проверяться
1. Работающая сборка проекта:
  * проект компилируется без ошибок;
  * основной сервис и сервис статистики успешно запускаются в Docker-контейнерах;
  * для каждого сервиса запускается свой экземпляр PostgreSQL в Docker-контейнере.
2. Корректная работа основного сервиса:
  * все эндпоинты отрабатывают в соответствии со спецификацией;
  * данные успешно сохраняются и выгружаются из базы данных;
  * основной сервис и сервис статистики корректно взаимодействуют;
  * реализация работы с данными не производит лишней нагрузки на базу данных.
</details>