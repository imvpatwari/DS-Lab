import java.util.Scanner;

public class SimpleRingElection {

    static class Process {
        int id;
        boolean isActive;

        Process(int id) {
            this.id = id;
            this.isActive = true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = scanner.nextInt();
        Process[] processes = new Process[n];

        // Input process IDs
        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID for process " + i + ": ");
            processes[i] = new Process(scanner.nextInt());
        }

        while (true) {
            System.out.println("\n1. Start Election\n2. Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter index of process to start election: ");
                int initiator = scanner.nextInt();

                if (!processes[initiator].isActive) {
                    System.out.println("Process is inactive. Choose another.");
                    continue;
                }

                startElection(processes, initiator);
            } else if (choice == 2) {
                System.out.println("Program ended.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    static void startElection(Process[] processes, int initiator) {
        int n = processes.length;
        int maxId = processes[initiator].id;
        System.out.println("Election started by Process " + maxId);

        int i = (initiator + 1) % n;
        while (i != initiator) {
            if (processes[i].isActive) {
                System.out.println("Process " + processes[i].id + " received election message.");
                if (processes[i].id > maxId) {
                    maxId = processes[i].id;
                }
            }
            i = (i + 1) % n;
        }

        System.out.println("Process " + maxId + " is elected as Coordinator.");
    }
}

