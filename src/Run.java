public class Run {
    public static void main(String[] args){
        Port port = new Port();
        Suppliers suppliers = new Suppliers(port);
        Crane crane = new Crane(port);
        Ships ships = new Ships(port);
        new Thread(suppliers).start();
        new Thread(crane).start();
        new Thread(ships).start();
    }
}
