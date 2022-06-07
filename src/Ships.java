public class Ships implements Runnable {
    Port port;
    Ships(Port port) {
        this.port = port;
    }
    public void run(){
        for (int i = 0; i < 30; i++){
            port.newShip();
        }
    }
}


