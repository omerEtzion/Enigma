

public class Enigma {
    private PlugBoard plug_board;
    private Rotor[] rotors;
    private Reflector reflector;

   /* public Enigma() {
        this.rotors = new Rotor[3];
        for(int i = 0; i < rotors.length; i++ ) {
            if(i > 0) {
                rotors[i] = new Rotor(i+1, 0, 0, rotors[i-1]);
            } else {
                rotors[i] = new Rotor(i+1, 0, 0, null);
            }
        }
        this.reflector = new Reflector(1);
        this.plug_board = new PlugBoard();
    }*/

    public Enigma(Rotor[] rotors, Reflector reflector, PlugBoard plug_board) {
        this.rotors = rotors;
        this.reflector = reflector;
        this.plug_board = plug_board;
    }

    public String evaluateWord(String word) {
        int[] input = new int[word.length()];
        char[] output = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            input[i] = word.charAt(i) - 'a';
        }
        for (int i = 0; i < input.length; i++) {
            int k = evaluateLetter(input[i]);
            output[i] = (char)(k + 'a');
        }
        return new String(output);
    }

    private int evaluateLetter(int c) {
        rotors[2].rotate(1);
        int output = c;
        output = plug_board.get(output);
        output = rotors[2].get(output, false);
        output = rotors[1].get(output, false);
        output = rotors[0].get(output,false);
        output = reflector.get(output);
        output = rotors[0].get(output, true);
        output = rotors[1].get(output, true);
        output = rotors[2].get(output,true);
        output = plug_board.get(output);
        return output;
    }

    public void reset() {
        for(int i = 0; i < rotors.length; i++) {
            rotors[i].reset();
        }
    }
}

