import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CountPairsWithDiffK {
    private static final int mod = 1000000007;
    public int countPairs(int [] nums, int k){
        int n = nums.length;
        int [] dp = new int[n+1];
        Arrays.sort(nums);
        Arrays.fill(dp,-1);
        return recursive(0,nums,k,dp);
    }
    private int recursive(int ind, int [] nums, int k, int [] dp){
        //1. Start with base condition check
        if(ind == nums.length ){
            return 1;
        }
        //2. Check cache
        if(dp[ind] != -1){
            return dp[ind];
        }

        long ways = 0;

        for(int j = ind;j < nums.length;j++){

            if(nums[j] - nums[ind] <= k){
                ways = (ways + recursive(j + 1, nums, k, dp)) % mod;
            }else{
                break;
            }
        }
        return dp[ind] = (int)ways;
    }

    public int optimizedSolution(int [] nums, int k){
        int MOD = (int) 1e9 + 7, n = nums.length, left = 0;
        int[] dp = new int[n + 1], prefix = new int[n + 2];

        dp[0] = 1; prefix[1] = 1;

        Deque<Integer> min = new ArrayDeque<>(), max = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[i]) {
                max.pollLast();
            }
            max.addLast(i);

            while (!min.isEmpty() && nums[min.peekLast()] >= nums[i]) {
                min.pollLast();
            }
            min.addLast(i);

            while (nums[max.peekFirst()] - nums[min.peekFirst()] > k) {
                if (max.peekFirst() == left) max.pollFirst();
                if (min.peekFirst() == left) min.pollFirst();

                left++;
            }

            dp[i + 1] = (prefix[i + 1] - prefix[left] + MOD) % MOD;

            prefix[i + 2] = (prefix[i + 1] + dp[i + 1]) % MOD;
        }

        return dp[n];
    }
    static void main(String [] args){
        CountPairsWithDiffK object = new CountPairsWithDiffK();
        int [] arr = {3,3,4};
        int k = 0;
        int res = object.countPairs(arr,k);
        int res2 = object.optimizedSolution(arr,k);
        System.out.println(res);
        System.out.println(res2);
    }
}
