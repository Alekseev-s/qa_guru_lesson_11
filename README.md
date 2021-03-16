# Проект с UI автотестами для сайта arenadata.tech
## Стек используемых технологий:
* Java
* Selenide
* Junit5
* Allure
* Jenkins
* Selenoid
* Integration with telegram
## Запуск тестов:
Запуск тестов можно выполнять как локально, так и в Jenkins.
При запуске используются параметры (опционально):
* -Dbrowser=
* -Dvideo.storage=
* -Dweb.remote.driver=
## Пример используемых технологий:
**Запуск тестов в Jenkins**

![](https://raw.githubusercontent.com/Alekseev-s/qa_guru_lesson_11/master/src/test/resources/screenshots/jenkins.png)


**Построение Allure report**

![](https://raw.githubusercontent.com/Alekseev-s/qa_guru_lesson_11/master/src/test/resources/screenshots/allure.png)


**Для каждого теста добавлены вложения (last screenshot, page source, console log, video)**

![](https://raw.githubusercontent.com/Alekseev-s/qa_guru_lesson_11/master/src/test/resources/screenshots/attachments.png)



**Выполнение отдельного теста в Selenoid**

![](https://raw.githubusercontent.com/Alekseev-s/qa_guru_lesson_11/master/src/test/resources/screenshots/Selenoid.gif)



**Уведомление в telegram о результатах прохождения тестов**

![](https://raw.githubusercontent.com/Alekseev-s/qa_guru_lesson_11/master/src/test/resources/screenshots/tg.png)
