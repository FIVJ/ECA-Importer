package functions;

import dao.PbfPagamentos2013DAO;
import dao.PbfSaques2013DAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.PbfPagamentos2013;
import model.PbfSaques2013;
import org.apache.log4j.Logger;

/**
 *
 * @author tassio
 */
public class ImportDB2013 {

    Logger logger = Logger.getLogger("Functions");

    //2013
    public void importPBF_Payments2013() {
        logger.trace("Starting Method importPBF_Payments");
        File fInput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV/Pagamentos/2013");
        BufferedReader br = null;
        String line = "";
        String csvDivisor = "\t";
        File[] filesCSV = fInput.listFiles();

        for (int j = 0; j < filesCSV.length; j++) {
            File fileCSV = filesCSV[j];
            long totalimport = 0;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDivisor);
                    if (totalimport != 0) {

                        PbfPagamentos2013 pbf = new PbfPagamentos2013();

                        pbf.setUf(data[0]);
                        pbf.setCodigoSIAFIMunicipio(Integer.parseInt(data[1]));
                        pbf.setNomeMunicipio(data[2]);
                        pbf.setCodigoFuncao(Integer.parseInt(data[3]));
                        pbf.setCodigoSubfuncao(Integer.parseInt(data[4]));
                        pbf.setCodigoPrograma(Integer.parseInt(data[5]));
                        pbf.setCodigoAcao(Integer.parseInt(data[6]));
                        pbf.setNISFavorecido(data[7]);
                        pbf.setNomeFavorecido(data[8]);
                        pbf.setFonteFinalidade(data[9]);
                        pbf.setValorParcela(Double.parseDouble(data[10].replaceAll(",", "")));
                        pbf.setMesCompetencia(fileCSV.getName().substring(4, 6));
                        pbf.setAnoCompetencia(fileCSV.getName().substring(0, 4));
                        pbf.setArquivo(fileCSV.getName());
                        pbf.setAtualizacao("Mensal");
                        pbf.setOrigem("Caixa Econômica Federal");

                        PbfPagamentos2013DAO.getInstance().save(pbf);
                    }
                    totalimport++;
                }
            } catch (FileNotFoundException e) {
                logger.error("Unexpected error", e);
            } catch (IOException e) {
                logger.error("Unexpected error", e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                        logger.trace("Ended Method importPBF_Payments");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

    public void importPBF_Drawal2013() throws ParseException {
        logger.trace("Starting Method importPBF_Drawal");
        File fInput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV/Saques/2013");
        BufferedReader br = null;
        String line = "";
        String csvDivisor = "\t";
        File[] filesCSV = fInput.listFiles();

        for (int j = 0; j < filesCSV.length; j++) {
            File fileCSV = filesCSV[j];
            long totalimport = 0;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDivisor);
                    if (totalimport != 0) {
                        PbfSaques2013 pbf = new PbfSaques2013();
                        pbf.setUf(data[0]);
                        pbf.setCodigoSIAFIMunicipio(Integer.parseInt(data[1]));
                        pbf.setNomeMunicipio(data[2]);
                        pbf.setCodigoFuncao(Integer.parseInt(data[3]));
                        pbf.setCodigoSubfuncao(Integer.parseInt(data[4]));
                        pbf.setCodigoPrograma(Integer.parseInt(data[5]));
                        pbf.setCodigoAcao(Integer.parseInt(data[6]));
                        pbf.setNISFavorecido(data[7]);
                        pbf.setNomeFavorecido(data[8]);
                        pbf.setFonteFinalidade(data[9]);
                        pbf.setMesReferenciaParcela(data[10]);
                        pbf.setValorParcela(Double.parseDouble(data[11].replaceAll(",", "")));
                        pbf.setMesCompetencia(fileCSV.getName().substring(4, 6));
                        pbf.setAnoCompetencia(fileCSV.getName().substring(0, 4));
                        pbf.setAtualizacao("Mensal");
                        pbf.setOrigem("Caixa Econômica Federal");
                        pbf.setArquivo(fileCSV.getName());
                        if (data.length > 12) {
                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                            Date datasaque = formato.parse(data[13]);
                            pbf.setDataSaque(datasaque);
                        }
                        PbfSaques2013DAO.getInstance().save(pbf);
                    }
                    totalimport++;
                }
            } catch (FileNotFoundException e) {
                logger.error("Unexpected error", e);
            } catch (IOException e) {
                logger.error("Unexpected error", e);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                        logger.trace("Ended Method importPBF_Drawal");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

}
