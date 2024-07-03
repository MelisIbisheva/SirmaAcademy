package GenericCountMethodStrings;

import java.util.List;

public class CompareElement {

    public static <T extends Comparable<T>> int countGreaterThan(List<T> elements, T element){
        int count = 0;
        for (T e : elements){
            int compare = e.compareTo(element);
            if(compare > 0){
                count++;
            }
        }
        return count;
    }
}
