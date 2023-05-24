import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
    public static void main(String[] args) {
        System.out.println("Receiver is running");
        try {
            DatagramSocket ds = new DatagramSocket(4444);
            while (true) {
                DatagramPacket pack = new DatagramPacket(new byte[64], 64);
                ds.receive(pack);
                System.out.println(new String(pack.getData()).trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
