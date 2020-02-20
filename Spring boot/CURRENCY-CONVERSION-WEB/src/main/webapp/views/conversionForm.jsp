<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Currency Conversion</h3>
	<form:form action="convertCurrency" 
			   method="POST"
			   modelAttribute="currencyFormBean">

		<table>
			<tr>
				<td>Currency From:</td>
				<td><form:input path="from" /></td>
			</tr>
			<tr>
				<td>Currency To:</td>
				<td><form:input path="to" /></td>
			</tr>
			<tr>
				<td>Currency Quantity:</td>
				<td><form:input path="quantity" /></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Convert" /></td>
			</tr>

		</table>
	</form:form>
	<hr/>
	
	Converted Amount : ${responseBean.totalCurrencyAmt}
</body>
</html>