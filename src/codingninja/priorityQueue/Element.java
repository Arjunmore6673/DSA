package codingninja.priorityQueue;

public class Element<T> {
    T value ;
    Integer priority;

    public Element(T value, Integer priority) {
        this.value = value;
        this.priority = priority;
    }
}
