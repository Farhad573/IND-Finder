import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public Data() throws IOException {
        makeFiles();
        readAll();
        sortAll();
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

    public  void makeFiles(){
        File file = new File("resources");
        List<File> files = new ArrayList<>();
        for (File entry:
             file.listFiles()) {
            files.add(entry);
        }
        this.files = files;
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
                lists.get(i).add(tokens[i]);
            }
        }
        this.customers = new Customers(C_CUSTKEY,C_NAME,C_ADDRESS,C_NATIONKEY,C_PHONE,C_ACCTBAL,C_MKTSEGMENT,C_COMMENT);
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
                lists.get(i).add(tokens[i]);
            }
        }
        this.lineItems = new LineItems(L_ORDERKEY,L_PARTKEY,L_SUPPKEY,L_LINENUMBER,L_QUANTITY,L_EXTENDEDPRICE,L_DISCOUNT,L_TAX,
                L_RETURNFLAG,
                L_LINESTATUS,
                L_SHIP,
                L_COMMIT,
                L_RECEIPT,
                L_SHIPINSTRUCT,
                L_SHIPMODE,
                L_COMMENT);
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
                lists.get(i).add(tokens[i]);
            }
        }
        this.nation = new Nation(N_NATIONKEY,N_NAME,N_REGIONKEY,N_COMMENT);
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
                lists.get(i).add(tokens[i]);
            }
        }
        this.orders = new Orders(O_ORDERKEY,O_CUSTKEY,O_ORDERSTATUS,O_TOTALPRICE,O_ORDER,O_ORDERPRIORITY,O_CLERK,O_SHIPPRIORITY,O_COMMENT);
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
                lists.get(i).add(tokens[i]);
            }
        }
        this.part = new Part(P_PARTKEY,P_NAME,P_MFGR,P_BRAND,P_TYPE,P_SIZE,P_CONTAINER,P_RETAILPRICE,P_COMMENT);
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
                lists.get(i).add(tokens[i]);
            }
        }
        this.region = new Region(R_REGIONKEY,R_NAME,R_COMMENT);
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
                lists.get(i).add(tokens[i]);
            }
        }
        this.supplier = new Supplier(S_SUPPKEY,S_NAME,S_ADDRESS,S_NATIONKEY,S_PHONE,S_ACCTBAL,S_COMMENT);
    }

    public void readAll() throws IOException {

        for (File file:
             this.files) {
            if(file.getName().contains("customer")){
                readCustomerFile(file);
            } else if (file.getName().contains("lineitem")) {
                readLineItemFile(file);
            }else if (file.getName().contains("nation")) {
                readNationFile(file);
            }else if (file.getName().contains("orders")) {
                readOrderFile(file);
            }else if (file.getName().contains("part")) {
                readPartFile(file);
            }else if (file.getName().contains("region")) {
                readRegionFile(file);
            }else if (file.getName().contains("supplier")) {
                readSupplierFile(file);
            }
        }
    }

    public void sortAll(){
        for (List<String> list:
             this.customers.getLists()) {
            Collections.sort(list);
        }
        for (List<String> list:
                this.lineItems.getLists()) {
            Collections.sort(list);
        }
        for (List<String> list:
                this.nation.getLists()) {
            Collections.sort(list);
        }for (List<String> list:
                this.orders.getLists()) {
            Collections.sort(list);
        }for (List<String> list:
                this.part.getLists()) {
            Collections.sort(list);
        }for (List<String> list:
                this.region.getLists()) {
            Collections.sort(list);
        }for (List<String> list:
                this.supplier.getLists()) {
            Collections.sort(list);
        }

    }

    public void checkLineItems(){
        List<List<String>> lists = this.lineItems.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if (lists.get(i).get(k) != lists.get(j).get(k)){
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
    }
    public void checkCustomer(){
        List<List<String>> lists = this.customers.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if (lists.get(i).get(k) != lists.get(j).get(k)){
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
    }
    public void checkNations(){
        List<List<String>> lists = this.supplier.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if (lists.get(i).get(k) != lists.get(j).get(k)){
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
    }
    public void checkOrders(){
        List<List<String>> lists = this.orders.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if (lists.get(i).get(k) != lists.get(j).get(k)){
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
    }
    public void checkPart(){
        List<List<String>> lists = this.part.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if (lists.get(i).get(k) != lists.get(j).get(k)){
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
    }
    public void checkRegions(){
        List<List<String>> lists = this.region.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if (lists.get(i).get(k) != lists.get(j).get(k)){
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
    }
    public void checkSupplier(){
        List<List<String>> lists = this.supplier.getLists();
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if (lists.get(i).get(k) != lists.get(j).get(k)){
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
    }
    public void checkallColoumns(){
        List<List<String>> lists = this.allColounms;
        for(int i = 0; i< lists.size();i++){
            for (int j = 1; j< lists.size();j++){
                for (int k = 0; k< lists.get(i).size();k++){
                    if (lists.get(i).get(k) != lists.get(j).get(k)){
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
    }
}
