<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="/theme/head.jsp" />
<s:include value="/theme/header.jsp" />
<s:include value="/theme/menu.jsp" />

<s:if test=" index == null || index == 'managerRh'">
	<s:include value="/managerRh/tables/listeCollaborateurs.jsp" />
</s:if>

<s:if test="menu == 'listCol'">
	<s:include value="/managerRh/tables/listeCollaborateurs.jsp" />
</s:if>

<s:if test="type == 'editerFormulaire'">
	<s:include value="/managerRh/form/editerCollaborateur.jsp" />
</s:if>

<s:if test="menu == 'newMessage' || menu == 'NewMessage' ">
	<s:include value="/theme/emailTheme.jsp" />
	<s:include value="/email/newEmail.jsp" />
</s:if>

<s:if test="menu == 'message' || menu == 'Message' ">
	<s:include value="/theme/emailTheme.jsp" />
	<s:include value="/email/email.jsp" />
</s:if>

<s:if test=" type == 'ManagerRH'">
	<s:include value="/managerRh/form/managerRhProfile.jsp" />
</s:if>

<s:include value="/theme/footer.jsp" />