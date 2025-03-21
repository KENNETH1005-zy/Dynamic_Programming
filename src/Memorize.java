class Memorize {
    public static int fib(int n, int[] lookupTable) {
        if (lookupTable [n] == -1) {
            if (n <= 1)
                lookupTable[n] = n;
            else
                lookupTable[n] = fib(n-1, lookupTable) + fib(n-2, lookupTable);
        }
        return lookupTable[n];
    }
    public static void main(String args[]) {
        int n = 6;
        int[] lookupTable = new int[n+1];
        for (int i = 0; i < n+1 ; i++) {
            lookupTable[i] = -1;
        }
        System.out.println(fib(n,lookupTable));
    }
}