![drawing](img/LabX.png | width=50%)

# LabX
Проект LabX создан для того, чтобы сделать обучение физике максимально интересным. Пользуясь данным продуктом, пользователь не только сможет детально разобрать базовые законы кинематики и динамики, но и научиться программировать. Среда обладает удобным пользовательским интерфейсом, что также способствует качественному обучению. 
 
 
![LabX](img/labe2.png)

# Программирование в среде LabX

Решение физических задач и описание физических процессов в среде LabX, реализуется на языке JavaScript.

Основные функции языка JavaScript:
<H3> 1.	Печать в консоль: </H3>
<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">print<span style="color: #009900;">&#40;</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li></ol></pre>
<H3>2.	Создание переменных:</H3>
<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> a <span style="color: #339933;">=</span> <span style="color: #3366CC;">&quot;text&quot;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> b <span style="color: #339933;">=</span> <span style="color: #CC0000;">10</span><span style="color: #339933;">;</span>  </div></li></ol></pre>
<em>На имя переменной в JavaScript наложены всего два ограничения.
Имя может состоять из: букв, цифр, символов $ и _
Первый символ не должен быть цифрой.
Так как JavaScript является слабо типизированным языком программирования, при создании переменных не нужно указывать их тип. Достаточно просто присвоить значение.</em>
<h3>3.	Условные операторы:</h3>
<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">if</span> <span style="color: #009900;">&#40;</span>year <span style="color: #339933;">&lt;</span> <span style="color: #CC0000;">2018</span><span style="color: #009900;">&#41;</span> <span style="color: #009900;">&#123;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">    print<span style="color: #009900;">&#40;</span> <span style="color: #3366CC;">&quot;Это слишком рано..&quot;</span> <span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #009900;">&#125;</span> <span style="color: #000066; font-weight: bold;">else</span> <span style="color: #000066; font-weight: bold;">if</span> <span style="color: #009900;">&#40;</span>year <span style="color: #339933;">&gt;</span> <span style="color: #CC0000;">2018</span><span style="color: #009900;">&#41;</span> <span style="color: #009900;">&#123;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">    print<span style="color: #009900;">&#40;</span> <span style="color: #3366CC;">&quot;Это поздновато..&quot;</span> <span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: bold; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #009900;">&#125;</span> <span style="color: #000066; font-weight: bold;">else</span> <span style="color: #009900;">&#123;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">    print<span style="color: #009900;">&#40;</span> <span style="color: #3366CC;">&quot;Да, точно в этом году!&quot;</span> <span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #009900;">&#125;</span>  </div></li></ol></pre> 



<h3>4.	Циклы</h3>
<em>Цикл while:</em>
<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">while <span style="color: #009900;">&#40;</span>условие<span style="color: #009900;">&#41;</span> <span style="color: #009900;">&#123;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">  <span style="color: #006600; font-style: italic;">// код, тело цикла  </span></div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #009900;">&#125;</span>  </div></li></ol></pre>
<em>Цикл for:</em>
<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">for</span> <span style="color: #009900;">&#40;</span>начало<span style="color: #339933;">;</span> условие<span style="color: #339933;">;</span> шаг<span style="color: #009900;">&#41;</span> <span style="color: #009900;">&#123;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">  <span style="color: #006600; font-style: italic;">// ... тело цикла ...  </span></div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #009900;">&#125;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">&nbsp;</div></li></ol></pre>

<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> i<span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">&nbsp;</div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">for</span> <span style="color: #009900;">&#40;</span>i <span style="color: #339933;">=</span> <span style="color: #CC0000;">0</span><span style="color: #339933;">;</span> i <span style="color: #339933;">&lt;</span> <span style="color: #CC0000;">3</span><span style="color: #339933;">;</span> i<span style="color: #339933;">++</span><span style="color: #009900;">&#41;</span> <span style="color: #009900;">&#123;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">  print<span style="color: #009900;">&#40;</span> i <span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: bold; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #009900;">&#125;</span>  </div></li></ol></pre>

Код проектов LabX исполняется в цикле.
<em>(соответственно если вызвать метод print(); в основном теле программы, текст будет печататься в консоль непрерывно)</em>

