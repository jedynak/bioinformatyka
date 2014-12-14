package pl.bioinformatyka;

import java.util.Scanner;

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
            DNA = args[0];
            alfaParam = Double.parseDouble(args[1]);
            betaParam = Double.parseDouble(args[2]);
            time = Double.parseDouble(args[3]);
            avarageTime = Double.parseDouble(args[4]);
            if(args.length>5){
                timeUnit = Double.parseDouble(args[5]);
            }
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.println("Wpisz sekwencje poczatkowa");
            DNA = scan.nextLine();
            System.out.println("Wpisz parametry alfa i beta modelu Kimury");
            alfaParam = scan.nextDouble();
            betaParam = scan.nextDouble();
            System.out.println("Wpisz czas przez ktory sekwencja ewouluje");
            time = scan.nextDouble();
            System.out.println("Wpisz średni czas po ktorym nastapi rozdzielenie linii gatunkowej");
            avarageTime = scan.nextDouble();
            System.out.println("Wpisz czas słuzacy jako najmniejsza jednostka przy wyświetlaniu drzewa");
            timeUnit = scan.nextDouble();
        }
        RandomTimeGenerator timeGenerator = new RandomTimeGenerator(avarageTime);
        Tree tree = new Tree(DNA);
        Kimura kimura = new Kimura(alfaParam,betaParam);
        DNAsimulator simulator = new DNAsimulator(time,timeGenerator,tree,kimura);
        simulator.startSimulation();
        tree.simplePrint(timeUnit);
    }
}
