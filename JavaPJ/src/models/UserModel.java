package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.User;

public class UserModel {
	private static final String SELECT_ALL_USER = "select * from users";
	private static final String CREATE_USER = "insert into users (user_firstname,user_lastname,user_email,user_password,user_telephone) values (?,?,?,?,?);";
	private static final String SELECT_EMAIL = "select user_email from users where user_email=?";
	private static final String SELECT_PASSWORD = "select user_password from users where user_email=?";
	
	public void createUser(User user) {
		try (Connection connection = DBModel.getConnection();
				PreparedStatement prepareStament = connection.prepareStatement(CREATE_USER);) {
			prepareStament.setString(1, user.getFirstName());
			prepareStament.setString(2, user.getLastName());
			prepareStament.setString(3, user.getEmail());
			prepareStament.setString(4, user.getPassword());
			prepareStament.setString(5, user.getTelephone());
			System.out.println(prepareStament);

			prepareStament.executeUpdate();
		} catch (Exception e) {

		}
	}

	public String getEmail(String email) {
		String mail = "";
		try (Connection connection = DBModel.getConnection();
				PreparedStatement prepareStament = connection.prepareStatement(SELECT_EMAIL);) {
			prepareStament.setString(1, email);
			System.out.println(prepareStament);
			ResultSet rs = prepareStament.executeQuery();

			while (rs.next()) {
				mail = rs.getString("user_email");
			}
		} catch (Exception e) {

		}
		return mail;
	}

	public String getPassword(String email) {
		String pass = "";
		try (Connection connection = DBModel.getConnection();
				PreparedStatement prepareStament = connection.prepareStatement(SELECT_EMAIL);) {
			prepareStament.setString(1, email);
			System.out.println(prepareStament);
			ResultSet rs = prepareStament.executeQuery();

			while (rs.next()) {
				pass = rs.getString("user_password");
			}
		} catch (Exception e) {

		}
		return pass;
	}

}