Для того чтобы задать константы для проекта или напечатать текст один раз в начале выполнения проекта,  в LabX предусмотрен специальный тип комментариев:

<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #339933;">/</span># </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">print<span style="color: #009900;">&#40;</span><span style="color: #3366CC;">&quot;Начало выполнения программы&quot;</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">#<span style="color: #339933;">/</span> </div></li></ol></pre>

<h3>Служебные константы и объекты системы LabX</h3>
<H4>1. Служебный объект Running:</H4>
Отвечает за цикл симуляции физики.
<em>Функции и методы:</em>
<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">Running.<span style="color: #000066; font-weight: bold;">set</span><span style="color: #009900;">&#40;</span><span style="color: #003366; font-weight: bold;">false</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li></ol></pre>
Завершает симуляцию физики.
<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">Running.<span style="color: #000066; font-weight: bold;">get</span><span style="color: #009900;">&#40;</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li></ol></pre>
Возвращает состояние цикла симуляции.
<H4>2.	Служебная переменная TIME</H4>
В данной переменной хранится текущее время (в секундах) с начала работы программы.

# Создание физических объектов

В языке программирования LabX предусмотрена возможность создания специальных шарообразных объектов, со следующими атрибутами:
<ul>
 <li>масса</li>
 <li>координаты</li>
 <li>проекции скорости и ускорения на оси координат</li>
 <li>цвет</li>
</ul>

Соответственно:
<ul>
<li><em>m</em> - масса объекта</li>
<li><em>x</em> - координата x объекта</li>
<li><em>y</em> - координата y объекта</li>
<li><em>vx</em> - проекция скорости объекта на ось x</li>
<li><em>vy</em> - проекция скорости объекта на ось y</li>
<li><em>ax</em> - проекция ускорения на ось x</li>
<li><em>ay</em> - проекция ускорения на ось y</li>
</ul>
<em>Таблица воможных цветов объекта:</em>
<table>
 <tr>
  <td><b>Название</b></td>
  <td><b>Расшифровка</b></td>
  <td><b>Цвет</b></td>
  </tr>
  <tr>
    <td>“black”</td>
   <td>Черный</td>
   <td>
    <img src="img/black.png"/>
   </td>
  </tr>
  <tr>
    <td>“blue”</td>
   <td>Синий</td>
   <td>
    <img src="img/blue.png"/>
   </td>
  </tr>
  <tr>
    <td>“cyank”</td>
   <td>Циан 
(сине-зелёный)
</td>
   <td>
    <img src="img/cyan.png"/>
   </td>
  </tr>
  <tr>
    <td>“black”</td>
   <td>Черный</td>
   <td>
    <img src="img/black.png"/>
   </td>
  </tr>
  <tr>
    <td>“darkgray”</td>
   <td>Тёмно-серый</td>
   <td>
    <img src="img/darkgray.png"/>
   </td>
  </tr>
  <tr>
    <td>“gray”</td>
   <td>Серый</td>
   <td>
    <img src="img/gray.png"/>
   </td>
  </tr>
  <tr>
    <td>“lightgray”</td>
   <td>Светло-серый</td>
   <td>
    <img src="img/lightgray.png"/>
   </td>
  </tr>
 <tr>
    <td>“green”</td>
   <td>Зелёный</td>
   <td>
    <img src="img/green.png"/>
   </td>
  </tr>
  <tr>
    <td>“magenta”</td>
   <td>Маджента
(малиновый)
</td>
   <td>
    <img src="img/magenta.png"/>
   </td>
  </tr>
 <tr>
    <td>“orange”</td>
   <td>Оранжевый</td>
   <td>
    <img src="img/orange.png"/>
   </td>
  </tr>
  <tr>
    <td>“pink”</td>
   <td>Розовый</td>
   <td>
    <img src="img/pink.png"/>
   </td>
  </tr>
 <tr>
    <td>“red”</td>
   <td>Красный</td>
   <td>
    <img src="img/red.png"/>
   </td>
  </tr>
  <tr>
    <td>“yellow”</td>
   <td>Жёлтый</td>
   <td>
    <img src="img/yellow.png"/>
   </td>
  </tr>
