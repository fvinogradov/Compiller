package engine.lexicalAnalyzer;

import engine.fileSupport.FileLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Developer: Rinat Muhamedgaliev <rinat.muhamedgaliev@citronium.com>
 * Date: 10/22/12
 */
public class LexicalAnalyzer {
    private FileLoader fileLoader = new FileLoader();
    private final String sourceLine = fileLoader.readSourceFileToString();
    private final char[] symbols = {'>', '<', '=', '!'};

    public void analyze() throws Exception{
        printSourceInput();
        List<String> results = new ArrayList<String>();
        if (sourceLine.contains("while")){
            System.out.println("Yes source contain while loop");
        } else {
            throw new Exception("Error source.txt not contain while loop");
        }
        Integer whileConditionStart = "while".length();

        for (int iter = 0; iter < sourceLine.length() - 1; iter++){
            for (char logicChar : symbols){
                if (sourceLine.charAt(iter) == logicChar){
                        for (char logicCharSecond : symbols){
                            if (sourceLine.charAt(iter + 1) == logicCharSecond){
                                System.out.println("Find strong logic");
                            }
                        }
                }
            }
        }
    }

    private void printSourceInput(){
        System.out.println("Source code line: " + sourceLine);
    }

    private void printInputString(String inputString){
        System.out.println(inputString);
    }
}
