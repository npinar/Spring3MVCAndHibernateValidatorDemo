<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring 3 MVC Example With Validation Annotation - Registration Form</title>

<style>
	.error {
		color: #ff0000;
	}
</style>

</head>
<body>
<h2>Registration Form</h2>
<!-- commandName defines the server side JavaBean that input fields bind to -->
<form:form method="post" commandName="registration" action="registerUser">
 
    <table>
    <tr>
        <td><form:label path="firstname">First Name</form:label></td>
        <td><form:input path="firstname" /></td>
        <td><form:errors path="firstname" cssClass="error" />
    </tr>
    <tr>
        <td><form:label path="lastname">Last Name</form:label></td>
        <td><form:input path="lastname" /></td>
        <td><form:errors path="lastname" cssClass="error" />
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" cssClass="error" />
    </tr>
    <tr>
        <td><form:label path="telephone">Telephone</form:label></td>
        <td><form:input path="telephone" /></td>
        <td><form:errors path="telephone" cssClass="error" />
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Register"/>
        </td>
    </tr>
</table>  
 
</form:form>
</body>
</html>