<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="/theme/head.jsp" />
<s:include value="/theme/header.jsp" />
<s:include value="/theme/menu.jsp" />

<s:if
	test="type == 'affectation'">
	<s:include value="/manager/form/editerStatusManager.jsp" />
</s:if>

<s:if
	test="menu == 'nouveauCollaborateur'">
	<s:include value="/manager/form/colaborateur.jsp" />
</s:if>

<s:if
	test="type == 'listCollaborateur'">
	<s:include value="/manager/tables/listeCollaborateurs.jsp" />
</s:if>



<s:if test="excel == 'importExcelManagerRh'">
	<s:include value="/manager/form/uploadXlsManager.jsp"></s:include>
</s:if>

<s:elseif test=" excel == 'importExcelCol'">
	<s:include value="/manager/form/uploadXlsManager.jsp"></s:include>
</s:elseif>

<s:if
	test="type == 'managerColaborateur'">
	<s:include value="/manager/form/EditeColaborateurManager.jsp" />
</s:if>

<s:if
	test=" type == 'editManagerRh'">
	<s:include value="/manager/form/EditeManagerRhManager.jsp" />
</s:if>

<s:if
	test="menu == 'nouveauManagerRh'">
	<s:include value="/manager/form/managerRH.jsp" />
</s:if>
<s:if
	test="retour == 'listManagerRH'">
	<s:include value="/manager/tables/listManagerRH.jsp" />
</s:if>

<s:if test=" type == 'ManagerAgence'">
	<s:include value="/manager/form/managerProfile.jsp" />
</s:if>

<s:if test=" type == 'ResponsableProduction'">
	<s:include value="/manager/form/managerProfile.jsp" />
</s:if>

<s:if test=" type == 'AmbassadeurRH'">
	<s:include value="/manager/form/managerProfile.jsp" />
</s:if>

<s:include value="/theme/footer.jsp" />
