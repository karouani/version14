<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row-fluid">
	<div class="span12">

		<div class="box">

			<div class="title">

				<h4>
					<span class="icon16 brocco-icon-grid"></span> <span>Durant
						la durée de vie du collaborateur chez la société</span>
				</h4>

			</div>
			<div class="content">

				<form class="form-horizontal" action="UpdateColaborateurManager">
					<input type="hidden" value='<s:property value="code"/>' name="code"> 
					<div class="form-row row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<s:if test="%{messageGood != null}">
									<div class="alert alert-error">
										<a href="" class="close" data-dismiss="alert">X</a>
										<p>
											<s:property value="messageGood" />
										</p>
									</div>
								</s:if>
								<label class="form-label span4" for="salaire">le salaire
									du collaborateur : </label> <input class="span8" id="normalInput"
									type="text" required="required" name="salaire"
									value='<s:property value="col.salaireactuel" />' />
							</div>
						</div>
					</div>

					<div class="form-row row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<label class="form-label span4" for="post">le poste
									niveau APP</label> <input class="span8 focused" id="normalInput"
									type="text" required="required" name="poste"
									value='<s:property value="col.posttravail" />' />
							</div>
						</div>
					</div>

					<div class="form-row row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<label class="form-label span4" for="password">Ancien
									Manager input</label> <input class="span8" id="manager" type="text" required="required"
									name="ancienmanager" disabled="disabled"
									value='<s:property value="col.manageractuel.nom" /> <s:property value="col.manageractuel.prenom" />' />
							</div>
						</div>
					</div>

					<div class="form-row row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<label class="form-label span4" for="manager-actuel">Manager
									RH Actuel:</label>
								<div class="span8 controls">
									<select id="actuel" name="manageractuel">
										<s:iterator value="managerActuel">
											<option value='<s:property value="codecol" />'>
												<s:property value="nom" />
												<s:property value="prenom" />
											</option>
										</s:iterator>
									</select>
								</div>
							</div>
						</div>
					</div>

					<div class="form-actions">
						<div style="width: 200px; float: right;">
							<button type="submit" class="btn btn-info">Save changes</button>
							<button type="button" class="btn">Cancel</button>
						</div>
					</div>


				</form>

			</div>

		</div>
		<!-- End .box -->

	</div>
	<!-- End .span12 -->
</div>