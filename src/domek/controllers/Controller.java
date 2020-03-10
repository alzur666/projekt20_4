package domek.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domek.Dane;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends Component implements Initializable {
    @FXML
    private Button btnWczytajDane;

    @FXML
    private Button btnRysujWykres;
    @FXML
    private FontAwesomeIcon icClose;
    @FXML
    private Pane pnWyswietlanie;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void klikajka(javafx.scene.input.MouseEvent event) throws IOException {
        if(event.getSource()==btnWczytajDane) {
            String sciezkaDoPlik;
            JFileChooser otworz= new JFileChooser();
            int wynik = otworz.showOpenDialog(this);
            if(wynik== JFileChooser.APPROVE_OPTION)
            {
                Dane dane = new Dane();
                sciezkaDoPlik= otworz.getSelectedFile().getPath();
                dane.odczytajPlik(sciezkaDoPlik);
                for(int i = 0; i<dane.daneOdczytane.length; i++)
                {
                    for(int j = 0; j<dane.daneOdczytane[i].length; j++){
                        System.out.print(dane.daneOdczytane[i][j]+" ");
                    }
                    System.out.print("\n");
                }

            }
        } else if(event.getSource()==btnRysujWykres) {
            pnWyswietlanie.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    @FXML
    public void klikZamknij(javafx.scene.input.MouseEvent event) {
        if(event.getSource()==icClose) {
            System.exit(0);
        }
    }
}
