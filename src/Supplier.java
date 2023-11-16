import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Supplier {
    private  List<String> S_SUPPKEY;
    private   List<String> S_NAME;
    private   List<String> S_ADDRESS;
    private   List<String> S_NATIONKEY;
    private   List<String> S_PHONE;
    private   List<String> S_ACCTBAL;
    private   List<String> S_COMMENT;
    private   List<List<String>> lists = new ArrayList<>();
    Map<Integer,String> map;


    public Supplier(List<String> s_SUPPKEY,
                    List<String> s_NAME,
                    List<String> s_ADDRESS,
                    List<String> s_NATIONKEY,
                    List<String> s_PHONE,
                    List<String> s_ACCTBAL,
                    List<String> s_COMMENT) {
        S_SUPPKEY = s_SUPPKEY;
        S_NAME = s_NAME;
        S_ADDRESS = s_ADDRESS;
        S_NATIONKEY = s_NATIONKEY;
        S_PHONE = s_PHONE;
        S_ACCTBAL = s_ACCTBAL;
        S_COMMENT = s_COMMENT;
        lists.add(S_SUPPKEY);
        lists.add(S_NAME);
        lists.add(S_ADDRESS);
        lists.add(S_NATIONKEY);
        lists.add(S_PHONE);
        lists.add(S_ACCTBAL);
        lists.add(S_COMMENT);
        map = new HashMap<>();
        map.put(0,"S_SUPPKEY");
        map.put(1,"S_NAME");
        map.put(2,"S_ADDRESS");
        map.put(3,"S_NATIONKEY");
        map.put(4,"S_PHONE");
        map.put(5,"S_ACCTBAL");
        map.put(6,"S_COMMENT");
    }

    public List<List<String>> getLists() {
        return lists;
    }

    public List<String> getS_SUPPKEY() {
        return S_SUPPKEY;
    }

    public List<String> getS_NAME() {
        return S_NAME;
    }

    public List<String> getS_ADDRESS() {
        return S_ADDRESS;
    }

    public List<String> getS_NATIONKEY() {
        return S_NATIONKEY;
    }

    public List<String> getS_PHONE() {
        return S_PHONE;
    }

    public List<String> getS_ACCTBAL() {
        return S_ACCTBAL;
    }

    public List<String> getS_COMMENT() {
        return S_COMMENT;
    }
    public Map<Integer, String> getMap() {
        return map;
    }
}
