package ru.gb.pugacheva.lesson2j2;

public class MyArrayDataException extends RuntimeException{
    int index1;
    int index2;

    public MyArrayDataException(int index1, int index2) {
        super("Элемент массива с индексом " + index1 + " " + index2 + " невозможно преобразовать в число.");
        this.index1 = index1;
        this.index2 = index2;
    }
}
