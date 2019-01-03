package src;
import java.util.*;

public class Interp3 {
    static int PC;
    static int reg0;
    static int reg1;
    static int reg2;
    static int reg3;
    static int reg4;
    static final int r0 = 1111;
    static final int r1 = 2222;
    static final int r2 = 3333;
    static final int r3 = 4444;
    static final int r4 = 5555;
    static Random rand;
    static int instr;
    static boolean run_bit = true;
    static boolean debugging = false;
    static final int CLR = 0;   //set the value in the reg X to 0
    static final int ADDI = 1;  //add the value x to the AC
    static final int ADDM = 2;  //add the value in memory location y to AC
    static final int HALT = 9;  //instruction which halts the processor
    static final int LDI = 111; //load the AC with the value x
    static final int LDM = 222; //load the AC with the value in memory location y
    static final int ST = 777;  //store the value in the AC  in memory location y
    static final int DBG = 888; //turn on debug flag
    static final int NODBG = 999; //turn off debug flag

    public static void interpret(int memory[], int starting_address) {
        PC = starting_address;
        while (run_bit) {
            instr = memory[PC];
            PC += 1;
            execute(instr, memory);
            PC += 2;
            if (debugging) {
                System.out.println("PC = " + PC + ";");
                System.out.println("reg0 = " + reg0 + ";");
                System.out.println("reg1 = " + reg1 + ";");
                System.out.println("reg2 = " + reg2 + ";");
                System.out.println("reg3 = " + reg3 + ";");
                System.out.println("reg4 = " + reg4 + ";");
            }
        }
    }

    private static int get_instr_type(int opcode) {
        return opcode;
    }

    private static void updateReg(int reg, int value){
            switch (reg) {
                case (r0):
                    reg0 = value;
                    break;
                case (r1):
                    reg1 = value;
                    break;
                case (r2):
                    reg2 = value;
                    break;
                case (r3):
                    reg3 = value;
                    break;
                case (r4):
                    reg4 = value;
                    break;
                default:
                    System.out.println("No such register.");
                    break;
            }
    }

    private static void addReg(int reg, int value){
        switch (reg) {
            case (r0):
                reg0 += value;
                break;
            case (r1):
                reg1 += value;
                break;
            case (r2):
                reg2 += value;
                break;
            case (r3):
                reg3 += value;
                break;
            case (r4):
                reg4 += value;
                break;
            default:
                System.out.println("No such register.");
                break;
        }
    }

    private static void execute(int instr, int memory[]) {
        switch (instr) {
            case (CLR):
                updateReg(memory[PC],0);
                break;
            case (DBG):
                debugging = true;
                break;
            case (NODBG):
                debugging = false;
                break;
            case (ADDI):
                addReg(memory[PC],memory[PC+1]);
                break;
            case (ADDM):
                addReg(memory[PC],memory[memory[PC+1]]);
                break;
            case (HALT):
                run_bit = false;
                debugging = false;
                break;
            case (LDI):
                updateReg(memory[PC],memory[PC+1]);
                break;
            case (LDM):
                updateReg(memory[PC],memory[memory[PC+1]]);
                break;
            case (ST):
                updateReg(memory[PC+1],memory[PC]);
                break;
            default:
                System.out.println("unimplemented instruction");
                run_bit = false;
                break;
        }
    }

    public static void main(String[] arg) {
        Interp3 it = new Interp3();
        int m2[] = {9,
                -5,
                CLR,    r0,  0,
                DBG,    0,   0,
                CLR,    r1,  0,
                ADDI,   r0,  17,
                ADDI,   r3,  2,
                ADDM,   r0,  0,
                NODBG,  0,   0,
                ADDM,   r3,  1,
                ST,     1,   r3,
                LDM,    r2,  1,
                CLR,    r4,  0,
                HALT,   0,   0
        };
        it.interpret( m2, 2 );
        /**
        System.out.println("PC = " + PC + ";");
        System.out.println("reg0 = " + reg0 + ";");
        System.out.println("reg1 = " + reg1 + ";");
        System.out.println("reg2 = " + reg2 + ";");
        System.out.println("reg3 = " + reg3 + ";");
        System.out.println("reg4 = " + reg4 + ";");
         */

        int t1[] = {-7,
                12,
                3,
                CLR,    r3,  0,
                DBG,    0,   0,
                ADDI,   r2,  5,
                ADDM,   r2,  0,
                ADDI,   r4,  -7,
                ADDM,   r0,  1,
                ADDM,   r3,  1,
                ST,     1,   r3,
                LDM,    r2,  1,
                LDI,    r3,  2,
                CLR,    r4,  0,
                HALT,   0,   0
        };
        //it.interpret( t1, 3 );

        int t2[] = {3,
                4,
                -9,
                CLR,    r3,  0,
                DBG,    0,   0,
                ST,     11,  r1,
                ADDI,   r1,  8,
                ADDM,   r1,  2,
                ADDI,   r3,  -7,
                ADDM,   r0,  2,
                ADDM,   r3,  1,
                CLR,    r2,  0,
                ST,     155,   r3,
                LDM,    r2,  1,
                LDI,    r3,  0,
                CLR,    r1,  0,
                CLR,    r0,  0,
                CLR,    r2,  0,
                CLR,    r3,  0,
                ST,     777, r4,
                HALT,   0,   0
        };
        //it.interpret( t2, 3 );
    }
}