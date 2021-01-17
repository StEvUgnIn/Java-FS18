package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyList <E> implements Appendable<MyList<E>> {
    public MyList(MyList<E> list) {
        this(list.list);
    }

    public MyList(List<E> list) {
        this.list = list;
    }

    private List<E> list;

    @Override
    public MyList<E> append (MyList<E> list) {
        List<E> newList = new ArrayList<E>(this.list);
        Collections.copy(newList, list.list);
        return new MyList<>(newList);
    }

    public int size() {
        return list.size();
    }
}
