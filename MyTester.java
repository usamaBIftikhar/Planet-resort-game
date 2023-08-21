 
import java.util.*;
/**
 * Write a description of class OTester here.
 * 
 * @author 
 * @version 
 */
public class MyTester 
{   

    private void doTest()
    {
        Resort wayward = new Resort("Wayward Asteroids");
        /*
         * Testing Can Travel Method
         * Checking All Method Can travel From
         * Home to Next Planet
         * Expected Ans: True
         *               False
         */
        System.out.println("Expected: True  | Actual: "+wayward.canTravel(1000,"ABC1"));
        System.out.println("Expected: False | Actual: "+wayward.canTravel(1000,"BCD2"));
        
        /*
         * Moving Pan to next Planet and Then Checking
         * 
         */
        System.out.println("Expected: Happy Journey | Actual: "+wayward.travel(1000,"ABC1"));
        /*
         *Getting Location of permit 1000
         *it should be Sprite
         *Testing getting Permits On One PLanet 
         *Cross Check Ans Should be Same
         */
        System.out.println("Expected: Sprite | Actual: \n"+wayward.getPermitLocation(1000));
        System.out.println("Expected: 1000 | Actual: "+wayward.getAllPermitsOnOnePlanet("Sprite"));
        
        /*
         *Now Checking Credits
         *By Moving low Credit Permit
         */
        System.out.println("Expected: Happy Journey | Actual: "+wayward.travel(1004,"ABC1"));
        
        /*
         * Now Testing
         * Credits Because 1004 Permit
         * Has only 3 Credits
         * Now it becomes 0
         */
        System.out.println("Expected: False | Actual: "+wayward.canTravel(1004,"BCD2"));
        /*
         * Now Testing For Rating
         * on Permit 1005
         */
        System.out.println("Expected: Happy Journey | Actual: "+wayward.travel(1005,"ABC1"));
        System.out.println("Expected: Not-Allowed For Journey | Actual: "+wayward.travel(1005,"CDE3"));
        /*
         * Now Testing if Wrong Shuttle
         * Testing If Wrong Permit
         */
        System.out.println("Expected: Permit-Not Present | Actual: "+wayward.travel(1005,"CSE3"));
        System.out.println("Expected: Shuttle Not Present | Actual: "+wayward.travel(1019,"CSE3"));
        /*
         * Now moving Printing Only Richest Guests
         * and Testing
         */
        System.out.println("Expected: 1002, 1006, 1007, 1008 \n Actual: "+wayward.getRichGuests());
        /*
         * Moving Richest Guest To High Rating Planet
         */
        System.out.println("Expected: True  | Actual: "+wayward.travel(1007,"ABC1"));
        System.out.println("Expected: Sprite | Actual: \n"+wayward.getPermitLocation(1007));
        
        System.out.println("Expected: True  | Actual: "+wayward.travel(1007,"CDE3"));
        System.out.println("Expected: Tropicana | Actual: \n"+wayward.getPermitLocation(1007));
        
        System.out.println("Expected: True  | Actual: "+wayward.travel(1007,"JKL8"));
        System.out.println("Expected: Fantasia | Actual: \n"+wayward.getPermitLocation(1007));
        
        System.out.println("Expected: True  | Actual: "+wayward.travel(1007,"EFG5"));
        System.out.println("Expected: Sprite | Actual: \n"+wayward.getPermitLocation(1007));
        
        System.out.println("Expected: True  | Actual: "+wayward.travel(1007,"GHJ6"));
        System.out.println("Expected: Solo | Actual: \n"+wayward.getPermitLocation(1007));
        
        System.out.println("Expected: True  | Actual: "+wayward.travel(1007,"HJK7"));
        System.out.println("Expected: Sprite | Actual: \n"+wayward.getPermitLocation(1007));
        
        System.out.println("Expected: False  | Actual: "+wayward.travel(1007,"BCD2"));
        System.out.println("Expected: Sprite | Actual: \n"+wayward.getPermitLocation(1007));
        
    }
     
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest();
    }
}
