
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- loading animation -->
<div id="qLoverlay"></div>
<div id="qLbar"></div>

<div id="header">

	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<h2>
					<a class="brand" href='menuIndex?index=<s:property value="#session.user.role" />'>
						<img alt="Sqli Ressources humaines" src="profileImages/logo-sqli.png"
						width="134px">
					</a>
				</h2>
				<div class="nav-no-collapse">
					<ul class="nav">

						<li class="active"><a href='menuIndex?index=<s:property value="#session.user.role" />'><span
								class="icon16 icomoon-icon-screen"></span> Accueil </a></li>

						<s:if test="#session.user.role == 'ManagerRH'">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <span
									class="icon16 icomoon-icon-mail"></span>Messages <span
									class="notification">8</span>
							</a>
								<ul class="dropdown-menu">
									<li class="menu">
										<ul class="messages">
											<li class="header"><strong>Messages</strong> (10) emails
												and (2) PM</li>
											<li><span class="icon"><span
													class="icon16 icomoon-icon-user-2"></span></span> <span
												class="name"><a data-toggle="modal" href="#myModal1"><strong>Administrateur</strong></a><span
													class="time">35 min ago</span></span> <span class="msg">I
													have question about new function ...</span></li>
											<li><span class="icon avatar"><img src=""
													alt="RH" title="RH" /></span> <span class="name"><a
													data-toggle="modal" href="#myModal1"><strong>MRH</strong></a><span
													class="time">1 hour ago</span></span> <span class="msg">I
													need to meet you urgent please call me ...</span></li>
											<li><span class="icon"><span
													class="icon16 icomoon-icon-mail"></span></span> <span class="name"><a
													data-toggle="modal" href="#myModal1"><strong>CiCine
															Navas</strong></a><span class="time">1 day ago</span></span> <span
												class="msg">I send you my suggestion, please look and
													...</span></li>
											<li class="view-all"><a href="menu?menu=message">View
													all messages <span
													class="icon16  icomoon-icon-arrow-right-7"></span>
											</a></li>
										</ul>
									</li>
								</ul></li>
						</s:if>
					</ul>

					<ul class="nav pull-right usernav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <span
								class="icon16 icomoon-icon-bell"></span><span
								class="notification">3</span>
						</a>
							<ul class="dropdown-menu">
								<li class="menu">
									<ul class="notif">
										<li class="header"><strong>Notifications</strong> (3)
											items</li>
										<li><a href="#"> <span class="icon"><span
													class="icon16 icomoon-icon-user-2"></span></span> <span
												class="event">1 User is registred</span>
										</a></li>
										<li><a href="#"> <span class="icon"><span
													class="icon16 icomoon-icon-comments-4"></span></span> <span
												class="event">Yassine add 1 comment</span>
										</a></li>
										<li><a href="#"> <span class="icon"><span
													class="icon16 icomoon-icon-new"></span></span> <span class="event">admin
													Rachid added post with a long description</span>
										</a></li>
										<li class="view-all"><a href="#">View all
												notifications <span
												class="icon16  icomoon-icon-arrow-right-7"></span>
										</a></li>
									</ul>
								</li>
							</ul></li>
						<li class="dropdown"><a href="#"
							class="dropdown-toggle avatar" data-toggle="dropdown">
							<s:if test="#session.user.role == 'Administrateur'">
								<img
								src="profileImages/<s:property value='#session.user.getPhoto()'/>"
								alt="<s:property value='#session.user.getPhoto()'/>"
								class="image marginR10" width="60px" height="60px" />
							</s:if>
								<img
								src="profileImages/cicin.jpg"
								alt="logo"
								class="image marginR10" width="60px" height="60px" />
							  <span
								class="txt"><s:property value="#session.user.getName()" /></span>
								<b class="caret"></b>
						     </a>
							<ul class="dropdown-menu">
								<li class="menu">
									<ul>
										<li>
										<a
											href="profile?id=<s:property value='#session.user.id'/>
															&type=<s:property value='#session.user.role'/>
											">
												<span class="icon16 icomoon-icon-user-3"></span> Edit
												profile
										</a>
									</ul>
							</li>
							</ul>
						<li><a href="logout"><span
								class="icon16 icomoon-icon-exit"></span> Logout</a></li>
					</ul>
				</div>
				<!-- /.nav-collapse -->
			</div>
		</div>
		<!-- /navbar-inner -->
	</div>
	<!-- /navbar -->

</div>
<!-- End #header -->