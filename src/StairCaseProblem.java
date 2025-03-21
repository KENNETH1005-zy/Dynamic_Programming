class StarirCaseProblem {
    public static int stairRec(int n, int[] lookupTable) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (lookupTable[n] > -1)
            return lookupTable[n];
        else {
            lookupTable[n] = stairRec(n - 1, lookupTable) + stairRec(n - 2, lookupTable) + stairRec(n - 3, lookupTable);
            return lookupTable[n];
        }
    }
    public static int stairWays(int n) {
        int [] lookupTable = new int [n+1];
        for (int i = 0; i < n+1; i++){
            lookupTable [i] = -1;
        }
        return stairRec (n, lookupTable);
    }
    public static void main(String args[])
    {
        System.out.println(stairWays(3));
    }

}
