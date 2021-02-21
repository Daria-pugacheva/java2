package ru.gb.pugacheva.lesson3j3;

import java.util.ArrayList;

// Вариант кода, когда в справочнике могут быть одинаковые фамилии в разных строках справочника, и каждой
// повторяющейся фамилии соответствует свой номер телефона. И надо вывести номера телефонов всех
// однофамильцев, если такое случается.
// С точки зрения поиска в большом телефонном справочнике, вариант так себе из-за скорости...

public class Phones {
    private ArrayList<String> surnames = new ArrayList<>();   //поля private, значит, есть гарантия, что в эти
    private ArrayList<String> phoneNumbers = new ArrayList<>(); // коллекции по отдельности никто ничего не
                                                                // добавит.


    public void add(String surname, String phoneNumber) {
        surnames.add(surname);                      // поскольку добавление происходит одновременно, индексы
        phoneNumbers.add(phoneNumber);              // фамилии и телефона с двух коллекциях будут совпадать.
    }

    public void get(String surname) {
        for (int i = 0; i < surnames.size(); i++) {
            if (surnames.get(i).equals(surname)) {
                System.out.println("Телефон абонента " + surname + " : " + phoneNumbers.get(i));
            }
        }
        System.out.println("В справочнике нет иных телефонных номеров абонента " + surname);
    }

    public static void main(String[] args) {
        Phones phones = new Phones();
        phones.add("Петров", "100-10-10");
        phones.add("Иванов", "200-20-20");
        phones.add("Сидоров", "300-30-30");
        phones.add("Петров", "400-40-40");

        phones.get("Петров");


    }

}
