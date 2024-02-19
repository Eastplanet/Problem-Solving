import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class Gear {
		int[] arr = new int[8];
		int pos = 0;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(in.readLine());

			Gear[] gears = new Gear[4];

			for (int i = 0; i < 4; i++) {
				gears[i] = new Gear();
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 8; j++) {
					gears[i].arr[j] = Integer.parseInt(st.nextToken());
				}
			}

			
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int gearNum = Integer.parseInt(st.nextToken());
				int cmd = Integer.parseInt(st.nextToken());
				
				int r,l;
				if(cmd == -1) {
					r = 1;
					l =  7;
					}
				else {
					r = 7;
					l = 1;
					}

				gearNum--;

				int[] can = new int[4];
				if (gearNum == 0) {

					can[0] = 1;

					if (gears[0].arr[(gears[0].pos + 2) % 8] != gears[1].arr[(gears[1].pos + 6) % 8]) {
						can[1] = 1;
					}

					if (can[1] == 1 && (gears[1].arr[(gears[1].pos + 2) % 8] != gears[2].arr[(gears[2].pos + 6) % 8])) {
						can[2] = 1;
					}
					if (can[2] == 1 && (gears[2].arr[(gears[2].pos + 2) % 8] != gears[3].arr[(gears[3].pos + 6) % 8])) {
						can[3] = 1;
					}
					
					

					gears[0].pos = (gears[0].pos + r) % 8;
					if (can[1] == 1) {
						gears[1].pos = (gears[1].pos + l) % 8;
					}
					if (can[2] == 1) {
						gears[2].pos = (gears[2].pos + r) % 8;
					}
					if (can[3] == 1) {
						gears[3].pos = (gears[3].pos + l) % 8;
					}
				} else if (gearNum == 1) {
					can[1] = 1;

					if (gears[1].arr[(gears[1].pos + 2) % 8] != gears[2].arr[(gears[2].pos + 6) % 8]) {
						can[2] = 1;
					}

					if (gears[1].arr[(gears[1].pos + 6) % 8] != gears[0].arr[(gears[0].pos + 2) % 8]) {
						can[0] = 1;
					}
					if (can[2] == 1 && (gears[2].arr[(gears[2].pos + 2) % 8] != gears[3].arr[(gears[3].pos + 6) % 8])) {
						can[3] = 1;
					}

					gears[1].pos = (gears[1].pos + r) % 8;
					
					if (can[0] == 1) {
						gears[0].pos = (gears[0].pos + l) % 8;
					}
					if (can[2] == 1) {
						gears[2].pos = (gears[2].pos + l) % 8;
					}
					if (can[3] == 1) {
						gears[3].pos = (gears[3].pos + r) % 8;
					}
				} else if (gearNum == 2) {
					can[2] = 1;

					if (gears[2].arr[(gears[2].pos + 2) % 8] != gears[3].arr[(gears[3].pos + 6) % 8]) {
						can[3] = 1;
					}

					if (gears[2].arr[(gears[2].pos + 6) % 8] != gears[1].arr[(gears[1].pos + 2) % 8]) {
						can[1] = 1;
					}
					if (can[1] == 1 && (gears[1].arr[(gears[1].pos + 6) % 8] != gears[0].arr[(gears[0].pos + 2) % 8])) {
						can[0] = 1;
					}

					gears[2].pos = (gears[2].pos + r) % 8;
					
					if (can[1] == 1) {
						gears[1].pos = (gears[1].pos + l) % 8;
					}
					if (can[3] == 1) {
						gears[3].pos = (gears[3].pos + l) % 8;
					}
					if (can[0] == 1) {
						gears[0].pos = (gears[0].pos + r) % 8;
					}
				}else if (gearNum == 3) {
					can[3] = 1;

					if (gears[3].arr[(gears[3].pos + 6) % 8] != gears[2].arr[(gears[2].pos + 2) % 8]) {
						can[2] = 1;
					}

					if (can[2] == 1 && (gears[2].arr[(gears[2].pos + 6) % 8] != gears[1].arr[(gears[1].pos + 2) % 8])) {
						can[1] = 1;
					}
					if (can[1] == 1 && (gears[1].arr[(gears[1].pos + 6) % 8] != gears[0].arr[(gears[0].pos + 2) % 8])) {
						can[0] = 1;
					}

					gears[3].pos = (gears[3].pos + r) % 8;
					
					if (can[2] == 1) {
						gears[2].pos = (gears[2].pos + l) % 8;
					}
					if (can[1] == 1) {
						gears[1].pos = (gears[1].pos + r) % 8;
					}
					if (can[0] == 1) {
						gears[0].pos = (gears[0].pos + l) % 8;
					}
				}
			}
			
			
			int sum = 0;
			
			for(int i=0;i<4;i++) {
				if(gears[i].arr[gears[i].pos]==1)sum+= 1<<(i);
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}