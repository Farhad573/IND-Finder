import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customers {
    private List<String> C_CUSTKEY;
    private List<String> C_NAME;
    private List<String> C_ADDRESS;
    private   List<String> C_NATIONKEY;
    private List<String> C_PHONE;
    private List<String> C_ACCTBAL;
    private List<String> C_MKTSEGMENT;
    private List<String> C_COMMENT;

    private List<List<String>> lists = new ArrayList<>();
    Map<Integer,String> map;

    public Customers(List<String> c_CUSTKEY,
                     List<String> c_NAME,
                     List<String> c_ADDRESS,
                     List<String> c_NATIONKEY,
                     List<String> c_PHONE,
                     List<String> c_ACCTBAL,
                     List<String> c_MKTSEGMENT,
                     List<String> c_COMMENT) {
        C_CUSTKEY = c_CUSTKEY;
        C_NAME = c_NAME;
        C_ADDRESS = c_ADDRESS;
        C_NATIONKEY = c_NATIONKEY;
        C_PHONE = c_PHONE;
        C_ACCTBAL = c_ACCTBAL;
        C_MKTSEGMENT = c_MKTSEGMENT;
        C_COMMENT = c_COMMENT;
        lists.add(C_CUSTKEY);
        lists.add(C_NAME);
        lists.add(C_ADDRESS);
        lists.add(C_NATIONKEY);
        lists.add(C_PHONE);
        lists.add(C_ACCTBAL);
        lists.add(C_MKTSEGMENT);
        lists.add(C_COMMENT);
        map = new HashMap<>();
        map.put(0,"C_CUSTKEY");
        map.put(1,"C_NAME");
        map.put(2,"C_ADDRESS");
        map.put(3,"C_NATIONKEY");
        map.put(4,"C_PHONE");
        map.put(5,"C_ACCTBAL");
        map.put(6,"C_MKTSEGMENT");
        map.put(7,"C_COMMENT");
    }



    public List<String> getC_CUSTKEY() {
        return C_CUSTKEY;
    }

    public List<String> getC_NAME() {
        return C_NAME;
    }

    public List<String> getC_ADDRESS() {
        return C_ADDRESS;
    }

    public List<String> getC_NATIONKEY() {
        return C_NATIONKEY;
    }

    public List<String> getC_PHONE() {
        return C_PHONE;
    }

    public List<String> getC_ACCTBAL() {
        return C_ACCTBAL;
    }

    public List<String> getC_MKTSEGMENT() {
        return C_MKTSEGMENT;
    }

    public List<String> getC_COMMENT() {
        return C_COMMENT;
    }

    public List<List<String>> getLists() {
        return lists;
    }

    public Map<Integer, String> getMap() {
        return map;
    }
}
