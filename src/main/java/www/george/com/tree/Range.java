package www.george.com.tree;

/**
 * @author rouqiu
 *
 */
public class Range {
    private int mStart;
    private int mEnd;
    private int mMax;

    public void setStart(final int start) {
        mStart = start;
    }

    public int getStart() {
        return mStart;
    }

    public int getEnd() {
        return mEnd;
    }

    public int getMax() {
        return mMax;
    }

    public void setEnd(final int end) {
        mEnd = end;
    }

    public void setMax(final int max) {
        mMax = max;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass())) {
            return  false;
        }

        if (obj == this) {
            return true;
        }
        final Range other = (Range) obj;
        return mStart == other.mStart && mEnd == other.mEnd;
    }
}
