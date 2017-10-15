package main;

import functions.Convert;
import functions.ImportDBFull;
import functions.ImportDBOpt;
import functions.ImportDBPart;

/**
 *
 * @author tassio
 */
public class Main {

    public static void main(String[] args) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("Main");

        //Import file to DB
        Thread impPBFAction = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBPart impDB = new ImportDBPart();
                impDB.importPBF_Action();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                this.stop();
            }
        };

        Thread impPBFCities = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBPart impDB = new ImportDBPart();
                impDB.importPBF_Cities();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                this.stop();
            }
        };

        Thread impPBFFiles = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBPart impDB = new ImportDBPart();
                impDB.importPBF_Files();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                this.stop();
            }
        };

        Thread impPBFBeneficiaries = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBPart impDB = new ImportDBPart();
                impDB.importPBF_Beneciciaries();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                this.stop();
            }
        };

        Thread impPBFFunctions = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBPart impDB = new ImportDBPart();
                impDB.importPBF_Functions();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                this.stop();
            }
        };

        Thread impPBFPayments = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBPart impDB = new ImportDBPart();
                impDB.importPBF_Payments();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                this.stop();
            }
        };

        Thread impPBFProgram = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBPart impDB = new ImportDBPart();
                impDB.importPBF_Program();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                this.stop();
            }
        };

        Thread impPBFSource = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBPart impDB = new ImportDBPart();
                impDB.importPBF_Source();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                this.stop();
            }
        };

        Thread impPBFSubFunction = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBPart impDB = new ImportDBPart();
                impDB.importPBF_SubFunctions();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                this.stop();
            }
        };

        Thread impPBFOPT = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBOpt impDB = new ImportDBOpt();
                impDB.importPBF();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                this.stop();
            }
        };

        Thread impPBFFull = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                ImportDBFull impDB = new ImportDBFull();
                impDB.importPBF();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                System.exit(0);
            }
        };

        Thread ConvertSQL = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                Convert csql = new Convert();
                csql.convertPBF_SQL_Payments();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                System.exit(0);
            }
        };

        Thread ValidateData = new Thread() {
            @Override
            public void run() {
                long StartTime = System.currentTimeMillis();
                Convert valid = new Convert();
                valid.validatePBF_Datas();
                System.gc();
                long EndTime = System.currentTimeMillis();
                long totalms = ((EndTime - StartTime));
                long totalsec = (totalms / 1000) % 60;
                long totalmin = (totalms / 60000) % 60;
                long totalh = (totalms / 3600000);
                System.out.println("Files Imports - Total time ('HHH':'mm':'ss'.'SSS'): " + String.format("%03d:%02d:%02d.%03d", totalh, totalmin, totalsec, totalms));
                System.exit(0);
            }
        };

        //Imports for ports the datas
        impPBFBeneficiaries.start();
        //impPBFFiles.start();
        /*impPBFAction.start();
        impPBFCities.start();
        impPBFFunctions.start();
        impPBFProgram.start();
        impPBFSource.start();
        impPBFSubFunction.start();*/
        //Imports payments, but needs of functions after.
        //impPBFPayments.start();
        //Imports all datas in all files
        //impPBFFull.start();
        //Imports payments via SQL
        //impPBFOPT.start();
        //Geration SQL Import
        //ConvertSQL.start();
        //Validate Data Import
        //ValidateData.start();
    }
}
