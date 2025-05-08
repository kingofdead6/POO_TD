package core;

import java.util.Collection;

public abstract class SortedGroup<T> {
    public abstract void insert(T element);
    public abstract T getElement(int index);
    protected abstract Collection<T> getContent();

    public void remove(T element) {
        getContent().remove(element);
    }

    public int size() {
        return getContent().size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        int i = 0;
        for (T element : getContent()) {
            sb.append("<").append(element).append(">");
            if (++i < size()) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
