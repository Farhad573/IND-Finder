import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Region {
    private  List<String> R_REGIONKEY;
    private   List<String> R_NAME;
    private   List<String> R_COMMENT;
    private   List<List<String>> lists = new ArrayList<>();
    private Map<Integer,String> map;


    public Region(List<String> r_REGIONKEY,
                  List<String> r_NAME,
                  List<String> r_COMMENT) {
        R_REGIONKEY = r_REGIONKEY;
        R_NAME = r_NAME;
        R_COMMENT = r_COMMENT;
        lists.add(R_REGIONKEY);
        lists.add(R_NAME);
        lists.add(R_COMMENT);
        map = new HashMap<>();
        map.put(0,"R_REGIONKEY");
        map.put(1,"R_NAME");
        map.put(2,"R_COMMENT");
    }

    public List<String> getR_REGIONKEY() {
        return R_REGIONKEY;
    }

    public List<String> getR_NAME() {
        return R_NAME;
    }

    public List<String> getR_COMMENT() {
        return R_COMMENT;
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
