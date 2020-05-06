package com;

import java.sql.*;

public class Payments {
    Connection con = null;

    public Payments() {
        String url = "jdbc:mysql://localhost:3306/paf";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //
    public String getPayments() {

        String output = "<table border='1'><tr><th>Patient name</th> <th>Amount</th><th>Payment Type</th>"
                + "<th>Date</th> <th>Update</th><th>Remove</th></tr>";

        String sql = "select * from payment";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String paymentId = Integer.toString(rs.getInt("paymentId"));
                String patientName = rs.getString("patientName");
                String amout = Double.toString(
                        rs.getDouble("amout"));
                String type = rs.getString("type");
                String date = rs.getString("date");
// Add into the html table
                output += "<tr><td><input id='paymentHiddenId' name='paymentId' type='hidden' value='" + paymentId
                        + "'>" + patientName + "</td>";
                output += "<td>" + amout + "</td>";
                output += "<td>" + type + "</td>";
                output += "<td>" + date + "</td>";
// buttons
                output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
                        + "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-paymentHiddenId='"
                        + paymentId + "'>" + "</td></tr>";
            }
           

        } catch (Exception e) {
            System.out.println(e);
        }
        output += "</table>";
        return output;
    }

	public String create(PaymentDTO p1) {
		String sql = "insert into payment values(?,?,?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, p1.getPaymentId());
			st.setString(2,p1.getPatientName());
			st.setDouble(3,p1.getAmout());
			st.setString(4,p1.getType());
			st.setString(5,p1.getDate());

			st.executeUpdate();
            return getPayments();
		}

		catch(Exception e)
		{
			System.out.println(e);
			return "";
		}

	}
//
//
	public String update(PaymentDTO p1) {
		String sql = "update payment set patientName=?, amout=?, type=?, date=? where paymentId = ?";

		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, p1.getPatientName());
			st.setDouble(2,p1.getAmout());
			st.setString(3,p1.getType());
			st.setString(4, p1.getDate());
			st.setInt(5, p1.getPaymentId());
			st.executeUpdate();
            return getPayments();
		}

		catch(Exception e)
		{
			System.out.println(e);
			return "";
		}

	}
	public String delete(int paymentId) {

			String sql = "delete from payment where paymentId = ?";
			try
			{
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1,paymentId);
			st.executeUpdate();

            return getPayments();
			}
			catch(Exception e) {
				System.out.println(e);
				return e.toString();
			}

	}
}
