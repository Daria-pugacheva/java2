package ru.gb.pugacheva.lesson3j3;

import java.lang.reflect.Array;
import java.util.*;

// Вариант кода для случая, когда нет разных строк справочника, где была бы одинаковая фамилия, но
// разные телефоны. Предполагаем, что в случае, если фамилия одинаковая, то просто для этой фамилии
// добавляется очередной телефонный номер.

public class PhoneDirectory extends HashMap { // создан класс Телефонный справочник
    String surname;
    List<String> phoneNumber;
    String phoneNumber1;


    public Object add (String surname, List<String> phoneNumber) { //В HashMap метод, добавляющий эл-ты в
        return super.put(surname, phoneNumber);                     //коллекцию, называется put , а у нас
    }                                                               //должен называться add, поэтому взято
                                                        // тело метода put и применяем его для метода add

    public Object add (String surname, String phoneNumber1) {  // Сделана перегрузка метода add, чтобы можно
        return super.put(surname, phoneNumber1);                // было добавлять не только коллекцию, но и
    }                                                           //просто строку, если номер телефона один.


    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Petrov", Arrays.asList("100-10-10", "200-20-20")); // по одной фамилии
        // прописано два варианта телефонного номера. Это не совсем, конечно, реализация идеи про однофамильцев,
        // но ведь и несколько одинаковых ключей задавать нельзя... А сделать номера телефонов ключами тоже никак,
        // т.к.поиск надо осуществлять по фамилии (т.е. фамилии должны быть ключами однозначно)
        phoneDirectory.add("Ivanov","300-30-30");
        phoneDirectory.add("Lupin","400-40-40");

        System.out.println(phoneDirectory);

        System.out.println("Телефон абонента Petrov: " + phoneDirectory.getOrDefault("Petrov",
                "Абонент с такой фамилией не обнаружен"));

    }

}
