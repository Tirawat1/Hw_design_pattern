package no_03;

import no_01.*;

public class DuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createDuckCall() {
        return new MallardDuck();
    }
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RedheadDuck();
    }
}

