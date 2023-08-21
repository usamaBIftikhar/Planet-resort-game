 
/**
 * A Permit has an id number, name, a luxury rating and number of credits.
 * 
 * @author 
 * @version
 */
public class Permit 
{
    private int id;
    private String guestName;
    private int luxuaryRating;
    private int credits;
    
    public Permit(int id, String guestName, int luxuaryRating, int credits){
        this.id =  id;
        this.guestName = guestName;
        this.luxuaryRating = luxuaryRating;
        this.credits = credits;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getGuestName(){
        return this.guestName;
    }
    
    public int getLuxuaryRating(){
        return this.luxuaryRating;
    }
    
    public int getCredits(){
        return this.credits;
    }
    
    public void addCredits(int c){
        this.credits+=c;
    }
    
    public void deductCredits(int c){
        this.credits-=c;
    }
    
    public boolean enoughCredits(){
        return this.credits>=WISH.CREDITS_FOR_JOURNEY;
    }
    
    @Override
    public String toString(){
        return "Permit: ["+this.id+","+this.guestName+","+this.luxuaryRating+","+this.credits+"]";
    }
}

