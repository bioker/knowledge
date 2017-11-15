<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
    <head><title>Java EE Learning Project</title></head>
    <body>
        <h1>Get Form</h1>
        <form action="get_form" method="GET">
            First parameter: <input type="text" name="first">
            <br/>
            Second parameter: <input type="text" name="second">
            <input type="submit" value="Submit"/>
        </form>
        <h1>Post Form</h1>
        <form action="post_form" method="POST">
            First parameter: <input type="text" name="first">
            <br/>
            Second parameter: <input type="text" name="second">
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>