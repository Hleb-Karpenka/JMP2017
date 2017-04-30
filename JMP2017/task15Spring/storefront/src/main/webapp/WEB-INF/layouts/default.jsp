<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />

<title><spring:message code="welcome_h3" arguments="${app_name}" /></title>

<spring:theme code="styleSheet" var="app_css" />
<spring:url value="/${app_css}" var="app_css_url" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${app_css_url}" />

<spring:url value="/resources/scripts/jquery-1.11.1.js" var="jquery_url" />
<spring:url value="/resources/scripts/jquery-ui-1.10.4.custom.min.js"
	var="jquery_ui_url" />
<spring:url value="/resources/styles/custom/jquery/jquery-ui.theme.css"
	var="jquery_ui_theme_css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${jquery_ui_theme_css}" />
<script src="${jquery_url}" type="text/javascript">
	<jsp:text/>
</script>
<script src="${jquery_ui_url}" type="text/javascript">
	<jsp:text/>
</script>

<!-- CKEditor -->
<spring:url value="/resources/ckeditor/ckeditor.js" var="ckeditor_url" />
<spring:url value="/resources/ckeditor/adapters/jquery.js"
	var="ckeditor_jquery_url" />
<script type="text/javascript" src="${ckeditor_url}">
	<jsp:text/>
</script>
<script type="text/javascript" src="${ckeditor_jquery_url}">
	<jsp:text/>
</script>

<!-- jqGrid -->
<spring:url value="/resources/jqgrid/css/ui.jqgrid.css" var="jqgrid_css" />
<spring:url value="/resources/jqgrid/js/i18n/grid.locale-en.js"
	var="jqgrid_locale_url" />
<spring:url value="/resources/jqgrid/js/jquery.jqGrid.min.js"
	var="jqgrid_url" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${jqgrid_css}" />
<script type="text/javascript" src="${jqgrid_locale_url}">
	_$tag______
</script>
<script type="text/javascript" src="${jqgrid_url}">
	<jsp:text/>
</script>

</head>

<body>

	<div id="page-container">

		<tiles:insertAttribute name="header" ignore="true" />

		<tiles:insertAttribute name="sidebar" ignore="true" />

		<div id="content">
			<div class="padding">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		
		<tiles:insertAttribute name="prefooter" ignore="true" />

		<tiles:insertAttribute name="footer" ignore="true" />
	</div>
	<div align="center">
		Template customization
	</div>
</body>
</html>
