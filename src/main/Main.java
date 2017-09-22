package main;

import functions.Convert;
import functions.ImportDB2011;
import functions.ImportDB2012;
import functions.ImportDB2013;
import functions.ImportDB2014;
import functions.ImportDB2015;
import functions.ImportDB2016;
import functions.ImportDB2017;
import java.text.ParseException;

/**
 *
 * @author tassio
 */
public class Main {

    public static void main(String[] args) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("Main");

        //Convert file \t --> ;
        Thread tcvt = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                Convert cvt = new Convert();
                cvt.convertPBF_Payments();
                //cvt.convertPBF_Drawal();
                System.gc();   
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Total time ('HHH':'mm':'ss'.'SSSSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        //Import file to DB
        Thread imp11pg = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2011 impDB = new ImportDB2011();
                impDB.importPBF_Payments2011();
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Pagamentos 2011 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp11sc = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2011 impDB = new ImportDB2011();
                try {
                    impDB.importPBF_Drawal2011();
                } catch (ParseException ex) {
                    logger.error("Unexpected error", ex);
                }
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Saques 2011 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp12pg = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2012 impDB = new ImportDB2012();
                impDB.importPBF_Payments2012();
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Pagamentos 2012 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp12sc = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2012 impDB = new ImportDB2012();
                try {
                    impDB.importPBF_Drawal2012();
                } catch (ParseException ex) {
                    logger.error("Unexpected error", ex);
                }
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Saques 2012 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp13pg = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2013 impDB = new ImportDB2013();
                impDB.importPBF_Payments2013();
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Pagamentos 2013 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp13sc = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2013 impDB = new ImportDB2013();
                try {
                    impDB.importPBF_Drawal2013();
                } catch (ParseException ex) {
                    logger.error("Unexpected error", ex);
                }
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Saques 2013 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp14pg = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2014 impDB = new ImportDB2014();
                impDB.importPBF_Payments2014();
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Pagamentos 2014 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp14sc = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2014 impDB = new ImportDB2014();
                try {
                    impDB.importPBF_Drawal2014();
                } catch (ParseException ex) {
                    logger.error("Unexpected error", ex);
                }
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Saques 2014 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp15pg = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2015 impDB = new ImportDB2015();
                impDB.importPBF_Payments2015();
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Pagamentos 2015 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp15sc = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2015 impDB = new ImportDB2015();
                try {
                    impDB.importPBF_Drawal2015();
                } catch (ParseException ex) {
                    logger.error("Unexpected error", ex);
                }
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Saques 2015 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp16pg = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2016 impDB = new ImportDB2016();
                impDB.importPBF_Payments2016();
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Pagamentos 2016 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp16sc = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2016 impDB = new ImportDB2016();
                try {
                    impDB.importPBF_Drawal2016();
                } catch (ParseException ex) {
                    logger.error("Unexpected error", ex);
                }
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Saques 2016 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp17pg = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2017 impDB = new ImportDB2017();
                impDB.importPBF_Payments2017();
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Pagamentos 2017 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        Thread imp17sc = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB2017 impDB = new ImportDB2017();
                try {
                    impDB.importPBF_Drawal2017();
                } catch (ParseException ex) {
                    logger.error("Unexpected error", ex);
                }
                System.gc();
                //medindo tempo
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Saques 2017 - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };

        //run thread convert
        //tcvt.start();
        //run threads imports
        imp11pg.start();
        imp11sc.start();
        imp12pg.start();
        imp12sc.start();
        imp13pg.start();
        imp13sc.start();
        imp14pg.start();
        imp14sc.start();
        imp15pg.start();
        imp15sc.start();
        imp16pg.start();
        imp16sc.start();
        imp17pg.start();
        imp17sc.start();

    }
}
