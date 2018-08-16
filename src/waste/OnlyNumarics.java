package waste;

public class OnlyNumarics {
	public static void main(String[] args) {
		String s = "helloThisIsA 1234s mple";
		s = s.replaceAll("\\D+","");
		System.out.println(s);
	}

}
