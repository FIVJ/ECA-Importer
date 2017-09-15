package main;

import functions.Convert;
import functions.ImportDB;
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
        tcvt.start();
        //Import file to DB in unique table
        Thread tiptut = new Thread() {
            @Override
            public void run() {
                //medindo tempo
                long StartTime = System.currentTimeMillis();
                ImportDB impDB = new ImportDB();
                //impDB.importPBF_Payments();
                try {
                    impDB.importPBF_Drawal();
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
                System.out.println("Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
            }
        };
        tiptut.start();

    }
}
