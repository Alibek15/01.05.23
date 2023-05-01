import model.MyHashTable;
import model.Songs;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Songs, String> table = new MyHashTable<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Songs name = new Songs();
            Songs artist = new Songs();
            Songs year = new Songs();

        }
    }
}