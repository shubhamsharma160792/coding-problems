package com.java.array.rotation;

public class KRotationInArray {

    private void leftRotation(int[] array, int rotation) {
        int length = array.length;
        if (rotation > length) {
            rotation = rotation % length;
        }
        for (int i = rotation; i < rotation + length; i++) {
            System.out.print(array[i % length] + " ");
        }
    }

    private void rightRotation(int[] array, int rotation) {
        int length = array.length;
        if (rotation > length) {
            rotation = rotation % length;
        }
        rotation = length - rotation;
        for (int i = rotation; i < rotation + length; i++) {
            System.out.print(array[i % length] + " ");
        }
    }

    public static void main(String[] args) {
        KRotationInArray obj = new KRotationInArray();
        int[] array = { 1, 3, 5, 7, 9 };
        obj.leftRotation(array, 14);
        System.out.println();
        obj.rightRotation(array, 14);
    }


}
