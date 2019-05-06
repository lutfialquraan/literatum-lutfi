package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    static int count = 0;

    public static void findAndCopyFile(File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
            for (File fil : list)
            {
                if (fil.isDirectory())
                {
                    if (!fil.getName().equalsIgnoreCase("issue-files"))
                        findAndCopyFile(fil);
                }
                else if ((fil.getName().endsWith(".xml") || fil.getName().endsWith(".pdf")) && !fil.getName().startsWith("manifest"))
                {
                    Path path = Paths.get(fil.getPath());
                    Path pathTo = Paths.get("C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\ok\\src\\dois\\"+fil.getName());
                    try {
                        Files.copy(path, pathTo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }


    public static void main(String[] args) throws IOException {

//        count++;
//        UnZip.unZip("C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\ok\\src\\bhda_bhda_40_3_20181029050711164.zip","C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\ok\\src\\unprocessed-file\\"+count);
//        Path directory = Paths.get("C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\ok\\src\\a.zip");
//        Files.delete(directory);

        File file = new File("C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\ok\\src\\unprocessed-file");
        findAndCopyFile(file);


    }
}
