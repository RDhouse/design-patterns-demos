package com.rdhouse.creational.abstractfactory.practice;

import java.util.Scanner;

import com.rdhouse.Demo;

public class AbstractFactoryPracticeDemo implements Demo {

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What kind of brand of car would you like? Options: Opel / VW");
        String line = scanner.nextLine();
        AbstractCarFactory factory = null;
        switch (line) {
            case "Opel": 
                factory = AbstractCarFactory.getFactory(Menufactorer.OPEL);
                break;
            
            case "VW": 
                factory = AbstractCarFactory.getFactory(Menufactorer.VW);
                break;
            
        }
        System.out.println(String.format("Producing %s Car..", line));

        Engine engine = factory.fabricatEngine();
        Body body = factory.fabricateBody();
        Wheels wheels = factory.fabricatWheels();

        System.out.println(String.format("Engine: %s, Body: %s, Wheels: %s", engine, body, wheels));
        scanner.close();
    }

}

// the abstract factory
abstract class AbstractCarFactory {

    private static final OpelCarFactory OPEL_CAR_FACTORY = new OpelCarFactory();
    private static final VWCarFactory VW_CAR_FACTORY = new VWCarFactory();

    abstract Engine fabricatEngine();
    abstract Body fabricateBody();
    abstract Wheels fabricatWheels();

    public static AbstractCarFactory getFactory(Menufactorer menufactorer) {
        AbstractCarFactory factory = null;
        switch(menufactorer) {
            case OPEL :
                factory = OPEL_CAR_FACTORY;
            case VW :
                factory = VW_CAR_FACTORY;
        }
        return factory;
    }
}

// the product abstractions the factory produces
abstract class Engine {}
abstract class Body {}
abstract class Wheels {}

// Enum representing the manufactorers
enum Menufactorer {
    OPEL,
    VW,
}

// concrete impls of products
class OpelEngine extends Engine {
    @Override
    public String toString() {
        return "Opel Engine";
    }
}
class VWEngine extends Engine {
    @Override
    public String toString() {
        return "VW Engine";
    }
}

class OpelBody extends Body {
    @Override
    public String toString() {
        return "Opel Body";
    }
}
class VWBody extends Body {
    @Override
    public String toString() {
        return "VW Body";
    }
}

class OpelWheels extends Wheels {
    @Override
    public String toString() {
        return "Opel Wheels";
    }
}
class VWWheels extends Wheels {
    @Override
    public String toString() {
        return "VW Wheels";
    }
}

// factory impls bases on the manufactorers
class OpelCarFactory extends AbstractCarFactory {
    @Override
    public Engine fabricatEngine() {
        return new OpelEngine();
    }

    @Override
    public Body fabricateBody() {
        return new OpelBody();
    }

    @Override 
    public Wheels fabricatWheels() {
        return new OpelWheels();
    }
}
class VWCarFactory extends AbstractCarFactory {
    @Override
    public Engine fabricatEngine() {
        return new VWEngine();
    }

    @Override
    public Body fabricateBody() {
        return new VWBody();
    }

    @Override 
    public Wheels fabricatWheels() {
        return new VWWheels();
    }
}
