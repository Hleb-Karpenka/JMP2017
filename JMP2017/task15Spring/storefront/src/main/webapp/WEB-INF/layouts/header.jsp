<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<spring:message code="header_text" var="headerText" />
<spring:message code="label_logout" var="labelLogout" />
<spring:message code="label_welcome" var="labelWelcome" />
<spring:url var="logoutUrl" value="/j_spring_security_logout" />

<div id="header">
	Welcome to ${headerText}
</div>
