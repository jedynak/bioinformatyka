package pl.bioinformatyka;

public class Main {

    public static void main(String[] args) {
        RandomTimeGenerator timeGenerator = new RandomTimeGenerator(0.01);
        Tree tree = new Tree("AGTCAGCATCATCATAA");
        Kimura kimura = new Kimura(1,2);
        DNAsimulator simulator = new DNAsimulator(0.03,timeGenerator,tree,kimura);
        simulator.startSimulation();
        tree.simplePrint(0.0005);
    }
}
