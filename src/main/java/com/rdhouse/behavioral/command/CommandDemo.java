package com.rdhouse.behavioral.command;

import java.util.ArrayList;
import java.util.List;

import com.rdhouse.Demo;

public class CommandDemo implements Demo {

    static List<Command> produceCommands() {
        List<Command> queue = new ArrayList<>();
        queue.add(new Cook());
        queue.add(new Waitress());
        return queue;
    }

    static void executeCommands(List<Command> queue) {
        for (Command command : queue) {
            command.execute();
        }
    }

    @Override
    public void run() {
        List<Command> queue = produceCommands();
        executeCommands(queue);
    }
}

interface Command {

    public void execute();

}

class Cook implements Command {

    public void execute() {
        System.out.println("Cooking!");
    }
}

class Waitress implements Command {

    public void execute() {
        System.out.println("Taking Order!");
    }
}


