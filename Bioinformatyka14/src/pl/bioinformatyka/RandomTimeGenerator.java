package pl.bioinformatyka;

import java.util.Random;

public class RandomTimeGenerator {
    private double avarageValue;
    private Random random;
    public RandomTimeGenerator(double _avarageValue){
        avarageValue = _avarageValue;
        random = new Random();
    }
    public double getRandomTime(){
        double x = random.nextDouble();
        if(x == 1.0){
            x = 0.0;
        }
        double y = -avarageValue * Math.log(1.0-x);
        return y;
    }

}