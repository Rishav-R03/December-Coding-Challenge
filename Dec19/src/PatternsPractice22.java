import java.util.Scanner;

public class PatternsPractice22 {
    /**
     * ****
     * ****
     * ****
     * ****
     */
    //1. Outer loop counts the number of lines.
    //2. Inner loop focus on the column and connect them some how to the rows.
    //3. Whatever printing, print them inside loop
    //4. (Optional) Observe symmetry.
    static Scanner sc = new Scanner(System.in);
    static void squarePatterns(){
        //Outer loop
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            //Inner loop focus on column and connect to outer loop
            //At every line we are trying to print n stars.
            for(int j = 0;j<n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Pattern 2
    static void stairCasePattern(){
        int n = sc.nextInt();
        //1. Outer loop for number of lines
        for(int i = 0;i<n;i++){
            for(int j = 0;j < i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Pattern 3: Numbered pattern
    static void numberedPattern(){
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(" " +j);
            }
            System.out.println();
        }
    }
    // Pattern 4: Inverted staircase
    static void invertedStairCase(){
        int n =  sc.nextInt();
        for(int i = 0;i<n;i++){
            for(int j = n-i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // Pattern 5: NumberedInvertedStairCase
    static void numberedInvertedStairCase(){
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<= n-i+1;j++){
                System.out.print(" "+j);
            }
            System.out.println();
        }
    }

//    Pattern 6: Row wise colum
    static void rowWiseCol(){
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
//    Pattern 7: Triangle
    static void trianglePattern(){
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++){
            //Inner loop to print white space
            //The number of spaces decreases as the row number increases.
            for(int space = 1; space <= n-i;space++){
                System.out.print(" ");
            }
            //Inner loop to print stars
            for(int j = 1;j <= 2 * i - 1;j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
    static void main(String [] args){
//        squarePatterns();
//        stairCasePattern();
//            numberedPattern();
//            invertedStairCase();
//            rowWiseCol();
//            numberedInvertedStairCase();
        int t = sc.nextInt();
        for(int i = 0;i<t;i++){
            int testCase = i+1;
            System.out.println("Test case " + testCase);
            trianglePattern();
            System.out.println();
        }
    }
}
