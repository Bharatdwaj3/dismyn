import java.util.ArrayList;
import java.util.List;

public class Yun {
    public static boolean foo(List<Integer> bills){
        int five=0;
        int ten=0;
        for(int i=0;i<bills.size();i++){
            if(bills.get(i)==5){
                five++;
            }else if(bills.get(i)==10){
                if(five>0){
                    five--;
                    ten++;
                }else
                    return false;
            }else{
                if(five > 0&& ten > 0){
                    five--;
                    ten--;
                }else if(five>=3){
                    five -=3;
                }else
                    return false;
            }
        }
        return false;
    }
    public static void main(String[] args){
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(5);
        bills.add(5);
        bills.add(10);
        bills.add(20);

        System.out.println("Queues of customers: ");
        for(int bill : bills){
            System.out.println(bill+ " ");
        }
        System.out.println();
        boolean ans = foo(bills);
        if(ans)
            System.out.print("It's possible to change change for all customers!!");
        else
            System.out.println("It's not possible to provide change for all customers!!");
        } 

}
