package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import objects.Person;
import util.ConnectionUtil;

public class PersonDao {
	
	public PersonDao() {
		
	}
	
	public ArrayList<Person> getPeople() {
		Connection con = new ConnectionUtil().getConnection();
		ResultSet rs;
		ArrayList<Person> people = new ArrayList<Person>();
		Person person;
		try {
			PreparedStatement ps = con.prepareStatement("select * from person");
			rs = ps.executeQuery();
			while(rs.next()) {
				person = new Person();
				person.setId(rs.getInt("id"));
				person.setUsername(rs.getString("username"));
				person.setFirstname(rs.getString("firstname"));
				person.setLastname(rs.getString("lastname"));
				person.setDescription(rs.getString("description"));
				people.add(person);
			}
			return people;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting list of people");
			return null;
		}
	}
	
	public Person getPersonById(int id) {
		Connection con = new ConnectionUtil().getConnection();
		ResultSet rs;
		Person person = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from person where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				person = new Person();
				person.setId(rs.getInt("id"));
				person.setUsername(rs.getString("username"));
				person.setFirstname(rs.getString("firstname"));
				person.setLastname(rs.getString("lastname"));
				person.setDescription(rs.getString("description"));
			}
			return person;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error getting list of people");
			return person;
		}
	}
	
	public void insertPerson(Person p) {
		Connection con = new ConnectionUtil().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into person(username, password, firstname, lastname, description) values(?, ?, ?, ?, ?)");
			ps.setString(1, p.getUsername());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getFirstname());
			ps.setString(4, p.getLastname());
			ps.setString(5, p.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Failed to insert person into tables");
			e.printStackTrace();
		}
	}
	
	/*Implement the following methods
	 * update person how you like (maybe update their password)
	 * update getPersonByUsername by letting them get a user with just the username (what kind of issues could arise from this?)
	*/
	
	/*
	public void updatePerson(Person p) {
		
	}
	
	public Person getPersonByUsername(String username) {
		
	}
	*/
	

}
