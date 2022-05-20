import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //SimulationManager sm = new SimulationManager(2, 10);
        // erfan // Faeze //
        Scanner sc = new Scanner(System.in);
        System.out.println("server number : ");
        int serverNum = sc.nextInt();
        System.out.println("event number : ");
        int eventNum = sc.nextInt();

        SimulationManager sm = new SimulationManager(serverNum, eventNum);
    }
}
