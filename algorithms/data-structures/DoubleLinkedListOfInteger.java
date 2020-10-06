
public class DoubleLinkedListOfInteger {

    private Node header;
    private Node trailer;
    private int count;

    private class Node {
        public Integer element;
        public Node next;
        public Node prev;

        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Add one element to the end of the list
     */
    public void add(Integer element) {
        Node n = new Node(element);
        Node last = trailer.prev;
        n.prev = last;
        n.next = trailer;
        last.next = n;
        trailer.prev = n;
        count++;
    }

    /**
     * Remove the first ocurence of a element at the list
     */
    public boolean remove(Integer element) {
        boolean achou = false;
        Node aux = header.next;

        while (achou != true && aux != null) {
            if (element.equals(aux.element)) {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                achou = true;
            } else {
                aux = aux.next;
            }
        }
        return achou;
    }

    /**
     * Remove a element at index x
     */
    public Integer remove(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node aux = null;
        if (index <= count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        Integer item = aux.element;
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;
        return item;
    }

    /**
     * See's if the list have some element x
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        while (aux != trailer) {
            if (aux.element.equals(element)) {
                return (true);
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Return element at index x
     */
    public Integer get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }

        Node aux = header.next;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return aux.element;
    }

    /**
     * Return index of the ocurence of the number x
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                return (i);
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Changes the value of some index to x
     */
    public Integer set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = header.next;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        Integer tmp = aux.element;
        aux.element = element;
        return tmp;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Return size
     */
    public int size() {
        return count;
    }

    /**
     * Checks if list is empty
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

}
