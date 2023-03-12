package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FileManagement {

    public String solutionFileContent(Integer solutionLength,String solution) {
        String text = solutionLength.toString();
        if(solutionLength > 0) {
            text += "\n" + solution;
        }
        return text;
    }
    public String extraInfoFile(Integer solutionLength, Integer visited, Integer processed, Integer maxReachedRecursion,Double elapsedTime) {
        return solutionLength + "\n" + visited + "\n" + processed + "\n" +maxReachedRecursion + "\n" +String.format("%.3f",elapsedTime);
    }
    public void saveToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
