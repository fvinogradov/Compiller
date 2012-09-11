import engine.fileSupport.FileLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Developer: Muhamedgaliev Rinat
 * Date: 9/10/12
 */

public class Runner {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        FileLoader fileLoader = (FileLoader) context.getBean("fileLoader");
        List<File> files = fileLoader.initFiles();
        FileInputStream inputStream;
        DataInputStream dataInputStream;
        BufferedReader bufferedReader;
        String strLine;
        StringTokenizer stringTokenizer;
        int i = 0;
        List<String> words = new ArrayList<String>();
        for (File file : files){
            try {
                inputStream = new FileInputStream(file);
                dataInputStream = new DataInputStream(inputStream);
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                while ((strLine = bufferedReader.readLine()) != null){
                    stringTokenizer = new StringTokenizer(strLine, " ,.!?");
                    while (stringTokenizer.hasMoreTokens()){
                        i++;
                        words.add(stringTokenizer.nextToken().toLowerCase());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Object[] lol = words.toArray();
        Arrays.sort(lol);
        for (int j = 0; j < lol.length; j++){
            System.out.println(lol[j]);
        }
    }
}
