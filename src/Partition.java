class Partition
{
    public static int canPartitionRecursive(int[][]lookupTable, int num[], int sum, int currentIndex)
    {
        int numLength = num.length;
        // base check
        if (sum == 0)
            return 1;
        if (numLength == 0 || currentIndex >= numLength)
            return 0;

        // if we have not already processed a similar problem
        if (lookupTable[currentIndex][sum] == -1) {
            // recursive call after choosing the number at the currentIndex
            // if the number at currentIndex exceeds the sum, we shouldn't process this
            if (num[currentIndex] <= sum)
            {
                if (canPartitionRecursive(lookupTable, num, sum - num[currentIndex], currentIndex + 1) == 1) {
                    lookupTable[currentIndex][sum] = 1;
                    return 1;
                }
            }
            // recursive call after excluding the number at the currentIndex
            lookupTable[currentIndex][sum] = (int)canPartitionRecursive(lookupTable, num, sum, currentIndex + 1);
        }
        return lookupTable[currentIndex][sum];
    }

    public static int canPartition(int[] num)
    {
        int numLength = num.length;
        int sum = 0;
        for (int i = 0; i < numLength; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0)
            return 0;

        int [][] lookupTable = new int [numLength][];
        for (int i = 0; i < numLength; i++)
        {
            lookupTable[i] = new int[sum / 2 + 1];

            for (int j = 0; j < sum / 2 + 1; j++)
                lookupTable[i][j] = -1;
        }
        return canPartitionRecursive(lookupTable, num, sum / 2, 0);
    }

    public static void main(String args[])
    {
        int set1[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(set1) + "\t--->\t" + canPartition(set1));
        int set2[] = {1, 1, 3, 4, 7};
        System.out.println(Arrays.toString(set2) + "\t--->\t" + canPartition(set2));
        int set3[] = {2, 3, 4, 6};
        System.out.println(Arrays.toString(set3) + "\t--->\t" + canPartition(set3));
    }
};