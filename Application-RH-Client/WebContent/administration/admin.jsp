<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="/theme/head.jsp" />
<s:include value="/theme/header.jsp" />
<s:if test="type != 'managerList'">
	<s:include value="/theme/menu.jsp" />
</s:if>
<s:else>
	<s:include value="/theme/menu2.jsp" />
</s:else>

<s:if test="index == null || index == 'admin'">
	<s:include value="/administration/index.html" />
</s:if>
<s:if test="type == null">
	<s:include value="/administration/index.html" />
</s:if>

<s:if test="type == 'exelImport'">
	<s:include value="/administration/form/uploadXls.jsp" />
</s:if>

<s:elseif test="type == 'Administrateur'">
	<s:if test="%{deconnecte == 'deconnecter'}">
		<META HTTP-EQUIV="Refresh" CONTENT="0;URL=logout.action">
		<%
			response.sendRedirect("logout.action");
		%>
	</s:if>
	<s:include value="/administration/form/profile.jsp" />
</s:elseif>

<s:if test="type == 'nouveauAdmin'">
	<s:include value="/administration/form/nouveauAdmin.jsp" />
</s:if>

<s:if test="type == 'adminList' ">
	<s:include value="/administration/tables/listAdmin.jsp" />
</s:if>

<s:if test="type == 'managerList'">
	<s:include value="/administration/tables/listManager.jsp" />
</s:if>

<s:if test=" type == 'managerEdit'">
	<s:include value="/administration/form/EditerManager.jsp" />
</s:if>

<s:if test="type == 'AddManager'">
	<s:include value="/administration/form/colaborateur.jsp" />
</s:if>

<s:include value="/theme/footer.jsp" />