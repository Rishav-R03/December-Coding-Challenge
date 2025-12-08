public class PythaTriplets {
    public static int countTriplets(int n){
        int count = 0;
        for(int a = 1;a<=n;a++){
            for(int b = 1;b<=n;b++){
                int c = (int) Math.sqrt(a*a + b * b);
                if(c <= n && c * c == (a*a + b * b)){
                    count++;
                }
            }
        }
        return count;
    }
    static void main(String []args){
        int ans = countTriplets(5);
        System.out.println(ans);
    }
}
