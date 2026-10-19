package oop.inheritance;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    public String name;
    public double energy;
    public String breed;

    public Animal(String name, double energy) {
        this.name = name;
        this.energy = energy;
    }

    public void eat() {
        energy += Math.exp(-energy);
    }

    public void makeNoise() {
        System.out.println("Make some noise");
    }

}
class Dog extends Animal {
    public String breed;

    public Dog(String name, double energy) {
        super(name, energy);
    }

    public Dog (String name, double energy, String breed) {
        super(name, energy);
        this.breed = breed;
    }

    @Override
    public void makeNoise() {
        System.out.println("haf");
    }
}
class Cat extends Animal {
    public Cat(String name, double energy) {
        super(name, energy);
    }

    @Override
    public void makeNoise() {
        System.out.println("Meow");
    }
}
class Pig extends Animal {
    int mudLevel;

    public Pig(String name, double energy) {
        super(name, energy);
    }

    void playInMud() {
        mudLevel += 10;
        mudLevel = Math.min(mudLevel, 100);
    }
    @Override
    public void makeNoise() {
        System.out.println("Oink");
    }

}

class Main {
    public static void main(String[] args) {
        Animal c = new Cat();
        c.eat();
        c.name = "Betsy";
        c.makeNoise();

        Animal d = new Dog();
        d.name = "Arnold";
        d.breed = "Zlatý retriever";
        d.eat();
        d.makeNoise();



        List<Animal> animals = new ArrayList<>();
        animals.add(c);
        animals.add(d);

        DataImport di = new DataImport("data/animals.txt");

    }
}
