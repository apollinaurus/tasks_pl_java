package vectors.task1;

/*
    Модифицировать класс из прошлой работы, оставив в нем следующие методы:
        конструктор,
        доступа к элементам вектора,
        получения размерности вектора,
        получения нормы вектора.
        Назвать получившийся класс ArrayVector.
 */
public class ArrayVector {

    private final Double[] elementData;

    public ArrayVector(Double[] elementData) {
        this.elementData = elementData;
    }

    //  доступ к элементам вектора (получения значения)
    public Double get(int index) {
        return elementData[index];
    }

    // получение «длины» вектора (количества его элементов),
    public int getSize() {
        return elementData.length;
    }

    //нахождения евклидовой нормы -> формула: (x, y) = x1×y1 + x2×y2 + … + xn×yn
    public Double euclideanNorm() {
        return Math.sqrt(scalarMult());
    }

    // нахождения скалярного произведения двух векторов.
    public Double scalarMult() {
        Double sum = 0.0;
        for (int i = 0; i < getSize(); i++) {
            sum += get(i) * get(i);
        }
        return sum;
    }

}
