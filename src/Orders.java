import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orders {
    private  List<String> O_ORDERKEY;
    private  List<String> O_CUSTKEY;
    private   List<String> O_ORDERSTATUS;
    private   List<String> O_TOTALPRICE;
    private   List<String> O_ORDER;
    private   List<String> O_ORDERPRIORITY;
    private   List<String> O_CLERK;
    private   List<String> O_SHIPPRIORITY;
    private   List<String> O_COMMENT;
    private  List<List<String>> lists = new ArrayList<>();
    private Map<Integer,String> map;



    public Orders(List<String> o_ORDERKEY,
                  List<String> o_CUSTKEY,
                  List<String> o_ORDERSTATUS,
                  List<String> o_TOTALPRICE,
                  List<String> o_ORDER,
                  List<String> o_ORDERPRIORITY,
                  List<String> o_CLERK,
                  List<String> o_SHIPPRIORITY,
                  List<String> o_COMMENT) {
        O_ORDERKEY = o_ORDERKEY;
        O_CUSTKEY = o_CUSTKEY;
        O_ORDERSTATUS = o_ORDERSTATUS;
        O_TOTALPRICE = o_TOTALPRICE;
        O_ORDER = o_ORDER;
        O_ORDERPRIORITY = o_ORDERPRIORITY;
        O_CLERK = o_CLERK;
        O_SHIPPRIORITY = o_SHIPPRIORITY;
        O_COMMENT = o_COMMENT;
        lists.add(O_ORDERKEY);
        lists.add(O_CUSTKEY);
        lists.add(O_ORDERSTATUS);
        lists.add(O_TOTALPRICE);
        lists.add(O_ORDER);
        lists.add(O_ORDERPRIORITY);
        lists.add(O_CLERK);
        lists.add(O_SHIPPRIORITY);
        lists.add(O_COMMENT);
        map = new HashMap<>();
        map.put(0,"O_ORDERKEY");
        map.put(1,"O_CUSTKEY");
        map.put(2,"O_ORDERSTATUS");
        map.put(3,"O_TOTALPRICE");
        map.put(4,"O_ORDER");
        map.put(5,"O_ORDERPRIORITY");
        map.put(6,"O_CLERK");
        map.put(7,"O_SHIPPRIORITY");
        map.put(8,"O_COMMENT");
    }

    public List<String> getO_ORDERKEY() {
        return O_ORDERKEY;
    }

    public List<String> getO_CUSTKEY() {
        return O_CUSTKEY;
    }

    public List<String> getO_ORDERSTATUS() {
        return O_ORDERSTATUS;
    }

    public List<String> getO_TOTALPRICE() {
        return O_TOTALPRICE;
    }

    public List<String> getO_ORDER() {
        return O_ORDER;
    }

    public List<String> getO_ORDERPRIORITY() {
        return O_ORDERPRIORITY;
    }

    public List<String> getO_CLERK() {
        return O_CLERK;
    }

    public List<String> getO_SHIPPRIORITY() {
        return O_SHIPPRIORITY;
    }

    public List<String> getO_COMMENT() {
        return O_COMMENT;
    }

    public List<List<String>> getLists() {
        return lists;
    }
    public Map<Integer, String> getMap() {
        return map;
    }
}
