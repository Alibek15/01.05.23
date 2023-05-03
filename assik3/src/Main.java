import model.MyHashTable;
import model.Songs;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Songs, String> table = new MyHashTable<>();
         StringBuffer artist=new StringBuffer();
        StringBuffer name=new StringBuffer();
        StringBuffer album=new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int year=random.nextInt(1900,2020);
            for (int j = 0; j <20 ; j++) {
                name.append(random.nextInt(65,90));
            }
            for (int j = 0; j <20 ; j++) {
                artist.append(random.nextInt(65,90));
            }
            for (int j = 0; j <20 ; j++) {
                album.append(random.nextInt(65,90));
            }
            table.put(new Songs(name.toString(), artist.toString(),year),album.toString());
        }
        Songs val1=new Songs("After hours", "the Weekend", 2019 );
        Songs val2=new Songs("Blinding lights", "the Weekend", 2021 );
        System.out.println("Get " + table.get(val1));
         table.put(val1, "after hours");
        System.out.println("Contains " + table.contains("after hours"));
        System.out.println("Get key " + table.getKey("after hours"));
        System.out.println("remove " + table.remove(val2));
    }
}
