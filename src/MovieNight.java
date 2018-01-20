
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MovieNight {
    public static Boolean canViewAll(Collection<Movie> movies) {
        boolean isOverlap = false;


        List<Movie> sorted = movies.stream().sorted(Comparator.comparing(Movie::getStart)).collect(Collectors.toList());

        for(int i =0; i< sorted.size() ; i++){
            for (int y = i +1; y < sorted.size();){
                if (sorted.get(i).getEnd().compareTo(sorted.get(y).getStart()) > 0){
                   return false;
                }
               else if (sorted.get(i).getEnd().compareTo(sorted.get(y).getStart()) < 0){
                    break;
                }
                else {
                    y++;
                }

            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));

        System.out.println(MovieNight.canViewAll(movies));
    }
}

class Movie {
    private Date start, end;

    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}