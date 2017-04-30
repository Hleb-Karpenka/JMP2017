<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<spring:message code="header_text" var="headerText" />
<spring:message code="label.notlogin" var="notlogin" />
<spring:message code="label_logout" var="labelLogout" />
<spring:message code="label_welcome" var="labelWelcome" />
<spring:url var="logoutUrl" value="/j_spring_security_logout" />

<div id="sidebar-a">

	<div class="padding">
	<sec:authorize access="!isAuthenticated()">
       <a href="<c:url value="login" />" >${notlogin}</a><p/>
                 </sec:authorize>
            <sec:authorize access="isAuthenticated()">${labelWelcome}
                <sec:authentication property="principal.username" />
                <a href="${logoutUrl}">${labelLogout}</a>
            </sec:authorize>
		<ul id="menu">
			<li>Option1</li>
			<li>Option2</li>
			<li>Option3</li>
			<li>Option4</li>
			<li>Option5</li>
		</ul>
	</div>
	<div id="hrgreen"></div>
</div>