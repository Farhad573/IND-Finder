import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nation {
    private  List<String> N_NATIONKEY;
    private  List<String> N_NAME;
    private   List<String> N_REGIONKEY;
    private   List<String> N_COMMENT;
    private   List<List<String>> lists = new ArrayList<>();
    Map<Integer,String> map;


    public Nation(List<String> n_NATIONKEY,
                  List<String> n_NAME,
                  List<String> n_REGIONKEY,
                  List<String> n_COMMENT) {
        N_NATIONKEY = n_NATIONKEY;
        N_NAME = n_NAME;
        N_REGIONKEY = n_REGIONKEY;
        N_COMMENT = n_COMMENT;
        lists.add(N_NATIONKEY);
        lists.add(N_NAME);
        lists.add(N_REGIONKEY);
        lists.add(N_COMMENT);
        map = new HashMap<>();
        map.put(0,"N_NATIONKEY");
        map.put(1,"N_NAME");
        map.put(2,"N_REGIONKEY");
        map.put(3,"N_COMMENT");
    }

    public List<String> getN_NATIONKEY() {
        return N_NATIONKEY;
    }

    public List<String> getN_NAME() {
        return N_NAME;
    }

    public List<String> getN_REGIONKEY() {
        return N_REGIONKEY;
    }

    public List<String> getN_COMMENT() {
        return N_COMMENT;
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
