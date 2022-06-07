public class Suppliers implements Runnable {
    Port port;
    Suppliers(Port port) {
        this.port = port;
    }
    public void run(){
        for (int i = 0; i < 100; i++){
            port.accept();
        }
    }
}
