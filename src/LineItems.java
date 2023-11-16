import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineItems {
    private   List<String> L_ORDERKEY;
    private   List<String> L_PARTKEY;
    private   List<String> L_SUPPKEY;
    private   List<String> L_LINENUMBER;
    private  List<String> L_QUANTITY;
    private  List<String> L_EXTENDEDPRICE;
    private  List<String> L_DISCOUNT;
    private  List<String> L_TAX;
    private  List<String> L_RETURNFLAG;
    private  List<String> L_LINESTATUS;
    private  List<String> L_SHIP;
    private  List<String> L_COMMIT;
    private  List<String> L_RECEIPT;
    private  List<String> L_SHIPINSTRUCT;
    private  List<String> L_SHIPMODE;
    private  List<String> L_COMMENT;
    private  List<List<String>> lists = new ArrayList<>();
    Map<Integer,String> map;


    public LineItems(List<String> l_ORDERKEY,
                     List<String> l_PARTKEY,
                     List<String> l_SUPPKEY,
                     List<String> l_LINENUMBER,
                     List<String> l_QUANTITY,
                     List<String> l_EXTENDEDPRICE,
                     List<String> l_DISCOUNT,
                     List<String> l_TAX,
                     List<String> l_RETURNFLAG,
                     List<String> l_LINESTATUS,
                     List<String> l_SHIP,
                     List<String> l_COMMIT,
                     List<String> l_RECEIPT,
                     List<String> l_SHIPINSTRUCT,
                     List<String> l_SHIPMODE,
                     List<String> l_COMMENT) {
        L_ORDERKEY = l_ORDERKEY;
        L_PARTKEY = l_PARTKEY;
        L_SUPPKEY = l_SUPPKEY;
        L_LINENUMBER = l_LINENUMBER;
        L_QUANTITY = l_QUANTITY;
        L_EXTENDEDPRICE = l_EXTENDEDPRICE;
        L_DISCOUNT = l_DISCOUNT;
        L_TAX = l_TAX;
        L_RETURNFLAG = l_RETURNFLAG;
        L_LINESTATUS = l_LINESTATUS;
        L_SHIP = l_SHIP;
        L_COMMIT = l_COMMIT;
        L_RECEIPT = l_RECEIPT;
        L_SHIPINSTRUCT = l_SHIPINSTRUCT;
        L_SHIPMODE = l_SHIPMODE;
        L_COMMENT = l_COMMENT;
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
        map = new HashMap<>();
        map.put(0,"L_ORDERKEY");
        map.put(1,"L_PARTKEY");
        map.put(2,"L_SUPPKEY");
        map.put(3,"L_LINENUMBER");
        map.put(4,"L_QUANTITY");
        map.put(5,"L_EXTENDEDPRICE");
        map.put(6,"L_DISCOUNT");
        map.put(7,"L_TAX");
        map.put(8,"L_RETURNFLAG");
        map.put(9,"L_LINESTATUS");
        map.put(10,"L_SHIP");
        map.put(11,"L_RECEIPT");
        map.put(12,"L_COMMIT");
        map.put(13,"L_SHIPINSTRUCT");
        map.put(14,"L_SHIPMODE");
        map.put(15,"C_COMMENT");
    }

    public List<String> getL_ORDERKEY() {
        return L_ORDERKEY;
    }

    public List<String> getL_PARTKEY() {
        return L_PARTKEY;
    }

    public List<String> getL_SUPPKEY() {
        return L_SUPPKEY;
    }

    public List<String> getL_LINENUMBER() {
        return L_LINENUMBER;
    }

    public List<String> getL_QUANTITY() {
        return L_QUANTITY;
    }

    public List<String> getL_EXTENDEDPRICE() {
        return L_EXTENDEDPRICE;
    }

    public List<String> getL_DISCOUNT() {
        return L_DISCOUNT;
    }

    public List<String> getL_TAX() {
        return L_TAX;
    }

    public List<String> getL_RETURNFLAG() {
        return L_RETURNFLAG;
    }

    public List<String> getL_LINESTATUS() {
        return L_LINESTATUS;
    }

    public List<String> getL_SHIP() {
        return L_SHIP;
    }

    public List<String> getL_COMMIT() {
        return L_COMMIT;
    }

    public List<String> getL_RECEIPT() {
        return L_RECEIPT;
    }

    public List<String> getL_SHIPINSTRUCT() {
        return L_SHIPINSTRUCT;
    }

    public List<String> getL_SHIPMODE() {
        return L_SHIPMODE;
    }

    public List<String> getL_COMMENT() {
        return L_COMMENT;
    }

    public List<List<String>> getLists() {
        return lists;
    }
    public Map<Integer, String> getMap() {
        return map;
    }
}
