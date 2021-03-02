package ru.gb.pugacheva.lesson5j2;

public class MainApp {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void countArray1() {         // первый простой метод, который просто пересчитывает массив
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1; // массив у нас float, а я внаглую тут не заморачиваюсь ставить f после
        }               // единички, уповая на автоматическое приведение. Это нехорошо? Теряем время?
                        // или наоборот, если есть шанс на автоприведение типов, лучше код сокращать?
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 5));
        } // этот код из задания. Джава ворчит, что тут в дробях нефлоатовские данные. Но они же
        //все равно преобразуются во float, т.к. массив у нас float + еще тут откастовали. Собственно,
        // это замечание-вопрос в продолжение вопроса по строке 11 (выше).
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void countArray2() {   // второй метод, дробит на части
        float[] arr0 = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[SIZE - HALF];

        for (int i = 0; i < arr0.length; i++) {
            arr0[i] = 1;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(arr0, 0, arr1, 0, HALF);
        System.arraycopy(arr0, HALF, arr2, 0, SIZE - HALF);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 5));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 5));
            }
        }); // тут вроде никакие sleep никому не нужны. А в принципе оно зачем? На лекции sleep помогал
        // наглядно увидеть, как работают разные потоки. Но вряд ли его придумали ради студентов :)
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr0, 0, arr1.length);
        System.arraycopy(arr2, 0, arr0, HALF, arr2.length);

        System.out.println(System.currentTimeMillis() - a);
    }

    public static void main(String[] args) {  // вызов методов
        countArray1();
        countArray2();
    }

}

