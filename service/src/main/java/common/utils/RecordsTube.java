package common.utils;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by aksndr on 26.05.14.
 */
public class RecordsTube<E> extends ConcurrentLinkedDeque<E> {

    private int capacity;

    public RecordsTube(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean add(E e) {
        if (this.size() == 0) {
            return super.add(e);
        } else if (this.size() < capacity) {
            super.addFirst(e);
            return true;
        } else if (this.size() >= capacity) {
            super.addFirst(e);
            this.removeLast();
            return true;
        }
        return false;
    }

    public Object get(int index) {
        return this.toArray()[index];
    }
}