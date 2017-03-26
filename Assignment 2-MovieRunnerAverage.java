
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerAverage {
    public void printAverageRatings(){
        SecondRatings sr = new SecondRatings("ratedmoviesfull","ratings");
        System.out.println("The number of movies is "+sr.getMovieSize());
        System.out.println("The number of raters is "+sr.getRaterSize());
        ArrayList<Rating> temp = sr.getAverageByID(20);
        Collections.sort(temp, new Comparator<Rating>(){
            @Override
            public int compare(Rating r1, Rating r2){
                return r1.compareTo(r2);
            }
           }
        );
        for(int i=0; i<temp.size(); i++){
            System.out.println("The movie with name of "+sr.getTitle(temp.get(i).getItem())
            +", the average rating is "+ temp.get(i).getValue());
        }
    }
    public void getAverageRatingOneMovie(){
        SecondRatings sr = new SecondRatings("ratedmoviesfull","ratings");

        ArrayList<Rating> temp = sr.getAverageByID(0);
        for(int i=0; i<temp.size(); i++){
            if(temp.get(i).getItem().equals(sr.getID("Vacation"))){
                System.out.println("The average for the movie is "+temp.get(i).getValue());
            }
        }
    }
}
