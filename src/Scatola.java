import java.awt.*;

public class Scatola {

    private int x;
    private int y;

    private Sabbia sabbia;

    private DatiCondivisi datiCondivisi;
    private ThScatola thread;

    public Scatola(int x, int y, DatiCondivisi datiCondivisi, int volumeSabbia) {
        this.x = x;
        this.y = y;
        this.datiCondivisi = datiCondivisi;

        sabbia = new Sabbia(datiCondivisi, volumeSabbia);
        thread = new ThScatola(this, datiCondivisi);
        thread.start();
    }

    public void aggiornaSabbia() {
        sabbia.aggiorna();
    }

    public void visualizzaScatola() {
        datiCondivisi.getMain().fill(255, 255, 255);
        datiCondivisi.getMain().rect(x, y, datiCondivisi.getLarghezzaScatola(), datiCondivisi.getLunghezzaScatola());

        datiCondivisi.getMain().fill(new Color(150, 100, 20).getRGB());
        datiCondivisi.getMain().rect(x + sabbia.getInizioSabbia(), y, sabbia.getFineSabbia(), datiCondivisi.getLunghezzaScatola());
    }
}
