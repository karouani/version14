<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row-fluid">

	<div class="span12">

		<div class="page-header">
			<h4>
				Nouveau Admin
			</h4>
		</div>
		<form class="form-horizontal seperator" method="post"
			action="nouveauAdmin" enctype="multipart/form-data">
			<s:if test="%{messageN != null}">
				<div class="alert alert-error">
					<a href="" class="close" data-dismiss="alert">X</a>
					<p>
						<s:property value="messageN" />
					</p>
				</div>
			</s:if>
			 <input
							type="hidden" name="idadm"
							value="<s:property value="administrateur.idadm"/>" />
					
			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="myFile">Avatar:</label><input
							type="hidden" name="photo"
							> <input
							type="file" name="myFile" id="file" />
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="name">Nom:</label> <input
							class="span4" id="name" name="nom" type="text" required="required"
							/>
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="name">Prenom:</label> <input
							class="span4" id="prenom" name="prenom" type="text" required="required"
							/>
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="email">Email:</label> <input
							class="span4" id="email" type="text" required="required" name="email"
							/>
					</div>
				</div>
			</div>

			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="username">Username:</label> <input
							class="span4" id="username" type="text" required="required"
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

								<input type="radio" name="sexe" id="optionsRadios1" value="H"
									/>
								Homme
								<input type="radio" name="sexe" id="optionsRadios2" value="F" />
								Femme
							
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
							cols="5" name="description"></textarea>
					</div>
				</div>
			</div>
			<input type="hidden" name="status" value="in" />
							</div>
			<!--  
			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="email">Status de
							Compte:</label>
						<div class="span4 controls">
							<div class="left marginR10">
									<input type="checkbox" id="inlineCheckbox4" checked="checked"
										class="ibuttonCheck" name="status" value="in" />
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