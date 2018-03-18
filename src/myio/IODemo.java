package myio;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class IODemo {

    public static void main(String[] args) throws IOException {
        readFromUrl();
    }

    public static void readFromUrl() {
        URL url;

        try {
            // get URL content
            // tao ket noi.
            url = new URL("https://vnexpress.net/");
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());

            BufferedReader br = new BufferedReader(isr);

            String tmp;

            FileWriter fileWriter = new FileWriter("vnexpress.html");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while ((tmp = br.readLine()) != null) {
                bufferedWriter.write(tmp);
            }

            bufferedWriter.close();
            fileWriter.close();
//            BufferedReader br = new BufferedReader(isr);
//
//            String inputLine;

//            //save to this filename
//            String fileName = "/users/mkyong/test.html";
//            File file = new File(fileName);
//
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//            //use FileWriter to write file
//            FileWriter fw = new FileWriter(file.getAbsoluteFile());
//            BufferedWriter bw = new BufferedWriter(fw);

//            while ((inputLine = br.readLine()) != null) {
//                bw.write(inputLine);
//            }

//            bw.close();
//            br.close();

            System.out.println("Done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
