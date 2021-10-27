package utils.readers;

import points.Point;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public static File file = new File("Pictures.txt");
    {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInFile(String str) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(str);
        writer.flush();
        writer.close();
    }

    public static void writeInFile(byte[] array) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write("\narray\n");
        for(int i = 0; i < array.length; i++){
            writer.write(array[i] + ", ");
        }
        writer.flush();
        writer.close();
    }

    public static String getFileAsString(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)){
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static void write(String str){

    }

    public static void clearFile(String filePath){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
    }




}