</table>

Пример создания объекта красного цвета, c массой 5 кг, находящийся в координатах (200,300), с проекциями скорости на оси координат (10, 10) и проекциями ускорения (2, 2).

<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> ob1 <span style="color: #339933;">:</span> object<span style="color: #009900;">&#40;</span><span style="color: #CC0000;">5</span><span style="color: #339933;">,</span><span style="color: #CC0000;">200</span><span style="color: #339933;">,</span><span style="color: #CC0000;">300</span><span style="color: #339933;">,</span><span style="color: #CC0000;">10</span><span style="color: #339933;">,</span><span style="color: #CC0000;">10</span><span style="color: #339933;">,</span><span style="color: #CC0000;">2</span><span style="color: #339933;">,</span><span style="color: #CC0000;">2</span><span style="color: #339933;">,</span>”red”<span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span> </div></li></ol></pre>

Обращение к атрибутам созданных физических объектов:

<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">ob1.<span style="color: #660066;">x</span><span style="color: #339933;">=</span><span style="color: #CC0000;">100</span><span style="color: #339933;">;</span>  </div></li></ol></pre>

# Процедуры создания физических сил

Физические силы – это силы, действующие на созданные учеником объекты. Они приводят объект в движение, придают ему скорость.
После нажатия кнопки “Запуск“ все объекты, на которые действуют силы, приводятся в движение.
На один объект одновременно может действовать несколько сил.

Структура создания силы выглядит следующим образом:
<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> <span style="color: #339933;">&lt;</span>название силы<span style="color: #339933;">&gt;</span> <span style="color: #339933;">:</span> force<span style="color: #009900;">&#40;</span>fx<span style="color: #339933;">,</span>fy<span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li></ol></pre>

Для того чтобы определить силу для объекта, нужно воспользоваться следующей процедурой:

<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> <span style="color: #339933;">&lt;</span>название силы<span style="color: #339933;">&gt;</span> <span style="color: #339933;">:</span> force<span style="color: #009900;">&#40;</span>fx<span style="color: #339933;">,</span>fy<span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li></ol></pre>

Пример создания физической силы:

<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> f <span style="color: #339933;">:</span> force<span style="color: #009900;">&#40;</span><span style="color: #CC0000;">20</span><span style="color: #339933;">,</span><span style="color: #CC0000;">40</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li></ol></pre>

Обращение к атрибутам созданных физических сил:

<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">f.<span style="color: #660066;">fx</span><span style="color: #339933;">=</span><span style="color: #CC0000;">10</span><span style="color: #339933;">;</span></div></li></ol></pre>

# Методические указания

Здесь будут представлены основные способы применения LabX на уроках в школах. Также здесь будут приведены примеры программ и упражнений, которые можно использовать на уроках.
На уроках физики LabX предлагается использовать во время изучения Механики и Динамики. Объекты и силы позволяют демонстрировать характер движения тел.
Рекомендуется применять LabX в решении задач на нахождение равнодействующей нескольким силам. А также для оценки пройденного телом расстояния.

# Решение задач

1.	На горизонтальной крышке стола лежит учебник массой m = 1 кг. В некоторый момент на него начинает действовать сила F, модуль которой равен 2 Н. В результате учебник начинает двигаться поступательно. Определите ускорение учебника, если коэффициент трения μ, между ним и поверхностью стола равен 0,3?

