import java.util.*;

public class LeetCode3433_CountMentions {
    static Scanner sc = new Scanner(System.in);
    public static int [] countMentions(int n, List<List<String>> events){
        events.sort((a,b)->{
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));

            if(timeA != timeB){
                return Integer.compare(timeA,timeB);
            }
            boolean aIsMessage = a.getFirst().equals("MESSAGE");
            boolean bIsMessage = b.getFirst().equals("MESSAGE");
            return Boolean.compare(aIsMessage,bIsMessage);
        });
        int [] countMentions = new int[n];
        int [] nextOnlineTime = new int[n];

        for(List<String> event : events){
            int curTime = Integer.parseInt(event.get(1));
            String type = event.getFirst();

            if(type.equals("MESSAGE")){
                String target = event.get(2);
                if(target.equals("ALL")){
                    for(int i = 0;i<n;i++){
                        countMentions[i]++;
                    }
                }else if(target.equals("HERE")){
                    for(int i =0;i<n;i++){
                        if(nextOnlineTime[i] <= curTime){
                            countMentions[i]++;
                        }
                    }
                }else{
                    String [] users = target.split(" ");
                    for(String user : users){
                        int idx = Integer.parseInt(user.substring(2));
                        countMentions[idx]++;
                    }
                }
            }else {
                int idx = Integer.parseInt(event.get(2));
                nextOnlineTime[idx] = curTime + 60;
            }
        }
        return countMentions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            // Read number of users
            int numberOfUsers = sc.nextInt();
            // Read next non-empty line (events)
            String line;
            do {
                line = sc.nextLine().trim();
            } while (line.isEmpty());

            List<List<String>> events = new ArrayList<>();

            // -------- FORMAT 1: JSON-like --------
            if (line.startsWith("[")) {

                // Remove outer [ ]
                line = line.substring(1, line.length() - 1);

                // Split individual events
                String[] rawEvents = line.split("\\],\\[");

                for (String raw : rawEvents) {
                    raw = raw.replace("[", "")
                            .replace("]", "")
                            .replace("\"", "");

                    String[] parts = raw.split(",");

                    List<String> event = new ArrayList<>();
                    event.add(parts[0].trim()); // MESSAGE / OFFLINE
                    event.add(parts[1].trim()); // time
                    event.add(parts[2].trim()); // target / user

                    events.add(event);
                }

            }
            // -------- FORMAT 2: CP-style --------
            else {
                int numberOfEvents = Integer.parseInt(line);

                for (int i = 0; i < numberOfEvents; i++) {
                    String eventLine = sc.nextLine().trim();
                    String[] parts = eventLine.split(" ", 3);

                    List<String> event = new ArrayList<>();
                    event.add(parts[0]);
                    event.add(parts[1]);
                    event.add(parts[2]);

                    events.add(event);
                }
            }

            // Solve
            int[] result = countMentions(numberOfUsers, events);

            // Print result
            for (int x : result) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }

}
