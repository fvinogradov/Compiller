package engine.fileSupport;

import java.io.*;
import java.util.*;

/**
 * Developer: Muhamedgaliev Rinat
 * Date: 9/10/12
 */

public class FileLoader {
    private static final String FILE_PATH = "texts";
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
            checkCountFiles(filesList);
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
                    StringTokenizer clearWords = new StringTokenizer(lineFromTextFile, " ,.!?-{}()");
                    while (clearWords.hasMoreTokens()){
                        words.add(clearWords.nextToken().toLowerCase());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        words.toArray();

        return words;
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
}
