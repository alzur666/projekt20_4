package domek;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import javafx.stage.FileChooser;
import org.apache.commons.lang3.math.NumberUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Dane {
    public String[][] daneOdczytane;
    public void odczytajPlik(String nazwaPliku) {
        // Tworzymy obiekt typu Path
        Path sciezka = Paths.get(nazwaPliku);
        // Lista do przechowywania kolejnych linii odczytanych pliku jako String
        ArrayList<String> odczyt = new ArrayList();
        try {
            // Linie pliku zostaja umieszoczne w liscie
            odczyt = (ArrayList) Files.readAllLines(sciezka);
        } catch (IOException ex) {
            System.out.println("Brak pliku!");
        }

        // Tablica dla odczytanych danych
        daneOdczytane = new String[odczyt.size()][];
        // Indeks linii
        int nrLinii = 0;
        // Pobranie kolejnych linii z listy
        for (String linia : odczyt) {
            // Rozbijamy linię (przedzielone przecinkami)
            String[] liniaDaneString = linia.split(",");
            // Tablica do przechowania danych w fomie liczb double
            int[] liniaDouble = new int[liniaDaneString.length];
            // Pętla pobiera z tablicy String liczbe i konwertuje ją na double i zapisuje w tablicy double[]
            for (int i = 0; i < liniaDouble.length; i++) {
                if(NumberUtils.isParsable(liniaDaneString[i]))
                    liniaDouble[i] = Integer.parseInt(liniaDaneString[i]);
            }
            // Dodajemy tablicę z serią danych do tablicy z wszystkimi danymi
            daneOdczytane[nrLinii] = liniaDaneString;
            nrLinii++;
        }

    }
}
