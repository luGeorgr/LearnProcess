package www.george.com.designpattern.state;

import lombok.Getter;

public class Context {
    public static final LiftState OPEN_STATE = new OpenState();

    public static final LiftState CLOSE_STATE = new CloseState();

    @Getter
    private LiftState state;
    public void setState(final LiftState state) {
        state.setContext(this);
        this.state = state;
    }

    public void open() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public static void main(String[] argv) {
        final Context context = new Context();
        context.setState(OPEN_STATE);
        context.close();
        context.open();
    }
}
