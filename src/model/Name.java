package model;

import static java.lang.System.out;

public class Name {
	private String fName;
	private String lName;
	private String nickName;

	public String getFName() {
		return fName;
	}

	public void setFname(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getNickname() {
		return nickName;
	}

	public void setNickname(String nickName) {
		this.nickName = nickName;
	}

	public static void main(String args[]) {
		Name name = new Name();
		name.setFname("Henry");
		name.setLName("Williams");
		name.setNickname("Joseph");
		if (name.getFName().equals("Henry") && name.getLName().equals("Williams")
				&& name.getNickname().equals("Joseph"))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}

}
