import java.io.*;
import java.util.*;

public class Main {
	
	static class Lesson {
		int start;
		int end;
		int time;
		
		public Lesson(int start, int end, int time) {
			super();
			this.start = start;
			this.end = end;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Lesson [start=" + start + ", end=" + end + ", time=" + time + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Lesson> list = new ArrayList<Lesson>();
		
		for(int i = 1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = end - start;
			
			list.add(new Lesson(start, end, time));
		}
		
		//정렬..
		list.sort(new Comparator<Lesson>() {
			@Override
			public int compare(Lesson o1, Lesson o2) {
				if(o1.start == o2.start) {
					return o1.time - o2.time;
				} else {
					return o1.start - o2.start;
				}
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.offer(list.get(0).end);
		for(int i = 1; i<N; i++) {
			if(pq.peek() <= list.get(i).start) {
				pq.poll();
			} 
			pq.offer(list.get(i).end);
		}
		
		int result = pq.size();
		System.out.println(result);
	}
}