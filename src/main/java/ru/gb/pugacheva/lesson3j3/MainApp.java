package ru.gb.pugacheva.lesson3j3;

import java.util.*;

// задание 1 : создать массив со словами, вывести список этих слов без дублей, вывести инфо, сколько раз
// слова встречаются в массиве

public class MainApp {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("Dog", "Cat", "Apple", "Juice", "Dog", "Dog",
                "Cat", "Cat", "Cat", "Apple", "Apple", "Apple", "Apple", "Rain", "Rain"));
        Set<String> uniqueWords = new HashSet<>(words);
        System.out.println("Список уникальных слов, из которых состоит массив words: " + uniqueWords);
        for (String o : uniqueWords) {
            int quantityWord = 0;
            for (int i = 0; i < words.size(); i++) {
                if (o.equals(words.get(i))) {
                    quantityWord += 1;
                }
            }
            System.out.println(o + " встречается в ArrayList word " + quantityWord + " раз.");
        }
    }
}
