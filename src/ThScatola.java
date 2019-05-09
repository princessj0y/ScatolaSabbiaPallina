public class ThScatola extends Thread {
    private Scatola scatola;
    private DatiCondivisi datiCondivisi;

    public ThScatola(Scatola scatola, DatiCondivisi datiCondivisi) {
        this.scatola = scatola;
        this.datiCondivisi = datiCondivisi;
    }

    public void run() {
        try {
            while(true) {
                scatola.aggiornaSabbia();
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
        }
    }
}
