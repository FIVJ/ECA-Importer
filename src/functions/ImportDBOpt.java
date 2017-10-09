package functions;

import dao.TbPaymentsDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;

/**
 *
 * @author tassio
 */
public class ImportDBOpt {

    Logger logger = Logger.getLogger("Functions");

    public void importPBF() {
        logger.trace("Starting Method importPBF");
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

                        String SQL, source;

                        if (data[9].toUpperCase().equals("CAIXA - PROGRAMA BOLSA FAMÍLIA")) {
                            source = "1";
                        } else {
                            source = "2";
                        }

                        SQL = "INSERT INTO `DB_ECA`.`tb_payments`\n"
                                + "(`tb_city_id_city`,\n"
                                + "`tb_functions_id_function`,\n"
                                + "`tb_subfunctions_id_subfunction`,\n"
                                + "`tb_program_id_program`,\n"
                                + "`tb_action_id_action`,\n"
                                + "`tb_beneficiaries_id_beneficiaries`,\n"
                                + "`tb_source_id_source`,\n"
                                + "`tb_files_id_file`,\n"
                                + "`db_value`)\n"
                                + "VALUES\n"
                                + "("
                                + "(SELECT id_city FROM DB_ECA.tb_city where str_cod_siafi_city=" + data[1] + "),\n"
                                + "1,\n"
                                + "1,\n"
                                + "1,\n"
                                + "1,\n"
                                + "(SELECT id_beneficiaries FROM DB_ECA.tb_beneficiaries where str_nis=" + data[7] + "),\n"
                                + source + ",\n"
                                + "1,\n"
                                + data[10].replaceAll(",", "") + ");";

                        TbPaymentsDAO.getInstance().insert(SQL);
                        //System.out.println(SQL);

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
                        logger.trace("Ended Method importPBF");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }
}
