import java.util.Arrays;

public class Reflector {
    private int[] reflector;

    public Reflector(int type) {
        String wiring = "";
        this.reflector = new int[26];
        if (type == 1) { //all these are taken from wikipedia, these were the 5 types of reflectors available
            wiring = "AYBRCUDHEQFSGLIPJXKNMOTZVW";
        } else if (type == 2) {
            wiring = "AFBVCPDJEIGOHYKRLZMXNWTQSU";
        }

        int i = 0;
        while(i < wiring.length()) {
            int c1 = wiring.charAt(i) - 'A';
            int c2 = wiring.charAt(i+1) - 'A';
            reflector[c1] = c2;
            reflector[c2] = c1;
            i += 2;
        }
    }

    public int get(int i) {
        return reflector[i];
    }
}
