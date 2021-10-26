package org.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SpringBootFileChanger {
    ArrayList<Integer> linesToChange = new ArrayList<>(Arrays.asList(21, 69, 70, 71, 72, 73, 74, 75));
    
    public void readFile(String path){
        File obj = new File(path);
        if(obj.exists()){
            try {
                StringBuilder stringBuilder = new StringBuilder();
                Scanner scanner = new Scanner(obj);
                int i = 0;
                while(scanner.hasNextLine()){
                    if(linesToChange.contains(i))
                    stringBuilder.append("//"+scanner.nextLine()+"\n");
                    else
                    stringBuilder.append(scanner.nextLine()+"\n");
                    i++;
                }
                scanner.close();
                
                FileWriter fileWriter = new FileWriter(path);
                fileWriter.write(stringBuilder.toString());
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void deleteFile(String path) {
        File file = new File(path);
        if(file.exists())
            file.delete();
    }
}
