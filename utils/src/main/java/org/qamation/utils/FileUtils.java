package org.qamation.utils;

import java.io.File;
import java.nio.file.*;
import java.security.SecureRandom;

import static java.nio.file.StandardCopyOption.*;

/**
 * Created by Pavel on 2017-03-25.
 */
public class FileUtils {
    public final static String FILE_SEPARATOR = System.getProperty("file.separator");

    public static Path copyFileToSameFolder(String sourceFilePath, String newfileName) {
        File f = new File(sourceFilePath);
        if (f.isDirectory()) throw new RuntimeException("Given path should lead to a file.");
        String fileName = getFileName(f.getAbsolutePath());
        String fileExt = getFileNameExtention(fileName);
        String filePath = getPathToFile(f.getAbsolutePath());
        try {
            return  Files.copy(f.toPath(), Paths.get(filePath,newfileName), StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public static String getFileName(String absolutePath) {
        Path p = Paths.get(absolutePath);
        return p.getFileName().toString();
    }

    public static String getPathToFile(String absolutePath) {
        Path p = Paths.get(absolutePath);
        return p.getParent().toString();
    }

    public static String getFileNameExtention(String fileName) {
        String ext = fileName.substring(fileName.lastIndexOf("."));
        return ext;
    }

    public static String createTempFile(String origFileName) {
        String prefix = generateFileNamePrefix();
        return createTempFile(origFileName,prefix);
    }

    public static String createTempFile(String origFileName, String tempFileNamePrefix) {
        String suffix = FileUtils.getFileNameExtention(origFileName);
        String tempFileName = tempFileNamePrefix+suffix;
        Path p = FileUtils.copyFileToSameFolder(origFileName,tempFileName);
        return p.toString();
    }

    private static String generateFileNamePrefix() {
        SecureRandom sr = new SecureRandom();
        long l = sr.nextLong();
        return String.valueOf(l);
    }

}
