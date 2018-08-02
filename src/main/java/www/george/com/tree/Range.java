package www.george.com.tree;

/**
 * @author rouqiu
 *
 */
public class Range {
    private int mStart;
    private int mEnd;

    public void setStart(final int start) {
        mStart = start;
    }

    public int getStart() {
        return mStart;
    }

    public int getEnd() {
        return mEnd;
    }

    public void setEnd(final int end) {
        mEnd = end;
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

    public boolean isOverlap(final Range other) {
        return mStart <= other.getEnd() && other.getStart() <= mEnd;
    }
}
