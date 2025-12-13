import java.util.Arrays;

public class BatteryProblem {
    public long getTime(int n,int [] batteries){
        long totalBatteries = 0;
        for(int battery : batteries){
            totalBatteries += battery;
        }
        Arrays.sort(batteries);
        for(int i = batteries.length - 1; i >= 0;i--){
            if(batteries[i] > totalBatteries / n){
                totalBatteries -= batteries[i];
                n--;
            }else{
                break;
            }
        }
        return totalBatteries/n;
    }

    static void main(String [] args){
        int [] arr = {3,3,3};
        BatteryProblem bp = new BatteryProblem();
        long ans = bp.getTime(2,arr);
        System.out.println(ans);
    }
}
