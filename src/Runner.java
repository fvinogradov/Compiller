import engine.fileSupport.FileLoader;

/**
 * Developer: Muhamedgaliev Rinat
 * Date: 9/10/12
 */

public class Runner {
    public static void main(String[] args){
        FileLoader fileLoader = new FileLoader();
        fileLoader.wordsTable();
        int iter = fileLoader.logariphmSearch();
        if (iter == -1){
            System.out.print("Error!Wrong id");
        } else {
            System.out.print("Выполнено количество шагов поиска : " + iter);
        }
    }
}
