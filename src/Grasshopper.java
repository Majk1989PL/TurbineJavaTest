import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Grasshopper {

    ArrayList<Integer> leavs = new ArrayList<>();
    int currentPosition;
    /**
     * Initialization of view field with n leaves and grasshopper on leaf 'position'.
     *
     * @param n Number of leaves in row.
     * @param position
     */
    public Grasshopper(int n, int position) {
        currentPosition = position;
        for (int i = 0; i < n; i++) {
            leavs.add(i+1);
        }

    }

    /**
     * Grasshopper has eaten the current leaf and hopped left.
     */
    public void eatAndHopLeft() {
        int tempPosition = currentPosition;
        currentPosition -=2;
        if(currentPosition < 0) {
            currentPosition = 0;
        }

        if(leavs.size() > tempPosition) {
            leavs.remove(tempPosition);
        }
    }

    /**
     * Grasshopper has eaten the current leaf and hopped right.
     */
    public void eatAndHopRight() {

        int tempPosition = currentPosition;
        if(currentPosition > leavs.size()) {
            currentPosition = leavs.size() - 1;
        }

        if(leavs.size() > tempPosition) {
            leavs.remove(tempPosition - 1);
        }
    }

    /**
     * Return the leaf number that grasshopper is feeding on right now.
     *
     * @return Leaf number that grasshopper is feeding on right now.
     */
    public int whereAmI() {
        return leavs.get(currentPosition -1);
    }

    public static void main(String[] args) {
        Grasshopper g = new Grasshopper(5, 2);
        System.out.println(g.whereAmI());

        g.eatAndHopRight();
        System.out.println(g.whereAmI());

        g.eatAndHopLeft();
        System.out.println(g.whereAmI());
    }
}