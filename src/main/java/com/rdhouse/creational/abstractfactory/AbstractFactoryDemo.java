package com.rdhouse.creational.abstractfactory;

import com.rdhouse.Demo;

public class AbstractFactoryDemo implements Demo {

    @Override
    public void run() {
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.INTEL);
        CPU cpu = factory.createCPU();
        GPU gpu = factory.createGPU();
        System.out.println("CPU: " + cpu.getClass().getName());
        System.out.println("GPU: " + gpu.getClass().getName());
    }

}

// define abstract CPU type
abstract class CPU {}

// create CPU impls
class IntelCPU extends CPU {}

class AmdCPU extends CPU {}

// define abstract GPU type
abstract class GPU {}

// create impls
class IntelGPU extends GPU {}

class AmdGPU extends GPU {}

enum Architecture {
    AMD, INTEL
}

class AmdFactory extends AbstractFactory {
    
    @Override
    public CPU createCPU() {
        return new AmdCPU();
    }

    @Override
    public GPU createGPU() {
        return new AmdGPU();
    }
}

class IntelFactory extends AbstractFactory {

    @Override
    public CPU createCPU() {
        return new IntelCPU();
    }

    @Override
    public GPU createGPU() {
        return new IntelGPU();
    }
}

// create abstract factory
abstract class AbstractFactory {

    private static final AmdFactory AMD_FACTORY = new AmdFactory();
    private static final IntelFactory INTEL_FACTORY = new IntelFactory();
    
    // returns a concreate factory object that is an instance of
    // the concrete factory class appropriate for the given achitecture
    static AbstractFactory getFactory(Architecture architecture) {
        AbstractFactory factory = null;
        switch(architecture) {
            case AMD: {
                factory = AMD_FACTORY;
            }
            case INTEL: {
                factory = INTEL_FACTORY;
            }
        }

        return factory;
    }

    public abstract CPU createCPU();

    public abstract GPU createGPU();
}