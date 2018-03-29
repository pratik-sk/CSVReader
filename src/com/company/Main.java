package com.company;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static void generateCsvFile(String fileName,List<DataModel> l) {

        FileWriter writer = null;

        try {

            writer = new FileWriter(fileName);

            writer.append("handle");
            writer.append(',');
            writer.append("title");
            writer.append(',');
            writer.append("Body (HTML)");
            writer.append(',');
            writer.append("vendor");
            writer.append(',');
            writer.append("Type");
            writer.append(',');
            writer.append("Tags");
            writer.append(',');
            writer.append("Published");
            writer.append(',');
            writer.append("sku");
            writer.append(',');
            writer.append("Variant Barcode");
            writer.append(',');
            writer.append("Image Src");
            writer.append(',');
            writer.append("Author");
            writer.append(',');
            writer.append("YearLevel");
            writer.append('\n');


            for (DataModel e : l) {
                writer.append(e.getLong_Title());
                writer.append(',');
                writer.append(e.getLong_Title());
                writer.append(',');
                writer.append(e.getLong_Description());
                writer.append(',');
                writer.append(e.getImprint());
                writer.append(',');
                writer.append(e.getFormat());
                writer.append(',');
                writer.append('"'+e.getDivision()+","+e.getLearning_Area()+","+e.getSeries_lvl_1()+'"');
                writer.append(',');
                writer.append("TRUE");
                writer.append(',');
                writer.append(e.getISBN());
                writer.append(',');
                writer.append(e.getISBN());
                writer.append(',');
                writer.append("");
                writer.append(',');
                writer.append(e.getAuthor1());
                writer.append(',');
                writer.append(e.getYear_Level());

                writer.append('\n');
            }
            System.out.println("CSV file is created...");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readCSV(String fileName){
        try{
            Scanner scanner = new Scanner(new File(fileName));
            Scanner dataScanner = null;
            int index = 0;
            List<DataModel> dataList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                dataScanner = new Scanner(scanner.nextLine());
                dataScanner.useDelimiter(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
                DataModel d = new DataModel();

                while (dataScanner.hasNext()) {
                    String data = dataScanner.next();

                    switch (index){
                        case 0: d.setISBN(data);
                                break;
                        case 1: d.setDivision(data);
                                break;
                        case 2: d.setImprint(data);
                                break;
                        case 3: d.setCurriculum(data);
                                break;
                        case 4: d.setLearning_Area(data);
                                break;
                        case 5: d.setSubject(data);
                                break;
                        case 6: d.setStrand(data);
                                break;
                        case 7: d.setSeries_lvl_1(data);
                                break;
                        case 8: d.setYear_Level(data);
                                break;
                        case 9:d.setReading_Level(data);
                                break;
                        case 10: d.setReading_Age(data);
                                break;
                        case 11: d.setReading_Recovery_Level(data);
                                break;
                        case 12: d.setIntervention_Leading(data);
                                break;
                        case 13: d.setDRA(data);
                                break;
                        case 14: d.setGuided_reading_Level(data);
                                break;
                        case 15: d.setLexical_reading_Level(data);
                                break;
                        case 16: d.setColour_Wheel_System(data);
                                break;
                        case 17: d.setMacmillan_reading_Level(data);
                                break;
                        case 18: d.setComprhension_Skill(data);
                                break;
                        case 19: d.setTest_Type(data);
                                break;
                        case 20: d.setGenre(data);
                                break;
                        case 21: d.setPack_Type(data);
                                break;
                        case 22: d.setProduct_Type(data);
                                break;
                        case 23: d.setLong_Title(data);
                                break;
                        case 24: d.setSub_Title(data);
                                break;
                        case 25: d.setAuthor1(data);
                                break;
                        case 26: d.setAuthor2(data);
                                break;
                        case 27: d.setAuthor3(data);
                                break;
                        case 28: d.setAuthor4(data);
                                break;
                        case 29: d.setAuthor5(data);
                                break;
                        case 30: d.setAuthor6(data);
                                break;
                        case 31: d.setAUD_RRP(data);
                                break;
                        case 32: d.setNZ_RRP(data);
                                break;
                        case 33: d.setPub_Date(data);
                                break;
                        case 34: d.setEdition_Number(data);
                                break;
                        case 35: d.setFormat(data);
                                break;
                        case 36: d.setLong_Description(data);
                                break;
                        case 37: d.setShort_Description(data);
                                break;
                        case 38: d.setAuthor_Bio(data);
                                break;
                        case 39: d.setContents(data);
                                break;
                        case 40: d.setSales_Region(data);
                                break;
                        case 41: d.setBroucher(data);
                                break;
                        case 42: d.setSample_Page(data);
                                break;
                        case 43: d.setVideo(data);
                                break;
                        case 44: d.setProfessional_Development(data);
                                break;
                        case 45: d.setTeacher_Support_Material(data);
                                break;
                        default: System.out.println("invalid data::" + data);

                    }
                    index++;
                }
                index = 0;
                dataList.add(d);
            }
            scanner.close();

            System.out.println(dataList.get(40));
            String location = "/Users/pko1544/Java/src/newCsvFile.csv";
            generateCsvFile(location,dataList);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args)  {
            readCSV("/Users/pko1544/Java/src/data.csv");
    }
}


