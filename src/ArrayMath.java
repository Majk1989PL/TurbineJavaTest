import java.util.List;
import java.util.Arrays;

public class ArrayMath
{
    public static double weightedMean(List<Integer> values, List<Integer> weights)
    {
        if(values == null  || weights == null || (values.size() != weights.size())){
            throw  new IllegalArgumentException("Wrong params");
        }
        double sum = 0;
        double sumWeights = 0;
        for (int i = 0; i < values.size(); i++)
        {
            sum += values.get(i) * weights.get(i);
            sumWeights += weights.get(i);
        }

        return sum / sumWeights;
    }

    public static void main(String[] args)
    {
        List<Integer> a = Arrays.asList(new Integer[] { 3, 6 });
        List<Integer> b = Arrays.asList(new Integer[] { 4, 2 });

        System.out.println(weightedMean(a, b));
    }
}