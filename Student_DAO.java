package DAO_DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student_DAO {
	String driver = "com.mysql.jdbc.Driver"; // �� 4�� ������ sql�� �����ϱ� ���� �����.
												// Orcle�� �ٸ� �ڵ带 ���
	String url = "jdbc:mysql://localhost:3306/ciara'scomputer";
	String userid = "root";
	String passwd = "Hyun1004!";

	public Connection con = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;

	public Student_DAO() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	// == ���� DB �� "���" ==>

	public void insertDB(String SbDe, String SbML, String SbNo, String SbNa, String PfNa, String SbCr, String SbTi) {

		String sql = "insert into ca_sb values(?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, SbDe);
			pstmt.setString(2, SbML);
			pstmt.setString(3, SbNo);
			pstmt.setString(4, SbNa);
			pstmt.setString(5, PfNa);
			pstmt.setString(6, SbCr);
			pstmt.setString(7, SbTi);

			pstmt.executeUpdate();

		} catch (Exception x) {
			x.printStackTrace();
		}

	}

	public void regSub(String SbNo, String StNo) {

		String sql = "insert into ca_rg values(?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, SbNo);
			pstmt.setString(2, StNo);
			pstmt.setString(3, "");

			pstmt.executeUpdate();

		} catch (Exception x) {
			x.printStackTrace();
		}

	}

	// == ���� ==>

	public void deleteDB(String SbNo, String SbNa) {

		String sql = "delete from _regist where SbNo = ? and SbNa = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(2, SbNo);
			pstmt.setString(3, SbNa);
			pstmt.executeUpdate();

		} catch (Exception x) {
			x.printStackTrace();
		}

	}

	// ��������

	public Student_DTO bringMyInfo(String StNo) {
		Student_DTO dto = new Student_DTO();
		String query = "SELECT * FROM ca_st where stno = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, StNo);
			rs = pstmt.executeQuery();

			while (rs.next()) { // next() : �������� �����ϴ°�?

				dto.setStNo(rs.getString("stno"));
				dto.setStNa(rs.getString("stna"));
				dto.setStGr(rs.getString("stgr"));
				dto.setStDe(rs.getString("stde"));
				dto.setStPw(rs.getString("stpw"));
				dto.setStSe(rs.getString("stse"));
				dto.setStBd(rs.getString("stbd"));
				dto.setStPn(rs.getString("stem"));
				dto.setStEm(rs.getString("stpn"));
				dto.setStCr(rs.getString("stcr"));
				System.out.print(rs.getString("stpw"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;

	}

	// �� �Ʒ��� �� �ֱ۲� �����ͼ� ��ģ�κ��̾�
	public Student_DTO renewMyInfo(String newMobile, String newEmail, String StNo) {// �л�
				
		String sql = "UPDATE ca_st SET StPn = ?, StEm = ? WHERE StNo = ?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMobile);
			pstmt.setString(2, newEmail);
			pstmt.setString(3, StNo);
			pstmt.executeUpdate();

		} catch (Exception x) {
			x.printStackTrace();
		}

		return null;
	}

	public String OldPass(String StNo) {// ��й�ȣ ��ġ�ϴ��� Ȯ���Ϸ��� DB���� �������°�
		String oldpass = null;
		System.out.println(StNo);
		String sql = "SELECT stpw FROM ca_st WHERE stno = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, StNo);
			rs = pstmt.executeQuery();
			rs.next();

			oldpass = rs.getString("stpw");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return oldpass;
	}

	public void changePass(String StNo, String newPass) {// ��й�ȣ ����

		String sql = "UPDATE ca_st SET stpw = ? WHERE stno = ?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setString(2, StNo);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ���� ����

	public void SetPnEm(String Pn, String Em) {
		Student_DTO dto = new Student_DTO();
		String query = "UPDATE ca_st SET StEm=?, StPn=? WHERE StNo=?";
		try {
			pstmt = con.prepareStatement(query);
			;
			pstmt.setString(1, Em);
			pstmt.setString(2, Pn);
			pstmt.setString(3, dto.getStNo());
			int r = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
