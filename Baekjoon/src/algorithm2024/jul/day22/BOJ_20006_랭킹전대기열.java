package algorithm2024.jul.day22;

import java.io.*;
import java.util.*;


public class BOJ_20006_랭킹전대기열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Room{
        int level;
        List<Player> members;

        public Room(int level, Player player) {
            this.level = level;
            this.members = new ArrayList<>();
            members.add(player);
        }
    }

    static class Player{
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();


        loop:
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            for (Room room : rooms) {
                if(room.members.size()<m){
                    if(room.level>=l-10&&room.level<=l+10){
                        room.members.add(new Player(l,n));
                        continue loop;
                    }
                }
            }
            rooms.add(new Room(l, new Player(l,n)));

        }
        for (Room room : rooms) {
            Collections.sort(room.members, Comparator.comparing(o -> o.name));
            if(room.members.size()==m){
                sb.append("Started!\n");
            }else{
                sb.append("Waiting!\n");
            }
            for (Player member : room.members) {
                sb.append(member.level).append(" ").append(member.name).append("\n");
            }
        }
        System.out.println(sb);
    }
}
