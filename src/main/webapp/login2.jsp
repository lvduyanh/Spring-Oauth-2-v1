<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<html>

<head>
	<meta charset="UTF-8">
	<title>Login page</title>
</head>

<body>
	<h1>Login</h1>
	<input type="text" name="usname" id="usname" placeholder="Username"><br>
	<br> <input type="password" name="password" id="password" placeholder="Password">
	<br><br>
	<button id="login">Login</button>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

	<script>
		$("#login").on("click", function () {
			var usn = $("#usname").val();
			var pass = $("#password").val();
			$.ajax({
				type: "POST",
				url: "oauth/token",
				beforeSend: function (request) {
					request.setRequestHeader("Authorization", "Basic ZGEtY2xpZW50OiQyeSQxMiRNVTlMbG9EbkR0Mzh6THF6TGtKQlV1RFlNL1FxMEl6dm5xYjByZ3N2ZG5JTGhMWUFnVGxQSw==");
				},
				data: {
					"username": usn,
					"password": pass,
					"grant_type": "password"
				},
				success: function (data) {
					let token = data.access_token;
					console.log(token);
					window.location.replace("login?access_token=" + token);
				},
				error: function (err) {
					console.log(err);
				}

			});
		})
	</script>
</body>

</html>