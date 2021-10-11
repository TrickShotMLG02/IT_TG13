package A02_Threads;

public class AmpelStart {

    public static AmpelThread a1;

    public static void main(String[] args) {
        a1 = new AmpelThread("Ampel_1", 1000);
        a1.start();
    }

}
