package A02_Threads;

public class AmpelStart {

    public static void main(String[] args) {
        AmpelThread a1 = new AmpelThread("Ampel_1", 1000);
        a1.start();
    }

}
