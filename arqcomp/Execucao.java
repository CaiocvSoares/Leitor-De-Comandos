package arqcomp;

public class Execucao {
        public static void main(String[] args) {
        String receberlinha = "10101101001010000000010010110000";
        char [] array = receberlinha.toCharArray();
        String opcode = "" + array[0] + array[1] + array[2] + array[3] + array[4] + array[5];
        String Resul;
        /*
        0 a 5 opcode 

        Tipo R e I:
        6 a 10 reg1
        11 a 15 reg2

        tipo R
        16 a 20 reg3
        21 a 25 shamt
        26 a 31 function

        tipo I:
        15 a 31 imediato

        Tipo J:
        6 a 31 adress
        */
        switch (opcode) {
            case "000000":
                String regis1 =  new String(array, 6, 5);
                String regis2 = new String(array, 11, 5);
                String regis3 = new String (array, 16, 5);
                String shamt = new String(array, 21, 5);
                String Function = new String(array, 26, 6);
                Resul = getFunction(regis1, regis2, regis3, shamt, Function);
                System.out.println(Resul);
                break;
    
            case "000010":
                int instrução = Integer.parseInt((new String (array, 6, 26)), 2);
                instrução = instrução * 4;
                Resul = "j " + instrução;
                System.out.println(Resul);
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
                regis1 =  new String(array, 6, 5);
                regis2 = new String(array, 11, 5);
                String imediato = new String(array, 16, 16);
                Resul = getImmediate(opcode, regis1, regis2, imediato);
                System.out.println(Resul);
                break;
    
            case "101000":
    
                break;
    
            case "101001":
    
                break;
    
            case "101011":
                regis1 =  new String(array, 6, 5);
                regis2 = new String(array, 11, 5);
                imediato = new String(array, 16, 16);
                Resul = getImmediate(opcode, regis1, regis2, imediato);
                System.out.println(Resul);
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
                    return "add " + registrador3 + ", " + registrador1 + ", "  + registrador2;
                case "100010":
                    registrador1 = NumRegistrador(reg1);
                    registrador2 = NumRegistrador(reg2);
                    registrador3 = NumRegistrador(reg3);
                    return "sub " + registrador3 + ", " + registrador1 + ", "  + registrador2;
                case "100100":registrador1 = NumRegistrador(reg1);
                    registrador2 = NumRegistrador(reg2);
                    registrador3 = NumRegistrador(reg3);
                    return "and " + registrador3 + ", " + registrador1 + ", "  + registrador2;
                case "100101":registrador1 = NumRegistrador(reg1);
                    registrador2 = NumRegistrador(reg2);
                    registrador3 = NumRegistrador(reg3);
                    return "or " + registrador3 + ", " + registrador1 + ", "  + registrador2;
                case "100110":registrador1 = NumRegistrador(reg1);
                    registrador2 = NumRegistrador(reg2);
                    registrador3 = NumRegistrador(reg3);
                    return "xor " + registrador3 + ", " + registrador1 + ", "  + registrador2;
                default:
                    return"";
            }
        }
        public static int getShamt (String a){
            int num = Integer.parseInt(a, 2);
            return num;
        }
        
        public static String getImmediate(String opcode, String reg1, String reg2, String immediate) {
            String registrador1 = NumRegistrador(reg1);
            String registrador2 = NumRegistrador(reg2);
            int valor = Integer.parseInt(immediate, 2);
            
            switch (opcode) {
                case "100011": 
                    return "lw " + registrador2 + ", " + valor + "(" + registrador1 + ")";
                
                case "101011":
                    return "sw " + registrador2 + ", " + valor + "(" + registrador1 + ")";

                case "001000": 
                        return "addi " + registrador1 + ", " + registrador2 + ", " + valor;
        
                case "001100": 
                        return "andi " + registrador1 + ", " + registrador2 + ", " + valor;
        
                case "001101": 
                        return "ori " + registrador1 + ", " + registrador2 + ", " + valor;
  
                case "000100": 
                        return "beq " + registrador1 + ", " + registrador2 + ", " + valor;
        
                case "000101": 
                        return "bne " + registrador1 + ", " + registrador2 + ", " + valor;
                 
            }
        
            return "Instrução não reconhecida";
        }
}
