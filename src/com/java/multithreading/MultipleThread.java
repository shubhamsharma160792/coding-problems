package com.java.multithreading;

class MultiThread extends Thread {
    public void run() {
        try {
            System.out.printf("ThreadId:" + Thread.currentThread().getId());
            System.out.println();

        }
        catch (Exception e) {
            System.out.println("Exception occured");
        }
    }
}

class MultiThreadV2 implements Runnable {

    @Override
    public void run() {
        try {
            System.out.printf("ThreadId:" + Thread.currentThread().getId());
            System.out.println();

        }
        catch (Exception e) {
            System.out.println("Exception occured");
        }
    }
}
public class MultipleThread extends Thread {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread object = new Thread(new MultiThread());
            object.start();
        }
        System.out.println("Runnable:");
        for (int i = 0; i < 10; i++) {
            Thread object = new Thread(new MultiThreadV2());
            object.start();
        }
    }
}
