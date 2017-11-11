package utils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Класс для чтения файлов
 * Created by user on 25.07.2017.
 */
public class ReadFile {
    public static ArrayList<String> readFile(Path f, String encode) {
        ArrayList<String> readedFile = new ArrayList<>(); // построчное содержимое файла
        Charset charset = Charset.forName(encode);
        try (BufferedReader br = Files.newBufferedReader(f, charset)) {
            String readed;
            while ((readed=br.readLine())!=null) {
                readedFile.add(readed);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readedFile;
    }
}
