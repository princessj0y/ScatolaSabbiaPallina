public class Sabbia {

    private DatiCondivisi datiCondivisi;
    private int volume;

    private int x;
    private int y;

    private int altezzaBordi;

    private int livelloSabbiaSx;
    private int livelloSabbiaDx;

    private int inizioSabbia;
    private int fineSabbia;

    public Sabbia(DatiCondivisi datiCondivisi, int volume) {
        this.datiCondivisi = datiCondivisi;
        this.volume = volume;
    }

    public void aggiorna() {

        // Formula presa dal forum

        float inclinazione = datiCondivisi.getInclinazioneX();

        boolean reversed = false;
        if(inclinazione < 0) {
            inclinazione = -inclinazione;
            reversed = true;
        }

        final float area = volume / datiCondivisi.getLarghezzaScatola();

        float alpha = 90F;
        float gamma = inclinazione;
        float beta = 180F - alpha - gamma;

        alpha = (float) Math.toRadians(alpha);
        gamma = (float) Math.toRadians(gamma);
        beta = (float) Math.toRadians(beta);

        float a = (float) Math.sqrt((2 * area * Math.sin(alpha)) / (Math.sin(beta) * Math.sin(gamma)));

        if(!reversed) {
            livelloSabbiaSx = (int) Math.min(datiCondivisi.getLunghezzaScatola(), a * Math.sin(beta));
            livelloSabbiaDx = (int) Math.min(altezzaBordi, a * Math.sin(gamma));

            inizioSabbia = datiCondivisi.getLunghezzaScatola() - livelloSabbiaSx;
            fineSabbia = livelloSabbiaSx;
        } else {
            livelloSabbiaDx = (int) Math.min(datiCondivisi.getLunghezzaScatola(), a * Math.sin(beta));
            livelloSabbiaSx = (int) Math.min(altezzaBordi, a * Math.sin(gamma));

            x = 0;
            fineSabbia = livelloSabbiaDx;
        }
    }

    public int getInizioSabbia() {
        return inizioSabbia;
    }

    public int getFineSabbia() {
        return fineSabbia;
    }
}
