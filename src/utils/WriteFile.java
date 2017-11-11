package utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;


/**
 * Класс для создания файлов
 * Created by user on 25.07.2017.
 */
public class WriteFile {

    /**
     * Метод для создания произвольного файла
     *
     * @param f       - путь до файла
     * @param records - список строк для записи в файл
     */
    public static void writeFile(String f, ArrayList<String> records) {

        Charset charset = Charset.forName("windows-1251");
        String result = "";

        try (BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(f), charset))) {
            for (int i = 0; i < records.size(); i++) {
                result = records.get(i) + "\n";
                out.write(result);
                if (i % 1000 == 0) {
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для создания sql-файла (insert statements)
     *
     * @param f       - путь до файла
     * @param records - список строк для записи в файл
     */
    public static void writeSqlFile(String f, ArrayList<String> records, Charset charset, String table) {

        String result = "";
        String fileName = f + ".sql";
        for (String record : records) {
            result += "insert into " + table + " values (" + record.replace(";", ", ") + ");\r\n";
        }
        try (BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileName), charset))) {
            out.write(result);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDirectory(String dirName) {
        File dir = new File(dirName);
        if (!dir.exists()) {
            boolean mkdirs = dir.mkdirs();
        }
    }
}
