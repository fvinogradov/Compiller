package engine.fileSupport;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Developer: Muhamedgaliev Rinat
 * Date: 9/10/12
 */

public class FileFilter implements FilenameFilter {
    private final String FILE_MASK="*.txt";

    public FileFilter() {
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(FILE_MASK.toLowerCase());
    }
}
