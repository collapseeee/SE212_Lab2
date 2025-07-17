import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class UniData implements Comparable<UniData> {
    private String header1, header2;

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#");
        return getRank2024()+','+getRank2023()+','+getInstitution()+','+getLocation_code()+','+getLocation()+','+getSize()+','+getFocus()+','+getResearch()+','+getAge_band()+','+getStatus()+','
                +df.format(getAr_score())+','+getAr_rank()+','+df.format(getEr_score())+','+getEr_rank()+','+df.format(getFsr_score())+','+getFsr_rank()+','+
                df.format(getCpf_score())+','+getCpf_rank()+','+df.format(getIfr_score())+','+getIfr_rank()+','+df.format(getIsr_score())+','+getIsr_rank()+','+
                df.format(getIrn_score())+','+getIrn_rank()+','+df.format(getGer_score())+','+getGer_rank()+','+df.format(getSus_score())+','+getSus_rank()+','+df.format(getOverall_score());
    }
    @Override
    public int compareTo(UniData x) {
        return this.institution.replace("\"", "").compareToIgnoreCase(x.getInstitution().replace("\"", ""));
    }

    private String rank2024, rank2023, institution, location_code, location, size, focus, research, age_band, status,
            ar_rank, er_rank, fsr_rank, cpf_rank, ifr_rank, isr_rank, irn_rank, ger_rank, sus_rank;
    private Double ar_score, er_score, fsr_score, cpf_score, ifr_score, isr_score, irn_score, ger_score, sus_score, overall_score;
    public UniData() {}

    public String getRank2024() {
        return rank2024;
    }

    public String getRank2023() {
        return rank2023;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLocation_code() {
        return location_code;
    }

    public String getLocation() {
        return location;
    }

    public String getSize() {
        return size;
    }

    public String getFocus() {
        return focus;
    }

    public String getResearch() {
        return research;
    }

    public String getAge_band() {
        return age_band;
    }

    public String getStatus() {
        return status;
    }

    public Double getAr_score() {
        return ar_score;
    }

    public String getAr_rank() {
        return ar_rank;
    }

    public Double getEr_score() {
        return er_score;
    }

    public String getEr_rank() {
        return er_rank;
    }

    public Double getFsr_score() {
        return fsr_score;
    }

    public String getFsr_rank() {
        return fsr_rank;
    }

    public Double getCpf_score() {
        return cpf_score;
    }

    public String getCpf_rank() {
        return cpf_rank;
    }

    public Double getIfr_score() {
        return ifr_score;
    }

    public String getIfr_rank() {
        return ifr_rank;
    }

    public Double getIsr_score() {
        return isr_score;
    }

    public String getIsr_rank() {
        return isr_rank;
    }

    public Double getIrn_score() {
        return irn_score;
    }

    public String getIrn_rank() {
        return irn_rank;
    }

    public Double getGer_score() {
        return ger_score;
    }

    public String getGer_rank() {
        return ger_rank;
    }

    public Double getSus_score() {
        return sus_score;
    }

    public String getSus_rank() {
        return sus_rank;
    }

    public Double getOverall_score() {
        return overall_score;
    }

    public UniData(String rank2024, String rank2023, String institution, String location_code, String location, String size, String focus, String research, String age_band, String status,
                   Double ar_score, String ar_rank, Double er_score, String er_rank, Double fsr_score, String fsr_rank, Double cpf_score, String cpf_rank,
                   Double ifr_score, String ifr_rank, Double isr_score, String isr_rank, Double irn_score, String irn_rank, Double ger_score, String ger_rank,
                   Double sus_score, String sus_rank, Double overall_score) {
                    // Index that are score: 10,12,14,16,18,20,22,24,26,28.
                    // String that are rank: ar_rank, er_rank, fsr_rank, cpf_rank, ifr_rank, isr_rank, irn_rank, ger_rank, sus_rank.
        this.rank2024 = rank2024;
        this.rank2023 = rank2023;
        this.institution = institution;
        this.location_code = location_code;
        this.location = location;
        this.size = size;
        this.focus = focus;
        this.research = research;
        this.age_band = age_band;
        this.status = status;
        this.ar_score = ar_score;
        this.ar_rank = ar_rank;
        this.er_score = er_score;
        this.er_rank = er_rank;
        this.fsr_score = fsr_score;
        this.fsr_rank = fsr_rank;
        this.cpf_score = cpf_score;
        this.cpf_rank = cpf_rank;
        this.ifr_score = ifr_score;
        this.ifr_rank = ifr_rank;
        this.isr_score = isr_score;
        this.isr_rank = isr_rank;
        this.irn_score = irn_score;
        this.irn_rank = irn_rank;
        this.ger_score = ger_score;
        this.ger_rank = ger_rank;
        this.sus_score = sus_score;
        this.sus_rank = sus_rank;
        this.overall_score = overall_score;
    }


    public ArrayList<UniData> turnFileToArrayList(File file) throws FileNotFoundException {
        ArrayList<UniData> listOfUniversity = new ArrayList<UniData>();
        Scanner sc = new Scanner(file);
        header1 = sc.nextLine(); // skip 1st header
        header2 = sc.nextLine(); // skip 2nd header
        while(sc.hasNextLine()) {
            addUniData(listOfUniversity, sc.nextLine());
        }
        sc.close();
        return listOfUniversity;
    }
    public void printListOfUniversity(ArrayList<UniData> listOfUniversity) {
        System.out.println(header1);
        System.out.println(header2);
        for (int i=0; i< listOfUniversity.size(); i++) {
            System.out.println(listOfUniversity.get(i).toString());
        }
    }
    public int searchUniversityIndex(ArrayList<UniData> listOfUniversity, String university) {
        for (int i=0; i<listOfUniversity.size(); i++) {
            if (listOfUniversity.get(i).getInstitution().contains(university)) {
                return i;
            }
        }
        return -1;
    }
    public void writeToFileLastLine(ArrayList<UniData> listOfUniversity, String line, String fileName) {
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            for (int i=0; i<listOfUniversity.size(); i++) {
                pw.println(listOfUniversity.get(i).toString());
            }
            System.out.println("A new file " + fileName + " is created.");
            addUniData(listOfUniversity, line);
            pw.println(line);
            int index = listOfUniversity.size()-1;
            System.out.println(listOfUniversity.get(index).getInstitution() + " is added to index of " + index);
        } catch (FileNotFoundException e) {
            System.out.println("Target file to write not found.");
        }
    }
    public void writeAllToNewFile(ArrayList<UniData> listOfUniversity, String fileName) {
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            pw.println(header1);
            pw.println(header2);
            for (int i=0; i<listOfUniversity.size(); i++) {
                pw.println(listOfUniversity.get(i).toString());
            }
            System.out.println("File was successfully created.");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        }
    }
    public void addUniData(ArrayList<UniData> listOfUniversity, String line) {
        String[] input = lineSplitter(line);
        listOfUniversity.add(new UniData(input[0],input[1],input[2],input[3],input[4],input[5],input[6],input[7],input[8],input[9],
            scoreHandler(input[10]),input[11],scoreHandler(input[12]),input[13],scoreHandler(input[14]),input[15],scoreHandler(input[16]),input[17],scoreHandler(input[18]),input[19],scoreHandler(input[20]),
            input[21],scoreHandler(input[22]),input[23],scoreHandler(input[24]),input[25],scoreHandler(input[26]),input[27],scoreHandler(input[28])));
    }
    public ArrayList<UniData> getSpecificNumbericRankUniversity(ArrayList<UniData> listOfUniversity) {
        ArrayList<UniData> filteredUniversity = new ArrayList<UniData>();
        // String that are rank: ar_rank, er_rank, fsr_rank, cpf_rank, ifr_rank, isr_rank, irn_rank, ger_rank, sus_rank.
        for (UniData uni : listOfUniversity) {
            try {
            Integer.parseInt(uni.getRank2023().trim());
            Integer.parseInt(uni.getRank2024().trim());
            Integer.parseInt(uni.getAr_rank().trim());
            Integer.parseInt(uni.getEr_rank().trim());
            Integer.parseInt(uni.getFsr_rank().trim());
            Integer.parseInt(uni.getCpf_rank().trim());
            Integer.parseInt(uni.getIfr_rank().trim());
            Integer.parseInt(uni.getIsr_rank().trim());
            Integer.parseInt(uni.getIrn_rank().trim());
            Integer.parseInt(uni.getGer_rank().trim());
            Integer.parseInt(uni.getSus_rank().trim());
            filteredUniversity.add(uni);
            } catch (NumberFormatException e) {
                // Skip University if any rank is not an integer.
            }
        }
        return filteredUniversity;
    }
    public Double scoreHandler(String scoreStr) {
        Double score;
        try {
            score = (double) Math.round(Double.parseDouble(scoreStr));
        } catch (NumberFormatException e) {
            score = (double) 0;
        }
        return score;
    }
    public Double scoreRounding(Double score) {
        return (double) Math.round(score);
    }
    public String[] lineSplitter(String line) {
        String[] input = line.split(",", -1);
        // Comma Institution name handle.
        if (input[3].length()>2) {
            input[2] = input[2] + ", " + input[3];
            for (int i=3; i<input.length-1; i++) {
                input[i] = input[i+1];
            }
        }
        // Comma Country name handle.
        if (input[5].length() > 2) {
            input[4] = input[4] + ", " + input[5];
            for (int i=5; i<input.length-1; i++) {
                input[i] = input[i+1];
            }
        }
        return input;
    }
}
