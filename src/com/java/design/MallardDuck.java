package com.java.design;

public class MallardDuck extends Duck {

    public FlyBehavior   flyBehavior;
    public QuackBehavior quackBehavior;

    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a mallard duck");
    }

}
