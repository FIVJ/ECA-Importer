package functions;

import dao.TbBeneficiariesDAO;
import dao.TbCityDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import model.TbBeneficiaries;
import model.TbCity;
import org.apache.log4j.Logger;

/**
 *
 * @author tassio
 */
public class Convert {

    Logger logger = Logger.getLogger("Functions");

    public void convertPBF_SQL_Payments() {
        logger.trace("Starting Method Convert");
        File fInput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV/Pagamentos");
        File fOutput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV_Converter/Pagamentos");
        BufferedReader br = null;
        String line = "";
        String csvDivisor = "\t";
        File[] filesCSV = fInput.listFiles();

        for (int j = 0; j < filesCSV.length; j++) {
            File fileCSV = filesCSV[j];
            long total = 0;
            try {
                OutputStreamWriter StrW = new OutputStreamWriter(new FileOutputStream(fOutput + "/" + fileCSV.getName().replaceAll("csv", "sql")), "ISO-8859-1");
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                StrW.write("Use DB_ECA;");
                StrW.write("LOCK TABLES `tb_payments` WRITE;");
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDivisor);

                    if (total != 0) {
                        String SQL, source;
                        TbCity city;
                        TbBeneficiaries beneficiaries;

                        if (data[9].toUpperCase().equals("CAIXA - PROGRAMA BOLSA FAMÍLIA")) {
                            source = "1";
                        } else {
                            source = "2";
                        }
                        city = TbCityDAO.getInstance().get(data[1]);
                        beneficiaries = TbBeneficiariesDAO.getInstance().search(data[7],data[8].toUpperCase());

                        SQL = "INSERT INTO `DB_ECA`.`tb_payments` (`tb_city_id_city`,`tb_functions_id_function`,`tb_subfunctions_id_subfunction`,`tb_program_id_program`,`tb_action_id_action`,`tb_beneficiaries_id_beneficiaries`,`tb_source_id_source`,`tb_files_id_file`,`db_value`)" + "VALUES" + "(" + city.getIdCity() + "," + "1," + "1," + "1," + "1," + beneficiaries + "," + source + "," + "1," + data[10].replaceAll(",", "") + ");";

                        StrW.write(SQL);
                    }
                    total++;
                }
                StrW.write("UNLOCK TABLES;");
                StrW.close();
            } catch (FileNotFoundException e) {
                logger.error("Unexpected error", e);
            } catch (IOException e) {
                logger.error("Unexpected error", e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                        logger.trace("Ended Method Convert");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

    public void convertPBF_SQL_Beneciaries() {
        logger.trace("Starting Method Convert");
        File fInput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV/Pagamentos");
        File fOutput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV_Converter/Pagamentos");
        BufferedReader br = null;
        String line = "";
        String csvDivisor = "\t";
        File[] filesCSV = fInput.listFiles();
        String SQL;
        TbBeneficiaries beneficiaries;

        for (int j = 0; j < filesCSV.length; j++) {
            File fileCSV = filesCSV[j];
            long total = 0;
            try {
                OutputStreamWriter StrW = new OutputStreamWriter(new FileOutputStream(fOutput + "/" + fileCSV.getName().replaceAll("csv", "sql")), "ISO-8859-1");
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                StrW.write("Use DB_ECA;");
                StrW.write("LOCK TABLES `tb_beneficiaries` WRITE;");
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDivisor);

                    //verificação por partes
                    if (total != 0 && total >= 9000000 && total <= 10000000) {

                        beneficiaries = TbBeneficiariesDAO.getInstance().search(data[7], data[8].toUpperCase());
                        if (beneficiaries == null) {
                            SQL = "INSERT INTO `DB_ECA`.`tb_beneficiaries` (`str_nis`,`str_name_person`) VALUES (" + data[7] + ",'" + data[8].toUpperCase() + "');";
                            StrW.write(SQL);
                        }

                        if (total % 10000 == 0) {
                            System.out.println("Lines = " + total);
                            System.gc();
                        }
                    }
                    total++;
                }
                StrW.write("UNLOCK TABLES;");
                StrW.close();
            } catch (FileNotFoundException e) {
                logger.error("Unexpected error", e);
            } catch (IOException e) {
                logger.error("Unexpected error", e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                        logger.trace("Ended Method Convert");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

    public void validatePBF_Datas() {
        logger.trace("Starting Method Validation Data");
        File fInput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV/Pagamentos");
        BufferedReader br = null;
        String line = "";
        String csvDivisor = "\t";
        File[] filesCSV = fInput.listFiles();

        for (File filesCSV1 : filesCSV) {
            long StartTime = System.currentTimeMillis();
            File fileCSV = filesCSV1;
            long totalimport = 0;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDivisor);
                    if (totalimport != 0) {

                        if (!data[3].equals("08")) {
                            System.out.println("New function detected \n Value: " + data[3]);
                        }

                        if (!data[4].equals("244")) {
                            System.out.println("New subfunction detected \n Value: " + data[4]);
                        }

                        if (!data[5].equals("1335")) {
                            System.out.println("New program detected \n Value: " + data[5]);
                        }

                        if (!data[6].equals("8442")) {
                            System.out.println("New Action detected \n Value: " + data[6]);
                        }

                        if (!data[9].toUpperCase().equals("CAIXA - PROGRAMA BOLSA FAMÍLIA")) {
                            if (!data[9].toUpperCase().equals("CAIXA - PROGRAMA BOLSA FAMÍLIA (GDF)")) {
                                System.out.println("New source detected \n Value: " + data[9].toUpperCase());
                            }
                        }
                    }
                    totalimport++;
                }
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("File " + fileCSV.getName() + " - Total time ('HHH':'mm':'ss'.'SSSSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            } catch (FileNotFoundException e) {
                logger.error("Unexpected error", e);
            } catch (IOException e) {
                logger.error("Unexpected error", e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                        logger.trace("Ended Method Validation");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }
}
