package com.rdhouse;

import java.util.Scanner;

import com.rdhouse.behavioral.command.CommandDemo;
import com.rdhouse.creational.abstractfactory.AbstractFactoryDemo;
import com.rdhouse.creational.abstractfactory.practice.AbstractFactoryPracticeDemo;
import com.rdhouse.structural.composite.CompositeDemo;
import com.rdhouse.structural.composite.practice.CompositePracticeDemo;

public class Main {

    public static void main(String[] args) {
        // Vars
        Scanner scanner = new Scanner(System.in);

        // Welcome
        System.out.print("Please provide the name of the pattern to demo: ");

        String demoName = scanner.nextLine();
        Demo demo = null;
        if (demoName != null && demoName.length() > 0) {
            switch(demoName) {
                case "command" :
                    demo = new CommandDemo();
                    break;
                case "composite": 
                    demo = new CompositeDemo();
                    break;
                case "composite-practice": 
                    demo = new CompositePracticeDemo();
                    break;
                case "abstract-factory": 
                    demo = new AbstractFactoryDemo();
                    break;
                case "abstract-factory-practice" : 
                    demo = new AbstractFactoryPracticeDemo();
                    break;
            }
        }
        else {
            System.out.println("You did not provide a correct argument");
        }

        // Format output
        System.out.println("\n");

        // run the demo
        demo.run();

        // Close scanner
        scanner.close();

    }
}