//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) throws Exception{
//
//        Rotor[] rotors = new Rotor[3];
//        Reflector reflector;
//        PlugBoard plug_board = new PlugBoard();
//
//        System.out.println("This is an Enigma machine, a machine used by the German army in the second world war\n" +
//                " to encrypt their communications. The machine consists of five main components:\n" +
//                "three rotors (left, middle and right), one reflector and one plug board.\nWe will set them up in that order:\n");
//
//        Scanner console = new Scanner(System.in);
//        int rotor_type = -1;
//        int starting_position = -1;
//        int ring_setting = -1;
//        Rotor next_rotor = null;
//        String[] rotor_positions = {"Left", "Middle", "Right"};
//        for(int i = 0; i < 3; i++) {
//            System.out.println(rotor_positions[i] + " rotor parameters:");
//            System.out.println("    Rotor type -");
//            if(i == 0) {
//                System.out.println("    Each type has a specific wiring scheme (which letter goes to which letter) -");
//            }
//            System.out.print("    There are five types available, please enter a type between 1 and 5: ");
//            rotor_type = console.nextInt();
//            while(rotor_type < 1 || rotor_type > 5) {
//                System.out.print("    No such rotor type, please enter a type between 1 and 5: ");
//                rotor_type = console.nextInt();
//            }
//            System.out.println("    Starting position - ");
//            if(i == 0) {
//                System.out.println("    The letter that sits on top of the rotor at the beginning of the machine's operation - ");
//            }
//            System.out.print("    Please enter a letter between 'a' and 'z' in lower case: ");
//            String fix = console.nextLine();
//            String tmp = console.nextLine();
//            while(tmp.length() != 1 || ((int)tmp.charAt(0) - 'a') < 0 || ((int)tmp.charAt(0) - 'a') > 25) {
//                System.out.print("    Illegal input, please enter a letter between 'a' and 'z' in lower case: ");
//                tmp = console.nextLine();
//            }
//            starting_position = (int)tmp.charAt(0) - 'a';
//            System.out.println("    Ring setting - ");
//            if(i == 0) {
//                System.out.println("    An offset from the original wiring (i.e if the letter 'a' goes to 'f' in the original\n" +
//                        "    wiring, with ring setting 1 'b' would now go to 'f') - ");
//            }
//            System.out.print("    Please enter any number: ");
//            ring_setting = console.nextInt() % 26;
//
//            rotors[i] = new Rotor(rotor_type, starting_position, ring_setting, next_rotor);
//            next_rotor = rotors[i];
//            System.out.println();
//        }
//
//        System.out.println("Reflector:");
//        System.out.print("    Please enter a reflector type between 1 and 2: ");
//        int reflector_type = console.nextInt();
//        while(reflector_type < 1 || reflector_type > 2) {
//            System.out.print("    Invalid type, please enter a reflector type between 1 and 2: ");
//            reflector_type = console.nextInt();
//        }
//        reflector = new Reflector(reflector_type);
//        System.out.println();
//
//        System.out.println("Plug Board:");
//        System.out.println("    Please enter letters to be connected in pairs of lower case letters (i.e to connect\n" +
//                "    the letters 'a' and 'b' enter 'ab'). When you're done, enter the number 0:");
//        String pair = console.nextLine();
//        while ((pair = console.nextLine()) != null && !pair.equals("0")) {
//            if(pair.length() != 2 || pair.charAt(0) < 'a' || pair.charAt(0) > 'z' || pair.charAt(1) < 'a' || pair.charAt(1) > 'z') {
//                System.out.println("Invalid entry, please enter a pair of lower case letters:");
//            } else {
//                int a = pair.charAt(0) - 'a';
//                int b = pair.charAt(1) - 'a';
//                if(plug_board.isConnected(a)) {
//                    System.out.println("The letter " + pair.charAt(0) + " is already connected, please select another letter:");
//                } else if(plug_board.isConnected(b)) {
//                    System.out.println("The letter " + pair.charAt(1) + " is already connected, please select another letter:");
//                } else {
//                    plug_board.connect(a, b);
//                    System.out.println("Connected successfully, please choose another pair or enter 0 if you're done:");
//                }
//            }
//        }
//
//        Enigma enigma = new Enigma(rotors, reflector, plug_board);
//        System.out.println("\nPlease enter a message you wish to encrypt, or '0' to exit:");
//
//        String original_msg;
//        while((original_msg= console.nextLine()) != null && !original_msg.equals("0")) {
//            boolean is_legal_msg = true;
//            for (int i = 0; i < original_msg.length() && is_legal_msg; i++) {
//                char c = original_msg.charAt(i);
//                if (c < 'a' || c > 'z') {
//                    System.out.println("The message the illegal character '" + c + "', please enter only lower case letters");
//                    is_legal_msg = false;
//                }
//            }
//
//            if(is_legal_msg) {
//                String encrypted_msg = enigma.evaluateWord(original_msg);
//                System.out.println("Here is the encrypted message:");
//                System.out.println(encrypted_msg + "\n");
//                enigma.reset();
//
//                System.out.println("To decrypt the message, the machine has to be in the same initial state as the one that \n" +
//                        "encrypted the message, so after encrypting your message it has been reset to your original settings\n" +
//                        "(all the turns have been undone and the rotors have been put back to their original starting positions)");
//
//                String decrypted_msg = enigma.evaluateWord(encrypted_msg);
//                System.out.println("Here is your message decrypted:\n" + decrypted_msg + "\n\n");
//                System.out.println("Pease enter another message you wish to encrypt or '0' to exit:");
//            }
//        }
//    }
//}
