package www.george.com.designpattern.state;

public class OpenState extends LiftState {
    @Override
    public void close() {
        context.setState(Context.CLOSE_STATE);
        System.out.println("close");
    }
}
