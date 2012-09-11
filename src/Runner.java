import engine.fileSupport.FileLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Developer: Muhamedgaliev Rinat
 * Date: 9/10/12
 */

public class Runner {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        FileLoader fileLoader = (FileLoader) context.getBean("fileLoader");
    }
}
