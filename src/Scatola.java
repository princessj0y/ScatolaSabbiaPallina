public class Scatola {

    private int x;
    private int y;

    private Sabbia sabbia;

    private DatiCondivisi datiCondivisi;
    private ThScatola thread;

    public Scatola(int x, int y, DatiCondivisi datiCondivisi) {
        this.x = x;
        this.y = y;
        this.datiCondivisi = datiCondivisi;

        sabbia = new Sabbia(datiCondivisi, 100);
        thread = new ThScatola(this, datiCondivisi);
        thread.start();
    }

    public void aggiornaSabbia() {
        sabbia.aggiorna();
    }

    public void visualizzaScatola() {
        datiCondivisi.getMain().fill(255, 255, 255);
        datiCondivisi.getMain().rect(x, y, datiCondivisi.getLarghezzaScatola(), datiCondivisi.getLunghezzaScatola());

        datiCondivisi.getMain().fill(150, 100, 20);
        datiCondivisi.getMain().rect(x + sabbia.getInizioSabbia(), y, sabbia.getFineSabbia(), datiCondivisi.getLunghezzaScatola());
    }
}
