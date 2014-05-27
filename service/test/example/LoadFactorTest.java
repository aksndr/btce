package example;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * User: a.arzamastsev Date: 14.05.14 Time: 10:25
 */
public class LoadFactorTest {

        public static void main(String[] args) {

            HashMap <Integer,String> map =new LinkedHashMap<>(3, 1.1f);
            map.put(1, "Sandeep");
            map.put(2, "sangeeta");
            map.put(3, "Surabhi");
            map.put(4, "Sumanta");
            map.put(5, "Ram");
            map.put(6, "Shyam");
            map.put(7, "Rohan");
            map.put(8, "Tapan");
            map.put(9, "Hari");
            map.put(10, "Simon");
            map.put(11, "Joseph");
            map.put(12, "Heena");
            map.put(13, "Karan");
            map.put(14, "sujain");
            System.out.print(map.toString());

        }

}
