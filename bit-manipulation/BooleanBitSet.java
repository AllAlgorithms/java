
/**
 * BooleanBitSet that encodes bits in longs, thus saving memory compared to a
 * boolean[] array.
 */
public class BooleanBitSet {

    final long[] storage;

    public BooleanBitSet(int size) {
        storage = new long[(int)Math.ceil(size / 64.0)];
    }

    public void set(int adress, boolean value){

        // translate adress to holding long
        int pos = (int)Math.floor(adress/ 64.0);
        long holder = storage[pos];
        int offset = adress % 64;

        if(value){
            holder |= 1 << offset;
        } else {
            holder &= ~(1 << offset);
        }
        storage[pos] = holder;
    }

    public boolean get(int adress){

        long holder = storage[(int)Math.floor(adress/ 64.0)];
        int offset = adress % 64;

        return ((holder >> offset) & 1) == 1;
    }

    public static void main(String...strings){

        BooleanBitSet b = new BooleanBitSet(20);
        b.set(0, true);
        b.set(1, true);
        b.set(3, true);
        b.set(5, true);

        System.out.println(b.get(0));
        System.out.println(b.get(1));
        System.out.println(b.get(2));
        System.out.println(b.get(3));
        System.out.println(b.get(4));
        System.out.println(b.get(5));
        System.out.println(b.get(6));
    }



}