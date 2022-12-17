package vectors.task0;

import vectors.Vector;
import vectors.task4.IncompatibleVectorSizesException;
import vectors.task4.VectorIndexOutOfBoundsException;

/*
    Создать класс, реализующий работу с векторами (набор вещественных чисел, координат) и базовые операции векторной арифметики. Класс должен удовлетворять следующим требованиям.
    Экземпляр должен соответствовать вектору фиксированной длины (она задается как параметр конструктора).
    Должны быть реализованы следующие методы:
        доступа к элементам вектора (получения значения и изменения значения),
        получения «длины» вектора (количества его элементов),
        поиска минимального и максимального значений из элементов вектора,
        сортировки вектора (по возрастанию или убыванию – на ваш выбор),
        нахождения евклидовой нормы,
        умножения вектора на число,
        сложения двух векторов,
        нахождения скалярного произведения двух векторов.

    В процессе выполнения задания НЕЛЬЗЯ пользоваться утилитными классами Java (кроме метода Math.sqrt()).
    Точка входа программы может быть реализована в классе, в отладочных целях, но не обязательна к написанию.
 */
public class MyVector implements Vector {

    private final Double[] elementData;

    public MyVector(Double[] elementData) {
        this.elementData = elementData;
    }

    //  доступ к элементам вектора (получения значения)
    public Double get(int index) throws VectorIndexOutOfBoundsException {
        if (index > getSize()) {
            throw new VectorIndexOutOfBoundsException("Index " + index + " out of bounds for length " + getSize());
        }
        return elementData[index];
    }

    // изменение значения
    public void change(int index, Double data) {
        elementData[index] = data;
    }

    // получение «длины» вектора (количества его элементов),
    public int getSize() {
        return elementData.length;
    }

    // поиск минимального значения из элементов вектора
    public Double getMin() {
        Double min = elementData[0];
        for (int i = 0; i < getSize(); i++) {
            if (min > elementData[i]) {
                min = elementData[i];
            }
        }
        return min;
    }

    // поиск максимального значения из элементов вектора
    public Double getMax() {
        Double max = elementData[0];
        for (int i = 0; i < getSize(); i++) {
            if (max < elementData[i]) {
                max = elementData[i];
            }
        }
        return max;
    }

    // сортировки вектора
    public void sort(Double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    double temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //нахождения евклидовой нормы -> формула: (x, y) = x1×y1 + x2×y2 + … + xn×yn
    public Double euclideanNorm() {
        return Math.sqrt(scalarMult());
    }

    // умножения вектора на число
    public Double[] mult(Double factor) {
        Double[] data = new Double[getSize()];
        for (int i = 0; i < getSize(); i++) {
            data[i] = elementData[i] * factor;
        }
        return data;
    }

    // сложения двух векторов
    public Double[] sum(MyVector inputVector) throws IncompatibleVectorSizesException {
        if (inputVector.getSize() != getSize()) {
            throw new IncompatibleVectorSizesException("");
        }
        Double[] data = new Double[getSize()];
        for (int i = 0; i < inputVector.getSize() && i < getSize(); i++) {
            data[i] += inputVector.elementData[i];
        }
        return data;
    }

    // нахождения скалярного произведения двух векторов.
    public Double scalarMult() {
        Double sum = 0.0;
        for (int i = 0; i < getSize(); i++) {
            sum += elementData[i] * elementData[i];
        }
        return sum;
    }

}
