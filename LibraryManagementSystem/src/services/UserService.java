package services;

import java.util.ArrayList;
import java.util.List;

import models.Admin;
import models.Student;
import models.User;
import utils.FileUtil;

public class UserService {
	private final String FILE_PATH = "data/users.csv";
	private List<User> users;

	public UserService() {
		users = new ArrayList<>();
		loadUsers();
	}

	public void addUser(String id, String name, String role) {
		User user;
		if (role.equalsIgnoreCase("admin")) {
			user = new Admin(id, name);
		} else if (role.equalsIgnoreCase("student")) {
			user = new Student(id, name);
		} else {
			System.out.println("Invalid role.");
			return;
		}
		users.add(user);
		saveUsers();
		System.out.println(role + " added.");
	}

	public User getUserById(String id) {
		for (User user : users) {
			if (user.getUserId().equals(id)) {
				return user;
			}
		}
		return null;
	}

	public void printAllUsers() {
		for (User user : users) {
			System.out.println(user.getUserId() + "|" + user.getName() + "|" + user.getRole());
		}
	}

	private void saveUsers() {
		List<String> lines = new ArrayList<>();
		for (User user : users) {
			lines.add(user.getUserId() + "," + user.getName() + "," + user.getRole());
		}
		FileUtil.writeFile(FILE_PATH, lines);
	}

	private void loadUsers() {
		List<String> lines = FileUtil.readFile(FILE_PATH);
		for (String line : lines) {
			String[] parts = line.split(",");
			addUserWithoutSaving(parts[0], parts[1], parts[2]);
		}

	}

	private void addUserWithoutSaving(String id, String name, String role) {
		if (role.equalsIgnoreCase("admin")) {
			users.add(new Admin(id, name));
		} else if (role.equalsIgnoreCase("student")) {
			users.add(new Student(id, name));
		}

	}
}
