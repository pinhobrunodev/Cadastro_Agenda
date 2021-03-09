package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exceptions.DbExceptions;
import exceptions.DbIntegrityException;

public class DAO {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/agendabruno?useTimeZone=true&serverTimeZone=UTC";
	private static String user = "root";
	private static String password = null;
	

	public Connection conectar() {

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return con;
		}

	}

	public void adicionarContato(JavaBeans jb) {

		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement("insert into contatos (NOME,EMAIL,FONE) values (?,?,?)");
			ps.setString(1, jb.getNome());
			ps.setString(2, jb.getEmail());
			ps.setString(3, jb.getFone());
			ps.executeUpdate();
			closeStatement(ps);
			closeConnection(con);
		} catch (SQLException e) {
			throw new DbExceptions(e.getMessage());
		}

	}

	public ArrayList<JavaBeans> listarcontatos() {

		ArrayList<JavaBeans> list = new ArrayList<JavaBeans>();

		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement("select * from contatos order by NOME");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt(1);
				String NOME = rs.getString(2);
				String EMAIL = rs.getString(3);
				String FONE = rs.getString(4);
				list.add(new JavaBeans(NOME, EMAIL, FONE, ID));
			}
			closeStatement(ps);
			closeResultSet(rs);
			closeConnection(con);
			return list;
		} catch (SQLException e) {
			throw new DbExceptions(e.getMessage());
		}

	}
	public void removerContato(JavaBeans jb) {
		
		try {
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement("delete from contatos where EMAIL = ?");
			ps.setString(1, jb.getEmail());
			ps.executeUpdate();
			closeStatement(ps);
			closeConnection(con);
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		
	}
	
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DbExceptions(e.getMessage());
			}
		}
	}

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbExceptions(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbExceptions(e.getMessage());
			}
		}
	}
}
