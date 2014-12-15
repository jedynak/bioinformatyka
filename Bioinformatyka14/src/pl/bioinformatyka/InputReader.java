package pl.bioinformatyka;

import java.util.Locale;
import java.util.Scanner;

public class InputReader {
    private Scanner scan;
    public InputReader(){
        scan = new Scanner(System.in).useLocale(Locale.US);
    }
    public Double readAlfa(){
        String request="Wpisz parametr alfa modelu Kimury";
        return readDouble(request);
    }
    public Double readBeta(){
        String request="Wpisz parametr beta modelu Kimury";
        return readDouble(request);
    }
    public Double readTime(){
        String request="Wpisz czas przez ktory sekwencja ewoluuje";
        return readDouble(request);
    }
    public Double readAvarageTime(){
        String request="Wpisz średni czas po ktorym nastapi rozdzielenie linii gatunkowej";
        return readDouble(request);
    }
    public Double readTimeUnit(){
        String request="Wpisz czas słuzacy jako najmniejsza jednostka przy wyświetlaniu drzewa";
        return readDouble(request);
    }
    public String readSequence(){
        boolean correctData = false;
        String data;
        do{
            System.out.println("Wpisz sekwencje poczatkowa");
            data = scan.nextLine();
            correctData = true;
            for (char ch: data.toCharArray()) {
                if(!(ch=='A'||ch=='T'||ch=='G'||ch=='C')){
                    correctData = false;
                    System.out.println("Niepoprawna sekwencja poczatkowa");
                    break;
                }
            }
        }while(correctData == false);
        return data;
    }
    private Double readDouble(String request){
        Double data = 0.0;
        System.out.println(request);
        do{
            if (scan.hasNextDouble()) {
                data = scan.nextDouble();
                break;
            } else {
                scan.next();
                System.out.println("Niepoprawny parametr");
                System.out.println(request);
            }
        }while(scan.hasNext());
        return data;
    }

}
