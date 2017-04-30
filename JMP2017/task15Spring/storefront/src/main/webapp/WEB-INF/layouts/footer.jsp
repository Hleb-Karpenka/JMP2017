<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<spring:message code="home_text" var="homeText" />
<spring:message code="label_en" var="labelEn" />
<spring:message code="label_de" var="labelDe" />
<spring:url value="/" var="homeUrl" />
<spring:url value="" var="currentUrl" />

<div id="footer">

<a href="${homeUrl}">${homeText}</a>
|
<a href="${currentUrl}?lang=en">${labelEn}</a>
|
<a href="${currentUrl}?lang=de">${labelDe}</a>

</div>
