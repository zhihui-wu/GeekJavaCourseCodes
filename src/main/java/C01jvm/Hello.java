package C01jvm;

public class Hello {
    public static void main(String[] args) {
        int i = 10;
        int j = 4;
        int iaj = i + j;
        int imj = i * j;
        double idj = i / (float)j;
        if (i > j) {
            i = i + j;
        }
        int total = 0;
        for (int x = 0; x < 5; x++) {
            total += x;
        }
    }
}