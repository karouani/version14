<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row-fluid">

	<div class="span12">

		<div class="box gradient">

			<div class="title">
				<h4>
					<span>Donn&eacute;es Collaborateurs</span>
				</h4>
				
				<s:if test="%{message != null}">
								<div class="alert alert-error">
									<a href="" class="close" data-dismiss="alert">X</a>
									<p>
										<s:property value="message" />
									</p>
								</div>
							</s:if>
			</div>
			<div class="content noPad clearfix">
				<table cellpadding="0" cellspacing="0" border="0"
					class="responsive dynamicTable display table table-bordered"
					width="100%">
					<thead>
						<tr>
						    <th>Matricule</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Sexe</th>
							<th>Email</th>
							<th>Date Embauche</th>
							<th>Poste Travail</th>
							<th>Salaire</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
					
						<s:iterator value="colab">
							<tr class="odd gradeX">
								<td><s:property value="matricule" /></td>
								<td><s:property value="nom" /></td>
								<td><s:property value="prenom" /></td>
								<td><s:property value="sexe" /></td>
								<td><s:property value="email" /></td>
								<td><s:property value="dateembauche" /></td>
								<td><s:property value="posttravail" /></td>
								<td><s:property value="salaireactuel" /></td>
								<td>
									<div class="controls center">
										<a href="editerCollaborateurManagerRh?type=editerFormulaire&code=<s:property value="codecol" />"
											title="Edit task" class="tip"><span
											class="icon12 icomoon-icon-pencil"></span></a>
								</div>
								</td>
							</tr>
						</s:iterator>
					</tbody>	
					<tfoot>
						<tr>
							<th>Matricule</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Sexe</th>
							<th>Email</th>
							<th>Date Embauche</th>
							<th>Poste Travail</th>
							<th>Salaire</th>
							<th>Actions</th>
						</tr>
					</tfoot>
				</table>
			</div>

		</div>
		<!-- End .box -->

	</div>
	<!-- End .span12 -->

</div>
<!-- End .row-fluid -->
