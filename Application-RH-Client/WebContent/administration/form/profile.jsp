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
			action="updateAdmin" enctype="multipart/form-data">
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
							class="span4" id="profile" type="text" required="required" disabled="disabled"
							value="<s:property value="administrateur.idadm"/>" /> <input
							type="hidden" name="idadm"
							value="<s:property value="administrateur.idadm"/>" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="username">Avatar:</label> <img
							src="profileImages/<s:property value='administrateur.photo'/>"
							alt="<s:property value='administrateur.photo'/>"
							class="image marginR10" width="60px" height="60px" /> <input
							type="hidden" name="photo"
							value="<s:property value='administrateur.photo'/>"> <input
							type="file" name="myFile" id="file" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="name">Nom:</label> <input
							class="span4" id="name" name="nom" type="text" required="required"
							value="<s:property value='administrateur.nom'/>" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="name">Prenom:</label> <input
							class="span4" id="prenom" name="prenom" type="text" required="required"
							value="<s:property value='administrateur.prenom'/>" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="email">Email:</label> <input
							class="span4" id="email" type="text" required="required" name="email"
							value="<s:property value="administrateur.email"/>" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="username">Username:</label> <input
							class="span4" id="username" type="text" required="required"
							value="<s:property value="administrateur.getCmp().getUsername()"/>"
							name="username" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="normal">Password:</label>
						<div class="span4 controls">
							<input class="span12" id="password" name="password"
								type="password" placeholder="Enter your password" value="" /> <input
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

							<s:if test='%{administrateur.sexe == "H"}'>
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
						<label class="form-label span3" for="textarea">Description
							:</label>
						<textarea class="span4 limit elastic" id="textarea2" rows="3"
							cols="5" name="description"><s:property
								value="administrateur.description" /></textarea>
					</div>
				</div>
			</div>
			<input type="hidden" name="status" value="in" />
			<!-- Au cas ou on veut activer ou desactiver un admin 
			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="email">Status de
							Compte:</label>
						<div class="span4 controls">
							<div class="left marginR10">
								<s:if test="%{status == 'in'}">
									<input type="checkbox" id="inlineCheckbox4" checked="checked"
										class="ibuttonCheck" name="status" value="in" />
								</s:if>
								<s:else>
									<input type="checkbox" id="inlineCheckbox4"
										class="ibuttonCheck" name="status" value="out" />
								</s:else>
							</div>
						</div>
					</div>
				</div>
			</div>
		 -->
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