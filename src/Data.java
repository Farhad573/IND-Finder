

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Data {

    private Customers customers;
    private LineItems lineItems;
    private Nation nation;
    private Orders orders;
    private Part part;
    private Region region;
    private Supplier supplier;

    private List<File> files;
    private List<List<String>> allColounms;
    private List<String> first = new ArrayList<>();
    private List<String> second = new ArrayList<>();
    private ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();

    private HashMap<String,List<String>> resultMap = new HashMap<>();

    public Data() throws IOException {
        makeFiles();
        readAll();
        removeDuplicates();
        sortAll();

//        checkCustomer();
//        checkLineItems();
//        checkNations();
//        checkOrders();
//        checkPart();
//        checkRegions();
//        checkSupplier();
       fillTheMap();
        appendAllColoumns();
        checkallColoumns();
      //  checkallColoumnsInParallel();
    }
    public  Comparator<String> getNumericStringComparator() {
        return (str1, str2) -> {
            // Try parsing the strings to compare numerically
            try {
//                str1 = str1.startsWith("\"")? str1.substring(1):str1;
//                str2 = str2.startsWith("\"")? str2.substring(1):str2;
                Double num1 = Double.parseDouble(str1);
                Double num2 = Double.parseDouble(str2);
                return num1.compareTo(num2);
            } catch (NumberFormatException e) {
                // If parsing fails, compare them lexicographically
                return str1.compareTo(str2);
            }
        };
    }

    public void fillTheMap(){
        map.put(0,"C_CUSTKEY");
        map.put(1,"C_NAME");
        map.put(2,"C_ADDRESS");
        map.put(3,"C_NATIONKEY");
        map.put(4,"C_PHONE");
        map.put(5,"C_ACCTBAL");
        map.put(6,"C_MKTSEGMENT");
        map.put(7,"C_COMMENT");

        map.put(8,"L_ORDERKEY");
        map.put(9,"L_PARTKEY");
        map.put(10,"L_SUPPKEY");
        map.put(11,"L_LINENUMBER");
        map.put(12,"L_QUANTITY");
        map.put(13,"L_EXTENDEDPRICE");
        map.put(14,"L_DISCOUNT");
        map.put(15,"L_TAX");
        map.put(16,"L_RETURNFLAG");
        map.put(17,"L_LINESTATUS");
        map.put(18,"L_SHIP");
        map.put(19,"L_RECEIPT");
        map.put(20,"L_COMMIT");
        map.put(21,"L_SHIPINSTRUCT");
        map.put(22,"L_SHIPMODE");
        map.put(23,"L_COMMENT");

        map.put(24,"N_NATIONKEY");
        map.put(25,"N_NAME");
        map.put(26,"N_REGIONKEY");
        map.put(27,"N_COMMENT");

        map.put(28,"O_ORDERKEY");
        map.put(29,"O_CUSTKEY");
        map.put(30,"O_ORDERSTATUS");
        map.put(31,"O_TOTALPRICE");
        map.put(32,"O_ORDER");
        map.put(33,"O_ORDERPRIORITY");
        map.put(34,"O_CLERK");
        map.put(35,"O_SHIPPRIORITY");
        map.put(36,"O_COMMENT");

        map.put(37,"P_PARTKEY");
        map.put(38,"P_NAME");
        map.put(39,"P_MFGR");
        map.put(40,"P_BRAND");
        map.put(41,"P_TYPE");
        map.put(42,"P_SIZE");
        map.put(43,"P_CONTAINER");
        map.put(44,"P_RETAILPRICE");
        map.put(45,"P_COMMENT");

        map.put(46,"R_REGIONKEY");
        map.put(47,"R_NAME");
        map.put(48,"R_COMMENT");

        map.put(49,"S_SUPPKEY");
        map.put(50,"S_NAME");
        map.put(51,"S_ADDRESS");
        map.put(52,"S_NATIONKEY");
        map.put(53,"S_PHONE");
        map.put(54,"S_ACCTBAL");
        map.put(55,"S_COMMENT");
        System.out.println("Map is filled");
    }

    public Customers getCustomers() {
        return customers;
    }

    public LineItems getLineItems() {
        return lineItems;
    }

    public Nation getNation() {
        return nation;
    }

    public Orders getOrders() {
        return orders;
    }

    public Part getPart() {
        return part;
    }

    public Region getRegion() {
        return region;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<List<String>> getAllColounms() {
        return allColounms;
    }

    public List<String> getFirst() {
        return first;
    }

    public List<String> getSecond() {
        return second;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public HashMap<String, List<String>> getResultMap() {
        return resultMap;
    }


    public boolean checkMap( String key, String value) {
        if (!this.resultMap.containsKey(key)) {
            this.resultMap.put(key, new ArrayList<>());
            this.resultMap.get(key).add(value);
            return true;
        }else
            if(!this.resultMap.get(key).contains(value)){
                this.resultMap.get(key).add(value);
                return true;
            }else
                return false;
    }

    public  void makeFiles(){
        File file = new File("resources");
        List<File> files = new ArrayList<>();
        for (File entry:
             file.listFiles()) {
            files.add(entry);
        }
        this.files = files;
        System.out.println("All files were made");
    }

    public void appendAllColoumns(){
        this.allColounms = new ArrayList<>();
        allColounms.addAll(this.customers.getLists());
        allColounms.addAll(this.lineItems.getLists());
        allColounms.addAll(this.nation.getLists());
        allColounms.addAll(this.orders.getLists());
        allColounms.addAll(this.part.getLists());
        allColounms.addAll(this.region.getLists());
        allColounms.addAll(this.supplier.getLists());
        System.out.println("all lists are appended");
    }

    public void readCustomerFile(File file) throws IOException {
        List<String> C_CUSTKEY = new ArrayList<>();
        List<String> C_NAME= new ArrayList<>();
        List<String> C_ADDRESS= new ArrayList<>();
        List<String> C_NATIONKEY= new ArrayList<>();
        List<String> C_PHONE= new ArrayList<>();
        List<String> C_ACCTBAL= new ArrayList<>();
        List<String> C_MKTSEGMENT= new ArrayList<>();
        List<String> C_COMMENT= new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        lists.add(C_CUSTKEY);
        lists.add(C_NAME);
        lists.add(C_ADDRESS);
        lists.add(C_NATIONKEY);
        lists.add(C_PHONE);
        lists.add(C_ACCTBAL);
        lists.add(C_MKTSEGMENT);
        lists.add(C_COMMENT);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null){
            String[] tokens = line.split("\";\"");
            for(int i = 0; i<tokens.length;i++){
                String token = tokens[i].startsWith("\"")? tokens[i].substring(1) : tokens[i];
                lists.get(i).add(token);
            }
        }
        reader.close();
        System.out.println("customer file is read");
//        for (int i = 0; i < lists.get(0).size(); i++) {
//            System.out.println(lists.get(0).get(i));
//        }
        this.customers = new Customers(C_CUSTKEY,C_NAME,C_ADDRESS,C_NATIONKEY,C_PHONE,C_ACCTBAL,C_MKTSEGMENT,C_COMMENT);
        this.customers.setLists(lists);

    }
    public void readLineItemFile(File file) throws IOException {
        List<String> L_ORDERKEY = new ArrayList<>();
        List<String> L_PARTKEY= new ArrayList<>();
        List<String> L_SUPPKEY= new ArrayList<>();
        List<String> L_LINENUMBER= new ArrayList<>();
        List<String> L_QUANTITY= new ArrayList<>();
        List<String> L_EXTENDEDPRICE= new ArrayList<>();
        List<String> L_DISCOUNT= new ArrayList<>();
        List<String> L_TAX= new ArrayList<>();
        List<String> L_RETURNFLAG= new ArrayList<>();
        List<String> L_LINESTATUS= new ArrayList<>();
        List<String> L_SHIP= new ArrayList<>();
        List<String> L_COMMIT= new ArrayList<>();
        List<String> L_RECEIPT= new ArrayList<>();
        List<String> L_SHIPINSTRUCT= new ArrayList<>();
        List<String> L_SHIPMODE= new ArrayList<>();
        List<String> L_COMMENT= new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        lists.add(L_ORDERKEY);
        lists.add(L_PARTKEY);
        lists.add(L_SUPPKEY);
        lists.add(L_LINENUMBER);
        lists.add(L_QUANTITY);
        lists.add(L_EXTENDEDPRICE);
        lists.add(L_DISCOUNT);
        lists.add(L_TAX);
        lists.add(L_RETURNFLAG);
        lists.add(L_LINESTATUS);
        lists.add(L_SHIP);
        lists.add(L_COMMIT);
        lists.add(L_RECEIPT);
        lists.add(L_SHIPINSTRUCT);
        lists.add(L_SHIPMODE);
        lists.add(L_COMMENT);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null){
            String[] tokens = line.split("\";\"");
            for(int i = 0; i<tokens.length;i++){
                String token = tokens[i].startsWith("\"")? tokens[i].substring(1) : tokens[i];
                lists.get(i).add(token);
            }
        }
        reader.close();
        System.out.println("lineItem file is read");
        this.lineItems = new LineItems(L_ORDERKEY,L_PARTKEY,L_SUPPKEY,L_LINENUMBER,L_QUANTITY,L_EXTENDEDPRICE,L_DISCOUNT,L_TAX,
                L_RETURNFLAG,
                L_LINESTATUS,
                L_SHIP,
                L_COMMIT,
                L_RECEIPT,
                L_SHIPINSTRUCT,
                L_SHIPMODE,
                L_COMMENT);
        this.lineItems.setLists(lists);
    }

    public void readNationFile(File file) throws IOException {
        List<String> N_NATIONKEY = new ArrayList<>();
        List<String> N_NAME= new ArrayList<>();
        List<String> N_REGIONKEY= new ArrayList<>();
        List<String> N_COMMENT= new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        lists.add(N_NATIONKEY);
        lists.add(N_NAME);
        lists.add(N_REGIONKEY);
        lists.add(N_COMMENT);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null){
            String[] tokens = line.split("\";\"");
            for(int i = 0; i<tokens.length;i++){
                String token = tokens[i].startsWith("\"")? tokens[i].substring(1) : tokens[i];
                lists.get(i).add(token);
            }
        }
        reader.close();
        System.out.println("Nation file is read");
        this.nation = new Nation(N_NATIONKEY,N_NAME,N_REGIONKEY,N_COMMENT);
        this.nation.setLists(lists);
    }

    public void readOrderFile(File file) throws IOException {
        List<String> O_ORDERKEY = new ArrayList<>();
        List<String> O_CUSTKEY= new ArrayList<>();
        List<String> O_ORDERSTATUS= new ArrayList<>();
        List<String> O_TOTALPRICE= new ArrayList<>();
        List<String> O_ORDER= new ArrayList<>();
        List<String> O_ORDERPRIORITY= new ArrayList<>();
        List<String> O_CLERK= new ArrayList<>();
        List<String> O_SHIPPRIORITY= new ArrayList<>();
        List<String> O_COMMENT= new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        lists.add(O_ORDERKEY);
        lists.add(O_CUSTKEY);
        lists.add(O_ORDERSTATUS);
        lists.add(O_TOTALPRICE);
        lists.add(O_ORDER);
        lists.add(O_ORDERPRIORITY);
        lists.add(O_CLERK);
        lists.add(O_SHIPPRIORITY);
        lists.add(O_COMMENT);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null){
            String[] tokens = line.split("\";\"");
            for(int i = 0; i<tokens.length;i++){
                String token = tokens[i].startsWith("\"")? tokens[i].substring(1) : tokens[i];
                lists.get(i).add(token);
            }
        }
        reader.close();
        System.out.println("Order file is read");
        this.orders = new Orders(O_ORDERKEY,O_CUSTKEY,O_ORDERSTATUS,O_TOTALPRICE,O_ORDER,O_ORDERPRIORITY,O_CLERK,O_SHIPPRIORITY,O_COMMENT);
        this.orders.setLists(lists);
    }
    public void readPartFile(File file) throws IOException {
        List<String> P_PARTKEY = new ArrayList<>();
        List<String> P_NAME= new ArrayList<>();
        List<String> P_MFGR= new ArrayList<>();
        List<String> P_BRAND= new ArrayList<>();
        List<String> P_TYPE= new ArrayList<>();
        List<String> P_SIZE= new ArrayList<>();
        List<String> P_CONTAINER= new ArrayList<>();
        List<String> P_RETAILPRICE= new ArrayList<>();
        List<String> P_COMMENT= new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        lists.add(P_PARTKEY);
        lists.add(P_NAME);
        lists.add(P_MFGR);
        lists.add(P_BRAND);
        lists.add(P_TYPE);
        lists.add(P_SIZE);
        lists.add(P_CONTAINER);
        lists.add(P_RETAILPRICE);
        lists.add(P_COMMENT);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null){
            String[] tokens = line.split("\";\"");
            for(int i = 0; i<tokens.length;i++){
                String token = tokens[i].startsWith("\"")? tokens[i].substring(1) : tokens[i];
                lists.get(i).add(token);
            }
        }
        reader.close();
        System.out.println("Part file is read");
        this.part = new Part(P_PARTKEY,P_NAME,P_MFGR,P_BRAND,P_TYPE,P_SIZE,P_CONTAINER,P_RETAILPRICE,P_COMMENT);
        this.part.setLists(lists);
    }
    public void readRegionFile(File file) throws IOException {
        List<String> R_REGIONKEY = new ArrayList<>();
        List<String> R_NAME= new ArrayList<>();
        List<String> R_COMMENT= new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        lists.add(R_REGIONKEY);
        lists.add(R_NAME);
        lists.add(R_COMMENT);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null){
            String[] tokens = line.split("\";\"");
            for(int i = 0; i<tokens.length;i++){
                String token = tokens[i].startsWith("\"")? tokens[i].substring(1) : tokens[i];
                lists.get(i).add(token);
            }
        }
        reader.close();
        System.out.println("Region file is read");
        this.region = new Region(R_REGIONKEY,R_NAME,R_COMMENT);
        this.region.setLists(lists);
    }
    public void readSupplierFile(File file) throws IOException {
        List<String> S_SUPPKEY = new ArrayList<>();
        List<String> S_NAME= new ArrayList<>();
        List<String> S_ADDRESS= new ArrayList<>();
        List<String> S_NATIONKEY= new ArrayList<>();
        List<String> S_PHONE= new ArrayList<>();
        List<String> S_ACCTBAL= new ArrayList<>();
        List<String> S_COMMENT= new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        lists.add(S_SUPPKEY);
        lists.add(S_NAME);
        lists.add(S_ADDRESS);
        lists.add(S_NATIONKEY);
        lists.add(S_PHONE);
        lists.add(S_ACCTBAL);
        lists.add(S_COMMENT);

        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null){
            String[] tokens = line.split("\";\"");
            for(int i = 0; i<tokens.length;i++){
                String token = tokens[i].startsWith("\"")? tokens[i].substring(1) : tokens[i];
                lists.get(i).add(token);
            }
        }
        reader.close();
        System.out.println("Supplier file is read");
        this.supplier = new Supplier(S_SUPPKEY,S_NAME,S_ADDRESS,S_NATIONKEY,S_PHONE,S_ACCTBAL,S_COMMENT);
        this.supplier.setLists(lists);
    }

    public void readAll() throws IOException {

        for (File file:
             this.files) {
            if(file.getName().contains("tpch_customer")){
                readCustomerFile(file);
            } else if (file.getName().contains("tpch_lineitem")) {
                readLineItemFile(file);
            }else if (file.getName().contains("tpch_nation")) {
                readNationFile(file);
            }else if (file.getName().contains("tpch_orders")) {
                readOrderFile(file);
            }else if (file.getName().contains("tpch_part")) {
                readPartFile(file);
            }else if (file.getName().contains("tpch_region")) {
                readRegionFile(file);
            }else if (file.getName().contains("tpch_supplier")) {
                readSupplierFile(file);
            }
        }
        System.out.println("All files were read");

    }
    public void removeDuplicates(){
        List<List<String>> customerList = new ArrayList<>();
        List<List<String>> lineItemList = new ArrayList<>();
        List<List<String>> nationList = new ArrayList<>();
        List<List<String>> orderList = new ArrayList<>();
        List<List<String>> partList = new ArrayList<>();
        List<List<String>> regionList = new ArrayList<>();
        List<List<String>> supplerList = new ArrayList<>();
        for (List<String> list:
                this.customers.getLists()) {
            List<String> tmp = new ArrayList<>(new HashSet<>(list));
            customerList.add(tmp);
        }
        this.customers.setLists(customerList);
        System.out.println("duplicates in customer are removed");
        for (List<String> list:
                this.lineItems.getLists()) {
            List<String> tmp = new ArrayList<>(new HashSet<>(list));
            lineItemList.add(tmp);
        }
        this.lineItems.setLists(lineItemList);
        System.out.println("duplicates in lineItems are removed");
        for (List<String> list:
                this.nation.getLists()) {
            List<String> tmp = new ArrayList<>(new HashSet<>(list));
            nationList.add(tmp);
        }
        this.nation.setLists(nationList);
        System.out.println("duplicates in nation are removed");
        for (List<String> list:
                this.orders.getLists()) {
            List<String> tmp = new ArrayList<>(new HashSet<>(list));
            orderList.add(tmp);
        }
        this.orders.setLists(orderList);
        System.out.println("duplicates in orders are removed");
        for (List<String> list:
                this.part.getLists()) {
            List<String> tmp = new ArrayList<>(new HashSet<>(list));
            partList.add(tmp);
        }
        this.part.setLists(partList);
        System.out.println("duplicates in parts are removed");
        for (List<String> list:
                this.region.getLists()) {
            List<String> tmp = new ArrayList<>(new HashSet<>(list));
            regionList.add(tmp);
        }
        this.region.setLists(regionList);
        System.out.println("duplicates in region are removed");
        for (List<String> list:
                this.supplier.getLists()) {
            List<String> tmp = new ArrayList<>(new HashSet<>(list));
            supplerList.add(tmp);
        }
        this.supplier.setLists(supplerList);
        System.out.println("duplicates in supplier are removed");
    }

    public void sortAll(){
        for (List<String> list:
             this.customers.getLists()) {
            Collections.sort(list,getNumericStringComparator());
        }
        System.out.println("customers are sorted");
        for (List<String> list:
                this.lineItems.getLists()) {
            Collections.sort(list,getNumericStringComparator());
        }
        System.out.println("lineItems are sorted");
        for (List<String> list:
                this.nation.getLists()) {
            Collections.sort(list,getNumericStringComparator());
        }
        System.out.println("nations are sorted");
        for (List<String> list:
                this.orders.getLists()) {
            Collections.sort(list,getNumericStringComparator());
        }
        System.out.println("orders are sorted");
        for (List<String> list:
                this.part.getLists()) {
            Collections.sort(list,getNumericStringComparator());
        }
        System.out.println("parts are sorted");
        for (List<String> list:
                this.region.getLists()) {
            Collections.sort(list,getNumericStringComparator());
        }
        System.out.println("regions are sorted");
        for (List<String> list:
                this.supplier.getLists()) {
            Collections.sort(list,getNumericStringComparator());
        }
        System.out.println("All files were sorted");
    }

    public void checkLineItems(){
        List<List<String>> lists = this.lineItems.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if(i==j){
                        break;
                    }
                    else if (lists.get(i).get(k) != lists.get(j).get(k)){
                        break;
                    } else if ((k == lists.get(i).size() - 1) && lists.get(i).get(k) == lists.get(j).get(k)) {
                        String coloumn1 = "";
                        String coloumn2 = "";
                        coloumn1 = this.lineItems.getMap().get(i);
                        coloumn2 = this.lineItems.getMap().get(j);
                        first.add(coloumn1);
                        second.add(coloumn2);
                    }
                }
            }
        }
        System.out.println("Columns in LineItems were checked ");
    }
    public void checkCustomer(){
        List<List<String>> lists = this.customers.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if(i==j){
                        break;
                    }
                    else if (lists.get(i).get(k) != lists.get(j).get(k)){
                        break;
                    } else if ((k == lists.get(i).size() - 1) && lists.get(i).get(k) == lists.get(j).get(k)) {
                        String coloumn1 = "";
                        String coloumn2 = "";
                        coloumn1 = this.customers.getMap().get(i);
                        coloumn2 = this.customers.getMap().get(j);
                        first.add(coloumn1);
                        second.add(coloumn2);
                    }
                }
            }
        }
        System.out.println("Columns in Customers were checked ");

    }
    public void checkNations(){
        List<List<String>> lists = this.supplier.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if(i==j){
                        break;
                    }
                    else if (lists.get(i).get(k) != lists.get(j).get(k)){
                        break;
                    } else if ((k == lists.get(i).size() - 1) && lists.get(i).get(k) == lists.get(j).get(k)) {
                        String coloumn1 = "";
                        String coloumn2 = "";
                        coloumn1 = this.nation.getMap().get(i);
                        coloumn2 = this.nation.getMap().get(j);
                        first.add(coloumn1);
                        second.add(coloumn2);
                    }
                }
            }
        }
        System.out.println("Columns in Nations were checked ");
    }
    public void checkOrders(){
        List<List<String>> lists = this.orders.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if(i==j){
                        break;
                    }
                    else if (lists.get(i).get(k) != lists.get(j).get(k)){
                        break;
                    } else if ((k == lists.get(i).size() - 1) && lists.get(i).get(k) == lists.get(j).get(k)) {
                        String coloumn1 = "";
                        String coloumn2 = "";
                        coloumn1 = this.orders.getMap().get(i);
                        coloumn2 = this.orders.getMap().get(j);
                        first.add(coloumn1);
                        second.add(coloumn2);
                    }
                }
            }
        }
        System.out.println("Columns in Orders were checked ");
    }
    public void checkPart(){
        List<List<String>> lists = this.part.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if(i==j){
                        break;
                    }
                    else if (lists.get(i).get(k) != lists.get(j).get(k)){
                        break;
                    } else if ((k == lists.get(i).size() - 1) && lists.get(i).get(k) == lists.get(j).get(k)) {
                        String coloumn1 = "";
                        String coloumn2 = "";
                        coloumn1 = this.part.getMap().get(i);
                        coloumn2 = this.part.getMap().get(j);
                        first.add(coloumn1);
                        second.add(coloumn2);
                    }
                }
            }
        }
        System.out.println("Columns in Parts were checked ");
    }
    public void checkRegions(){
        List<List<String>> lists = this.region.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if(i==j){
                        break;
                    }
                    else if (lists.get(i).get(k) != lists.get(j).get(k)){
                        break;
                    } else if ((k == lists.get(i).size() - 1) && lists.get(i).get(k) == lists.get(j).get(k)) {
                        String coloumn1 = "";
                        String coloumn2 = "";
                        coloumn1 = this.region.getMap().get(i);
                        coloumn2 = this.region.getMap().get(j);
                        first.add(coloumn1);
                        second.add(coloumn2);
                    }
                }
            }
        }
        System.out.println("Columns in Regions were checked ");
    }
    public void checkSupplier(){
        List<List<String>> lists = this.supplier.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if(i==j){
                        break;
                    }
                    else if (lists.get(i).get(k) != lists.get(j).get(k)){
                        break;
                    } else if ((k == lists.get(i).size() - 1) && lists.get(i).get(k) == lists.get(j).get(k)) {
                        String coloumn1 = "";
                        String coloumn2 = "";
                        coloumn1 = this.supplier.getMap().get(i);
                        coloumn2 = this.supplier.getMap().get(j);
                        first.add(coloumn1);
                        second.add(coloumn2);
                    }
                }
            }
        }
        System.out.println("Columns in Supplier were checked ");
    }
    public void checkallColoumns(){
        List<List<String>> lists = this.allColounms;
//        for(int i = 0; i< lists.size();i++){
//            for (int j = i+1; j< lists.size();j++){
//                System.out.println("i is:" + i);
//                System.out.println("j is:" + j);
//                int end = Math.min(lists.get(i).size(),lists.get(j).size());
//                for (int k = 0; k< end;k++){
//                    if( i==j ){
//                        break;
//                    }
//                    else if ((! lists.get(i).get(k).equals(lists.get(j).get(k)))){
//                        Set<String> second = new HashSet<>(lists.get(j));
//                        int finalI = i;
//                        int finalK = k;
//                        boolean notFound = second.parallelStream().anyMatch(x -> x.equals(lists.get(finalI).get(finalK)));
//                        if(! notFound) {
//                            System.out.println("no inclusion");
//                            break;
//                        }else {
//                            System.out.println("i is " + i +" j is " + j +" k is: " + k);
//                        }
//                    } else if ((k == end - 1) && (lists.get(i).get(k).equals(lists.get(j).get(k)) || lists.get(j).contains(lists.get(i).get(k)) )) {
//                        System.out.println("inclusion found");
//                        String coloumn1 = "";
//                        String coloumn2 = "";
//
//                        coloumn1 = lists.get(i).size() < lists.get(j).size()? this.map.get(i) : this.map.get(j);
//                        coloumn2 = lists.get(i).size() < lists.get(j).size()? this.map.get(j) : this.map.get(i);
//                        first.add(coloumn1);
//                        second.add(coloumn2);
//                    }else {
//                        System.out.println("k is: " + k);
//                    }
//                }
//            }
//        }
        int firstIndex = 18;
        int secondIndex = 20;
        System.out.println("size of listI is: " + lists.get(firstIndex).size());
        System.out.println("size of listJ is: " + lists.get(secondIndex).size());
        int limit = Math.min(lists.get(firstIndex).size(),lists.get(secondIndex).size());
       List<String> first = lists.get(firstIndex);
        List<String> second = lists.get(secondIndex);

        for (int i = 0; i < limit; i++) {
            if ((! first.get(i).equals(second.get(i)))){
                System.out.println("indexes are not equal. checking containment:");
                System.out.println("i is:" + first.get(i) + " j is: " + second.get(i));
                List<String> listI = limit != first.size()? first : second;
                List<String> listJ = limit == first.size()? first : second;
                if(! checkContainmentInParallelForLargeList(listI,listJ)) {
                    System.out.println(i);
                    System.out.println(first.get(i));
                    System.out.println(second.get(i));
                    System.out.println("no inclusion found");
                    return;
                }else {
                    System.out.println("inclusion found");
                    return;
                }
            } else if ((i == limit - 1) && (first.get(i).equals(second.get(i)) || second.contains(first.get(i)) )) {
                System.out.println("inclusion found");
            }else {

            }
        }
        System.out.println("All Columns were checked");
    }
    public void checkallColoumnsInParallel() {
        List<List<String>> lists = this.allColounms;
        for (int i = 0; i < lists.size(); i++) {
            System.out.println("i is:" + i);
            processInParallel(i);
        }
    }
    private void processInParallel(int i) {
        List<String> listI = this.allColounms.get(i);
        for (int j = i + 1; j < this.allColounms.size(); j++) {
            System.out.println("j is:" + j);
            List<String> listJ = this.allColounms.get(j);
            int end = Math.min(listI.size(), listJ.size());
            for (int k = 0; k < end; k++) {
                if (i == j) {
                    break;
                } else if (!listI.get(k).equals(listJ.get(k))) {
                    // Check the size of listJ
                        // Parallelize the check if listJ size exceeds the threshold
                    List<String> listII = end != listI.size()? listI : listJ;
                    List<String> listJJ = end == listI.size()? listI : listJ;
                        boolean notFound = checkContainmentInParallelForLargeList(listII, listJJ);
                        if (!notFound) {
                            System.out.println("no inclusion");
                            break;
                        } else if (notFound){
                            System.out.println("inclusion found");
                            String column1 = "";
                            String column2 = "";

                            column1 = listII.size() < listJJ.size() ? map.get(i) : map.get(j);
                            column2 = listII.size() < listJJ.size() ? map.get(j) : map.get(i);
                            first.add(column1);
                            second.add(column2);
                            if(listII.size() == listJJ.size()){
                                first.add(column2);
                                second.add(column1);
                            }

                            break;
                        }

                } else if ((k == end - 1) && (listI.get(k).equals(listJ.get(k)) || listJ.contains(listI.get(k)))) {
                    System.out.println("inclusion found");
                    String column1 = "";
                    String column2 = "";

                    column1 = listI.size() < listJ.size() ? map.get(i) : map.get(j);
                    column2 = listI.size() < listJ.size() ? map.get(j) : map.get(i);
                    first.add(column1);
                    second.add(column2);
                    if(listI.size() == listJ.size()){
                        first.add(column2);
                        second.add(column1);
                    }
                }
                else {
                    System.out.println("i is " + i + " j is " + j + "k is: " + k);
                }
            }
        }
    }

    private boolean checkContainment(String value, List<String> list) {
        return list.contains(value);
    }

    private boolean checkContainmentInParallelForLargeList(List<String> listI, List<String> listJ) {
        // Check containment in parallel for large list
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // Divide the list into segments for parallel processing
        List<Future<Boolean>> futures = new ArrayList<>();
        int segmentSize = listJ.size() / Runtime.getRuntime().availableProcessors();
        int remainder = listJ.size() % Runtime.getRuntime().availableProcessors();

        int start = 0;
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            System.out.println("number of loop is : " + i);
            int size = segmentSize + (remainder-- > 0 ? 1 : 0);
            int end = start + size;
            final int startIndex = start;
            final int endIndex = end;

            List<String> sublist = listJ.subList(startIndex,endIndex);

            // Submit segments to the executor for parallel processing
            Future<Boolean> future = executorService.submit(() ->
                    search(listI,sublist)
            );
            futures.add(future);

            start = end;
        }

        // Wait for all segments to complete
        boolean found = true;
        for (Future<Boolean> future : futures) {
            try {
                if (! future.get()) {
                    found = false;
                    break;
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shut down the executor service
        executorService.shutdown();

        return found;
    }

    public boolean search(List<String> listI, List<String> listJ){
        boolean result = true;
        for (int i = 0; i < listJ.size(); i++) {
            //System.out.println("checking index is:" + listJ.get(i));
            if (! listI.contains(listJ.get(i))){
                System.out.println("the following was not found in listI:" + listJ.get(i));
                return false;
            }
        }
        System.out.println("everything in listJ was included in listI");
        return result;
    }

}
