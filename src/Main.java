import java.io.*;
import java.util.*;
import java.util.concurrent.Future;

public class Main {


    public static void main(String[] args) throws IOException {
//        try {
//            PrintStream fileStream = new PrintStream(new FileOutputStream("log.txt"));
//            System.setOut(fileStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Data data = new Data();
//        for (List<String> list: data.getAllColounms()
//             ) {
//            System.out.println(list.size());
//        }

//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//        Set<Integer> set = new HashSet<>(list);
//        System.out.println(set.);

//    || (i == 8 || i == 9 || i == 10 || i == 28 || i == 29) && (j == 28 || j == 37 || j ==49)
        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/resultTest.txt"));
        writer.write("Coloumn1          coloum2");
        writer.newLine();
        for (int i = 0; i < data.getFirst().size(); i++) {
            writer.write(data.getFirst().get(i));
            writer.write("\t");
            writer.write("c");
            writer.write("\t");
            writer.write(data.getSecond().get(i));
            writer.newLine();
        }
        writer.close();
//        List<List<Integer>> lists = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add(i);
//        }
//        int segmentSize = list.size() / Runtime.getRuntime().availableProcessors();
//        int remainder = list.size() % Runtime.getRuntime().availableProcessors();
//
//        int start = 0;
//        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
//            int size = segmentSize + (remainder-- > 0 ? 1 : 0);
//            int end = start + size;
//            final int startIndex = start;
//            final int endIndex = end;
//
//            lists.add(list.subList(startIndex,endIndex));
//            start = end;
//        }
//        for (List<Integer> l: lists
//             ) {
//            l.forEach(System.out::println);
//            System.out.println();
//            System.out.println();
//        }
//
//
//        }
    }
}
