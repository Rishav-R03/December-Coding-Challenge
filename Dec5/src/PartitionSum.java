public class PartitionSum {
    public static int partitions(int [] nums){
        int totalSum =0, n = nums.length;
        for(int num : nums){
            totalSum += num;
        }
        return totalSum % 2 == 0 ? n-1 : 0;
    }
}
