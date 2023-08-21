 
/**
 * A shuttle provides a one-way connection between two planets. It
 * has a Shuttle code and information about both the source and
 * the destination planet
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuttle
{
    private Planet source;
    private Planet destination;
    private String journeyCode;
    
    public Shuttle(Planet s, Planet d, String j){
        this.source = s;
        this.destination = d;
        this.journeyCode = j;
    }
    
    public Planet getSource(){
        return this.source;
    }
    
    public Planet getDestination(){
        return this.destination;
    }
    
    public String getJourneyCode(){
        return this.journeyCode;
    }
    
    public boolean isAllowed(Permit p){
        boolean planetTest = destination.checkCapacity()&& source.findPermit(p.getId());
        boolean permitTest = destination.getRating() <= p.getLuxuaryRating()  && p.enoughCredits();
        return  planetTest && permitTest;
    }
    
    public String startJourney(Permit p){
        if(isAllowed(p)){
            source.leave(p);
            destination.enter(p);
            p.deductCredits(WISH.CREDITS_FOR_JOURNEY);
            return "Happy Journey";
        }
        return "Not-Allowed For Journey";
    }
    
    
    
    @Override
    public String toString(){
        return  "Journey-Code:\t\t"+this.journeyCode+"\n"+
                "Source:\t\t"+source.getBriefDetail()+"\n"+
                "Destination:\t\t"+destination.getBriefDetail()+"\n";
    }
    
    
}
