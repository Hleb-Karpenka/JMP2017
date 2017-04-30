<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
<spring:message code="label.username" var="username" />
<spring:message code="label.password" var="password" />
<spring:message code="label.submitLogin" var="submitLogin" />
<spring:message code="label.notregister" var="notregister" />
<spring:message code="success_registration_message" var="successReg" />
<c:url value="/j_spring_security_check" var="loginUrl" />
</head>
<body>

<c:if test="${not empty registredName}">
${successReg} ${registredName}
</c:if>
	<form action="${loginUrl}" method="POST">

		<div align="center">
			<table>
				<tr>
					<td>${username}</td>
					<td><input type="text" name="j_username" /></td>
				</tr>
				<tr>
					<td>${password}</td>
					<td><input type="password" name="j_password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value=${submitLogin } /></td>
					<td><a href="<c:url value="/registration"/>">${notregister}</a></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>
		</div>
		<input type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
	</form>
</body>
</html>