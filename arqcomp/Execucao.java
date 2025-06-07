package arqcomp;

public class Execucao {
        public static void main(String[] args) {
        String receberlinha = "00000010001100100100000000100000";
        char [] array = receberlinha.toCharArray();
        String opcode = "" + array[0] + array[1] + array[2] + array[3] + array[4] + array[5];
        //21 a 25 shamt
        switch (opcode) {
            case "000000":
                System.out.println(array);
                String reg1 = "" + array[6]+ array[7] + array[8] + array[9] + array [10];; 
                reg1 = NumRegistrador(reg1);
                System.out.println(reg1);
                break;
    
            case "000010":
    
                break;
    
            case "000100":
    
                break;
    
            case "000101":
    
                break;
                
            case "000110":
    
                break;
    
            case "000111":
    
                break;
    
            case "001000":
    
                break; 
    
            case "001100":
    
                break;
    
            case "001101":
    
                break;
    
            case "001110":
    
                break;
    
            case "001111":
    
                break;
    
            case "100000":
    
                break;
    
            case "100001":
    
                break;
    
            case "100011":
    
                break;
    
            case "101000":
    
                break;
    
            case "101001":
    
                break;
    
            case "101011":
            
                break;
    
            default:
                System.out.println("Tipo de instrução não reconhecida.");
                break;
        }
        }
        public static String NumRegistrador (String a){
        switch (a) {
            case "00000":
                return "$zero";
            case "00001":
                return "$at";
            case "00010":
                return "$v0";
            case "00011":
                return "$v1";
            case "00100":
                return "$a0";
            case "00101":
                return "$a1";
            case "00110":
                return "$a2";
            case "00111":
                return "$a3";
            case "01000":
                return "$t0";
            case "01001":
                return "$t1";
            case "01010":
                return "$t2";
            case "01011":
                return "$t3";
            case "01100":
                return "$t4";
            case "01101":
                return "$t5";
            case "01110":
                return "$t6";
            case "01111":
                return "$t7";
            case "10000":
                return "$s0";
            case "10001":
                return "$s1";
            case "10010":
                return "$s2";
            case "10011":
                return "$s3";
            case "10100":
                return "$s4";
            case "10101":
                return "$s5";
            case "10110":
                return "$s6";
            case "10111":
                return "$s7";
            case "11000":
                return "$t8";
            case "11001":
                return "$t9";
            case "11010":
                return "$k0";
            case "11011":
                return "$k1";
            case "11100":
                return "$gp";
            case "11101":
                return "$sp";
            case "11110":
                return "$s8";
            default:
                return "ra";
        }
        }
        public static String getFunction (String reg1, String reg2, String reg3, String Shamt, String function){
            switch (function) {
                case "000000":
                    String registrador1 = NumRegistrador(reg1);
                    String registrador2 = NumRegistrador(reg2);
                    int ra = getShamt(Shamt);
                    return "sll " + registrador1 + ", "  + registrador2 + ", "  + ra;
                case "000010":
                    registrador1 = NumRegistrador(reg1);
                    registrador2 = NumRegistrador(reg2);
                    int RA = getShamt(Shamt);
                    return "srl " + registrador1 + ", "  + registrador2 + ", "  + RA;
                case "001000":
                    registrador1 = NumRegistrador(reg1);
                    return "jr " + registrador1;
                case "100000":
                    registrador1 = NumRegistrador(reg1);
                    registrador2 = NumRegistrador(reg2);
                    String registrador3 = NumRegistrador(reg3);
                    return "add " + registrador1 + ", " + registrador2 + ", "  + registrador3;
                case "100010":
                    registrador1 = NumRegistrador(reg1);
                    registrador2 = NumRegistrador(reg2);
                    registrador3 = NumRegistrador(reg3);
                    return "sub " + registrador1 + ", " + registrador2 + ", "  + registrador3;
                case "100100":registrador1 = NumRegistrador(reg1);
                    registrador2 = NumRegistrador(reg2);
                    registrador3 = NumRegistrador(reg3);
                    return "and " + registrador1 + ", " + registrador2 + ", "  + registrador3;
                case "100101":registrador1 = NumRegistrador(reg1);
                    registrador2 = NumRegistrador(reg2);
                    registrador3 = NumRegistrador(reg3);
                    return "or " + registrador1 + ", " + registrador2 + ", "  + registrador3;
                case "100110":registrador1 = NumRegistrador(reg1);
                    registrador2 = NumRegistrador(reg2);
                    registrador3 = NumRegistrador(reg3);
                    return "xor " + registrador1 + ", " + registrador2 + ", "  + registrador3;
                default:
                    return"";
            }
        }
        public static int getShamt (String a){
            int num = Integer.parseInt(a, 2);
            return num;
        }
    
}
