public class Crane implements Runnable {
    Port port;
    Crane(Port port) {
        this.port = port;
    }
    public void run(){
        for (int i = 0; i < 1000; i++){
            port.shipment();
        }
    }
}
