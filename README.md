<h1>Проект с UI автотестами для сайта arenadata.tech</h1>
<h2>Стек используемых технологий:</h2>
<ul>
    <li>Java</li>
    <li>Selenide</li>
    <li>Junit5</li>
    <li>Allure</li>
    <li>Jenkins</li>
    <li>Selenoid</li>
    <li>Integration with telegram</li>
</ul>
<h2>Запуск тестов:</h2>
Запуск тестов можно выполнять как локально, так и в Jenkins.
При запуске используются параметры (опционально):
<ul>
    <li>-Dbrowser=</li>
    <li>-Dvideo.storage=</li>
    <li>-Dweb.remote.driver=</li>
</ul>
<h2>Пример используемых технологий:</h2>
Запуск тестов в Jenkins

![](https://raw.githubusercontent.com/Alekseev-s/qa_guru_lesson_11/master/src/test/resources/screenshots/jenkins.png)


Построение Allure report

![](https://raw.githubusercontent.com/Alekseev-s/qa_guru_lesson_11/master/src/test/resources/screenshots/allure.png)


Для каждого теста добавлены вложения (last screenshot, page source, console log, video)

![](https://raw.githubusercontent.com/Alekseev-s/qa_guru_lesson_11/master/src/test/resources/screenshots/attachments.png)



Выполнение отдельного теста в Selenoid

![](https://raw.githubusercontent.com/Alekseev-s/qa_guru_lesson_11/master/src/test/resources/screenshots/Selenoid.gif)



Уведомление в telegram о результатах прохождения тестов

![](https://raw.githubusercontent.com/Alekseev-s/qa_guru_lesson_11/master/src/test/resources/screenshots/tg.png)
