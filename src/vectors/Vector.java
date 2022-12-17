package vectors;

import vectors.task4.VectorIndexOutOfBoundsException;

/*
    Описать интерфейс Vector взаимодействия с векторами, имеющий методы,
    соответствующие общей функциональности двух созданных классов векторов.
    Сделать так, чтобы оба класса реализовывали этот интерфейс.
 */
public interface Vector {
    int getSize();

    Double get(int i) throws VectorIndexOutOfBoundsException;

    void change(int index, Double data);
}
