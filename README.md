# Визуализатор работы алгоритмов сортировки

Репозиторий летней практики 2024 бригады №15:

1) Гаранин Роман Андреевич 2300
2) Бочкарева Евгения Романовна 2384
3) Володченко Матвей Валентинович 2384

## Спецификации

### 1. Постановка задачи
Разработка программы на языке Java для визуализации работы алгоритмов сортировки.

#### 1. Bubble-Sort
1. Начинаем сравнивать соседние элементы массива. Если элемент слева больше элемента справа, меняем их местами.
2. Повторяем этот процесс для каждой пары соседних элементов по всему массиву. При этом самый большой элемент "всплывает" на последнее место.
3. Повторяем эти шаги для всех элементов массива, и каждый раз самый большой элемент "всплывает" на своё место.
4. Повторяем процесс до тех пор, пока все элементы не будут отсортированы по возрастанию.

#### 2. Insertion-Sort
1. Начинаем считать, что первый элемент массива уже отсортирован. В оставшейся части массива берем первый неотсортированный элемент и вставляем его в нужную позицию в отсортированной части.
2. Сравниваем взятый элемент со всеми элементами в отсортированной части, двигаясь от конца отсортированной части к началу. Если встречаем элемент, который больше взятого, сдвигаем его вправо, чтобы освободить место для вставки.
3. Повторяем шаг 2 для всех неотсортированных элементов массива, пока весь массив не будет отсортирован.

#### 3. Merge-Sort
1. Разделение: Исходный массив разделяется на две примерно равные части, путем нахождения среднего элемента.
2. Рекурсивное слияние: Каждая из получившихся подмассивов сортируется отдельно с помощью рекурсивного вызова merge sort.
3. Слияние: Отсортированные подмассивы сливаются в один отсортированный массив. При слиянии элементы каждого подмассива сравниваются попарно и перемещаются в соответствующем порядке в результирующий массив.

### 2. Описание специфики визуализации алгоритмов сортировки
1. Множество элементов, которые попарно можно сравнить, с результатами <,>,=, может быть отсортировано.
2. Визуализатор будет подсвечивать элементы, с которыми алгоритм взаимодействует на каждом ходу: разные цвета, что бы показать, какие элементы были просмотрены алгоритмом, а какие, в итоге, перемещены.
3. Через верхнюю панель можно открыть файл в формате: <br />
      n <br />
      [1] <br />
      ... <br />
      [n] <br />
      Где n - размер массива, а [*] - элементы. <br />
      Сам файл ссостоит из n+1 строки соответственно.
4. Над массивами будет рисоваться график относительной "высоты\велечины":![изображение](https://github.com/googgom/VisualSort/assets/41430895/cc9878fd-ca1a-42f0-92f0-849b0163a3d4)
5. Под массивами будет написано: ДО\ПОСЛЕ и номер итерации.
6. Ходы можно продвигать вперёд или начать визуализацию сначала через интерфейс на верхней панели![изображение](https://github.com/googgom/VisualSort/assets/41430895/597cd90a-35aa-49de-bbda-c313aac4c1b5)




### 3. Техническое задание к разрабатываемой программе
Пользователь может указать файл, содержащий: количество элементов, последовательность самих элементов, разделённых символом переноса строки(Enter-'\n').

### 4. Распределение ролей
Гаранин Роман - один из встроенных алгоритмов - сортировка вставками, отчёт.

Бочкарева Евгения - один из встроенных алгоритмов - сортировка пузырьком, своя чать отчёта, связь интерфейса и алгоритмов.

Володченко Матвей - один из встроенных алгоритмов - сортировка слиянием, своя чать отчёта, разработка интерфейса.
