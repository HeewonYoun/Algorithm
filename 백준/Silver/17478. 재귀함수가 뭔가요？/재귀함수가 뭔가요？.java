import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String s1 = "\"재귀함수가 뭔가요?\"";
		String s2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		String s3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		String s4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		String s5 = "라고 답변하였지.";
		
		int i = 0;
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		chatBot(n, i, s1, s2, s3, s4, s5);
		
	}

	static void chatBot(int n, int i, String s1, String s2, String s3, String s4, String s5) {
		// 종료
		if (n <= 0) {
			String add = "";
			for(int j = 0 ; j<i;j++) {
				add = "____"+add;
			}
			System.out.println(add+"\"재귀함수가 뭔가요?\"");
			System.out.println(add+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(add+"라고 답변하였지.");

			return;
		}

		// 실행
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);

		// 재귀
		chatBot(n - 1,i+1, "____" + s1, "____" + s2, "____" + s3, "____" + s4, "____" +s5);
		// 돌아와서 ..
		System.out.println(s5);

	}
}