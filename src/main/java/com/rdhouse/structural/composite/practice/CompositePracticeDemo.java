package com.rdhouse.structural.composite.practice;

import java.util.ArrayList;
import java.util.List;

import com.rdhouse.Demo;

public class CompositePracticeDemo implements Demo {

    @Override
    public void run() {

        List<Composite> composits = new ArrayList<>();
        Composite player = new PlayerComposite();
        player.add(new InputComponent());
        player.add(new CollisionComponent());
        player.add(new RendererComponent());

        Composite enemy = new EnemyComposite();
        enemy.add(new AIComponent());
        enemy.add(new RendererComponent());

        composits.add(player);
        composits.add(enemy);

        System.out.println("Created the following two composites: ");
        for (Composite c : composits) {
            c.activate();
        }
    }
    
}

interface Component {

    void activate();

}

abstract class Composite implements Component {

    private List<Component> components = new ArrayList<>();

    public void add(Component c) {
        components.add(c);
    }

    @Override
    public void activate() {
        for (Component c : components) {
            c.activate();
        }
    }

}

// create some components
class RendererComponent implements Component {
    @Override
    public void activate()
    {
        System.out.println("Renderer Component");
    }
}
class AIComponent implements Component {
    @Override
    public void activate()
    {
        System.out.println("AI Component");
    }
}
class InputComponent implements Component {
    @Override
    public void activate()
    {
        System.out.println("Input Component");
    }
}
class CollisionComponent implements Component {
    @Override
    public void activate()
    {
        System.out.println("Collision Component");
    }
}

// create some composits
class PlayerComposite extends Composite {

    @Override
    public void activate() {
        System.out.println("Player consists of: ");
        super.activate();
    }
}

class EnemyComposite extends Composite {

    @Override
    public void activate() {
        System.out.println("Enemy consists of: ");
        super.activate();
    }
}