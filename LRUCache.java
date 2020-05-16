package systemDesign;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class LRUCache {
    Map cache = null;
    Stack order = null;
    int capacity = 0;


    public LRUCache(int capacity) {
        cache = new LinkedHashMap(capacity);

        order = new Stack();
        this.capacity = capacity;
    }

    public int get(int key) {

        if (cache.containsKey(key)) {

            order.remove(order.indexOf(key));

            order.push(key);

            return (int) cache.get(key);
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {

        if (cache.size() < capacity || cache.containsKey(key) ) {

            if(cache.containsKey(key))
                order.remove(order.indexOf(key));



                order.push(key);

            cache.put(key, value);

            //cachedOrder.put(key, 1);
        } else {
            int keyData = (int)order.firstElement();
            cache.remove(keyData);
            int num = order.indexOf(keyData);
            order.remove(num);
            cache.put(key,value);
            order.push(key);

        }

    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
       // int param_1 = obj.get(key);
        obj.put(1, 1);
        obj.put(2,2);
       // obj.put(3,3);
        //obj.put(4,4);
        System.out.print(obj.get(1)+" ");
        obj.put(3,3);
       // System.out.print(obj.get(3)+" ");
        System.out.print(obj.get(2)+" ");
       // System.out.print(obj.get(1)+" ");

        obj.put(4,4);
        System.out.print(obj.get(1)+" ");
       // obj.put(4,1);
        System.out.print(obj.get(3)+" ");
        System.out.print(obj.get(4)+" ");
       // System.out.print(obj.get(4)+" ");
       // System.out.print(obj.get(5)+" ");
    }
}
