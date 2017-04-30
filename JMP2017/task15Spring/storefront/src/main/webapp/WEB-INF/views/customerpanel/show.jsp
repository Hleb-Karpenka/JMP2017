<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:message code="label_contact_info" var="labelContactInfo" />
<spring:message code="label_contact_first_name"
	var="labelContactFirstName" />
<spring:message code="label_contact_email" var="labelContactEmail" />
<spring:message code="label_contact_zipCode" var="labelContactZipCode" />
<spring:message code="label_contact_address" var="labelContactAddress" />
<spring:message code="label_contact_last_name"
	var="labelContactLastName" />
<spring:message code="label_contact_birth_date"
	var="labelContactBirthDate" />
<spring:message code="label_contact_city" var="labelContactCity" />
<spring:message code="label_contact_update" var="labelContactUpdate" />
<spring:message code="label_contact_delete" var="labelContactDelete" />
<spring:message code="date_format_pattern" var="dateFormatPattern" />
<spring:message code="label_contact_photo" var="labelContactPhoto" />
<spring:message code="label_contact_country" var="labelContactCountry" />
<spring:url value="/customerpanel/photo" var="contactPhotoUrl" />
<spring:url value="/customerpanel" var="editContactUrl" />
<spring:url value="/customerpanel/delete" var="deleteContactUrl" />
<spring:message code="label_contact_photo" var="labelContactPhoto" />
</head>
<body>
	<h1>${labelContactInfo}</h1>

	<div id="contactInfo">

		<c:if test="${not empty message}">
			<div id="message" class="${message.type}">${message.message}</div>
		</c:if>

		<table>
			<tr>
				<td>${labelContactFirstName}:</td>
				<td>${customer.firstName}</td>
			</tr>
			<tr>
				<td>${labelContactLastName}:</td>
				<td>${customer.lastName}</td>
			</tr>
			<tr>
				<td>${labelContactEmail}:</td>
				<td>${customer.email}</td>
			</tr>
			<tr>
				<td>${labelContactCountry}:</td>
				<td>${customer.country}</td>
			</tr>

			<tr>
				<td>${labelContactCity}:</td>
				<td>${customer.city}</td>
			</tr>

			<tr>
				<td>${labelContactAddress}:</td>
				<td>${customer.address}</td>
			</tr>
			<tr>
				<td>${labelContactZipCode}:</td>
				<td>${customer.zipCode}</td>
			</tr>

			<tr>
				<td>${labelContactPhoto}</td>
				<td><img src="${contactPhotoUrl}/${customer.id}" height="150" width="150"></img></td>
			</tr>

			<tr>
			<td><a href="${editContactUrl}/${customer.id}?form">${labelContactUpdate}</a></td>
			<td><a href="${deleteContactUrl}/${customer.id}">${labelContactDelete}</a></td>
			</tr>
		</table>
	</div>

</body>
</html>

