import java.util.Iterator;

public interface Deque<t>{

    public boolean add(t value);

    public void addFirst(t value);

    public boolean contains(t value);

    public Iterator<t> iterator();

    public Iterator<t> descendingIterator();

    public t peek();

    public t peekLast();

    public t getFirst();

    public t getLast();

    public t remove();

    public boolean remove(Object o);

    public t removeLast();

    public int size();

}
