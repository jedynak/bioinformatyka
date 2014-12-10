package pl.bioinformatyka;

import java.util.Random;

public class Kimura{
    private double alfa;
    private double beta;
    private Random random;
    public Kimura(double _alfa,double _beta){
        alfa = _alfa;
        beta = _beta;
        random = new Random();
    }
    public String mutateDNA(String oldDNA, double time ){
        double transitionsPossibility = (1.0 - Math.exp(-4.0 * time * beta))/4.0;
        double transversionsPossibility = (1.0 + Math.exp(-4.0 * time * beta) - 2*Math.exp(-2.0 * time * (alfa + beta)) )/4.0;
        StringBuilder newDNA = new StringBuilder(oldDNA.length());
        for(int i = 0; i < oldDNA.length(); i++) {
            char c = oldDNA.charAt(i);
            double x = random.nextDouble();
            if (x < transitionsPossibility) {
                newDNA.append(transit(c));
            } else {
                x -= transitionsPossibility;
                if(x < transversionsPossibility){
                    newDNA.append(transvert1(c));
                }else{
                    x -= transversionsPossibility;
                    if(x < transversionsPossibility){
                        newDNA.append(transvert2(c));
                    }else{
                        newDNA.append(c);
                    }
                }
            }
        }
        return newDNA.toString();
    }
    private char transit(char a){
        char returnchar=' ';
        switch(a){
            case 'A':
                returnchar = 'G';
                break;
            case 'G':
                returnchar = 'A';
                break;
            case 'C':
                returnchar = 'T';
                break;
            case 'T':
                returnchar = 'C';
                break;
        }
        return returnchar;
    }
    private char transvert1(char a){
        char returnchar=' ';
        switch(a){
            case 'A':
                returnchar = 'C';
                break;
            case 'G':
                returnchar = 'T';
                break;
            case 'C':
                returnchar = 'A';
                break;
            case 'T':
                returnchar = 'G';
                break;
        }
        return returnchar;
    }
    private char transvert2(char a){
        char returnchar=' ';
        switch(a){
            case 'A':
                returnchar = 'T';
                break;
            case 'G':
                returnchar = 'C';
                break;
            case 'C':
                returnchar = 'G';
                break;
            case 'T':
                returnchar = 'A';
                break;
        }
        return returnchar;
    }

}