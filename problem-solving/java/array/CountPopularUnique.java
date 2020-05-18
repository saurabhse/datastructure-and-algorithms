package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountPopularUnique {
    private String popularName = "";
    private int popularSize = -1;
    private boolean uniqueSize = false;
    private boolean uniqueName = false;
    private ShoeSizesAPI API;

    CountPopularUnique(){
        API = new ShoeSizesAPI();
        //processData();
    }

    public static void main(String[] args) {
        CountPopularUnique c = new CountPopularUnique();
        c.processData();
    }
    public void processData(){
        List<Integer> l = new ArrayList<Integer>();
        int total = API.getListLength();
        for(int i=0;i<total;i++){
            //System.out.println(API.getName(i));
            //System.out.println(API.getSize(i));
            l.add(API.getSize(i));
        }
        Integer maxVal = l.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .map(Map.Entry::getKey).orElse(null);
        Map<Long,List<Integer>> map = l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        List<Integer> result = map
                .entrySet().stream().max((o1, o2) -> o1.getKey().compareTo(o2.getKey())).map(Map.Entry::getValue)
                .orElse(Collections.emptyList());
        System.out.println(result);
    }
}

class ShoeSizesAPI {


    private List<ShoeSizesEntity> records;

    public ShoeSizesAPI() {
        populateValues();
    }

    private void populateValues() {

        records = new ArrayList<>();
        records.add(new ShoeSizesEntity(45, "Mich"));
        records.add(new ShoeSizesEntity(41, "Marry"));
        records.add(new ShoeSizesEntity(46, "Mich"));
        records.add(new ShoeSizesEntity(42, "Larry"));
        records.add(new ShoeSizesEntity(44, "Bob"));
        records.add(new ShoeSizesEntity(40, "Neo"));
            records.add(new ShoeSizesEntity(44, "Bob"));
        records.add(new ShoeSizesEntity(45, "Mich"));

    }

    public int getListLength() {
        return records.size();
    }

    public int getSize(int index) {
        return records.get(index).getSize();
    }

    public String getName(int index) {
        return records.get(index).getName();
    }

}

class ShoeSizesEntity {



    private int size;
    private String name;

    public ShoeSizesEntity(int size, String name) {

        this.size = size;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
