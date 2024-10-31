# QA-java-diplom-3
для запуска мозилы: -Dbrowser=firefox
(версия указана в ручную , если у ывас другая подставьте свою )
отчет allure:  mvn clean test, чтобы сгенерировать отчёт.
команда allure serve target/surefire-reports/
запуск яндекс:( исользовать терменал idea Command prompt ) mvn clean test -Dbrowser=yandex -Ddriver.version=126.0.6478.182 -Dwebdriver.yandex.bin=C:\Users\HUAWEI\AppData\Local\Yandex\YandexBrowser\Application\browser.exe
bin указать к файлу вашего локального пути к браузеру 