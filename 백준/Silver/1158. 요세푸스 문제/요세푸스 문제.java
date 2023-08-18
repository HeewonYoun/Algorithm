import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		LinkedList<Integer> ll = new LinkedList<>(); //굳이..?
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 1; i < n + 1; i++) {
			ll.add(i);
		}

		int i = k-1;
		while (ll.size()>=1) {
			if(i >= ll.size()) {
				i = Math.abs(i -ll.size());
				continue;
			}
			result.add(ll.remove(i));
			i += k-1;
		}
		
		System.out.print("<");
		for(int j = 0; j<n-1 ; j++) {
			System.out.print(result.get(j)+", ");
		}
		System.out.println(result.get(n-1)+">");
		
	}
}