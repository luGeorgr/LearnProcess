package www.george.com.designpattern.state;

public abstract class LiftState {
    protected Context context;

    public void setContext(final Context context) {
        this.context = context;
    }

    protected void open() {
        throw new UnsupportedOperationException();
    }

    protected void close() {
        throw new UnsupportedOperationException();
    }
}
