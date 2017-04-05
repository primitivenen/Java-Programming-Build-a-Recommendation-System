
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    public ThirdRatings(String ratingsfile){
        FirstRatings fr = new FirstRatings();
        myRaters=fr.loadRaters(ratingsfile);
    }
 
    public int getRaterSize(){
        return myRaters.size();
    }
    private double getAverageByID(String id, int minimalRaters){
        int sum=0, count=0;
        //System.out.println("The size of myraters is "+myRaters.size());
        for(int i=0; i<myRaters.size(); i++){
            if(myRaters.get(i).hasRating(id)){
                double value = myRaters.get(i).getRating(id);
                //System.out.println("The value is "+value+" for Raters "+i);
                if(value!=-1){
                    count++;
                    sum+=value;
                }
            }
        }
        if(count>=minimalRaters){
            return (double)sum/count;
        }
        return -1;
    }
    public ArrayList<Rating> getAverageByID(int minimalRaters){
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> res = new ArrayList<Rating>();
        for (String id: movies) {
            double temp = getAverageByID(id, minimalRaters);
            if(temp!=-1){
                Rating rt = new Rating(id, temp);
                res.add(rt);
            }
        }
        return res;
    }
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria){
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> res = new ArrayList<Rating>();
        for (String id: movies) {
            double temp = getAverageByID(id, minimalRaters);
            if(temp!=-1){
                Rating rt = new Rating(id, temp);
                res.add(rt);
            }
        }
        return res;        
    }
}
