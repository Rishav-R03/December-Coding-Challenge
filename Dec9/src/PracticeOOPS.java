class GreatGrandFather{
    int netWorthOne = 100;
    public GreatGrandFather(){
        System.out.println("I am Great Grant Father with net worth" + netWorthOne);
    }
}
class GrandFather extends GreatGrandFather{
    int netWorthTwo = 500;
    public GrandFather(){
        System.out.println("I am Grand Father with net worth" + netWorthTwo);
    }
}

class Father extends GrandFather{
    int netWorthThree = 1000;
    public Father(){
        System.out.println("I am Father with net worth" + netWorthThree);
    }
}

class Son extends Father{
    int netWorthFour = 2000;
    public Son(){
        System.out.println("I am son with net worth" + netWorthFour);
    }
}
public class PracticeOOPS {
    public static void main(String [] args){
        Son son1 = new Son();
        System.out.println(son1.netWorthFour);
    }
}
