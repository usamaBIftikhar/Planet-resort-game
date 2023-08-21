 
import java.util.*;
/**
 * An planet is part of a STAR resort.Each planet has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(permits) who can be on the  
 * planet at any one time. Each planet must maintain a list of all people (permits)
 * currently on the planet. These lists are updated whenever permits enter or leave 
 * an planet,so that it is always possible to say how many people (permits) are on the planet 
 * and who they are.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Planet 
{
    private String name;
    private int rating;
    private int capacity;
    private ArrayList<Permit> permits;
    
    public Planet(String name, int rating, int capacity){
        this.name = name;
        this.rating = rating;
        this.capacity = capacity;
        permits = new ArrayList<>();
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getRating(){
        return this.rating;
    }
    
    public int getCapacity(){
        return this.capacity;
    }
    
    public void enter(Permit p){
        permits.add(p);
    }
    
    public boolean leave(Permit p){
        int pos=-1;
        for(int i=0;  i< permits.size() ; i++){
            if(permits.get(i).getId()==p.getId()){
                pos= i;
            }
        }
    
        if(pos<0){
            return false;
        }
        permits.remove(pos);
        return true;
    }
    
    public boolean checkCapacity(){
        return this.capacity>=permits.size();
    }
    
    public Permit getPermit(int id){
        for(Permit p: permits){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }
    
    public boolean findPermit(int id){
        for(Permit p: permits){
            if(p.getId()==id){
                return true;
            }
        }
        return false;
    }
    
    public String allPermits(){
        String list="";
        for(Permit p: permits){
            list+="\n"+p.toString();
        }
        return list;
    }
    
    public String getBriefDetail(){
        return "["+this.getName()+","+this.getRating()+","+this.getCapacity()+"]";
    }
    
    @Override
    public String toString(){
        return "Planet:\n"+
                "Name:\t\t"+this.name+"\n"+
                "Rating:\t\t"+this.rating+"\n"+
                "Capacity:\t"+this.capacity+"\n"+
                "List:\n"+allPermits();
    }
}
