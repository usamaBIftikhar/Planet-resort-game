 

import java.util.*;

/**This class implements the WISH interface
 *
 * @author 
 * @version 
 **/
public class Resort implements WISH
{
    private ArrayList<Permit> permits;
    private ArrayList<Planet> planets;
    private ArrayList<Shuttle> shuttles;
    /** constructor
     */
    public Resort(String loc) 
    {
        planets = new ArrayList<>();
        permits = new ArrayList<>();
        shuttles = new ArrayList<>();
        planets.add(new Planet(loc, 0, 100));
        loadPlanets();
        loadPermits();
        setUpShuttles();
        evacuateAll(loc);
    }
    
    /**
     * Returns all of the details of all planets including the permits
     * currently on each planet, on "No permits"
     * @return all of the details of all planets including location 
     * and all permits currently on each planet, or "No permits" 
     */
    public String toString()
    {
        return getAllPermitsOnEachPlanet();
    }
    
    /**Returns a String with details of a permit
     * @param permitId - id number of the permit
     * @return the details of the permit as a String, or "No such permit"
     */
    public String getPermitDetails(int permitId)
    {
        return getPermit(permitId).toString();
    }

    
    /**
     * Move All the Permits to Given Location
     * @param loc - location of Planet 
     */
    public void evacuateAll(String loc){
        for(Permit p: permits){
            moveHome(loc, p.getId());
        }
    }
    
    /**
     * @param loc - location of planet
     * @param p   - permit
     * Move permit p to location loc
     */
    public void moveHome(String loc, int p){
        getPlanet(loc).enter(getPermit(p));
    }
    
    /**
     * @return String details of all permits Rating > 5
     */
    public String getRichGuests(){
        String details="";
        for(Permit p: permits){
            if(p.getLuxuaryRating()>5){
                details+=p.toString();
            }
        }
        return details.isBlank() ? "No, Rich Guest": details;
    }
    
    /** Given the name of a planet, returns the planet id number
     * or -1 if planet does not exist
     * @param name of planet
     * @return id number of planet
     */
    public int getPlanetNumber(String ww)
    {
        int x = planets.indexOf(getPlanet(ww));
        return x>=0 ? x : -1;
    }
    
    /**Returns a String representation of all the permits on all planets
     * @return a String representation of all permits on all planets
     **/
    public String getAllPermitsOnEachPlanet()
    {
        String details = "";
        for(Planet p: planets){
            details+=p.toString();
        }
        return details;
    } 
 
    
    /**Returns the name of the planet which contains the specified permit or null
     * @param tr - the specified permit
     * @return the name of the Planet which contains the permit, or null
     **/
    public String getPermitLocation(int tr)
    {
        for(Planet p: planets){
            if(p.findPermit(tr)){
                return p.getName();
            }
        }
        return null;
    }
    
               
    /**Returns a String representation of all the permits on specified planet
     * @return a String representation of all permits on specified planet
     **/
    public String getAllPermitsOnOnePlanet(String planet)
    {
        if(getPlanet(planet)!=null){
            return getPlanet(planet).toString();
        }
        return null;
    } 

    
     /**Returns true if a Permit is allowed to move using the shuttle, false otherwise
      * A move can be made if:  
      * the rating of the permit  >= the rating of the destination planet
      * AND the destination planet is not full
      * AND the permit has sufficient credits
      * AND the permit is currently on the source planet
      * AND the permit id is for a permit on the system
      * AND the shuttle code is the code for a shuttle on the system
      * @param pId is the id of the permit requesting the move
      * @param shtlCode is the code of the shuttle journey by which the permit wants to pPermitel
      * @return true if the permit is allowed on the shuttle journey, false otherwise 
      **/
    public boolean canTravel(int pId, String shtlCode)
    {   //other checks optional
         if(getShuttle(shtlCode).isAllowed(getPermit(pId)) && getShuttle(shtlCode).getSource().getName().equals(getPermitLocation(pId))){
             return true;
         }
         return false;

    }     

