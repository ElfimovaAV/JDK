package ru.gb.seminar3.HomeWork.task3;

public class Main {
    public static void main(String[] args) {

        String[] stringArray1 = new String[]{"Husbаnd", "Wife", "Family"};
        String[] stringArray2 = new String[]{"Husbаnd", "Wife", "Happy"};
        String[] stringArray3 = new String[]{"Husbаnd", "Wife"};

        Integer[] integerArray1 = new Integer[]{1, 2, 3, 4, 5};
        Integer[] integerArray2 = new Integer[]{5, 6, 7, 8, 9};
        Integer[] integerArray3 = new Integer[]{1, 2, 3, 4};

        Compare compare = new Compare();

        System.out.println(compare.compareArrays(stringArray1, stringArray2));
        System.out.println(compare.compareArrays(stringArray1, stringArray3));
        System.out.println(compare.compareArrays(stringArray1, integerArray1));
        System.out.println();
        System.out.println(compare.compareArrays(integerArray1, integerArray2));
        System.out.println(compare.compareArrays(integerArray1, integerArray3));
        System.out.println(compare.compareArrays(integerArray1, stringArray3));
    }
}
