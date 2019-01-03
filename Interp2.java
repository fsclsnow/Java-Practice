public class Interp2 {
    static int PC;
    static int AC;
    static int instr;
    static int instr_type;
    static int data_loc;
    static int data;
    static boolean run_bit = true;
    static boolean debugging = true;
    static final int CLR = 0;   //set the value in the AC to 0
    static final int ADDI = 1;  //add the value x to the AC
    static final int ADDM = 2;  //add the value in memory location y to AC
    static final int HALT = 9;  //instruction which halts the processor
    static final int LDI = 111; //load the AC with the value x
    static final int LDM = 222; //load the AC with the value in memory location y
    static final int ST = 777;  //store the value in the AC  in memory location y

    public static void interpret (int memory[], int starting_address){
        PC = starting_address;
        while (run_bit) {
            instr = memory[PC];
            PC += 1;
            instr_type = get_instr_type(instr);
            data_loc = find_data(instr, instr_type,memory);
            if (data_loc>=0) {
                data = memory[data_loc];
            }
            execute(instr_type, data, memory);
            PC+=1;
            if (debugging){
                System.out.println("PC = " + PC + ";");
                System.out.println("AC = " + AC + ";");
            }
        }
    }

    public void setDebug (){
        debugging = true;
    }

    public void cancelDubug() {
        debugging = false;
    }

    private static int get_instr_type(int opcode){
        return opcode;
    }

    private static int find_data(int opcode, int type, int memory[]){
        if (type == 0){return -1;}
        else if (type == 1){return PC;}
        else if (type == 2) {return memory[PC];}
        else if (type == 111){return PC;}
        else if (type == 222) {return memory[PC];}
        else if (type == 777) {return PC;}
        else {return -1;}
    }

    private static void execute (int type, int data, int memory[]){
        switch(type) {
            case (CLR):
                AC = 0;
                break;
            case (ADDI):
            case (ADDM):
                AC += data;
                break;
            case (HALT):
                run_bit = false;
                debugging = false;
                break;
            case (LDI):
                AC = data;
                break;
            case (LDM):
                AC = data;
                break;
            case (ST):
                memory[data] = AC;
                break;
            default:
                System.out.println("unimplemented insturction");
                run_bit=false;
                break;
        }
    }

    public static void main (String[] arg) {
        Interp2 it = new Interp2();
        int m2[] = {  2,
                -5,
                15,
                CLR,        //"program" starts here
                ADDI,  12,
                ADDI,   7,
                ADDM,   0,
                ADDM,   1,
                CLR,
                HALT
        };
        //it.setDebug();
        //it.interpret( m2, 3 );

        System.out.println();

        int  m3[] = {  9,
                -5,
                CLR,    0,
                ADDI,  17,
                ADDI,   2,
                ST,     0,
                ADDM,   0,
                ADDM,   1,
                CLR,    0,
                HALT,   0
        };
        it.setDebug();
        it.interpret( m3, 2 );

        int t1[] = { 3,
                -7,
                6,
                CLR,     0,
                LDI,    10,
                ADDM,    0,
                ADDI,   -4,
                ST,      2,
                CLR,     0,
                LDM,     2,
                ADDM,    1,
                CLR,     0,
                HALT,    0,
        };
        //it.setDebug();
        //it.interpret( t1, 3 );

        int t2[] = { -3,
                12,
                CLR,     0,
                ADDI,    -5,
                ADDM,    0,
                ST,      1,
                LDM,     0,
                LDI,     9,
                ADDM,    1,
                CLR,     0,
                HALT,    0,
        };
        //it.setDebug();
        //it.interpret( t2, 2 );
    }
}


