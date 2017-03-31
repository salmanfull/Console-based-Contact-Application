package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Phone {
	private Map<String, Set<Long>> phone;

	public Phone() {
		phone = new HashMap<String, Set<Long>>();
	}

	public Map<String, Set<Long>> getPhone() {
		return phone;
	}

}
