package functions;

import dao.TbBeneficiariesDAO;
import dao.TbFilesDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import model.TbBeneficiaries;
import model.TbFiles;
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
        Arrays.sort(filesCSV);
        for (File fileCSV : filesCSV) {
            long total = 0;
            TbFiles file = TbFilesDAO.getInstance().get(fileCSV.getName());
            try {
                OutputStreamWriter StrW = new OutputStreamWriter(new FileOutputStream(fOutput + "/" + fileCSV.getName().replaceAll("csv", "sql")), "ISO-8859-1");
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                StrW.write("Use DB_ECA;");
                StrW.write("LOCK TABLES tb_payments WRITE;");
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDivisor);

                    if (total > 0) {
                        String SQL, source;

                        if (data[9].toUpperCase().equals("CAIXA - PROGRAMA BOLSA FAMÍLIA")) {
                            source = "1";
                        } else {
                            source = "2";
                        }

                        SQL = "INSERT INTO DB_ECA.tb_payments (tb_city_id_city,tb_function_id_function,tb_subfunction_id_subfunction,tb_program_id_program,tb_action_id_action,tb_beneficiaries_id_beneficiary,tb_source_id_source,tb_files_id_file,db_value) VALUES (" + Integer.parseInt(data[1]) + "," + Integer.parseInt(data[3]) + "," + Integer.parseInt(data[4]) + "," + Integer.parseInt(data[5]) + "," + Integer.parseInt(data[6]) + "," + Long.parseLong(data[7]) + "," + source + "," + file.getIdFile() + "," + Double.parseDouble(data[10].replaceAll(",", "")) + ");";

                        StrW.write(SQL);

                        if (total % 10000 == 0) {
                            System.out.println("Lines = " + total);
                            StrW.flush();
                            System.gc();
                            System.runFinalization();
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

    public void convertPBF_SQL_Beneciaries() {
        logger.trace("Starting Method Convert");
        File fInput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV/Pagamentos");
        File fOutput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV_Converter/Pagamentos");
        BufferedReader br = null;
        String line = "";
        String csvDivisor = "\t";
        File[] filesCSV = fInput.listFiles();
        String SQL;
        Arrays.sort(filesCSV);
        for (File fileCSV : filesCSV) {
            long total = 0;
            try {
                OutputStreamWriter StrW1 = new OutputStreamWriter(new FileOutputStream(fOutput + "/p1_" + fileCSV.getName().replaceAll("csv", "sql")), "ISO-8859-1");
                OutputStreamWriter StrW2 = new OutputStreamWriter(new FileOutputStream(fOutput + "/p2_" + fileCSV.getName().replaceAll("csv", "sql")), "ISO-8859-1");
                OutputStreamWriter StrW3 = new OutputStreamWriter(new FileOutputStream(fOutput + "/p3_" + fileCSV.getName().replaceAll("csv", "sql")), "ISO-8859-1");
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                StrW1.write("Use DB_ECA;\n");
                StrW1.write("LOCK TABLES tb_beneficiaries WRITE;\n");
                StrW2.write("Use DB_ECA;\n");
                StrW2.write("LOCK TABLES tb_beneficiaries WRITE;\n");
                StrW3.write("Use DB_ECA;\n");
                StrW3.write("LOCK TABLES tb_beneficiaries WRITE;\n");
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDivisor);

                    if (total > 0 && total < 4500001) {
                        TbBeneficiaries beneficiaries = TbBeneficiariesDAO.getInstance().get(Long.parseLong(data[7]));
                        if (beneficiaries == null) {
                            SQL = "INSERT INTO DB_ECA.tb_beneficiaries (int_nis,str_name_person) VALUES (" + Long.parseLong(data[7]) + ",\"" + data[8].toUpperCase() + "\");\n";
                            StrW1.write(SQL);
                        }

                        if (total % 10000 == 0) {
                            System.out.println("Lines = " + total);
                            StrW1.flush();
                            System.gc();
                            System.runFinalization();
                            System.gc();
                        }
                    }

                    if (total > 4500000 && total < 8500001) {
                        TbBeneficiaries beneficiaries = TbBeneficiariesDAO.getInstance().get(Long.parseLong(data[7]));
                        if (beneficiaries == null) {
                            SQL = "INSERT INTO DB_ECA.tb_beneficiaries (int_nis,str_name_person) VALUES (" + Long.parseLong(data[7]) + ",\"" + data[8].toUpperCase() + "\");\n";
                            StrW2.write(SQL);
                        }

                        if (total % 10000 == 0) {
                            System.out.println("Lines = " + total);
                            StrW2.flush();
                            System.gc();
                            System.runFinalization();
                            System.gc();
                        }
                    }

                    if (total > 8500000) {
                        TbBeneficiaries beneficiaries = TbBeneficiariesDAO.getInstance().get(Long.parseLong(data[7]));
                        if (beneficiaries == null) {
                            SQL = "INSERT INTO DB_ECA.tb_beneficiaries (int_nis,str_name_person) VALUES (" + Long.parseLong(data[7]) + ",\"" + data[8].toUpperCase() + "\");\n";
                            StrW3.write(SQL);
                        }

                        if (total % 10000 == 0) {
                            System.out.println("Lines = " + total);
                            StrW3.flush();
                            System.gc();
                            System.runFinalization();
                            System.gc();
                        }
                    }

                    total++;
                }
                StrW1.write("UNLOCK TABLES;\n");
                StrW1.write("OPTIMIZE TABLE DB_ECA.tb_beneficiaries;\n");
                StrW1.close();
                StrW2.write("UNLOCK TABLES;\n");
                StrW2.write("OPTIMIZE TABLE DB_ECA.tb_beneficiaries;\n");
                StrW2.close();
                StrW3.write("UNLOCK TABLES;\n");
                StrW3.write("OPTIMIZE TABLE DB_ECA.tb_beneficiaries;\n");
                StrW3.close();
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
        Arrays.sort(filesCSV);
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

                        if (totalimport % 10000 == 0) {
                            System.out.println("Lines = " + totalimport);
                            System.gc();
                            System.runFinalization();
                            System.gc();
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

    public void convertPBF_Payments() {
        logger.trace("Starting Method Convert");
        File fInput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV/Pagamentos");
        File fOutput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV_Converter/Pagamentos");
        BufferedReader br = null;
        String line = "";
        String csvDivisor = "\t";
        File[] filesCSV = fInput.listFiles();
        Arrays.sort(filesCSV);
        for (File fileCSV : filesCSV) {
            long total = 0;
            try {
                OutputStreamWriter StrW = new OutputStreamWriter(new FileOutputStream(fOutput + "/" + fileCSV.getName().replaceAll("csv", "sql")), "ISO-8859-1");
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                StrW.write("Use `DB_ECA`;\n");
                StrW.write("LOCK TABLES `tb_PBFPayments"+fileCSV.getName().substring(0, 4)+"` WRITE;\n");
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDivisor);

                    if (total > 0) {
                        String SQL;

                        String region;
                        switch (data[0].toUpperCase()) {
                            case "MG":
                            case "RJ":
                            case "SP":
                            case "ES":
                                region = "SUDESTE";
                                break;
                            case "PR":
                            case "RS":
                            case "SC":
                                region = "SUL";
                                break;
                            case "DF":
                            case "GO":
                            case "MT":
                            case "MS":
                                region = "CENTRO-OESTE";
                                break;
                            case "AM":
                            case "AC":
                            case "RO":
                            case "RR":
                            case "TO":
                            case "AP":
                                region = "NORTE";
                                break;
                            default:
                                region = "NORDESTE";
                                break;
                        }

                        SQL = "INSERT INTO `DB_ECA`.`tb_PBFPayments"+fileCSV.getName().substring(0, 4)+"` "
                                + "(`NIS`,"
                                + "`Name`,"
                                + "`Siafi`,"
                                + "`City`,"
                                + "`State`,"
                                + "`Region`,"
                                + "`File`,"
                                + "`Month`,"
                                + "`Year`,"
                                + "`Program`,"
                                + "`Action`,"
                                + "`Function`,"
                                + "`SubFunction`,"
                                + "`Source`,"
                                + "`Value`)"
                                + "VALUES ("
                                + data[7] + ",\""
                                + data[8].toUpperCase() + "\","
                                + data[1] + ", \""
                                + data[2].toUpperCase() + "\",\""
                                + data[0].toUpperCase() + "\",\""
                                + region + "\",\""
                                + fileCSV.getName().toUpperCase() + "\","
                                + Integer.parseInt(fileCSV.getName().substring(4, 6)) + ","
                                + Integer.parseInt(fileCSV.getName().substring(0, 4)) + ","
                                + Integer.parseInt(data[5]) + ","
                                + Integer.parseInt(data[6]) + ","
                                + Integer.parseInt(data[3]) + ","
                                + Integer.parseInt(data[4]) + ",\""
                                + data[9].toUpperCase() + "\","
                                + Double.parseDouble(data[10].replaceAll(",", "")) + ");\n";

                        StrW.write(SQL);

                        if (total % 10000 == 0) {
                            System.out.println("Lines = " + total);
                            StrW.flush();
                            System.gc();
                            System.runFinalization();
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
}
