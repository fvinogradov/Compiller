package engine.fileSupport;

import java.io.*;
import java.util.*;

/**
 * Developer: Muhamedgaliev Rinat
 * Date: 9/10/12
 */

public class FileLoader {
    private static final String FILE_PATH = "texts";
    private static final String Source_PATH = "sourceText";

    private String filePath;

    public FileLoader() {
    }

    public List<File> initFiles(){
        File inputFile;
        List<File> filesList;
        List<File> result = new ArrayList<File>();
        try {
            checkPath();
            inputFile = new File(FILE_PATH);
            filesList = Arrays.asList(inputFile.listFiles());
            //checkCountFiles(filesList);
            for (File file : filesList){
                checkIsFile(file);
                checkFileRead(file);
                result.add(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void wordsTable(){
        List<String> wordsList= sortedMapIds();
        Map<Integer, String> wordsMap = new HashMap<Integer, String>();

        for (int iter = 0; iter < wordsList.size(); iter++){
            wordsMap.put(iter + 1, wordsList.get(iter));
        }
        Set<Map.Entry<Integer,String>> set = wordsMap.entrySet();

        for(Map.Entry<Integer, String> entry : set) {
            //System.out.println( entry.getKey() + " : " + entry.getValue());
        }
    }

    public List<String> readSourceFile(){
        File file = new File("source.txt");
        FileInputStream inputStream = null;
        String lineFromTextFile;
        List<String> words = new ArrayList<String>();
        try {
            inputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            while ((lineFromTextFile = bufferedReader.readLine()) != null){
                StringTokenizer clearWords = new StringTokenizer(lineFromTextFile, " ,.!?-{}()!@#_\\|/$%=+^&*()\":;\t\n[]<>'");
                while (clearWords.hasMoreTokens()){
                    words.add(clearWords.nextToken().toUpperCase());
                }
            }
            return words;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readSourceFileToString(){
        File file = new File("source.txt");
        FileInputStream inputStream = null;
        String lineFromTextFile;
        String words = new String();
        try {
            inputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            while ((lineFromTextFile = bufferedReader.readLine()) != null){
                    words+=lineFromTextFile.toLowerCase();
            }
            words = words.replaceAll("\\s", "");
            words = words.replaceAll("\\t", "");
            words = words.replaceAll("\\n", "");
            return words;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*Utils methods*/
    private void checkPath() throws IOException {
        if(FILE_PATH.length() < 0){
            throw new IOException("path not valid");
        } else {
            File file = new File(FILE_PATH);
            if (!file.isDirectory()){
                throw new IOException("path not valid");
            }
        }
    }

    private void checkCountFiles(List<File> files) throws IOException {
        if (files.size() != 10){
            throw new IOException("need 10 files, you have:" + files.size());
        }
    }

    private void checkIsFile(File file) throws IOException{
        if(!file.isFile()){
            throw new IOException(file + " is not file");
        }
    }

    private void checkFileRead(File file) throws IOException{
        if(!file.canRead()){
            throw new IOException(file + " can't read");
        }
    }

    public List<String> sortedMapIds(){
        List<File> sourceFilesList = initFiles();
        String lineFromTextFile;
        List<String> words = new ArrayList<String>();
        for (File file : sourceFilesList){
            try {
                FileInputStream inputStream = new FileInputStream(file);
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                while ((lineFromTextFile = bufferedReader.readLine()) != null){
                    StringTokenizer clearWords = new StringTokenizer(lineFromTextFile, " ,.!?-{}+_()!@#$%^&*()\"=:;\t\n[]<>'");
                    while (clearWords.hasMoreTokens()){
                        words.add(clearWords.nextToken().toUpperCase());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String[] clearWordsArray = words.toArray(new String[words.size()]);
        Arrays.sort(clearWordsArray);
        return Arrays.asList(clearWordsArray);
    }

}
