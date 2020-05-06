<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Gateway</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Views/bootstrap.min.js"></script>
<script src="Components/main.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">

			<div class="col-8">

				<h1 class="m-3">Payment details</h1>

				<form id="formPayment">

					<!-- NAME -->
					<div class="input-group input-group-sm mb-5">
						<div class="input-group-prepend">
							<span class="input-group-text" >Patient Name: </span>
						</div>
						<input type="text" id="patientName" name="patientName">
					</div>

					<div class="input-group input-group-sm mb-5">
						<div class="input-group-prepend">
							<span class="input-group-text" >Amount : </span>
						</div>
						<input type="number" id="amout" name="amout">
					</div>


					<!-- YEAR -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Type : </span>
						</div>
						<select id="type" name="type">
							<option value="0">--Select payment type--</option>
							<option value="Cash">Cash</option>
							<option value="Credit Card">Credit Card</option>
						</select>
					</div>

					<div class="input-group input-group-sm mb-5">
						<div class="input-group-prepend">
							<span class="input-group-text" >Date : </span>
						</div>
						<input type="date" id="date" name="date">
					</div>
					<input type="number" hidden  id="paymentId" name="paymentId">
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>

					<input type="button" id="btnSave" value="Save" class="btn btn-success">
				</form>
			</div>
		</div>

		<br>
<%--		<div class="row">--%>
			<div class="col-12" id="paymentsGrid">

<%--                <table border='1'><tr><th>Item Code</th> <th>Item Name</th><th>Item Price</th><th>Item Description</th> <th>Update</th><th>Remove</th></tr><tr><td><input id='paymentHiddenId' name='paymentId' type='hidden' value='5'>adasd</td><td>123.0</td><td>1</td><td>2020-05-03</td><td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='5'></td></tr><tr><td><input id='paymentId' name='paymentId' type='hidden' value='6'>wert</td><td>234.0</td><td>1</td><td>2020-05-04</td><td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='6'></td></tr><tr><td><input id='paymentId' name='paymentId' type='hidden' value='7'>sd</td><td>89.0</td><td>1</td><td>2020-05-04</td><td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='7'></td></tr></table>--%>
			</div>
<%--		</div>--%>
	</div>
</body>
</html>