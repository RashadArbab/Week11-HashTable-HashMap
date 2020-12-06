// Represents a single value in a chain stored in one hash bucket.
class HashEntry {
    public int data;
    public HashEntry next;

    public HashEntry(int data) {
        this(data, null);
    }

    public HashEntry(int data, HashEntry next) {
        this.data = data;
        this.next = next;
    }
    
    @Override
    public boolean equals(Object other) {
        // Source:
        // https://www.sitepoint.com/implement-javas-equals-method-correctly/
        // self check
        if (this == other)
            return true;

        // null check
        if (other == null)
            return false;

        // type check and cast
        if (getClass() != other.getClass())
            return false;

        HashEntry count = (HashEntry) other;

        // field comparison (only check degree for equality)
        return this.data == count.data && this.next.equals(count.next);
    }
}