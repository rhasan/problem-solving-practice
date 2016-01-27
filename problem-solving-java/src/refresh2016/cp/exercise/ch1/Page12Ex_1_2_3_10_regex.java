package refresh2016.cp.exercise.ch1;

public class Page12Ex_1_2_3_10_regex {
	public static void main(String[] args) {
		String S = "line: a70 and z72 will be replaced, aa24 and a872 will not";
		System.out
				.println(S.replaceAll("(^| )+[a-z][0-9][0-9]( |$)+", " *** "));
	}
}
