import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part {
    private   List<String> P_PARTKEY;
    private  List<String> P_NAME;
    private  List<String> P_MFGR;
    private  List<String> P_BRAND;
    private   List<String> P_TYPE;
    private   List<String> P_SIZE;
    private   List<String> P_CONTAINER;
    private   List<String> P_RETAILPRICE;
    private   List<String> P_COMMENT;
    private   List<List<String>> lists = new ArrayList<>();
    private Map<Integer,String> map;


    public Part(List<String> p_PARTKEY,
                List<String> p_NAME,
                List<String> p_MFGR,
                List<String> p_BRAND,
                List<String> p_TYPE,
                List<String> p_SIZE,
                List<String> p_CONTAINER,
                List<String> p_RETAILPRICE,
                List<String> p_COMMENT) {
        P_PARTKEY = p_PARTKEY;
        P_NAME = p_NAME;
        P_MFGR = p_MFGR;
        P_BRAND = p_BRAND;
        P_TYPE = p_TYPE;
        P_SIZE = p_SIZE;
        P_CONTAINER = p_CONTAINER;
        P_RETAILPRICE = p_RETAILPRICE;
        P_COMMENT = p_COMMENT;
        lists.add(P_PARTKEY);
        lists.add(P_NAME);
        lists.add(P_MFGR);
        lists.add(P_BRAND);
        lists.add(P_TYPE);
        lists.add(P_SIZE);
        lists.add(P_CONTAINER);
        lists.add(P_RETAILPRICE);
        lists.add(P_COMMENT);
        map = new HashMap<>();
        map.put(0,"P_PARTKEY");
        map.put(1,"P_NAME");
        map.put(2,"P_MFGR");
        map.put(3,"P_BRAND");
        map.put(4,"P_TYPE");
        map.put(5,"P_SIZE");
        map.put(6,"P_CONTAINER");
        map.put(7,"P_RETAILPRICE");
        map.put(8,"P_COMMENT");
    }

    public List<String> getP_PARTKEY() {
        return P_PARTKEY;
    }

    public List<String> getP_NAME() {
        return P_NAME;
    }

    public List<String> getP_MFGR() {
        return P_MFGR;
    }

    public List<String> getP_BRAND() {
        return P_BRAND;
    }

    public List<String> getP_TYPE() {
        return P_TYPE;
    }

    public List<String> getP_SIZE() {
        return P_SIZE;
    }

    public List<String> getP_CONTAINER() {
        return P_CONTAINER;
    }

    public List<String> getP_RETAILPRICE() {
        return P_RETAILPRICE;
    }

    public List<String> getP_COMMENT() {
        return P_COMMENT;
    }

    public List<List<String>> getLists() {
        return lists;
    }
    public Map<Integer, String> getMap() {
        return map;
    }

    public void setLists(List<List<String>> lists) {
        this.lists = lists;
    }
}
