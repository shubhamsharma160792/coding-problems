package com.java.design;

public class DuckSimulator {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.setFlyBehavior(new NoFly());
        duck.performFly();
        duck.setFlyBehavior(new FlyWithWings());
        duck.performFly();

    }

}
