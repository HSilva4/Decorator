package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	private ArrayList<User> userList = new ArrayList<User>();
	private static final String USER_FILE = "assets/Users.txt";

	public Main() {

		initializeUsers();

	}

	public ArrayList<User> getUserList() {

		return userList;
	}



	private void initializeUsers() {

		try
		{
			File file = new File(USER_FILE);

			FileReader fr = new FileReader(file.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			while (str != null) {
				String[] ar = str.split("\\*");
				User user = new User(
						ar[0].replaceAll("[<]astrisk[>]", "*"), 
						ar[1].replaceAll("[<]astrisk[>]", "*"), 
						ar[2].replaceAll("[<]astrisk[>]", "*"), 
						ar[3].replaceAll("[<]astrisk[>]", "*"),
						ar[4].replaceAll("[<]astrisk[>]", "*"));
				this.userList.add(user);
				str = br.readLine();
			}
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void writeUser(User user)
	{
		userList.add(user);
		try
		{
			File file = new File(USER_FILE);
			FileWriter fw = new FileWriter(file.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String firstName = user.getFirstName().replaceAll("\\*", "<astrisk>");
			String lastName = user.getLastName().replaceAll("\\*", "<astrisk>");
			String loginName = user.getLoginName().replaceAll("\\*", "<astrisk>");
			String loginPass = user.getLoginPass().replaceAll("\\*", "<astrisk>");
			String email = user.getEmail().replaceAll("\\*", "<astrisk>");
			bw.write("\r\n" + firstName + "*" + lastName + "*" + loginName + "*" + loginPass + "*" + email);
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
