<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    h1{
        font-size: 24px;
        color: #4CAF50;
    }
    input[type=text],[type=number], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }


    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    div {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
    aside{
        width: 20%;
    }
    article{
        width: 80%;
        margin-left: 20%;
    }

</style>
<head>
    <title>Start</title>
</head>
<body>

<header></header>
<nav>
    <div class="returnButtons">

    </div>
</nav>


    <h1>Välkommen till Läsloggen!</h1>

<aside>
    <div><label>Mina böcker</label>
        <ul style="list-style-type:circle">
            <li>Sune</li>
            <li>Håkan Bråkan</li>
            <li>Sagan om Ringen</li>
        </ul>
    </div>
</aside>
<article>
    <div>
    <form method="POST" action="bookpage/">
        <table>
            <tr>
                <td><label>Bokens namn</label></td>
                <td><input type="text" name="name" placeholder="Bokens namn" style="width: 300px" /></td>
            </tr>
            <br>
            <tr>
                <td><label>Författare</label></td>
                <td><input type="text"  name="author" placeholder="Författaren" style="width: 300px"/></td>
            </tr>
            <br>
            <tr>
                <td><label>Totalt antal sidor</label></td>
                <td><input type="number" name="numberOfPages" placeholder="antal sidor" style="width: 300px" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Spara ny bok"/>
                </td>
            </tr>
        </table>
    </form>
    </div>
    <br>
    <br>
    <br>
</article>

</body>
</html>