    /**Returns the result of a permit requesting to move by Shuttle.
     * A move will be successful if:  
     * the luxury rating of the permit  >= the luxury rating of the destination planet
     * AND the destination planet is not full
     * AND the permit has sufficient credits
     * AND the permit is currently on the source planet
     * AND the permit id is for a permit on the system
     * AND the shuttle code is the code for a shuttle on the system
     * If the shuttle journey can be made, the permit information is removed from the source
     * planet, added to the destination planet and a suitable message returned.
     * If shuttle journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param ppId is the id of the permit requesting the move
     * @param shtlCode is the code of the shuttle journey by which the permit wants to pPermitel
     * @return a String giving the result of the request 
     **/
    public String travel(int ppId, String shtlCode )
    {   //other checks optional
        if(getPermit(ppId)==null){
            return "Permit-Not Present";
        }
        
        if(getShuttle(shtlCode)==null){
            return "Shuttle Not Present";
        }
        
        if(canTravel(ppId, shtlCode)){
            return getShuttle(shtlCode).startJourney(getPermit(ppId));
        }
        return "Not-Allowed For Journey";
    } 
         
    // These methods are for Task 6 only and not required for the Demonstration 
    // If you choose to implement them, uncomment the following code
    

    /** Allows a permit to top up their credits.This method is not concerned with 
     *  the cost of a credit as currency and prices may vary between resorts.
     *  @param id the id of the permit toping up their credits
     *  @param creds the number of credits purchased to be added to permits information
     */
    public void topUpCredits(int id, int creds)
    {
        getPermit(id).addCredits(creds);
    }
   
    //***************private methods**************
    private void loadPlanets()
    {
     planets.add(new Planet("Sprite",1,100));
     planets.add(new Planet("Tropicana", 3, 10));
     planets.add(new Planet("Fantasia", 5, 2));
     planets.add(new Planet("Solo", 1, 1));
    }
    
    private void setUpShuttles()
    {
        shuttles.add(new Shuttle(planets.get(0), planets.get(1), "ABC1"));
        shuttles.add(new Shuttle(planets.get(1), planets.get(0), "BCD2"));
        shuttles.add(new Shuttle(planets.get(1), planets.get(2), "CDE3"));
        shuttles.add(new Shuttle(planets.get(2), planets.get(1), "DEF4"));
        shuttles.add(new Shuttle(planets.get(2), planets.get(3), "JKL8"));
        shuttles.add(new Shuttle(planets.get(3), planets.get(1), "EFG5"));
        shuttles.add(new Shuttle(planets.get(1), planets.get(4), "GHJ6"));
        shuttles.add(new Shuttle(planets.get(4), planets.get(1), "HJK7"));
    }
    
    private void loadPermits()
    {
        permits.add(new Permit(1000,"Lynn", 5, 10));
        permits.add(new Permit(1001,"May", 3, 20));
        permits.add(new Permit(1002,"Nils", 10, 20));
        permits.add(new Permit(1003,"Olek", 2, 12));
        permits.add(new Permit(1004,"Pan", 3, 3));
        permits.add(new Permit(1005,"Quin", 1, 5));
        permits.add(new Permit(1006,"Raj", 10, 6));
        permits.add(new Permit(1007,"Sol", 7, 20));
        permits.add(new Permit(1008,"Tel", 6, 24));
    }
 
    /** Returns the permit with the permit id specified by the parameter
     * @return the permit with the specified name
     **/
    public Permit getPermit(int id)
    {
        for(Permit p: permits){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }
    
    
    /** Returns the planet with the name specified by the parameter
     * @return the planet with the specified name
     **/
    private Planet getPlanet(String planetName)
    {
        for(Planet plan: planets){
            if(plan.getName().equalsIgnoreCase(planetName)){
                return plan;
            }
        }
        return null;
    }
    
    /** Returns the planet with the name specified by the parameter
     * @return the planet with the specified name
     **/
    private Shuttle getShuttle(String shut)
    {
        for(Shuttle shutt: shuttles){
            if(shutt.getJourneyCode().equalsIgnoreCase(shut)){
                return shutt;
            }
        }
        return null;
    }
}