import no_01.*;
import no_02.QuackCounter;
import no_02.QuackEcho;
import no_03.AbstractDuckFactory;
import no_03.CountingDuckFactory;
import no_03.DuckFactory;
import no_03.EchoQuackFactory;
import no_04.Flock;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        System.out.println("Duck Factory");
        DuckFactory duckFactory = new DuckFactory();
        simulator.simulate(duckFactory);

        System.out.println("Duck Factory with Counter");
        CountingDuckFactory duckFactoryWithCounter = new CountingDuckFactory();
        simulator.simulate(duckFactoryWithCounter);

        System.out.println("Duck Factory with Counter and Echo");
        EchoQuackFactory duckFactoryWithCounterEcho = new EchoQuackFactory();
        simulator.simulate(duckFactoryWithCounterEcho);
    }

    void simulate(){
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseDuck = new QuackEcho(new GooseAdapter(new Goose()));
        Quackable piegoen = new QuackEcho(new PigeonAdapter(new Pigeon()));

        System.out.println("\n Duck Simulator : With Goose Adapter");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(piegoen);

        System.out.println("\n Duck Simulator : With QuackCounter and QuackEcho");

        System.out.println(QuackCounter.getQuacks());
    }
    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);
        flockOfDucks.add(pigeon);

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        Flock flockOfMallards = new Flock();
        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);

        System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks());
        System.out.println("================================================");


    }
    void simulate(Quackable duck) {
        duck.quack();
    }
}