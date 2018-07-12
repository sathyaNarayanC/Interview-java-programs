public class LargestArrSum
{
    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                                       maxSubArraySum(a));
    }
 
    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int maxNow = Integer.MIN_VALUE, maxEnds = 0;
 
        for (int i = 0; i < size; i++)
        {
            maxEnds = maxEnds + a[i];
            if (maxNow < maxEnds)
                maxNow = maxEnds;
            if (maxEnds < 0)
                maxEnds = 0;
        }
        return maxNow;
    }
}
