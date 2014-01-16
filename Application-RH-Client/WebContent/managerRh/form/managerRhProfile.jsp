<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row-fluid">

	<div class="span12">

		<div class="page-header">
			<h4>
				<s:property value="#session.user.getName()" />
				profile
			</h4>
		</div>
		<form class="form-horizontal seperator" method="post"
			action="updateManagerRhProfile">
			
			<s:if test="%{message != null}">
				<div class="alert alert-error">
					<a href="" class="close" data-dismiss="alert">X</a>
					<p>
						<s:property value="message" />
					</p>
				</div>
			</s:if>
			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="profile">ID :</label> <input
							class="span4" id="profile" type="text" disabled="disabled"
							value="<s:property value="autres.codecol"/>" /> <input
							type="hidden" name="idadm"
							value="<s:property value="autres.codecol"/>" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="username">Avatar:</label> <img
							src="profileImages/cicin.jpg"
							alt="<s:property value='autres.photo'/>"
							class="image marginR10" width="60px" height="60px" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="name">Nom:</label> <input
							class="span4" id="name" name="nom" type="text"
							value="<s:property value='autres.nom'/>" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="name">Prenom:</label> <input
							class="span4" id="prenom" name="prenom" type="text"
							value="<s:property value='autres.prenom'/>" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="email">Email:</label> <input
							class="span4" id="email" type="text" name="email"
							value="<s:property value="autres.email"/>" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="username">Username:</label> <input
							class="span4" id="username" type="text"
							value="<s:property value="autres.profil.username"/>"
							name="username" />
					</div>
				</div>
			</div>
			<input type="hidden" value="<s:property value="type"/>"
							name="type" />
			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="normal">Password:</label>
						<div class="span4 controls">
							<input class="span12" id="password" name="password"
								type="password" placeholder="Enter your password" value="<s:property value="autres.profil.password"/>" /> <input
								class="span12" id="passwordConfirm" name="confirm_password"
								type="password" placeholder="Enter your password again" />
						</div>
					</div>
				</div>
			</div>



			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="email">Sexe:</label>
						<div class="left marginT5 marginR10">

							<s:if test='%{autres.sexe == "H"}'>
								<input type="radio" name="sexe" id="optionsRadios1" value="H"
									checked="checked" />
								Homme
								<input type="radio" name="sexe" id="optionsRadios2" value="F" />
								Femme
							</s:if>
							<s:else>
								<input type="radio" name="sexe" id="optionsRadios1" value="H" />
								Homme
								<input type="radio" name="sexe" id="optionsRadios2" value="F"
									checked="checked" />
								Femme
							</s:else>
						</div>
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<div class="form-actions">
							<div class="span3"></div>
							<div class="span4 controls">
								<button type="submit" class="btn btn-info marginR10">Save
									changes</button>
								<button class="btn btn-danger">Cancel</button>
							</div>
						</div>
					</div>
				</div>
			</div>


		</form>

	</div>
	<!-- End .span12 -->

</div>
<!-- End .row-fluid -->