<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <title>Start</title>
</head>
<body>

<header></header>
<nav>
    <div class="returnButtons">

    </div>
</nav>

<section>
    <h1>Välkommen till Läsloggen!</h1>
    <form method="POST" action="bookpage/">
        <table>
            <tr>
                <td><label>Bokens namn</label></td>
                <td><input name="name" /></td>
            </tr>
            <tr>
                <td><label>Författare</label></td>
                <td><input name="author" /></td>
            </tr>
            <tr>
                <td><label>Antal sidor</label></td>
                <td><input name="numberOfPages" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Registrera läsning"/>
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
