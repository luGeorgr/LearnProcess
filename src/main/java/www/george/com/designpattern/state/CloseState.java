package www.george.com.designpattern.state;

public class CloseState extends LiftState {
    @Override
    public void open() {
        context.setState(Context.OPEN_STATE);
        System.out.println("open");
    }
}
