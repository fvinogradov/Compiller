import engine.binarySearch.BinarySearch;
import engine.fileSupport.FileLoader;
import engine.lexicalAnalyzer.LexicalAnalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Developer: Muhamedgaliev Rinat
 * Date: 9/10/12
 */

public class Runner {
    public static void main(String[] args){
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        try {
            lexicalAnalyzer.analyze();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void laba1(){
        FileLoader fileLoader = new FileLoader();
        fileLoader.wordsTable();
        BinarySearch binarySearch = new BinarySearch(fileLoader.sortedMapIds());
        List<Integer> iter =  new ArrayList<Integer>();
        int wordsCount = fileLoader.readSourceFile().size();
        int resultSumm = 0;
        for (String word : fileLoader.readSourceFile()){
            int result =  (Integer) binarySearch.search(word);
            if(result != 0){
                iter.add(result);
                resultSumm = resultSumm + result;
                System.err.println(word + " нашлось за :" + result + " шагов");
            }
        }

        System.out.println("\nСреднее количество" + " : " + String.format("%.3f", Double.valueOf(resultSumm) / Double.valueOf(wordsCount)));
    }
}
