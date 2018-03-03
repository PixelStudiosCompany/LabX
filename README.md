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
3.	Условные операторы:
1.	if (year < 2018) {  
2.	  print( "Это слишком рано.." );  
3.	} else if (year > 2018) {  
4.	  print( "Это поздновато.." );  
5.	} else {  
6.	  print( "Да, точно в этом году!" );  
7.	}  



4.	Циклы
Цикл while:
1.	while (условие) {  
2.	  // код, тело цикла  
3.	}  
       Цикл for:
1.	for (начало; условие; шаг) {  
2.	  // ... тело цикла ...  
3.	}  

1.	var i;  
2.	  
3.	for (i = 0; i < 3; i++) {  
4.	  print( i );  
5.	}  
