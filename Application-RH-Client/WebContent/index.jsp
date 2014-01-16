<%@include file="header.html"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.user != null">
	<%
		response.sendRedirect("login");
	%>
</s:if>
<s:else>
	<body class="loginPage">


		<!-- End .container-fluid -->
		<div class="container-fluid">
			<div class="loginContainer">

				<h2>Administration :</h2>
				<form class="form-horizontal" action="login" id="loginForm"
					method="post">
					<div class="form-row row-fluid">
						<div class="span12">
							<div class="row-fluid">
							
								<s:if test="%{message == 2}">
									<div class="alert alert-error">
										<button class="close" data-dismiss="alert" type="button">×</button>
										<p>
											Votre Compte est désactiver !!
										</p>
									</div>
								</s:if>

								<s:if test="%{message == 0}">
									<h2>
									<div class="alert alert-error">
										<button class="close" data-dismiss="alert" type="button">×</button>
										<p>
											Votre Login/password et incorrecte !!
										</p>
									</div>
									</h2>
								</s:if>

								<label class="form-label span12" for="login"> Nom
									d'utilisateur : <span
									class="icon16 icomoon-icon-user-2 right gray marginR10"></span>
								</label> <input class="span12" id="username" type="text" name="login"
									placeholder="Administrator" />
							</div>
						</div>
					</div>
					<div class="form-row row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<label class="form-label span12" for="password"> Mot de
									passe : <span
									class="icon16 icomoon-icon-locked right gray marginR10"></span>
								</label> <input class="span12" id="password" type="password"
									name="password" placeholder="mot de passe" />
							</div>
						</div>
					</div>
					<div class="form-row row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<div class="form-actions">
									<div class="span12 controls">
										<span class="styled"><a href="#">Mot de passe
												oublié?</a></span>
										<button type="submit" class="btn btn-info right" id="loginBtn">
											<span class="icon16 icomoon-icon-enter white"></span> Login
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<!-- End .container-fluid -->
		</div>
		<!-- End .container-fluid -->
		<%@include file="footer.html"%>
</s:else>