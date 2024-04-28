import java.lang.*;
import java.util.*;

class Solution {
    
    static class Task{
        String name;
        int start,need;
        Task(String name,String start,String playtime){
            this.name = name;
            String[] splitH = start.split(":");
            int startH = Integer.parseInt(splitH[0]);
            int startM = Integer.parseInt(splitH[1]);
            this.start = startH*60 + startM;
            this.need = Integer.parseInt(playtime);
        }
    }
    
    
    
    public String[] solution(String[][] plans) {
        Task[] tasks = new Task[plans.length];
		for(int i=0;i<plans.length;i++) {
			tasks[i] = new Task(plans[i][0],plans[i][1],plans[i][2]);
		}
		Arrays.sort(tasks, (t1, t2) -> t1.start - t2.start);

		int nowTime = tasks[0].start;
		int taskIdx = 0;

		Stack<Task> stack = new Stack<>();
		List<String> res = new ArrayList<>();
		while (res.size() != plans.length) {

			// 현재 과제가 끝나는 시간 계산
			int nowTaskEndTime = Integer.MAX_VALUE;
			if (stack.size() != 0) {
				nowTaskEndTime = nowTime + stack.peek().need;
			}
			// 다음 과제가 들어올 시간 계산
			int nextTaskStartTime = Integer.MAX_VALUE;
			if (taskIdx < tasks.length) {
				nextTaskStartTime = tasks[taskIdx].start;
			}

			// 현재 과제가 빨리(혹은 같이) 끝난 경우
			if (nowTaskEndTime <= nextTaskStartTime) {
				nowTime = nowTaskEndTime;
				res.add(stack.pop().name);
				if (nowTaskEndTime == nextTaskStartTime) {
					stack.add(tasks[taskIdx++]);
				}
			} else {
				// 일한 시간 만큼 빼준다.
				
				if(stack.size() != 0) {
					Task nowtask = stack.peek();
					nowtask.need -= (nextTaskStartTime - nowTime);
				}
				
				stack.add(tasks[taskIdx++]);
				nowTime = nextTaskStartTime;
			}

		}

		String[] answer = new String[plans.length];
		for (int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}
		return answer;
    }
}