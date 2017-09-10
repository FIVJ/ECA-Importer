package functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author tassio
 */
public class Convert {

    public void convertPBF_Payments() {

        File fInput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV");
        File fOutput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV_Converter");
        BufferedReader br = null;
        String line = "";
        String csvDivisor = "\t";
        File[] filesCSV = fInput.listFiles();

        for (int j = 1; j < filesCSV.length; j++) {
            File fileCSV = filesCSV[j];
            try {
                OutputStreamWriter StrW = new OutputStreamWriter(new FileOutputStream(fOutput + "/" + fileCSV.getName()), "ISO-8859-1");
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDivisor);
                    StrW.write(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";" + data[5] + ";" + data[6] + ";" + data[7]
                            + ";" + data[8] + ";" + data[9] + ";" + data[10] + ";" + fileCSV.getName().substring(4, 6) + ";" + fileCSV.getName().substring(0, 4) + "\n");
                }
                StrW.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void convertPBF_Drawal() {

        File fInput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV");
        File fOutput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV_Converter");
        BufferedReader br = null;
        String line = "";
        String csvDivisor = "\t";
        File[] filesCSV = fInput.listFiles();
        long totalconvert = 0;

        for (int j = 1; j < filesCSV.length; j++) {
            File fileCSV = filesCSV[j];
            try {
                OutputStreamWriter StrW = new OutputStreamWriter(new FileOutputStream(fOutput + "/" + fileCSV.getName()), "ISO-8859-1");
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                while ((line = br.readLine()) != null) {

                    String[] data = line.split(csvDivisor);
                    if (totalconvert != 0) {
                        if (data.length < 13) {
                            String dp = "01/" + fileCSV.getName().substring(4, 6) + "/" + fileCSV.getName().substring(0, 4);
                            StrW.write(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";" + data[5] + ";" + data[6] + ";" + data[7]
                                    + ";" + data[8] + ";" + data[9] + ";" + data[10] + ";" + data[11] + ";" + fileCSV.getName().substring(4, 6) + ";"
                                    + fileCSV.getName().substring(0, 4) + ";" + dp + "\n");
                        } else {
                            StrW.write(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";" + data[5] + ";" + data[6] + ";" + data[7]
                                    + ";" + data[8] + ";" + data[9] + ";" + data[10] + ";" + data[11] + ";" + fileCSV.getName().substring(4, 6) + ";"
                                    + fileCSV.getName().substring(0, 4) + ";" + data[13] + "\n");
                        }
                    }
                    totalconvert++;
                    //System.out.println("Imports Total: " + totalconvert);
                }
                StrW.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
