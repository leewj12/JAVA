package j241014;

public class Book {
	String title;
	String author;

	public Book() {
		this("파이썬", "최은석");
	}

	public Book(String t) { // 생성자
		// title = t;
//		author = "작자미상";
		this(t, "작자미상");
	}

	public Book(String t, String a) { // 생성자
		title = t;
		author = a;
	}

	public static void main(String[] args) {
		Book python = new Book();
		Book javaBook = new Book("Java", "황기태"); // 생성자 Book(String t, String a) 호출
		Book bible = new Book("Bible"); // 생성자 Book(String t) 호출
		Book novel = new Book("소년이 온다", "한강");

		System.out.println(javaBook.title);
		System.out.println(javaBook.author);
		System.out.println(bible.title);
		System.out.println(bible.author);
		System.out.println(novel.title);
		System.out.println(novel.author);
		System.out.println(python.title);
		System.out.println(python.author);
	}
}