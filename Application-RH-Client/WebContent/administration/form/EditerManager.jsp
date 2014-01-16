<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row-fluid">
	<div class="span12">
		<div class="box gradient">

			<div class="title">

				<h4>
					<span>Formulaire Nouveau <s:property value="type" /></span>
				</h4>

			</div>
			<div class="content noPad clearfix">

				<form action="UpdateManager" method="POST" class="form-horizontal"
					id="wizzard-form">

					<input type="hidden" name="idcol"
						value='<s:property value="col.codecol" />'>
					<!-- Smart Wizard -->
					<div id="wizard-validation" class="swMain">
						<ul>

							<li><a href="#step-1"> <label class="stepNumber">1</label>
									<span class="stepDesc"> Les données Personelles </span>
							</a></li>
							<li><a href="#step-2"> <label class="stepNumber">2</label>
									<span class="stepDesc"> Les dates </span>
							</a></li>
							<li><a href="#step-3"> <label class="stepNumber">3</label>
									<span class="stepDesc"> Autres détailles </span>
							</a></li>

							<s:if test="%{form != 'collaborateur' }">
								<li><a href="#step-4"> <label class="stepNumber">4</label>
										<span class="stepDesc">Compte</span>
								</a></li>
							</s:if>
						</ul>



						<div id="step-1">
							<div class="span12">
								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<s:if test="%{messageErreurUpdate != null}">
												<div class="alert alert-error">
													<a href="" class="close" data-dismiss="alert">X</a>
													<p>
														<s:property value="messageErreurUpdate" />
													</p>
												</div>
											</s:if>

											<label class="form-label span3" for="fname">Matricule
												:</label> <input class="span9" id="matricule" name="matricule"
												type="text" required="required" maxlength="5"
												value='<s:property value="col.matricule" />' />
										</div>
									</div>
								</div>

								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="fname">Nom :</label> <input
												class="span9" id="nom" name="nom" type="text" required="required"
												value='<s:property value="col.nom" />' />
										</div>
									</div>
								</div>
								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="lname">Prénom :</label>
											<input class="span9" id="prenom" name="prenom" type="text" required="required"
												value='<s:property value="col.prenom" />' />
										</div>
									</div>
								</div>
								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="email">Email :</label> <input
												class="span9" id="email" name="email" type="text" required="required"
												value='<s:property value="col.email" />' />
										</div>
									</div>
								</div>
								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="abreviation">Abreviation
												:</label> <input class="span9" id="abreviation" name="abreviation"
												type="text" required="required" value='<s:property value="col.abreviation" />' />
										</div>
									</div>
								</div>

								<!--  <div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="ancien-manager">Ancien
												Manager RH :</label>
											<div class="span9 controls">
												<select id="ancien" name="ancien-manager">
													<option value="" selected>- select -</option>
													<option value="homme">1</option>
													<option value="femme">2</option>
												</select>
											</div>
										</div>
									</div>
								</div>
							 -->
								<!--  
								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="manager-actuel">Manager
												RH Actuel:</label>
											<div class="span9 controls">
												<select id="actuel" name="manageractuel">
													<option value="" selected>- select -</option>
													<s:iterator value="managerRh">
														<option value='<s:property value="codecol"/>'>
															<s:property value="nom" />
															<s:property value="prenom" />
														</option>
													</s:iterator>
												</select>
											</div>
										</div>
									</div>
								</div>
							-->
								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="gender">Sexe :</label>
											<div class="span9 controls">
												<select id="gender" name="sexe">
													<s:if test='%{col.sexe == "H"}'>
														<option value="H" selected="selected">Homme</option>
														<option value="F">Femme</option>
													</s:if>
													<s:else>
														<option value="H">Homme</option>
														<option value="F" selected="selected">Femme</option>
													</s:else>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="step-2">
							<div class="span12">

								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="site">Site :</label> <select
												id="site" name="site">
												<s:iterator value="city">
													<s:if test="descsite == 'RABAT'">
														<option value='<s:property value="codest"/>'
															selected="selected">
															<s:property value="descsite" />
														</option>
													</s:if>
													<s:else>
														<option value='<s:property value="codest"/>'>
															<s:property value="descsite" />
														</option>
													</s:else>
												</s:iterator>
											</select>
										</div>
									</div>
								</div>

								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="bu">BU :</label> <select
												id="bu" name="bu">
												<s:iterator value="buv">
													<option value='<s:property value="codebu"/>'>
														<s:property value="descbu" />
													</option>
												</s:iterator>
											</select>
										</div>
									</div>
								</div>

								<div class="form-row row-fluid">
									<div class="span12">
									
										<s:if test='%{ diplomes.size > 0}'>
											<div class="row-fluid afficher" id="diplome">
											<label class="form-label span3" for="diplome">Diplômes
											:</label> <input class="span9 ecole" type="text" required="required" value="null" />
										<div class="span7 controls"
											style="display: -webkit-box; display: -moz-box; display: -webkit-flexbox; display: -ms-flexbox; display: -webkit-flex; display: flex; width: 74%; margin-top: 8px;">

											<select class="niveau">
												<option value="bac+2" selected="selected">Bac+2</option>
												<option value="bac+3">Bac+3</option>
												<option value="bac+5">Bac+5</option>
												<option value="col">col</option>
											</select> <select class="type-ecole">
												<option value="Nationale" selected="selected">nationale</option>
												<option value="Internationale">internationale</option>
											</select> <select class="type-diplome">
												<option value="prive">Privé</option>
												<option value="etatique" selected="selected">Etatique</option>
											</select> <input type="text" required="required" maxlength="9" placeholder="xxxx-xxxx"
												class="span4 text promotion"value="xxxx-xxxx" /> <i
												class="icon-plus-sign ajouterDiplome"></i> <i
												class="icon-minus-sign supprimerDiplome"></i>
										</div>
									</div>

									<!--  Iterator Diplomes de collaborateur -->

									<s:iterator value="diplomes">
										<div class="row-fluid">
											<label class="form-label span3" for="diplome">Diplômes
												:</label> <input class="span9 ecole" type="text" required="required" name="ecole"
												value='<s:property value="ecole"/>' />
											<div class="span7 controls"
												style="display: -webkit-box; display: -moz-box; display: -webkit-flexbox; display: -ms-flexbox; display: -webkit-flex; display: flex; width: 74%; margin-top: 8px;">

												<select name="niveau" class="niveau">
													<option value="<s:property value="niveau"/>"><s:property
															value="niveau" /></option>
													<option value="bac+2">Bac+2</option>
													<option value="bac+3">Bac+3</option>
													<option value="bac+5">Bac+5</option>
													<option value="col">col</option>
												</select> <select name="type_ecole" class="type_ecole">
													<option value='<s:property value="typeE"/>'><s:property
															value="typeE" /></option>
													<option value="Nationale">nationale</option>
													<option value="Internationale">internationale</option>
												</select> <select name="type_diplome" class="type_diplome">
													<option value='<s:property value="typeD"/>'><s:property
															value="typeD" /></option>
													<option value="prive">Privé</option>
													<option value="etatique">Etatique</option>
												</select> <input type="text" required="required" name="promotion" maxlength="9"
													placeholder="xxxx-xxxx" class="span4 text promotion" 
													value='<s:property value="promo"/>' /> <i
													class="icon-plus-sign ajouterDiplome"></i> <i
													class="icon-minus-sign supprimerDiplome"></i>
											</div>
										</div>
									</s:iterator>
										</s:if>
										<s:else>
											<div class="row-fluid">
											<label class="form-label span3" for="diplome">Diplômes
												:</label> <input class="span9 ecole" type="text" required="required" name="ecole"
												/>
											<div class="span7 controls"
												style="display: -webkit-box; display: -moz-box; display: -webkit-flexbox; display: -ms-flexbox; display: -webkit-flex; display: flex; width: 74%; margin-top: 8px;">

												<select name="niveau" class="niveau">
													<option value="bac+2">Bac+2</option>
													<option value="bac+3">Bac+3</option>
													<option value="bac+5">Bac+5</option>
													<option value="col">col</option>
												</select> <select name="type_ecole" class="type_ecole">
													<option value="Nationale">nationale</option>
													<option value="Internationale">internationale</option>
												</select> <select name="type_diplome" class="type_diplome">
													<option value="prive">Privé</option>
													<option value="etatique">Etatique</option>
												</select> <input type="text" required="required" name="promotion" maxlength="9"
													placeholder="xxxx-xxxx" class="span4 text promotion"
													 /> <i
													class="icon-plus-sign ajouterDiplome"></i> <i
													class="icon-minus-sign supprimerDiplome"></i>
											</div>
										</div>
										</s:else>
										
									<!-- End List Diplome de colaborateurs -->
									<div id="diplome1"></div>
								</div>
							</div>
								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="dateembauche">Date
												Embauche</label> <input type="text" required="required" class="span9" id="datepicker"
												name="dateembauche"
												value='<s:property value="col.dateembauche" />' />
										</div>
									</div>
								</div>

								<div class="form-row row-fluid afficher">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="moisBAP">mois
												BAP :</label> <input class="span9" id="moisBAP" name="moisBAP"
												value='<s:property value="col.moisBAP" />' type="hidden" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="step-3">
							<input type="hidden" id="testeur" value="yes">
							<div class="span12">


								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="participeseminaire">Participé
												au séminaire d'intégration :</label>
											<div class="span9 controls">
												<div class="left marginR10">
													<s:if test="%{col.participeseminaire == 'true' }">
														<input type="checkbox" id="inlineCheckbox4"
															checked="checked" class="ibutton"
															name="participeseminaire" value="true" />
													</s:if>
													<s:else>
														<input type="checkbox" id="inlineCheckbox4"
															class="ibutton" name="participeseminaire" value="false" />
													</s:else>
												</div>
											</div>
										</div>
									</div>
								</div>

								<s:if test="%{col.participeseminaire == 'true' }">
									<div class="form-row row-fluid" id="dateparticipe">
										<div class="span12">
											<div class="row-fluid">
												<label class="form-label span3" for="dateparticipeseminaire">Date
													participation</label> <input type="text" class="span9"
													id="dateparticipeseminaire" name="dateparticipeseminaire"
													value='<s:property value="col.dateparticipeseminaire" />' />
											</div>
										</div>
									</div>
								</s:if>
								<s:else>
									<div class="form-row row-fluid afficher" id="dateparticipe">
										<div class="span12">
											<div class="row-fluid">
												<label class="form-label span3" for="dateparticipeseminaire">Date
													participation</label> <input type="text" class="span9"
													id="dateparticipeseminaire" name="dateparticipeseminaire"
													value='<s:property value="col.dateparticipeseminaire" />' />
											</div>
										</div>
									</div>
								</s:else>
								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="posttravail">Poste
												Actuel :</label> <input maxlength="4" class="span9" id="posttravail"
												name="posttravail" type="text" required="required"
												value='<s:property value="col.posttravail" />' />
										</div>
									</div>
								</div>

								<div class="form-row row-fluid">
									<div class="span12">
										<div class="row-fluid">
											<label class="form-label span3" for="salaireactuel">Salaire
												Actuel :</label> <input class="span9" id="salaireactuel"
												name="salaireactuel" type="text" required="required"
												value='<s:property value="col.salaireactuel" />' />
										</div>
									</div>
								</div>


								<div class="form-row row-fluid">
									<div class="span12">
									<s:if test="%{techno.size()>0}">
										<div class="row-fluid afficher" id="technologie">
											<label class="form-label span3" for="desctechno">Technologie
												1 : </label>
											<div class="span7 controls"
												style="display: -webkit-box; display: -moz-box; display: -webkit-flexbox; display: -ms-flexbox; display: -webkit-flex; display: flex; width: 74%; margin-top: 8px;">
	
												<input class="span6 text desctechno" type="text" required="required"
													placeholder="Technologie" value="Technologie"/> <input
													class="span6 text comp" type="text" required="required"
													placeholder="Comp&eacute;tences" value="Comp&eacute;tences" /> <select
													class="level" style="width: 0;">
													<%
															for (int i = 1; i < 6; i++) {
														%>
													<option value="Level<%=i%>">Niveau
														<%=i%></option>
													<%
															}
														%>
												</select> <i class="icon-plus-sign Ajoutertechnologie"></i> <i
													class="icon-minus-sign supprimertechnologie"></i>
											</div>
										</div>
	
										<s:iterator value="techno">
											<div class="row-fluid">
												<label class="form-label span3" for="desctechno">Technologie
													: </label>
												<div class="span7 controls"
													style="display: -webkit-box; display: -moz-box; display: -webkit-flexbox; display: -ms-flexbox; display: -webkit-flex; display: flex; width: 74%; margin-top: 8px;">
	
													<input class="span6 text desctechno" type="text" required="required" name="desctechno"
														placeholder="Technologie"
														value='<s:property value="techno" />' /> <input
														class="span6 text comp" type="text" required="required" name="comp"
														placeholder="Comp&eacute;tences"
														value='<s:property value="comp" />' /> <select
														name="level" class="level" style="width: 0;">
														<option value="<s:property value="level" />">
															<s:property value="level" />
														</option>
														<%
															for (int i = 1; i < 6; i++) {
														%>
														<option value="Level<%=i%>">Niveau
															<%=i%></option>
														<%
															}
														%>
													</select> <i class="icon-plus-sign Ajoutertechnologie"></i> <i
														class="icon-minus-sign supprimertechnologie"></i>
												</div>
											</div>
										</s:iterator>
										</s:if>
										<s:else>
											<div class="row-fluid">
												<label class="form-label span3" for="desctechno">Technologie
													: </label>
												<div class="span7 controls"
													style="display: -webkit-box; display: -moz-box; display: -webkit-flexbox; display: -ms-flexbox; display: -webkit-flex; display: flex; width: 74%; margin-top: 8px;">
	
													<input class="span6 text desctechno" type="text" required="required" name="desctechno"
														placeholder="Technologie"
														 /> <input
														class="span6 text comp" type="text" required="required" name="comp"
														placeholder="Comp&eacute;tences"
														  /> <select
														name="level" class="level" style="width: 0;">
															
														<%
															for (int i = 1; i < 6; i++) {
														%>
														<option value="Level<%=i%>">Niveau
															<%=i%></option>
														<%
															}
														%>
													</select> <i class="icon-plus-sign Ajoutertechnologie"></i> <i
														class="icon-minus-sign supprimertechnologie"></i>
												</div>
											</div>
										</s:else>
										<div id="technologie1"></div>
									</div>
								</div>
							</div>
						</div>

						<s:if test="%{form != 'collaborateur' }">
							<div id="step-4">
								<input type="hidden" id="testeur" value="non">
								<div class="span12">
									<s:if test="#session.user.getRole() == 'Administrateur' ">
										<div class="form-row row-fluid">
											<div class="span12">
												<div class="row-fluid">
													<label class="form-label span3" for="profile">Profile
														:</label>
													<div class="span9 controls">
														<select id="profile" name="profile">
															<s:if test="col.getProfil().getRole() == 'AmbassadeurRH'">
																<option value="AmbassadeurRH" selected="selected">Ambassadeur
																	RH</option>
																<option value="ResponsableProduction">Responsable
																	de production</option>
																<option value="ManagerAgence">Manager d'agence</option>
															</s:if>

															<s:if
																test="col.getProfil().getRole() == 'ResponsableProduction'">
																<option value="AmbassadeurRH">Ambassadeur RH</option>
																<option value="ResponsableProduction"
																	selected="selected">Responsable de production</option>
																<option value="ManagerAgence">Manager d'agence</option>
															</s:if>

															<s:if test="col.getProfil().getRole() == 'ManagerAgence'">
																<option value="AmbassadeurRH">Ambassadeur RH</option>
																<option value="ResponsableProduction">Responsable
																	de production</option>
																<option value="ManagerAgence" selected="selected">Manager
																	d'agence</option>
															</s:if>

														</select>
													</div>
												</div>
											</div>
										</div>
									</s:if>
									<s:else>
										<input type="hidden" id="profile" name="profile"
											value="ManagerRH">
									</s:else>
									<div class="form-row row-fluid">
										<div class="span12">
											<div class="row-fluid">
												<label class="form-label span3" for="username">UserName
													:</label>
												<div class="span9 controls">
													<input id="username1" name="username1" class="span12"
														type="text" required="required"
														value='<s:property value="col.getProfil().getUsername()" />' />
												</div>
											</div>
										</div>
									</div>
									<div class="form-row row-fluid">
										<div class="span12">
											<div class="row-fluid">
												<label class="form-label span3" for="password">Password
													:</label>
												<div class="span9 controls">
													<input class="span12" id="password1" name="password1"
														type="password" placeholder="Enter your password"
														value='<s:property value="col.getProfil().getPassword()" />' />
													<input class="span12" id="passwordConfirm1"
														name="confirm_password1" type="password"
														placeholder="Enter your password again"
														value='<s:property value="col.getProfil().getPassword()" />' />
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</s:if>
					</div>
					<!-- End SmartWizard Content -->

				</form>
			</div>

		</div>
		<!-- End .box -->

	</div>
	<!-- End .span12 -->

</div>
<!-- End .row-fluid -->

