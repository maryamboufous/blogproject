package com.xadmin.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.usermanagement.bean.Blog;


 public class BlogDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/userdb";
	private String jdbcUsername = "root";
	private String jdbcPassword = "boufous";

	private static final String INSERT_BLOGS_SQL = "INSERT INTO blogs (titre, soustitre, contenu) VALUES (?, ?, ?) ;";

	private static final String SELECT_BLOG_BY_ID = "select id,titre,soustitre,contenu from blogs where id =?";
	private static final String SELECT_ALL_BLOGS = "select * from blogs";
	private static final String DELETE_BLOGS_SQL = "delete from blogs where id = ?;";
	private static final String UPDATE_BLOGS_SQL = "update blogs set titre = ?,soustitre= ?, contenu =? where id = ?;";

	public BlogDao() {
	}

	protected Connection getConnection() throws SQLException, ClassNotFoundException {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			return connection;

	}

	public void insertBlog(Blog blog) throws SQLException, ClassNotFoundException {
		System.out.println(INSERT_BLOGS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BLOGS_SQL)) {
			preparedStatement.setString(1, blog.getTitre());
			preparedStatement.setString(2, blog.getSoustitre());
			preparedStatement.setString(3, blog.getContenu());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new record was inserted successfully!");
            }
            else {
            	System.out.println("error insertion");
            }
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Blog selectBlog(int id) throws ClassNotFoundException {
		Blog blog = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BLOG_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String titre = rs.getString("titre");
				String soustitre = rs.getString("soustitre");
				String contenu = rs.getString("contenu");
				blog = new Blog(id, titre, soustitre, contenu);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return blog;
	}

	public List<Blog> selectAllBlogs() throws ClassNotFoundException {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Blog> blogs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BLOGS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String titre = rs.getString("titre");
				String soustitre = rs.getString("soustitre");
				String contenu = rs.getString("contenu");
				blogs.add(new Blog(id, titre, soustitre, contenu));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return blogs;
	}

	public boolean deleteBlog(int id) throws SQLException, ClassNotFoundException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BLOGS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateBlog(Blog blog) throws SQLException, ClassNotFoundException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BLOGS_SQL);) {
			statement.setString(1, blog.getTitre());
			statement.setString(2, blog.getSoustitre());
			statement.setString(3, blog.getContenu());
			statement.setInt(4, blog.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}