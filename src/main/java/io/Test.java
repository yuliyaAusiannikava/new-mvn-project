package io;

import util.IOUtils;

import java.io.*;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        File file = new File("/Users/julia/Documents/io_tests/new_file.rtf");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("New file is created - " + isCreated);

            File file2 = new File("/Users/julia/Documents/io_tests/simple_file2.rtf");
            boolean isExists = file2.exists();
            if(!isExists){
                file2.createNewFile();
                System.out.println("New file is created");
            }

            File file3 = new File("/Users/julia/Documents/io_tests");
            System.out.println("path: " + file3.getPath());
            System.out.println("name: " + file3.getName());
            File files[] = file3.listFiles();
            System.out.println("pathnames size: " + files.length);

            System.out.println("***************");
            //IOUtils.printStat("/Users/julia/Documents/io_tests");



            System.out.println("***************");
            Date startDate2 = new Date();
            InputStream is =
                    new FileInputStream(new File("/Users/julia/Documents/io_tests/simple_file.rtf"));

            int code = is.read();
           System.out.println("Code = " + code);
            char ch = (char) code;
            System.out.println(ch);
            while((code = is.read()) != -1){
               System.out.print((char)code);
            }
            Date endDate2= new Date();
            long mills1 = endDate2.getTime() - startDate2.getTime();
            System.out.println("processing took " + mills1);



            System.out.println("***************");
            Date startDate1 = new Date();
            Reader reader = new FileReader("/Users/julia/Documents/io_tests/parent A/parent A.rtf");
            int characterCode;
            while ((characterCode = reader.read()) != -1){
                System.out.print(((char)characterCode));
            }
          Date endDate1 = new Date();
           long mills2 = endDate1.getTime() - startDate1.getTime();
           System.out.println("processing took " + mills2);

            System.out.println("***************");
           Date startDate = new Date();
            Reader reader2 =
                    new BufferedReader
                            (new FileReader("/Users/julia/Documents/io_tests/war_and_peace.ru.txt"));
            reader2.read();
            int charCode;
            while ((charCode = reader2.read()) != -1){
                System.out.print(((char)charCode));
            }
            Date endDate = new Date();
            long mills = endDate.getTime() - startDate.getTime();
            System.out.println("processing took " + mills);







        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
