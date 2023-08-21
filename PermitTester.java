
/**
 * This class is intended to Test Permit Class
 * @author
 * @version
 */
public class PermitTester
{
    
    /**
     * doTest is only for testing Permit Class Objects
     */
    public void doTest(){
        /*
         * These Method Only For Testing
         */
        Permit p1 = new Permit(100, "J1", 3, 20);
        Permit p2 = new Permit(101, "J2", 4, 50);
        
        /*
         * Checking Credits
         */
        System.out.println("Expected: 20 | Actual: "+p1.getCredits());
        /*
         * Adding credits in p1
         * Deducting Credits from p2
         */
        p1.addCredits(5);
        p2.deductCredits(7);
        /*
         * Now After Deducting And Adding
         * Checking Credits
         */
        System.out.println("Expected: 25 | Actual: "+p1.getCredits());
        System.out.println("Expected: 43 | Actual: "+p2.getCredits());
        /*
         * Printing Name
         */
        System.out.println("Expected: J1 | Actual: "+p1.getGuestName());
        System.out.println("Expected: J2 | Actual: "+p2.getGuestName());
        /*
         * Deducting again and testing Enough Credit Method
         */
        p1.deductCredits(20);
        p2.deductCredits(43);
        /*
         * Enough Credit for Journey
         */
        System.out.println("Expected: True  | Actual: "+p1.enoughCredits());
        System.out.println("Expected: False | Actual: "+p2.enoughCredits());
        /*
         * Testing To String Method
         */
        System.out.println(p1);
        System.out.println(p2);
    }
    
    /*
     * Main Method
     */
    public static void main(String[] arg){
        PermitTester pt = new PermitTester();
        pt.doTest();
    }
}
