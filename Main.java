/**
 * 672115014 Nattikorn Sae-sue
 * nattikorn_s@cmu.ac.th
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("Please provide an csv file name in command line.");
            return;
        }
        String fileName = args[0];
        File file = new File(fileName);
        UniData uniData = new UniData();
        ArrayList<UniData> listOfUniversity = uniData.turnFileToArrayList(file);
        institutionToLowerCase(listOfUniversity);
        ArrayList<UniData> filteredUniveristyList = uniData.getSpecificNumbericRankUniversity(listOfUniversity);
        Collections.sort(filteredUniveristyList);
        uniData.printListOfUniversity(filteredUniveristyList);
        uniData.writeAllToNewFile(filteredUniveristyList, "QS-World-University-Rankings-2024_updated.csv");

    }

    public static void institutionToLowerCase(ArrayList<UniData> listOfUniversity) {
        for (int i=0; i<listOfUniversity.size(); i++) {
            listOfUniversity.get(i).setInstitution(listOfUniversity.get(i).getInstitution().toLowerCase());
        }
    }
    public static void institutionToUpperCase(ArrayList<UniData> listOfUniversity) {
        for (int i=0; i<listOfUniversity.size(); i++) {
            listOfUniversity.get(i).setInstitution(listOfUniversity.get(i).getInstitution().toUpperCase());
        }
    } 
}