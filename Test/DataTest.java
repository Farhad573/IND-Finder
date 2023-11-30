import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {


    DataTest() throws IOException {
    }

    @Test
    public void checkCustomerReading() throws IOException {
        Data datas = new Data();
        File file = datas.getFiles().stream().filter(x-> x.getName().contains("customer")).findFirst().get();
        datas.readCustomerFile(file);
        List<List<String>> lists = datas.getCustomers().getLists();
        List<String> key = new ArrayList<>(new HashSet<>(lists.get(0)));
        Collections.sort(key,datas.getNumericStringComparator());
        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/customerTest.csv"));
        //String firstline = "C_CUSTKEY   C_NAME  C_ADDRESS   C_NATIONKEY     C_PHONE     C_ACCTBAL   C_MKTSEGMENT    C_COMMENT";
        //writer.write(firstline);
        //writer.newLine();
//        for (int i = 0; i < lists.get(0).size(); i++) {
//            for (int j = 0; j <lists.size(); j++) {
//                writer.write(lists.get(j).get(i));
//                writer.write("\t");
//                writer.write("\t");
//            }
//            writer.newLine();
//        }
      //  lists.get(0).forEach(System.out::println);
        for (int i = 0;i < key.size();i++
             ) {
            writer.write(key.get(i));
            writer.newLine();
        }
        writer.close();
        //System.out.println(lists.get(0).get(lists.get(0).size()-1));

    }

    @Test
    public void checkLineItemReading() throws IOException {
        Data datas = new Data();
        File file = datas.getFiles().stream().filter(x-> x.getName().contains("lineitem")).findFirst().get();
        datas.readLineItemFile(file);
        List<List<String>> lists = datas.getLineItems().getLists();
        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/lineItemTest.csv"));
        //String firstline = "C_CUSTKEY   C_NAME  C_ADDRESS   C_NATIONKEY     C_PHONE     C_ACCTBAL   C_MKTSEGMENT    C_COMMENT";
        //writer.write(firstline);
        //writer.newLine();
//        for (int i = 0; i < lists.get(0).size(); i++) {
//            for (int j = 0; j <lists.size(); j++) {
//                writer.write(lists.get(j).get(i));
//                writer.write("\t");
//                writer.write("\t");
//            }
//            writer.newLine();
//        }
        //  lists.get(0).forEach(System.out::println);
        for (int i = 0;i < lists.get(0).size();i++
        ) {
            writer.write(lists.get(15).get(i));
            writer.newLine();
        }
        writer.close();
        System.out.println(lists.get(12).size());

    }

    @Test
    public void checkNation() throws IOException {
        Data datas = new Data();
        File file = datas.getFiles().stream().filter(x-> x.getName().contains("nation")).findFirst().get();
        datas.readNationFile(file);
        List<List<String>> lists = datas.getNation().getLists();
        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/NationTest.csv"));
        //String firstline = "C_CUSTKEY   C_NAME  C_ADDRESS   C_NATIONKEY     C_PHONE     C_ACCTBAL   C_MKTSEGMENT    C_COMMENT";
        //writer.write(firstline);
        //writer.newLine();
//        for (int i = 0; i < lists.get(0).size(); i++) {
//            for (int j = 0; j <lists.size(); j++) {
//                writer.write(lists.get(j).get(i));
//                writer.write("\t");
//                writer.write("\t");
//            }
//            writer.newLine();
//        }
        //  lists.get(0).forEach(System.out::println);
        for (int i = 0;i < lists.get(0).size();i++
        ) {
            writer.write(lists.get(2).get(i));
            writer.newLine();
        }
        writer.close();
        //System.out.println(lists.get(12).size());

    }
    @Test
    public void checkOrders() throws IOException {
        Data datas = new Data();
        File file = datas.getFiles().stream().filter(x-> x.getName().contains("orders")).findFirst().get();
        datas.readOrderFile(file);
        List<List<String>> lists = datas.getOrders().getLists();
        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/OrdersTest.csv"));
        //String firstline = "C_CUSTKEY   C_NAME  C_ADDRESS   C_NATIONKEY     C_PHONE     C_ACCTBAL   C_MKTSEGMENT    C_COMMENT";
        //writer.write(firstline);
        //writer.newLine();
//        for (int i = 0; i < lists.get(0).size(); i++) {
//            for (int j = 0; j <lists.size(); j++) {
//                writer.write(lists.get(j).get(i));
//                writer.write("\t");
//                writer.write("\t");
//            }
//            writer.newLine();
//        }
        //  lists.get(0).forEach(System.out::println);
        for (int i = 0;i < lists.get(0).size();i++
        ) {
            writer.write(lists.get(5).get(i));
            writer.newLine();
        }
        writer.close();
        //System.out.println(lists.get(12).size());

    }
    @Test
    public void checkParts() throws IOException {
        Data datas = new Data();
        File file = datas.getFiles().stream().filter(x-> x.getName().contains("part")).findFirst().get();
        datas.readPartFile(file);
        List<List<String>> lists = datas.getPart().getLists();
        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/PartTest.csv"));
        //String firstline = "C_CUSTKEY   C_NAME  C_ADDRESS   C_NATIONKEY     C_PHONE     C_ACCTBAL   C_MKTSEGMENT    C_COMMENT";
        //writer.write(firstline);
        //writer.newLine();
//        for (int i = 0; i < lists.get(0).size(); i++) {
//            for (int j = 0; j <lists.size(); j++) {
//                writer.write(lists.get(j).get(i));
//                writer.write("\t");
//                writer.write("\t");
//            }
//            writer.newLine();
//        }
        //  lists.get(0).forEach(System.out::println);
        for (int i = 0;i < lists.get(0).size();i++
        ) {
            writer.write(lists.get(8).get(i));
            writer.newLine();
        }
        writer.close();
        //System.out.println(lists.get(12).size());

    }
    @Test
    public void checkRegion() throws IOException {
        Data datas = new Data();
        File file = datas.getFiles().stream().filter(x-> x.getName().contains("region")).findFirst().get();
        datas.readRegionFile(file);
        List<List<String>> lists = datas.getRegion().getLists();
        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/RegionTest.csv"));
        //String firstline = "C_CUSTKEY   C_NAME  C_ADDRESS   C_NATIONKEY     C_PHONE     C_ACCTBAL   C_MKTSEGMENT    C_COMMENT";
        //writer.write(firstline);
        //writer.newLine();
//        for (int i = 0; i < lists.get(0).size(); i++) {
//            for (int j = 0; j <lists.size(); j++) {
//                writer.write(lists.get(j).get(i));
//                writer.write("\t");
//                writer.write("\t");
//            }
//            writer.newLine();
//        }
        //  lists.get(0).forEach(System.out::println);
        for (int i = 0;i < lists.get(0).size();i++
        ) {
            writer.write(lists.get(2).get(i));
            writer.newLine();
        }
        writer.close();
        //System.out.println(lists.get(12).size());

    }
    @Test
    public void checkSupplier() throws IOException {
        Data datas = new Data();
        File file = datas.getFiles().stream().filter(x-> x.getName().contains("supplier")).findFirst().get();
        datas.readSupplierFile(file);
        List<List<String>> lists = datas.getSupplier().getLists();
        List<String> key = new ArrayList<>(new HashSet<>(lists.get(0)));
        Collections.sort(key,datas.getNumericStringComparator());
        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/SupplierTest.csv"));
        //String firstline = "C_CUSTKEY   C_NAME  C_ADDRESS   C_NATIONKEY     C_PHONE     C_ACCTBAL   C_MKTSEGMENT    C_COMMENT";
        //writer.write(firstline);
        //writer.newLine();
//        for (int i = 0; i < lists.get(0).size(); i++) {
//            for (int j = 0; j <lists.size(); j++) {
//                writer.write(lists.get(j).get(i));
//                writer.write("\t");
//                writer.write("\t");
//            }
//            writer.newLine();
//        }
        //  lists.get(0).forEach(System.out::println);
        for (int i = 0;i < key.size();i++
        ) {
            writer.write(key.get(i));
            writer.newLine();
        }
        writer.close();
        //System.out.println(lists.get(12).size());

    }
}