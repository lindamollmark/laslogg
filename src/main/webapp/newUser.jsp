<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <title>Start</title>
</head>
<body>

<header>${message}</header>
<nav>
    <div class="returnButtons">

    </div>
</nav>

<section>
    <h1>Välkommen till Läsloggen!</h1>
    <form method="POST" action="newUser/">
        <table>
            <tr>
                <td><label>Välj användarnamn</label></td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td><label>Välj lösenord</label></td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Registrera dig"/>
                </td>
            </tr>
        </table>
    </form>
    <br>
    <br>
    <br>
</section>
</body>
</html>
