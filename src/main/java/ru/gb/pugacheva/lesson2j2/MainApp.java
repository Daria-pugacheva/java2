package ru.gb.pugacheva.lesson2j2;

public class MainApp {
    public static void main(String[] args) {
        String[][] array = new String[4][4];  //создаем массив нужной величины.
        for (int i = 0; i < array.length; i++) { // заполняем массив элементами, которые преобразуются с число
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "5";
                //System.out.print(array[i][j]);  // отсмотреть массив при желании можно
            }
            //System.out.println(); // отсмотреть массив при желании можно
        }
        array[1][2] = "q"; // меняем один элемент массива на непреобразуемый в число элемент

        try {
            System.out.println("Сумма элементов массива равна " + makeStringNumberAndSum(array));
        } catch (MyArraySizeException e) {   // если с массивом не задалось, то уже дальне нечего ловить
            e.printStackTrace();
        } catch (MyArrayDataException e) { // если с массивом все хорошо, то ловим дальше исключения
            e.printStackTrace();
        }
    }


    public static int makeStringNumberAndSum(String[][] arr) {
        if (arr.length != 4 || arr[0].length != 4 || arr[1].length != 4 || arr[2].length != 4 ||
                arr[3].length != 4) {
            throw new MyArraySizeException("Неверный размер массива. Необходимо задать массив размером 4х4.");
        }
        int[][] numberArr = new int[arr.length][arr.length]; //ввела новый интовый массив, куда класть преобразованный
                                                            //Одинаково задаю оба значения в скобках, т.к.
                                                             //массив 4х4. Затрудняюсь, как указывать, если
                                                            // массив будет неровный, например 4х5 ?
        int numberArraySum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    numberArr[i][j] = Integer.parseInt(arr[i][j]);
                    numberArraySum += numberArr[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return numberArraySum;
    }
}