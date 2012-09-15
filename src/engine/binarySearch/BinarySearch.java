package engine.binarySearch;

import java.util.List;

/**
 * User: Rinat
 * Date: 14.09.12
 * Time: 22:14
 */
public class BinarySearch {

    private List<String> wordList;

    public BinarySearch(List<String> wordList) {
        this.wordList = wordList;
    }

    public Object search(String word){
        return binarySearchXXX(wordList.toArray(), 0, wordList.size(), word);
    }

    private static int binarySearchXXX(Object[] a, int fromIndex, int toIndex,
                                       Object key) {
        int low = fromIndex;
        int high = toIndex - 1;
        int iterator = 0;
        while (low <= high) {
            iterator++;
            int mid = (low + high) >>> 1;
            Comparable midVal = (Comparable)a[mid];
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return iterator;
        }
        System.out.println("\""+key + "\" не нашлось за : " + iterator + " шагов");
        return 0;
    }
}
