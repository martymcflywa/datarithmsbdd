import java.lang.reflect.Array;

public class HashMap<TKey, TVal> {

    private Entry[] entries;
    private int initSize;
    private int size;
    private int collisions;
    private final int DEFAULT_INIT_SIZE = 128;
    private final int STEP_SIZE = 7;

    public HashMap() {
        this.initSize = getPrime(DEFAULT_INIT_SIZE * 2);
        this.entries = (Entry[]) Array.newInstance(Entry.class, initSize);
    }

    public TVal put(TKey key, TVal val) {
        int index = hash(key);
        int step = step(key);
        TVal out = null;

        while (entries[index] != null) {
            if (entries[index].key.equals(key)) {
                out = entries[index].setVal(val);
                break;
            }
            collisions++;
            index += step;
            index %= initSize;
        }
        entries[index] = new Entry(key, val);
        size++;
        return out;
    }

    public TVal get(TKey key) {
        int index = hash(key);
        int step = step(key);
        TVal out = null;

        while (entries[index] != null) {
            if (entries[index].key.equals(key)) {
                out = entries[index].val;
                break;
            }
            index += step;
            index %= initSize;
        }
        return out;
    }

    public TVal remove(TKey key) {
        int index = hash(key);
        int step = step(key);
        TVal out = null;

        while (entries[index] != null) {
            if (entries[index].key.equals(key)) {
                out = entries[index].val;
                entries[index] = null;
                break;
            }
            index += step;
            index %= initSize;
        }
        return out;
    }

    private int hash(TKey key) {
        return Math.abs(key.hashCode() % initSize);
    }

    private int step(TKey key) {
        return STEP_SIZE - Math.abs(key.hashCode() % STEP_SIZE);
    }

    private int getPrime(int initSize) {
        for (int i = initSize; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number % 2 == 0)
            return false;

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private class Entry {

        private TKey key;
        private TVal val;

        public Entry(TKey key, TVal val) {
            this.key = key;
            this.val = val;
        }

        public TKey key() {
            return key;
        }

        public TVal val() {
            return val;
        }

        public TVal setVal(TVal val) {
            TVal oldVal = this.val;
            this.val = val;
            return oldVal;
        }
    }
}
