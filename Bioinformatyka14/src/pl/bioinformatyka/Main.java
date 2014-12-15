package pl.bioinformatyka;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        double alfaParam=1;
        double betaParam=2;
        double time=0.03;
        double timeUnit=0.0005;
        double avarageTime=0.01;
        String DNA="AGTCAGCATCATCATAA";
            /*
            UWAGA: wymaga poprawy bo musi być przecinek przy wczytywaniu danych, a nie kropka.
            No i nie ma wyjątków sensownych
             */
        if(args.length>4){
            try {
                DNA = args[0];
                alfaParam = Double.parseDouble(args[1]);
                betaParam = Double.parseDouble(args[2]);
                time = Double.parseDouble(args[3]);
                avarageTime = Double.parseDouble(args[4]);
                if (args.length > 5) {
                    timeUnit = Double.parseDouble(args[5]);
                }
            } catch (NumberFormatException e){
                System.out.println("Niepoprawne parametry");
                InputReader reader = new InputReader();
                DNA = reader.readSequence();
                alfaParam = reader.readAlfa();
                betaParam = reader.readBeta();
                time = reader.readTime();
                avarageTime = reader.readAvarageTime();
                timeUnit = reader.readTimeUnit();
            }
        } else {
            InputReader reader = new InputReader();
            DNA = reader.readSequence();
            alfaParam = reader.readAlfa();
            betaParam = reader.readBeta();
            time = reader.readTime();
            avarageTime = reader.readAvarageTime();
            timeUnit = reader.readTimeUnit();
        }
        RandomTimeGenerator timeGenerator = new RandomTimeGenerator(avarageTime);
        Tree tree = new Tree(DNA);
        Kimura kimura = new Kimura(alfaParam,betaParam);
        DNAsimulator simulator = new DNAsimulator(time,timeGenerator,tree,kimura);
        simulator.startSimulation();
        tree.simplePrint(timeUnit);
    }
}
