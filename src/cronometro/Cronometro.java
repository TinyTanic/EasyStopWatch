package cronometro;

/**
 *
 * @author Luca Aguzzoli
 */
public class Cronometro {

    long start;
    long end;

    boolean started = false;

    public Cronometro() {
    }

    public void start() {
        start = System.currentTimeMillis();
        started = true;
    }

    public long step() {
        return started ? (System.currentTimeMillis() - start) : -1;
    }

    public void stop() {
        if (started) {
            end = System.currentTimeMillis();
            started = false;
        }
    }

    public long getTimeMillis() {
        return started ? -1 : end - start;
    }

    public long getTimeSecond() {
        return getTimeMillis() / 1000;
    }

    public void reset() {
        started = false;
        start = end = 0;
    }

    public static String beautify(long time) {
        long millis = time % 1000;
        long sectot = time / 1000;
        long sec = sectot % 60;
        long min = sectot / 60;
        return (min < 10 ? "0" : "") + min + "m:" + (sec < 10 ? "0" : "") + sec + "s:" + (millis < 100 ? (millis < 10 ? "00" : "0") : "") + millis + "ms";
    }

    public String toString() {
        long millis = getTimeMillis() % 1000;
        long sectot = getTimeMillis() / 1000;
        long sec = sectot % 60;
        long minutes = sectot / 60;
        return (minutes < 10 ? "0" : "") + minutes + "m:" + (sec < 10 ? "0" : "") + sec + "s:" + (millis < 100 ? (millis < 10 ? "00" : "0") : "") + millis + "ms";
    }
    
    public static void main(String []args){
        Cronometro c = new Cronometro();
        c.start();
        c.stop();
        System.out.println(Cronometro.beautify(c.getTimeMillis()));
    }

}
