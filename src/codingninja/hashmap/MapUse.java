package codingninja.hashmap;

public class MapUse {
    public static void main(String[] args) {
        MapCustom<Integer, Integer> map = new MapCustom<>();
        map.insert(1, 2);
        map.insert(3, 22);
        map.insert(2, 22);
        System.out.println(map.search(23));
        System.out.println(map.getCount());
        map.delete(3);
        map.delete(1);
    }
}
