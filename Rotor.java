public class Rotor {
    private int[] rotor;
    private int[] reverse_rotor;
    private Rotor nextRotor; //rotor to the left
    private int turning_point; //the letter on which the next rotor turns
    private int top_position; //the letter on top
    private int starting_position;
    private int ring_setting;

    public Rotor(int type, int starting_position, int ring_setting, Rotor nextRotor) {
        setRotor(type);
        this.starting_position = starting_position;
        this.ring_setting = ring_setting;
        rotate(ring_setting);
        this.nextRotor = nextRotor;
        this.top_position = starting_position;
    }

    private void setRotor(int type) {
        String wiring = "";
        this.rotor = new int[26];
        this.reverse_rotor = new int[26];
        if (type == 1) { //all these are taken from wikipedia, these were the 5 types of rotors available
            wiring = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
            this.turning_point = 'Q' - 'A';
        } else if (type == 2) {
            wiring = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
            this.turning_point = 'E' - 'A';
        } else if (type == 3) {
            wiring = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
            this.turning_point = 'V' - 'A';
        } else if (type == 4) {
            wiring = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
            this.turning_point = 'J' - 'A';
        } else if (type == 5) {
            wiring = "VZBRGITYUPSDNHLXAWMJQOFECK";
            this.turning_point = 'Z' - 'A';
        }

        for (int i = 0; i < wiring.length(); i++) {
            rotor[i] = wiring.charAt(i) - 'A';
        }
        for (int i = 0; i < rotor.length; i++) {
            reverse_rotor[rotor[i]] = i;
        }
    }

    public void reset() {
        rotate(26 - (top_position - starting_position));
        top_position = starting_position;
    }

    public void rotate(int d) {
        int[] rotated = new int[rotor.length];
        System.arraycopy(rotor, rotor.length-d, rotated, 0, d);
        System.arraycopy(rotor, 0, rotated, d, rotor.length - d);
        top_position = ((top_position % 26) + d) % 27; // change starting position
        if (nextRotor != null && d == 1 && top_position == turning_point) {
            nextRotor.rotate(1);
        }
        rotor = rotated;
        for (int i = 0; i < rotor.length; i++) {
            reverse_rotor[rotor[i]] = i;
        }
    }

    public int get(int i, boolean reverse) {
        if(reverse) {
            return reverse_rotor[i];
        }
        return rotor[i];
    }


}
