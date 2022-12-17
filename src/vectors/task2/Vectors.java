package vectors.task2;

import vectors.Vector;
import vectors.task4.VectorIndexOutOfBoundsException;

/*
    Создать отдельный класс Vectors, содержащий статические методы работы с векторами:
        умножения вектора на скаляр,
        сложения двух векторов,
        нахождения скалярного произведения двух векторов.
 */
public class Vectors {

    private final Vector vector;

    public Vectors(Vector vector) {
        this.vector = vector;
    }

    // умножение вектора на скаляр
    public void scalarProduct(int m) throws VectorIndexOutOfBoundsException {
        for (int i = 0; i < vector.getSize(); i++) {
            vector.change(i, vector.get(i) * m);
        }
    }

    // сложение двух векторов
    public void sum(Vector inputVector) throws VectorIndexOutOfBoundsException {
        for (int i = 0; i < inputVector.getSize() && i < vector.getSize(); i++) {
            vector.change(i, vector.get(i) + inputVector.get(i));
        }
    }

    // скалярное произведение двух векторов
    public Double scalarMult(Vector inputVector) throws VectorIndexOutOfBoundsException {
        Double data = 0.0;
        for (int i = 0; i < inputVector.getSize() && i < vector.getSize(); i++) {
            data += vector.get(i) * inputVector.get(i);
        }
        return data;
    }

}
