package util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.sun.xml.internal.ws.server.ServerRtException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static sun.security.util.KnownOIDs.Data;

public class IOUtilsTest {

    @Test
    public void readFileTest (){
        String text = IOUtils.readFile("/Users/julia/Documents/io_tests/simple_file3.rtf");
        Assert.assertNotNull(text);
        Assert.assertEquals("Wrong content", "Hello World", text);

    }

    @Test
    public void readLongFileTest(){
        String text = IOUtils.readFile("/Users/julia/Documents/io_tests/war_and_peace.ru.txt");
        Assert.assertNotNull(text);
        Assert.assertTrue(text.length() > 100000);
    }

    @Test
    public void writeFileTest(){
        String path = "/Users/julia/Documents/io_tests/new_file_" + new Date() + ".txt";
        IOUtils.write("Hello from Java", path);
        Assert.assertTrue(IOUtils.readFile(path).length() > 10);
    }

    @Test
    public void writeAppendFileTest(){
        String path = "/Users/julia/Documents/io_tests/new_append_file_" + new Date() + ".txt";
        IOUtils.write("Hello from Java", path);
        IOUtils.write(" EXTRA TEXT", path, true);
        IOUtils.write(" TEXT2", path, true);
        Assert.assertEquals("Wrong content!", "Hello from Java EXTRA TEXT TEXT2", IOUtils.readFile(path));
    }

    @Test
    public void copyFileTest(){
        String filePath1 = "/Users/julia/Documents/io_tests/first.txt";
        String filePath2 = "/Users/julia/Documents/io_tests/second.txt";
        String filePath3 = "/Users/julia/Documents/io_tests/third.txt";

        IOUtils.copyFiles(filePath3, filePath1, filePath2);

        Assert.assertEquals("Wrong content", "AB", IOUtils.readFile(filePath3));
    }

    @Test
    public void copyMultFileTest(){
        String filePath1 = "/Users/julia/Documents/io_tests/A.txt";
        String filePath2 = "/Users/julia/Documents/io_tests/B.txt";
        String filePath3 = "/Users/julia/Documents/io_tests/C.txt";
        String filePath4 = "/Users/julia/Documents/io_tests/D.txt";
        String filePath5 = "/Users/julia/Documents/io_tests/E.txt";
        IOUtils.write("A", filePath1);
        IOUtils.write("B", filePath2);
        IOUtils.write("C", filePath3);
        IOUtils.write("D", filePath4);
        IOUtils.write("E", filePath5);

        String dstPath = "/Users/julia/Documents/io_tests/ABCDE.txt";
        IOUtils.copyFiles(dstPath, filePath1, filePath2, filePath3, filePath4, filePath5);

        Assert.assertEquals("Wrong content", "ABCDE", IOUtils.readFile(dstPath));
    }

    @Test
    public void readFileByLinesTest(){
        String filePath = "/Users/julia/Documents/io_tests/war_and_peace.ru.txt";
        IOUtils.readFileByLines(filePath);
        //System.out.println(data);
        //Assert.assertNotNull(data);


    }
}
