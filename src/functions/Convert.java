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

/**
 *
 * @author tassio
 */
public class Convert {

    public void convertPBF_SQL_Payments() {

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
                        beneficiaries = TbBeneficiariesDAO.getInstance().get(data[7]);

                        //SQL = "INSERT INTO `DB_ECA`.`tb_payments` (`tb_city_id_city`,`tb_functions_id_function`,`tb_subfunctions_id_subfunction`,`tb_program_id_program`,`tb_action_id_action`,`tb_beneficiaries_id_beneficiaries`,`tb_source_id_source`,`tb_files_id_file`,`db_value`)" + "VALUES" + "(" + "(SELECT id_city FROM DB_ECA.tb_city where str_cod_siafi_city=" + data[1] + ")," + "1," + "1," + "1," + "1," + "(SELECT id_beneficiaries FROM DB_ECA.tb_beneficiaries where str_nis=" + data[7] + ")," + source + "," + "1," + data[10].replaceAll(",", "") + ");";
                        SQL = "INSERT INTO `DB_ECA`.`tb_payments` (`tb_city_id_city`,`tb_functions_id_function`,`tb_subfunctions_id_subfunction`,`tb_program_id_program`,`tb_action_id_action`,`tb_beneficiaries_id_beneficiaries`,`tb_source_id_source`,`tb_files_id_file`,`db_value`)" + "VALUES" + "(" + city.getIdCity() + "," + "1," + "1," + "1," + "1," + beneficiaries + "," + source + "," + "1," + data[10].replaceAll(",", "") + ");";

                        StrW.write(SQL);
                    }
                    total++;
                }
                StrW.write("UNLOCK TABLES;");
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

    public void validatePBF_Datas() {
        //implementar
    }
}
