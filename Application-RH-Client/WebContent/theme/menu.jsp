
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="wrapper">

	<!--Responsive navigation button-->
	<div class="resBtn">
		<a href="#"><span class="icon16 minia-icon-list-3"></span></a>
	</div>

	<!--Sidebar collapse button-->
	<div class="collapseBtn">
		<a href="#" class="tipR" title="Hide sidebar"><span
			class="icon12 minia-icon-layout"></span></a>
	</div>

	<!--Sidebar background-->
	<div id="sidebarbg"></div>
	<!--Sidebar content-->
	<div id="sidebar">

		<div class="shortcuts">
			<ul>
				<li><a href="#" title="Support section" class="tip"><span
						class="icon24 wpzoom-support"></span></a></li>
				<li><a href="#" title="Database backup" class="tip"><span
						class="icon24 icomoon-icon-database"></span></a></li>
				<li><a href="#" title="Sales statistics" class="tip"><span
						class="icon24 iconic-icon-chart"></span></a></li>
				<li><a href="#" title="Write post" class="tip"><span
						class="icon24 icomoon-icon-pencil"></span></a></li>
			</ul>
		</div>
		<!-- End shortcuts -->

		<div class="sidenav">

			<div class="sidebar-widget" style="margin: -1px 0 0 0;">
				<h5 class="title" style="margin-bottom: 0">Navigation</h5>
			</div>
			<!-- End .sidenav-widget -->

			<div class="mainnav">
				<ul>
					<li><a href="charts.html"><span
							class="icon16 icomoon-icon-stats-up"></span>Statistique</a></li>

					<s:if
						test="%{#session.user.role != 'Administrateur' && #session.user.role != 'ManagerRH'}">
						<li><a href="#"><span class="icon16 minia-icon-list-4"></span>Gestion
								Collaborateur</a>
							<ul class="sub">
								<li><a
									href="menuManager?menu=nouveauCollaborateur&type=collaborateur"><span
										class="icon16 icomoon-icon-paper"></span>Ajouter Collaborateur</a></li>
								<li><a href="ListCollaborateur?type=listCollaborateur"><span
										class="icon16 icomoon-icon-paper"></span>Listes Collaborateur</a></li>
							</ul></li>

						<li><a href="#"><span class="icon16 minia-icon-list-4"></span>Gestion
								ManagerRH</a>
							<ul class="sub">
								<li><a href="menuManager?menu=nouveauManagerRh"> <span
										class="icon16 icomoon-icon-paper"></span> Ajouter ManagerRh
								</a></li>
								<li><a href="listManagerRh?retour=listManagerRH"> <span
										class="icon16 icomoon-icon-paper"></span> Listes ManagerRh
								</a></li>
							</ul></li>

					</s:if>
					<s:if test="#session.user.role == 'Administrateur'">
						<li><a href="#"><span class="icon16 silk-icon-columns"></span>Gestion
								Manager</a>
							<ul class="sub">
								<li><a href="menu?type=AddManager&form=manager"> <span
										class="icon16 icomoon-icon-paper"></span> Ajouter Nouveau
								</a></li>
								<li><a href="listManager?type=managerList&qui=admin"> <span
										class="icon16 icomoon-icon-paper"></span> Listes Manager
								</a></li>
							</ul></li>
					</s:if>
					<s:if test="#session.user.role == 'ManagerRH'">
						<li><a href="listCollaborateurManagerRh"> <span
								class="icon16 silk-icon-columns"></span> Gestion Collaborateurs
						</a></li>
					</s:if>

					<s:if test="#session.user.role == 'Administrateur'">
						<li><a href="#"><span class="icon16 icomoon-icon-paper"></span>Workflow</a>
							<ul class="sub">
								<li><a href="menu?type=exelImport"><span
										class="icon16 icomoon-icon-paper"></span>import xls</a></li>
								<li><a href="ExportExcelAdmin"><span
										class="icon16 icomoon-icon-paper"></span>Export xls</a></li>
							</ul></li>
					</s:if>
					<s:if test="#session.user.role == 'ManagerRH'">
						<li><a href="ExportExcelManagerRh"><span
								class="icon16 icomoon-icon-paper"></span>Export xls</a></li>
					</s:if>
					<s:if
						test="#session.user.role != 'Administrateur' && #session.user.role != 'ManagerRH'">
						<li><a href="#"><span class="icon16 icomoon-icon-paper"></span>Workflow</a>
							<ul class="sub">
								<li>
									<a href="ImportExelManager?excel=importExcelManagerRh"><span
										class="icon16 icomoon-icon-paper"></span>import xls MRH</a>
								</li>
								<li>
									<a href="ImportExelManager?excel=importExcelCol"><span
										class="icon16 icomoon-icon-paper"></span>import xls COL</a>
								</li>
								<li>
									<a href="ExportExcelManager"><span
										class="icon16 icomoon-icon-paper"></span>Export xls MRH</a>
								</li>
								<li>
									<a href="ExportExcelManagerRh"><span
										class="icon16 icomoon-icon-paper"></span>Export xls COL</a>
								</li>
							</ul></li>
					</s:if>
				</ul>
			</div>
		</div>
		<!-- End sidenav -->
		<!-- Au cas on veut ajouter d'autre menu
            <div class="sidebar-widget">
                <h5 class="title"></h5>
                <div class="content">
                    
                </div>

            </div><!-- End .sidenav-widget -->


	</div>
	<!-- End #sidebar -->

	<!--Body content-->
	<div id="content" class="clearfix">
		<div class="contentwrapper">
			<!--Content wrapper-->

			<div class="heading">

				<h3>Back Office</h3>

				<div class="resBtnSearch">
					<a href="#"><span class="icon16 brocco-icon-search"></span></a>
				</div>



				<ul class="breadcrumb">
					<li>You are here:</li>
					<li><a href="#" class="tip" title="back to dashboard"> <span
							class="icon16 icomoon-icon-screen"></span>
					</a> <span class="divider"> <span
							class="icon16 icomoon-icon-arrow-right"></span>
					</span></li>
					<li class="active"></li>
				</ul>

			</div>
			<!-- End .heading-->