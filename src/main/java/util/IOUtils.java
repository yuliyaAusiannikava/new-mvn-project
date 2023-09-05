package util;

import javafx.beans.binding.StringBinding;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class IOUtils {

    public static void printStat(String path){
        File rootFile = new File(path);
        if (!rootFile.exists()) {
            System.out.println("Invalid file path");
            return;
        }

        if(rootFile.isDirectory()){
            System.out.println(String.format("FOLDER <%s><lastModified:%s>",
                    rootFile.getName(), new Date(rootFile.lastModified()).toString()));
            File[] files = rootFile.listFiles();
            if(files != null)
            for (File file: files) {
              printStat(file.getPath());
            }
        } else {
            //it should be files
            System.out.println(String.format("FILE ---> <%s><Size:%d>",
                    rootFile.getName(), rootFile.length()));
        }
    }

    public static String readFile(String path) {

        StringBuilder sb = new StringBuilder(214748364);
        try(Reader reader = new BufferedReader(
                new FileReader(path), 214748364)) { //using try - with - resource. See AutoCloseable
            int characterCode;
            while ((characterCode = reader.read()) != -1) {
                sb.append((char)characterCode);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Check you file path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String readFileByLines(String path) {

        StringBuilder sb = new StringBuilder(214748364);
        try(BufferedReader reader = new BufferedReader(
                new FileReader(path), 214748364)) { //using try - with - resource. See AutoCloseable
            String line;

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (FileNotFoundException e) {
            System.err.println("Check you file path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }





    public static void write(String data, String path){
       write(data, path, false);
    }

    public static void write(String data, String path, boolean append){
        try (Writer writer = new BufferedWriter(new FileWriter(path, append))){
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFiles(String dstPath, String path1, String path2){
        String content1 = readFile(path1);
        String content2 = readFile(path2);
        write(content1 + content2, dstPath);
    }

    public static void copyFiles(String dstPath, String...paths){
        StringBuilder sb = new StringBuilder();
        for (String path:paths){
            sb.append(readFile(path));
        }
        write(sb.toString(), dstPath);
    }

    public static void findText(String filePath, String searchWord){
        String content = readFile(filePath);
        if(content.toLowerCase().contains(searchWord.toLowerCase())){
            System.out.println("Search text is found");
        } else {
            System.out.println("Search text is not found");
        }

    }



    public static void main(String[] args) {
        try(Resource res = new Resource()){ //круглые скобки в try - ожидание ресурса
            res.addLine("Hello ");
            res.addLine("World");
            res.printData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Resource implements Closeable{

    private String data = new String();

    @Override
    public void close() throws IOException {
        if(data.length() > 0){
            data = new String();
            System.out.println("Resource data clear");
        }
    }

    public void addLine(String line){
        data += line;

    }

    public void printData(){
        System.out.println(data);
    }
}


class Tasks {
    static void t1(String path, String resultPath){
        System.out.println("TASK #1 Reverse file text");
        // 1 step: read content
        String data = IOUtils.readFile(path);

        // 2 step: process String value (revers)
        String result = new StringBuilder(data).reverse().toString();

        // 3 step: write result file
        IOUtils.write(result, resultPath);
    }

    static void t2(String path, String resultFilePath, String search){
        System.out.println("TASK #2 Reverse file text");
       //1 step: read content
        String resultFormat = "\"%s\": %d";
        String content = IOUtils.readFile(path).toLowerCase();
        //2 walk and count words in <search word>: <counter> format
        int counter = 0;

        if(content.contains(search)){
            //3 save the EMPTY results
            int index ;
            while((index = content.indexOf(search)) != -1){
                System.out.println("contain");
                content = content.substring(index + search.length());
                counter++;
            }

        }
        //3 save the result
        IOUtils.write(String.format(resultFormat, search, counter), resultFilePath);

    }

    public static void main(String[] args) {
        t1("/Users/julia/Documents/io_tests/Tasks/task 1.txt",
                "/Users/julia/Documents/io_tests/Tasks/result_task 1.txt" );
        t2("/Users/julia/Documents/io_tests/war_and_peace.ru.txt",
                "/Users/julia/Documents/io_tests/war_and_peace2.txt", "мир" );

    }


}
