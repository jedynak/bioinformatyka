package pl.bioinformatyka.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class InputReader {
    private File inputFile;

    public InputReader(String filename){
        this.inputFile = new File(filename);
    }

    public int[][] readAdjacencyMatrix() throws FileNotFoundException {
        Scanner scanner =  new Scanner(inputFile).useLocale(Locale.US);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] ret = new int[size][size];

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                ret[i][j] = scanner.nextInt();
            }
        }
        return ret;
    }
}