<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #339933;">/</span>#   </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">print<span style="color: #009900;">&#40;</span><span style="color: #3366CC;">&quot;Ускорение тела:&quot;</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">print<span style="color: #009900;">&#40;</span>a.<span style="color: #660066;">ax</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">#<span style="color: #339933;">/</span>  </div></li><li style="font-weight: bold; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> a <span style="color: #339933;">:</span> object<span style="color: #009900;">&#40;</span><span style="color: #CC0000;">1</span><span style="color: #339933;">,</span><span style="color: #CC0000;">100</span><span style="color: #339933;">,</span><span style="color: #CC0000;">100</span><span style="color: #339933;">,</span><span style="color: #CC0000;">0</span><span style="color: #339933;">,</span><span style="color: #CC0000;">0</span><span style="color: #339933;">,</span><span style="color: #CC0000;">0</span><span style="color: #339933;">,</span><span style="color: #CC0000;">0</span><span style="color: #339933;">,</span><span style="color: #3366CC;">&quot;orange&quot;</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> f <span style="color: #339933;">:</span> force<span style="color: #009900;">&#40;</span><span style="color: #CC0000;">4</span><span style="color: #339933;">,</span><span style="color: #CC0000;">0</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> f2 <span style="color: #339933;">:</span> force<span style="color: #009900;">&#40;</span><span style="color: #339933;">-</span><span style="color: #CC0000;">2.94</span><span style="color: #339933;">,</span><span style="color: #CC0000;">0</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">setforce<span style="color: #009900;">&#40;</span>a<span style="color: #339933;">,</span>f<span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">setforce<span style="color: #009900;">&#40;</span>a<span style="color: #339933;">,</span>f2<span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li></ol></pre>

![LabX](img/labe4png.png)

Ответ: ускорение a = 1.06 m/c2

2.	Человек массой 70 кг стоит на напольных пружинных весах в лифте. Лифт начинает двигаться с ускорением 0,5 м/с2, направленным вниз. В этот момент весы покажут массу.
(Источник: МИОО: Тренировочная работа по физике 16.05.2014 вариант ФИ90702.)
 
1) 70 кг
2) больше 70 кг
3) меньше 70 кг
4) 0

<b>Решение.</b>
Движущийся с ускорением лифт — неинерциальная система отсчёта, следовательно, на человека в лифте помимо силы тяжести будет действовать сила инерции, направленная противоположно ускорению лифта, то есть вверх, значит, весы покажут массу менее 70 кг.

Правильный ответ указан под номером 3.

<b>Решение задачи на LabX:</b>

<pre class="javascript" style="font-family:monospace;"><ol><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #339933;">/</span>#  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">print<span style="color: #009900;">&#40;</span><span style="color: #3366CC;">&quot;Масса человека:&quot;</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">print<span style="color: #009900;">&#40;</span>a.<span style="color: #660066;">ay</span><span style="color: #339933;">*</span>a.<span style="color: #660066;">m</span><span style="color: #339933;">/</span><span style="color: #CC0000;">10</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">#<span style="color: #339933;">/</span>  </div></li><li style="font-weight: bold; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> a <span style="color: #339933;">:</span> object<span style="color: #009900;">&#40;</span><span style="color: #CC0000;">700</span><span style="color: #339933;">,</span><span style="color: #CC0000;">100</span><span style="color: #339933;">,</span><span style="color: #CC0000;">100</span><span style="color: #339933;">,</span><span style="color: #CC0000;">0</span><span style="color: #339933;">,</span><span style="color: #CC0000;">0</span><span style="color: #339933;">,</span><span style="color: #CC0000;">0</span><span style="color: #339933;">,</span><span style="color: #CC0000;">0</span><span style="color: #339933;">,</span><span style="color: #3366CC;">&quot;red&quot;</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> f <span style="color: #339933;">:</span> force<span style="color: #009900;">&#40;</span><span style="color: #CC0000;">0</span><span style="color: #339933;">,</span><span style="color: #CC0000;">665</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;"><span style="color: #000066; font-weight: bold;">var</span> f2 <span style="color: #339933;">:</span> force<span style="color: #009900;">&#40;</span><span style="color: #CC0000;">0</span><span style="color: #339933;">,-</span><span style="color: #CC0000;">35</span><span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">setforce<span style="color: #009900;">&#40;</span>a<span style="color: #339933;">,</span>f<span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span>  </div></li><li style="font-weight: normal; vertical-align:top;"><div style="font: normal normal 1em/1.2em monospace; margin:0; padding:0; background:none; vertical-align:top;">setforce<span style="color: #009900;">&#40;</span>a<span style="color: #339933;">,</span>f2<span style="color: #009900;">&#41;</span><span style="color: #339933;">;</span> </div></li></ol></pre>


![LabX](img/labe5.png)

