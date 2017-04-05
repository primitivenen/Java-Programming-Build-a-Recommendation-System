
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class MovieRunnerWithFilters {
    public void printAverageRatings(){
        ThirdRatings sr = new ThirdRatings("ratings");
        System.out.println("The number of raters is "+sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("The number of movies in the database is"+MovieDatabase.size());
        
        ArrayList<Rating> temp = sr.getAverageByID(35);
        System.out.println("The number of movies with rating returned is "+temp.size());
        Collections.sort(temp, new Comparator<Rating>(){
            @Override
            public int compare(Rating r1, Rating r2){
                return r1.compareTo(r2);
            }
           }
        );
        for(int i=0; i<temp.size(); i++){
            System.out.println("The movie with name of "+MovieDatabase.getTitle(temp.get(i).getItem())
            +", the average rating is "+ temp.get(i).getValue());
        }
    }
    public void printAverageRatingsByYear(){
        ThirdRatings sr = new ThirdRatings("ratings");
        System.out.println("The number of raters is "+sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("The number of movies in the database is"+MovieDatabase.size());
   
        Filter f = new YearAfterFilter(2000);
        ArrayList<Rating> temp = sr.getAverageRatingsByFilter(20,f);
        System.out.println("The number of movies with rating returned is "+temp.size());
        Collections.sort(temp, new Comparator<Rating>(){
            @Override
            public int compare(Rating r1, Rating r2){
                return r1.compareTo(r2);
            }
           }
        );
        for(int i=0; i<temp.size(); i++){
            System.out.println("The movie with name of "+MovieDatabase.getTitle(temp.get(i).getItem())
            +", the average rating is "+ temp.get(i).getValue()+" in year "+MovieDatabase.getYear(temp.get(i).getItem()));
        }
    }
    public void printAverageRatingsByGenre(){        
        ThirdRatings sr = new ThirdRatings("ratings");
        System.out.println("The number of raters is "+sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("The number of movies in the database is"+MovieDatabase.size());
   
        Filter f = new GenreFilter("Comedy");
        ArrayList<Rating> temp = sr.getAverageRatingsByFilter(20,f);
        System.out.println("The number of movies with rating returned is "+temp.size());
        Collections.sort(temp, new Comparator<Rating>(){
            @Override
            public int compare(Rating r1, Rating r2){
                return r1.compareTo(r2);
            }
           }
        );
        for(int i=0; i<temp.size(); i++){
            System.out.println("The movie with name of "+MovieDatabase.getTitle(temp.get(i).getItem())
            +", the average rating is "+ temp.get(i).getValue());
            System.out.println("Its genres is "+MovieDatabase.getGenres(temp.get(i).getItem()));
        }
    }
    public void printAverageRatingsByMinutes(){        
        ThirdRatings sr = new ThirdRatings("ratings");
        System.out.println("The number of raters is "+sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("The number of movies in the database is"+MovieDatabase.size());
   
        Filter f = new MinutesFilter(105, 135);
        ArrayList<Rating> temp = sr.getAverageRatingsByFilter(5,f);
        System.out.println("The number of movies with rating returned is "+temp.size());
        Collections.sort(temp, new Comparator<Rating>(){
            @Override
            public int compare(Rating r1, Rating r2){
                return r1.compareTo(r2);
            }
           }
        );
        for(int i=0; i<temp.size(); i++){
            System.out.println("The movie with name of "+MovieDatabase.getTitle(temp.get(i).getItem())
            +", the average rating is "+ temp.get(i).getValue());
            System.out.println("Its minutes is "+MovieDatabase.getMinutes(temp.get(i).getItem()));
        }
    }
    public void printAverageRatingsByDirectors(){        
        ThirdRatings sr = new ThirdRatings("ratings");
        System.out.println("The number of raters is "+sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("The number of movies in the database is"+MovieDatabase.size());
   
        Filter f = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
        ArrayList<Rating> temp = sr.getAverageRatingsByFilter(4,f);
        System.out.println("The number of movies with rating returned is "+temp.size());
        Collections.sort(temp, new Comparator<Rating>(){
            @Override
            public int compare(Rating r1, Rating r2){
                return r1.compareTo(r2);
            }
           }
        );
        for(int i=0; i<temp.size(); i++){
            System.out.println("The movie with name of "+MovieDatabase.getTitle(temp.get(i).getItem())
            +", the average rating is "+ temp.get(i).getValue());
            System.out.println("Its directors are "+MovieDatabase.getDirector(temp.get(i).getItem()));
        }
    }
    public void printAverageRatingsByYearAfterAndGenre(){        
        ThirdRatings sr = new ThirdRatings("ratings");
        System.out.println("The number of raters is "+sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("The number of movies in the database is"+MovieDatabase.size());
   
        AllFilters f = new AllFilters();
        f.addFilter(new YearAfterFilter(1990));
        f.addFilter(new GenreFilter("Drama"));
        ArrayList<Rating> temp = sr.getAverageRatingsByFilter(8,f);
        System.out.println("The number of movies with rating returned is "+temp.size());
        Collections.sort(temp, new Comparator<Rating>(){
            @Override
            public int compare(Rating r1, Rating r2){
                return r1.compareTo(r2);
            }
           }
        );
        for(int i=0; i<temp.size(); i++){
            System.out.println("The movie with name of "+MovieDatabase.getTitle(temp.get(i).getItem())
            +", the average rating is "+ temp.get(i).getValue()+", year is "+MovieDatabase.getYear(temp.get(i).getItem()));
            System.out.println("Its genres are "+MovieDatabase.getGenres(temp.get(i).getItem()));
        }
    }
    public void printAverageRatingsByDirectorsAndMinutes(){        
        ThirdRatings sr = new ThirdRatings("ratings");
        System.out.println("The number of raters is "+sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("The number of movies in the database is"+MovieDatabase.size());
   
        AllFilters f = new AllFilters();
        f.addFilter(new MinutesFilter(90,180));
        f.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        ArrayList<Rating> temp = sr.getAverageRatingsByFilter(3,f);
        System.out.println("The number of movies with rating returned is "+temp.size());
        Collections.sort(temp, new Comparator<Rating>(){
            @Override
            public int compare(Rating r1, Rating r2){
                return r1.compareTo(r2);
            }
           }
        );
        for(int i=0; i<temp.size(); i++){
            System.out.println("The movie with name of "+MovieDatabase.getTitle(temp.get(i).getItem())
            +", the average rating is "+ temp.get(i).getValue()+", time length is "+MovieDatabase.getMinutes(temp.get(i).getItem()));
            System.out.println("Its directors are "+MovieDatabase.getDirector(temp.get(i).getItem()));
        }
    }
}
