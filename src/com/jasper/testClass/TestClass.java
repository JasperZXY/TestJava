package com.jasper.testClass;

public class TestClass {
    public static void main(String[] args) {
        // 测试 isAssignableFrom
        System.out.println("===isAssignableFrom===");
        System.out.println("Dog.class.isAssignableFrom(Animal.class) " + Dog.class.isAssignableFrom(Animal.class));   // false
        System.out.println("Dog.class.isAssignableFrom(Dog.class) " + Dog.class.isAssignableFrom(Dog.class));      // true
        System.out.println("Dog.class.isAssignableFrom(BigDog.class) " + Dog.class.isAssignableFrom(BigDog.class));   // true
        System.out.println("Dog.class.isAssignableFrom(Cat.class) " + Dog.class.isAssignableFrom(Cat.class));      // false
        System.out.println("Animal.class.isAssignableFrom(Dog.class) " + Animal.class.isAssignableFrom(Dog.class));   // true

        // isInstance
        System.out.println("===isInstance===");
        Dog dog = new Dog();
        System.out.println("Dog.class.isInstance(dog) " + Dog.class.isInstance(dog));       // true
        System.out.println("Animal.class.isInstance(dog) " + Animal.class.isInstance(dog)); // true
        System.out.println("BigDog.class.isInstance(dog) " + BigDog.class.isInstance(dog)); // false
    }


    static class Animal {
    }

    static class Dog extends Animal {
    }

    static class BigDog extends Dog {
    }

    static class Cat extends Animal {
    }
}
