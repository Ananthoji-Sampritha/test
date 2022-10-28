import java.util.Scanner;
//minimum cost required to make all the array elements equal by replacing ith number by m where
// cost=abs(m-arr[i])
public class Equal{
    public static int computeCost(int[] arr, int N,
                                  int X)
    {
        int cost = 0;
        for (int i = 0; i < N; i++)
            cost += Math.abs(arr[i] - X);
        return cost;
    }
    public static int minCostToMakeElementEqual(int[] arr,int N)
    {
        int low, high;
        low = high = arr[0];
        for (int i = 0; i < N; i++) {
            if (low > arr[i])
                low = arr[i];
            if (high < arr[i])
                high = arr[i];
        }
        while ((high - low) > 2) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            int cost1 = computeCost(arr, N, mid1);
            int cost2 = computeCost(arr, N, mid2);
            if (cost1 < cost2)
                high = mid2;
            else
                low = mid1;
        }
        return computeCost(arr, N, (low + high) / 2);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=sc.nextInt();
            }
            System.out.println(minCostToMakeElementEqual(arr, n));
        }

    }
}
