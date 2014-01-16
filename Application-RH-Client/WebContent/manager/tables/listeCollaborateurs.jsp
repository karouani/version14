<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row-fluid">

	<div class="span12">

		<div class="box gradient">

			<div class="title">
				<h4>
					<span>Donn&eacute;es Collaborateurs</span>
				</h4>
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
							<th>Date Embauche</th>
							<th>Poste Travail</th>
							<th>Salaire</th>
							<th>Manager Actuel</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
					
						<s:iterator value="colaborateur">
							<tr class="odd gradeX">
								<td><s:property value="matricule" /></td>
								<td><s:property value="nom" /></td>
								<td><s:property value="prenom" /></td>
								<td><s:property value="sexe" /></td>
								<td><s:property value="dateembauche" /></td>
								<td><s:property value="posttravail" /></td>
								<td><s:property value="salaireactuel" /></td>
								<td><s:property value="manageractuel.nom" /></td>
								<td>
									<div class="controls center">
										<a href="editerColaborateurManager?type=managerColaborateur&code=<s:property value="codecol" />"
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
							<th>Date Embauche</th>
							<th>Poste Travail</th>
							<th>Salaire</th>
							<th>Manager Actuel</th>
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
