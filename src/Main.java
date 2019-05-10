import processing.core.PApplet;
import processing.core.PConstants;

import java.awt.*;

public class Main extends PApplet {

    private DatiCondivisi datiCondivisi;

    public static void main(String[] args) {
        PApplet.main(Main.class);

    }
    /*
    Inizializzo le dimensioni del canvas.
    Inizializzo il numero di scatole (modifico nell'inizializzazione dei DatiCondivisi)
    */
    public void settings() {
        size(700, 500);
        datiCondivisi = new DatiCondivisi(this, 700, 500, 2, 2);
       SwingGui swingGui = new SwingGui(datiCondivisi);
        swingGui.show();
    }

    public void setup() {
        stroke(Color.red.getRGB());
        rectMode(PConstants.CORNER);
        frameRate(30);
        ellipseMode(RADIUS);
    }

    public void draw() {
        background(0, 0, 0);

        Scatola[][] scatole = datiCondivisi.getScatole();
        for(int i = 0; i < scatole.length; i++) {
            for(int j = 0; j < scatole[i].length; j++) {
                scatole[i][j].visualizzaScatola();
            }
        }
        datiCondivisi.getPallina().disegnaPallina();
        
    }
}
