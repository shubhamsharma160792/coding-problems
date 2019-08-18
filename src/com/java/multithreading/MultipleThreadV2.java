package com.java.multithreading;
class MultiThreadV3 extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getId());
    }
}

class MultiThreadV4 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
    }

}

class MultipleThreadV2{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread obj = new Thread(new MultiThreadV3());
            obj.start();
        }
        System.out.println("Runnable");
        for (int i = 0; i < 10; i++) {
            Thread obj = new Thread(new MultiThreadV4());
            obj.start();
        }
    }
}