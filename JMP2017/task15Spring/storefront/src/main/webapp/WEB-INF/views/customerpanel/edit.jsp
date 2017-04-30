<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		$('#birthDate').datepicker({
			dateFormat : 'yy-mm-dd',
			changeYear : true
		});

		$("#address").ckeditor({
			toolbar : 'Basic',
			uiColor : '#CCCCCC'
		});
	});
</script>
<spring:message code="label_contact_country" var="labelContactCountry" />

<spring:message code="label_contact_new" var="labelContactNew" />
<spring:message code="label_contact_update" var="labelContactUpdate" />
<spring:message code="label_contact_first_name"
	var="labelContactFirstName" />
<spring:message code="label_contact_email" var="labelContactEmail" />
<spring:message code="label_contact_zipCode" var="labelContactZipCode" />
<spring:message code="label_contact_address" var="labelContactAddress" />
<spring:message code="label_contact_city" var="labelContactCity" />
<spring:message code="label_contact_last_name"
	var="labelContactLastName" />
<spring:message code="label_contact_birth_date"
	var="labelContactBirthDate" />
<spring:message code="label_contact_photo" var="labelContactPhoto" />
</head>
<body>

	<spring:eval
		expression="customer.id == null ? labelContactNew:labelContactUpdate"
		var="formTitle" />

	<h1>${formTitle}</h1>

	<div id="contactInfo">
		<form:form modelAttribute="customer" id="customer" method="POST" enctype="multipart/form-data">

			<c:if test="${not empty message}">
				<div id="message" class="${message.type}">${message.message}</div>
			</c:if>

			<form:label path="firstName">
                ${labelContactFirstName}*
            </form:label>
			<p />

			<form:input path="firstName" />
			<div>
				<form:errors path="firstName" cssClass="error" />
			</div>
			<p />

			<form:label path="lastName">
                ${labelContactLastName}*
            </form:label>
			<form:input path="lastName" />
			<div>
				<form:errors path="lastName" cssClass="error" />
			</div>
			<p />

			<form:label path="dateBirth">
                ${labelContactBirthDate}
            </form:label>
			<form:input path="dateBirth" id="birthDate" />
			<div>
				<form:errors path="dateBirth" cssClass="error" />
			</div>
			<p />

			<form:label path="email">
                            ${labelContactEmail}*
                        </form:label>
			<form:input path="email" />
			<div>
				<form:errors path="email" cssClass="error" />
			</div>
			<p />

			<form:label path="country">
                                                ${labelContactCountry}
                                            </form:label>
			<form:input path="country" />
			<div>
				<form:errors path="country" cssClass="error" />
			</div>
			<p />
			<form:label path="city">
			    ${labelContactCity}
                </form:label>
			<form:input path="city" />
			<div>
				<form:errors path="city" cssClass="error" />
			</div>
			<p />

			<form:label path="address">
                            ${labelContactAddress}
                        </form:label>
			<form:textarea cols="60" rows="8" path="address" id="address" />
			<div>
				<form:errors path="address" cssClass="error" />
			</div>

			<form:label path="zipCode">
                                         ${labelContactZipCode}
                                     </form:label>
			<form:input path="zipCode" id="zipCode" />
			<div>
				<form:errors path="zipCode" cssClass="error" />
			</div>
			<p />

			<label for="file"> ${labelContactPhoto} </label>
			<input name="file" type="file" />
			<p />

			<button type="submit"
				class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only">
				<span class="ui-button-text">Save</span>
			</button>
			<button type="reset"
				class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only">
				<span class="ui-button-text">Reset</span>
			</button>
		</form:form>
	</div>
</body>
</html>
