<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row-fluid">
	<div class="span12">
		<div class="box gradient">

			<div class="title">
				<h4>
					<span>Modification de collaborateur <s:property
							value="model.idcol" />
					</span>
				</h4>
			</div>
			
				<form action="updateCollaborateurManagerRh" method="POST"
						class="form-horizontal seperator" id="wizzard-form"> 
						<!-- Smart Wizard -->
						<input type="hidden" name="id" value='<s:property value="code"/>'>
							<div class="form-row row-fluid">
								<div class="span12">
									<div class="row-fluid">
										<s:if test=" message != null ">
											<div class="alert alert-error">
												<a href="" class="close" data-dismiss="alert">X</a>
												<p>
													<s:property value="message" />
												</p>
											</div>
										</s:if>
										<label class="form-label span3" for="fname">Matricule :</label>
										<input disabled="disabled" class="span9" id="matricule"
											name="matricule" type="text"
											value="<s:property value='model.matricule'/>" maxlength="5" />
									</div>
								</div>
							</div>
	
							<div class="form-row row-fluid">
								<div class="span12">
									<div class="row-fluid">
										<label class="form-label span3" for="fname">Nom :</label> <input
											class="span9" id="nom" name="nom" type="text"
											value="<s:property value='model.nom'/>" />
									</div>
								</div>
							</div>
							
							<div class="form-row row-fluid">
								<div class="span12">
									<div class="row-fluid">
										<label class="form-label span3" for="lname">Prénom :</label> <input
											class="span9" id="prenom" name="prenom" type="text"
											value="<s:property value='model.prenom'/>" />
									</div>
								</div>
							</div>
							
							<div class="form-row row-fluid">
								<div class="span12">
									<div class="row-fluid">
										<label class="form-label span3" for="email">Email :</label> <input
											class="span9" name="email" type="text"
											value="<s:property value='model.email'/>" />
									</div>
								</div>
							</div>
	
							<div class="form-row row-fluid">
								<div class="span12">
									<div class="row-fluid">
										<label class="form-label span3" for="abreviation">Abreviation
											:</label> <input class="span9" id="abreviation" name="abreviation"
											type="text" value="<s:property value='model.abreviation'/>" />
									</div>
								</div>
							</div>
	
							<div class="form-row row-fluid">
								<div class="span12">
									<div class="row-fluid">
										<label class="form-label span3" for="sexe">Sexe :</label>
										<div class="span9 controls">
											<select id="gender" name="sexe">
												<s:if test='model.sexe != "F"'>
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
							
							<input type="hidden" id="testeur" value="no">
							
							<div class="form-row row-fluid">
								<div class="span12">
									<div class="row-fluid">
										<label class="form-label span3" for="checkboxes">Participé
											au séminaire d'intégration :</label>
										<div class="span9 controls">
											<div class="left marginR10">
												<s:if
													test="col.participeseminaire == 'oui' || col.participeseminaire == 'true'">
													<input type="checkbox" id="inlineCheckbox4" class="ibutton"
														checked="checked" name="participeseminaire" value="true" />
												</s:if>
												<s:else>
													<input type="checkbox" id="inlineCheckbox4" class="ibutton"
														name="participeseminaire" value="false" />
												</s:else>
											</div>
										</div>
									</div>
								</div>
							</div>
	
							<div class="form-row row-fluid afficher" id="dateparticipe">
								<div class="span12">
									<div class="row-fluid">
										<label class="form-label span3" for="dateparticipeseminaire">Date
											participation</label> <input type="text" class="span9"
											id="dateparticipeseminaire" name="dateparticipeseminaire"
											value='<s:property value="col.dateparticipeseminaire"/>' />
									</div>
								</div>
							</div>
	
							<div class="form-row row-fluid">
								<div class="span12">
									<div class="row-fluid">
										<div class="form-actions">
											<div class="span3 controls" style="float: right;">
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
		<!-- End .box -->
	</div>
	<!-- End .span12 -->
</div>
<!-- End .row-fluid -->

