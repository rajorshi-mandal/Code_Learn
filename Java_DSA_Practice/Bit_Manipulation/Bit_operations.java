package Bit_Manipulation;

public class Bit_operations {

    public static int getIthBit(int n, int i){
        if((n & (1 << i)) != 0){
            return 1;
        }
        return 0;
    }

    public static int setIthBit(int n, int i){
        System.out.println("given bit : " + n);;

        return (n | (1 << i));
    }

    public static int clearIthBit(int n, int i){
        System.out.println("given input : " + n);

        return (n & (~(1 << i)));
    }

    public static int updateIthBit(int n, int i, int newBit){
        System.out.println("given num : " + n + ", given new bit : " + newBit);

        //method 1
        // if(newBit == 0){
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        //method 2
        int temp = clearIthBit(n, i);
        int bitMask = newBit << i;
        return temp | bitMask;
    }

    public static int clearIBits(int n, int i){
        //int bitMask = (~0) << i;
        return (n & ((~0) << i));
    }

    public static int clearRangeBits(int n, int l, int r){
        System.out.println("given input : " + n);

        int a = (~0) << ( l + 1 );
        int b = (1 << r) - 1;  // 2^r - 1 == 1 << r

        int bitMask = a | b;

        return n & bitMask;
    }

    public static boolean evenCheck(int n){
        if((n & (n - 1)) == 0){
            return true;
        }
        return false;
    }

    public static int countSetBits(int n){
        int count = 0;

        while(n > 0){
            if((n & 1) == 1) {
                count++;
            }
            n = n >> 1; //taking the next bit for LSB
        }

        return count;
    }

    public static int fastExponentiation(int a, int n){
        //help link - https://youtu.be/US1_VVD98Vw
        int ans = 1;

        while(n > 0){
            if((n & 1) != 0){
                ans *= a;
            }
            a *= a; // 2^3.2 = 2^4 -> getting next part to multiply
            n = n >> 1;
        }

        return ans;
    }

    public static int addIntNoOp(int n){
        return -~n;
    }

    public static void swap(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("a = " + a + ", b = " + b);
    }

    public static void upperToLower(){
        for( char ch = 'A'; ch <= 'Z'; ch++){
            System.out.print((char)(ch | ' '));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // System.out.println(getIthBit(1101, 1));
        
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(14, 2));
        // System.out.println(updateIthBit(26, 1, 0));
        // System.out.println(clearIBits(31, 2));
        // System.out.println(4 << 2);
        // System.out.println(clearRangeBits(31, 2, 1));
        // System.out.println(evenCheck(13));
        // System.out.println(countSetBits(15));
        // System.out.println(addIntNoOp(5));
        // swap(4, 6);
        upperToLower();
    }
}
