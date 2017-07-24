<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Validation</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function(){
	$("#msgVlddAddrs").hide();
	<c:if test="${isVerified}">
	$("#msgVlddAddrs").show();
	</c:if>
	
});

</script>
</head>
<body>
	<h3>Address Information</h3>

	<form id="payform" action="AddressServlet">
		<table>
			<tr>
				<td><label>Street</label></td>
				<td><input id="street" name="street" type="text"></td>
			</tr>
			<tr>
				<td><label>City</label></td>
				<td><input id="city" name="city" type="text"></td>
			</tr>
			<tr>
				<td><label>state</label></td>
				<td><input id="state" name="state" type="text"></td>
			</tr>
			<tr>
				<td><label>Zip</label></td>
				<td><input id="pc" name="pc" type="text"></td>
			</tr>
			<tr>
				<td><label>Country</label></td>
				<td><input id="country" name="country" type="text" value="USA"
					disabled></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><br /> <input type="submit"
					id="btnSubmit" /></td>
			</tr>
			<tr>
				<td colspan="2"><br />
					<div id="msgVlddAddrs">
						Validated Address: <br /><br />
						${address}

					</div></td>
			</tr>
		</table>


	</form>
</body>
</html>