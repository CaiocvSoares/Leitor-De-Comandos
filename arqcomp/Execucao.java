package arqcomp;

public class Execucao {
        public static String decodificarInstrucao(String receberlinha){
            if (receberlinha.length() != 32) return "Instrução inválida";
            char [] array = receberlinha.toCharArray();
            String opcode = new String(array, 0, 6);
            
            String regis1, regis2, imediato;
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
                    String reg1 = new String(array, 6, 5);
                    String reg2 = new String(array, 11, 5);
                    String reg3 = new String(array, 16, 5);
                    String shamt = new String(array, 21, 5);
                    String funct = new String(array, 26, 6);
                    return getFunction(reg1, reg2, reg3, shamt, funct);
    
                case "000010":
                    int instrucao = Integer.parseInt(new String(array, 6, 26), 2) * 4;
                    return "j " + instrucao;
    
                default:
                    regis1 = new String(array, 6, 5);
                    regis2 = new String(array, 11, 5);
                    imediato = new String(array, 16, 16);
                    return getImmediate(opcode, regis1, regis2, imediato);
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
                return "$ra";
        }
        }
        public static String getFunction (String reg1, String reg2, String reg3, String Shamt, String function){
            String registrador1 = NumRegistrador(reg1);
            String registrador2 = NumRegistrador(reg2);
            String registrador3 = NumRegistrador(reg3);
            int ra = getShamt(Shamt);
            int RA = getShamt(Shamt);
            switch (function) {
                case "000000":
                    return "sll " + registrador1 + ", "  + registrador2 + ", "  + ra;
                case "000010":
                    return "srl " + registrador1 + ", "  + registrador2 + ", "  + RA;
                case "001000":
                    return "jr " + registrador1;
                case "100000":
                    return "add " + registrador3 + ", " + registrador1 + ", "  + registrador2;
                case "100010":
                    return "sub " + registrador3 + ", " + registrador1 + ", "  + registrador2;
                case "100100":
                    return "and " + registrador3 + ", " + registrador1 + ", "  + registrador2;
                case "100101":
                    return "or " + registrador3 + ", " + registrador1 + ", "  + registrador2;
                case "100110":
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
            int valor = (short) Integer.parseInt(immediate, 2);
        
            switch (opcode) {
                case "100011":
                    return "lw " + registrador2 + ", " + valor + "(" + registrador1 + ")";
                case "101011":
                    return "sw " + registrador2 + ", " + valor + "(" + registrador1 + ")";
                case "001000":
                    return "addi " + registrador2 + ", " + registrador1 + ", " + valor;
                case "001100":
                    return "andi " + registrador2 + ", " + registrador1 + ", " + valor;
                case "001101":
                    return "ori " + registrador2 + ", " + registrador1 + ", " + valor;
                case "001110":
                    return "xori " + registrador2 + ", " + registrador1 + ", " + valor;
                case "000100":
                    return "beq " + registrador1 + ", " + registrador2 + ", " + valor;
                case "000101":
                    return "bne " + registrador1 + ", " + registrador2 + ", " + valor;
                case "000110":
                    return "blez " + registrador1 + ", " + valor;
                case "000111":
                    return "bgtz " + registrador1 + ", " + valor;
                case "001111":
                    return "lui " + registrador2 + ", " + valor;
                case "100000":
                    return "lb " + registrador2 + ", " + valor + "(" + registrador1 + ")";
                case "100001":
                    return "lh " + registrador2 + ", " + valor + "(" + registrador1 + ")";
                case "101000":
                    return "sb " + registrador2 + ", " + valor + "(" + registrador1 + ")";
                case "101001":
                    return "sh " + registrador2 + ", " + valor + "(" + registrador1 + ")";
            }
            return "Instrução não reconhecida";
        }
        
}   
