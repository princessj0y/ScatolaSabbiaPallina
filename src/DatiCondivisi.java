public class DatiCondivisi {

    private Main main;

    private Scatola[][] scatole;
    private Pallina pallina;

    private int largezzaSchermo;
    private int altezzaSchermo;

    private int lunghezzaScatola;
    private int larghezzaScatola;

    private float inclinazioneX;

    public DatiCondivisi(Main main, int largezzaSchermo, int altezzaSchermo, int vaschePerRiga, int vaschePerColonna) {
        this.main = main;
        inclinazioneX=0;
        pallina = new Pallina();

        this.largezzaSchermo = largezzaSchermo;
        this.altezzaSchermo = altezzaSchermo;

        larghezzaScatola = (largezzaSchermo - 10 - 10) / vaschePerColonna;
        lunghezzaScatola = (altezzaSchermo - 10 - 10) / vaschePerRiga;
        inclinazioneX = 0;

        int x = 10, y = 10;
        this.scatole = new Scatola[vaschePerRiga][vaschePerColonna];
        for(int i = 0; i < vaschePerRiga; i++) {
            x = 10;
            for(int j = 0; j < vaschePerColonna; j++) {

                int volumeSabbia;
                if(j == 0 && i == 0) {
                    volumeSabbia = 100;
                  
                }
                else
                    volumeSabbia = 0;             
                  this.scatole[i][j] = new Scatola(x, y, this, volumeSabbia);
                x += larghezzaScatola;
            }
            y += lunghezzaScatola;
        }
    }

    public synchronized Main getMain() {
        return main;
    }

    public synchronized Scatola[][] getScatole() {
        return scatole;
    }

    public synchronized Pallina getPallina() {
        return pallina;
    }

    public synchronized int getLargezzaSchermo() {
        return largezzaSchermo;
    }

    public synchronized int getAltezzaSchermo() {
        return altezzaSchermo;
    }

    public synchronized int getLunghezzaScatola() {
        return lunghezzaScatola;
    }

    public synchronized int getLarghezzaScatola() {
        return larghezzaScatola;
    }

    public synchronized float getInclinazioneX() {
        return inclinazioneX;
    }

    public synchronized void setLargezzaSchermo(int largezzaSchermo) {
        this.largezzaSchermo = largezzaSchermo;
    }

    public synchronized void setAltezzaSchermo(int altezzaSchermo) {
        this.altezzaSchermo = altezzaSchermo;
    }

    public synchronized void setInclinazioneX(float inclinazioneX) {
        this.inclinazioneX = inclinazioneX;
    }

    void incInclinazione() {
       inclinazioneX++;
    }

    void decInclinazione() {
         inclinazioneX--;
    }
}
