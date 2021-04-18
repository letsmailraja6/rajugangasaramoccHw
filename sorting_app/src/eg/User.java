package eg;

public class User implements Comparable<User>{

	private static int c;
	private int id;
	private String firstName;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public User(String firstName) {
		super();
		this.firstName = firstName;
		this.id = ++c;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.firstName.compareTo(o.firstName);
	}

}
