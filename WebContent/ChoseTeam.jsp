<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChooseMyTeam</title>
</head>
<body style="background:url('image/index.jpg') no-repeat;">
<h1 style="text-align:center;padding:150px"> Choose Teams to start your quick game</h1>
	<form style="text-align:center;" name = 'SelectTeam' action = "/WebAPP/TeamServlet">
		<table style = "margin-left:600px">
		
			<tbody style="text-align:center;">
			<tr>
				<td >Choose Your Team:</td>
				
				<td>
					<select name = 'MyTeam'>
						<option>Atlanda Hawwks</option>
						<option>Boston Celtics</option>
						<option>Brooklvn Nets</option>
						<option>Charlotte Hornets</option>
						<option>Chicago Bulls</option>
					</select>
			</tr>
			</tbody>
		
		</table >
		<table style = "margin-left:600px">
		
			<tbody style="text-align:center;">
			<tr>
				<td >Choose Your Opponent Team:</td>
				<td>
					<select name = 'OpTeam'>
						<option>Atlanda Hawwks</option>
						<option>Boston Celtics</option>
						<option>Brooklvn Nets</option>
						<option>Charlotte Hornets</option>
						<option>Chicago Bulls</option>
					</select>
			</tr>
			</tbody>		
		</table>
		<input style = "margin-top:50px" type = 'submit' value = 'Confirm' name = 'conform'/>
	</form>
	
	<form style="text-align:center;" name = 'BackIndex' action = 'Index.jsp' method = 'post'>
<input type = 'submit' value = 'Back to index' name = 'comform'/>
</form>
</body>
</html>