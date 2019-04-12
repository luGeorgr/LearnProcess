package www.george.com.designpattern.reactor;

public class Server {
    private Selector selector = new Selector();
    private Dispatcher eventLooper = new Dispatcher(selector);
    private Acceptor acceptor;

    Server(int port) {
        acceptor = new Acceptor(selector, port);
    }

    public void start() {
        eventLooper.registEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        eventLooper.handleEvents();
    }
}
