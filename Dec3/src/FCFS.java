class Process{
    int pId;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnAroundTime;
    int waitingTime;

    public Process(int pId,int arrivalTime,int burstTime){
        this.pId = pId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

}
public class FCFS{
    /**
     * @param processes An array of Process objects.
     */
    public static void calculateTimes(Process [] processes){
        int n = processes.length;
        int currTime = 0;

        for(int i = 0; i< n;i++){
            Process p = processes[i];
            // 1. Calculate Completion Time

            // If the CPU is idle (curTime < process arrivale time) wait for AT.
            if(currTime < p.arrivalTime){
                currTime = p.arrivalTime;
            }
            // The process starts and runs for it's burst time
            p.completionTime = currTime + p.burstTime;
            // update the current time
            currTime = p.completionTime;

            //2. Calculate Turn around
            p.turnAroundTime = p.completionTime - p.arrivalTime;

            //3. Calculate waiting time;
            p.waitingTime = p.turnAroundTime - p.burstTime;
        }
    }
    public static void printAverageTimes(Process[] processes) {
        int n = processes.length;
        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;

        for (Process p : processes) {
            totalWaitingTime += p.waitingTime;
            totalTurnaroundTime += p.turnAroundTime;
        }

        double avgWaitingTime = totalWaitingTime / n;
        double avgTurnaroundTime = totalTurnaroundTime / n;

        System.out.println("\n--- Average Performance ---");
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaroundTime);
    }

    /**
     * Prints the details of all processes.
     * @param processes An array of Process objects.
     */
    public static void printResults(Process[] processes) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("PID | Arrival | Burst | Completion | Turnaround | Waiting ");
        System.out.println("------------------------------------------------------------------");
        for (Process p : processes) {
            System.out.printf("%3d | %7d | %5d | %10d | %10d | %7d \n",
                    p.pId, p.arrivalTime, p.burstTime,
                    p.completionTime, p.turnAroundTime, p.waitingTime);
        }
        System.out.println("------------------------------------------------------------------");
    }

    public static void main(String [] args){
        Process[] processes = {
                new Process(1, 0, 10),
                new Process(2, 2, 4),
                new Process(3, 5, 2),
                new Process(4, 6, 4)
        };

        calculateTimes(processes);
        printResults(processes);
        printAverageTimes(processes);
    }
}
