package functions;

import dao.TbActionDAO;
import dao.TbBeneficiariesDAO;
import dao.TbCityDAO;
import dao.TbFilesDAO;
import dao.TbFunctionsDAO;
import dao.TbPaymentsDAO;
import dao.TbProgramDAO;
import dao.TbSourceDAO;
import dao.TbStateDAO;
import dao.TbSubfunctionsDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import model.TbAction;
import model.TbBeneficiaries;
import model.TbCity;
import model.TbFiles;
import model.TbFunctions;
import model.TbPayments;
import model.TbProgram;
import model.TbSource;
import model.TbState;
import model.TbSubfunctions;
import org.apache.log4j.Logger;

/**
 *
 * @author tassio
 */
public class ImportDBPart {

    Logger logger = Logger.getLogger("Functions");

    public void importPBF_Cities() {
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

                        TbCity tbcity = TbCityDAO.getInstance().get(data[1]);

                        if (tbcity == null) {
                            TbState tbstate = TbStateDAO.getInstance().get(data[0]);
                            if (tbstate != null) {
                                tbcity = new TbCity();
                                tbcity.setTbStateIdState(tbstate);
                                tbcity.setStrCodSiafiCity(data[1]);
                                tbcity.setStrNameCity(data[2].toUpperCase());
                                TbCityDAO.getInstance().save(tbcity);
                            } else {
                                logger.error("Unexpected error");
                                System.exit(1);
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
                        logger.trace("Ended Method importPBF");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

    public void importPBF_Functions() {
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

                        TbFunctions tbfunctions = TbFunctionsDAO.getInstance().get(data[3]);
                        if (tbfunctions != null) {
                            tbfunctions = new TbFunctions();
                            tbfunctions.setStrCodFunction(data[3]);
                            tbfunctions.setStrNameFunction("Unknown".toUpperCase());
                            TbFunctionsDAO.getInstance().save(tbfunctions);
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
                        logger.trace("Ended Method importPBF");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

    public void importPBF_SubFunctions() {
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

                        TbSubfunctions tbsubfunctions = TbSubfunctionsDAO.getInstance().get(data[4]);
                        if (tbsubfunctions == null) {
                            tbsubfunctions = new TbSubfunctions();
                            tbsubfunctions.setStrCodSubfunction(data[4]);
                            tbsubfunctions.setStrNameSubfunction("Unknown".toUpperCase());
                            TbSubfunctionsDAO.getInstance().save(tbsubfunctions);
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
                        logger.trace("Ended Method importPBF");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

    public void importPBF_Program() {
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

                        TbProgram tbprogram = TbProgramDAO.getInstance().get(data[5]);
                        if (tbprogram == null) {
                            tbprogram = new TbProgram();
                            tbprogram.setStrCodProgram(data[5]);
                            tbprogram.setStrNameProgram("Unknown".toUpperCase());
                            TbProgramDAO.getInstance().save(tbprogram);
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
                        logger.trace("Ended Method importPBF");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

    public void importPBF_Action() {
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

                        TbAction tbaction = TbActionDAO.getInstance().get(data[6]);
                        if (tbaction == null) {
                            tbaction = new TbAction();
                            tbaction.setStrCodAction(data[6]);
                            tbaction.setStrNameAction("Unknown".toUpperCase());
                            TbActionDAO.getInstance().save(tbaction);
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
                        logger.trace("Ended Method importPBF");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

    public void importPBF_Beneciciaries() {
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

                        TbBeneficiaries tbbeneficiaries = TbBeneficiariesDAO.getInstance().get(data[7]);
                        if (tbbeneficiaries == null) {
                            tbbeneficiaries = new TbBeneficiaries();
                            tbbeneficiaries.setStrNis(data[7]);
                            tbbeneficiaries.setStrNamePerson(data[8].toUpperCase());
                            TbBeneficiariesDAO.getInstance().save(tbbeneficiaries);
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
                        logger.trace("Ended Method importPBF");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

    public void importPBF_Source() {
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

                        TbSource tbsource = TbSourceDAO.getInstance().get(data[9].toUpperCase());
                        if (tbsource == null) {
                            tbsource = new TbSource();
                            tbsource.setStrGoal(data[9].toUpperCase());
                            tbsource.setStrOrigin("Caixa Econômica Federal".toUpperCase());
                            tbsource.setStrPeriodicity("Mensal".toUpperCase());
                            TbSourceDAO.getInstance().save(tbsource);
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
                        logger.trace("Ended Method importPBF");
                    } catch (IOException e) {
                        logger.error("Unexpected error", e);
                    }
                }
            }
        }
    }

    public void importPBF_Files() {
        logger.trace("Starting Method importPBF");
        File fInput = new File("/Users/tassio/NetBeansProjects/ECA-Importer/CSV/Pagamentos");
        BufferedReader br = null;
        String line = "";
        String csvDivisor = "\t";
        File[] filesCSV = fInput.listFiles();

        for (File filesCSV1 : filesCSV) {
            long StartTime = System.currentTimeMillis();
            File fileCSV = filesCSV1;

            TbFiles tbfiles = TbFilesDAO.getInstance().get(fileCSV.getName().toUpperCase());
            if (tbfiles != null) {
                tbfiles = new TbFiles();
                tbfiles.setStrNameFile(fileCSV.getName().toUpperCase());
                tbfiles.setStrMonth(fileCSV.getName().substring(4, 6));
                tbfiles.setStrYear(fileCSV.getName().substring(0, 4));
                TbFilesDAO.getInstance().save(tbfiles);
            }

            long EndTime = System.currentTimeMillis();
            long totalms = ((EndTime - StartTime));
            long totalsec = (totalms / 1000) % 60;
            long totalmin = (totalms / 60000) % 60;
            long totalh = (totalms / 3600000);
            System.out.println("File " + fileCSV.getName() + " - Total time ('HHH':'mm':'ss'.'SSSSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));

        }
    }

    public void importPBF_Payments() {
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
            long idB = 0;
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(fInput + "/" + fileCSV.getName()), "ISO-8859-1"));
                System.out.println(fileCSV.getName());
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDivisor);
                    if (totalimport != 0) {

                        TbPayments tbpayments = new TbPayments();

                        TbCity tbcity = TbCityDAO.getInstance().get(data[1]);
                        tbpayments.setTbCityIdCity(tbcity);

                        //TbFunctions tbfunctions = TbFunctionsDAO.getInstance().get(data[3]);
                        TbFunctions tbfunctions = new TbFunctions();
                        tbfunctions.setIdFunction(1);
                        tbpayments.setTbFunctionsIdFunction(tbfunctions);

                        //TbSubfunctions tbsubfunctions = TbSubfunctionsDAO.getInstance().get(data[4]);
                        TbSubfunctions tbsubfunctions = new TbSubfunctions();
                        tbsubfunctions.setIdSubfunction(1);
                        tbpayments.setTbSubfunctionsIdSubfunction(tbsubfunctions);

                        //TbProgram tbprogram = TbProgramDAO.getInstance().get(data[5]);
                        TbProgram tbprogram = new TbProgram();
                        tbprogram.setIdProgram(1);
                        tbpayments.setTbProgramIdProgram(tbprogram);

                        //TbAction tbaction = TbActionDAO.getInstance().get(data[6]);
                        TbAction tbaction = new TbAction();
                        tbaction.setIdAction(1);
                        tbpayments.setTbActionIdAction(tbaction);

                        //TbBeneficiaries tbbeneficiaries = TbBeneficiariesDAO.getInstance().get(data[7]);
                        TbBeneficiaries tbbeneficiaries = new TbBeneficiaries();
                        tbbeneficiaries.setIdBeneficiaries(idB);
                        tbpayments.setTbBeneficiariesIdBeneficiaries(tbbeneficiaries);

                        //TbSource tbsource = TbSourceDAO.getInstance().get(data[9].toUpperCase());
                        if (data[9].toUpperCase().equals("CAIXA - PROGRAMA BOLSA FAMÍLIA")) {
                            TbSource tbsource = new TbSource();
                            tbsource.setIdSource(1);
                            tbpayments.setTbSourceIdSource(tbsource);
                        } else {
                            TbSource tbsource = new TbSource();
                            tbsource.setIdSource(2);
                            tbpayments.setTbSourceIdSource(tbsource);
                        }

                        //TbFiles tbfiles = TbFilesDAO.getInstance().get(fileCSV.getName().toUpperCase());
                        TbFiles tbfiles = new TbFiles();
                        tbfiles.setIdFile(1);
                        tbpayments.setTbFilesIdFile(tbfiles);

                        tbpayments.setDbValue(Double.parseDouble(data[10].replaceAll(",", "")));
                        TbPaymentsDAO.getInstance().persist(tbpayments);
                    }
                    totalimport++;
                    idB++;
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