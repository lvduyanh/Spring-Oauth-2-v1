<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Welcome page</title>
</head>

<body>
    <span>Welcome ${name}!</span><br>
    <a href="logout">Logout</a>

    <script>
        var getUrlParameter = function (sParam) {
            var sPageURL = window.location.search.substring(1),
                sURLVariables = sPageURL.split('&'),
                sParameterName,
                i;

            for (i = 0; i < sURLVariables.length; i++) {
                sParameterName = sURLVariables[i].split('=');

                if (sParameterName[0] === sParam) {
                    return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
                }
            }
        }
        console.log("access_token: " + getUrlParameter("access_token"));
        window.history.pushState({}, "", "home");
    </script>
</body>

</html>