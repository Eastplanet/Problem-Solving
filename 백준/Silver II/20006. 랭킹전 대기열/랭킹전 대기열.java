import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int P;
	static ArrayList<Room> rooms;

	static class Room {
		boolean isStart;
		int createLv;
		ArrayList<Player> players;

		public Room(int createLv) {
			players = new ArrayList<>();
			this.createLv = createLv;
		}
	}

	static class Player implements Comparable<Player> {
		int lv;
		String name;
		
		public Player(int lv, String name) {
			super();
			this.lv = lv;
			this.name = name;
		}

		@Override
		public int compareTo(Player o) {
			return this.name.compareTo(o.name);
		}

		@Override
		public String toString() {
			return ""+lv+" "+this.name;
		}
		
	}
	
	public static int findRooms(int lv) {
		if (rooms.size() == 0)
			return -1;

		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).isStart) {
				continue;
			}

			if (rooms.get(i).createLv - 10 <= lv && lv <= rooms.get(i).createLv + 10) {
				return i;
			}
		}

		return -1;
	}

	public static void joinRooms(int lv, String name) {

		int roomNum = findRooms(lv);

		if (roomNum == -1) {
			rooms.add(new Room(lv));
			Room room = rooms.get(rooms.size() - 1);
			room.players.add(new Player(lv, name));
			if (room.players.size() == M) {
				room.isStart = true;
			}
			
			return;
		}

		Room room = rooms.get(roomNum);
		room.players.add(new Player(lv, name));
		if (room.players.size() == M) {
			room.isStart = true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();

		P = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		rooms = new ArrayList<>();

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(in.readLine());
			int lv = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			joinRooms(lv, name);
		}
		
		
		for(int i=0;i<rooms.size();i++) {
			if(rooms.get(i).isStart) {
				sb.append("Started!").append("\n");
			}
			else {
				sb.append("Waiting!").append("\n");
			}
			
			Collections.sort(rooms.get(i).players);
			for (Player p : rooms.get(i).players) {
				sb.append(p).append("\n");
			}
		}
		
		System.out.println(sb);
		
		
	}

	
}