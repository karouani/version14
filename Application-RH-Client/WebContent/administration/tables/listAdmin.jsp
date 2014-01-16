<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row-fluid">

	<div class="span12">

		<div class="box gradient">

			<div class="title">
				<h4>
					<span>Data table</span>
					<s:property value="%{list.size()}" />
				</h4>
			</div>
			<div class="content noPad clearfix">
				<table cellpadding="0" cellspacing="0" border="0"
					class="responsive dynamicTable display table table-bordered"
					width="100%">
					<thead>
						<tr>
							<th>Nom</th>
							<th>Pr&eacute;nom</th>
							<th>Email</th>
							<th>Sexe</th>
							<th>Photo</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>

						<s:iterator value="list">
							<tr class="odd gradeX">
								<td><s:property value="nom" /></td>
								<td><s:property value="prenom" /></td>
								<td><s:property value="email" /></td>
								<td><s:property value="sexe" /></td>
								<td>
									<img src='profileImages/<s:property value="photo" />'
										width="60px" height="60px" />
								</td>
								<td>
									<div class="controls center">
										<a href='profile?id=<s:property value="idadm" />&type=Administrateur'
										   title="Edit task" 
										   class="tip">
										   		<span
														class="icon12 icomoon-icon-pencil">
												</span>
										</a> 
										<a href="#"
											title="Remove task" class="tip">
												<span
													class="icon12 icomoon-icon-remove">
												</span> 
										</a>

									</div>
								</td>
							</tr>
						</s:iterator>
					<tfoot>
						<tr>
							<th>Rendering engine</th>
							<th>Browser</th>
							<th>Platform(s)</th>
							<th>Engine version</th>
							<th>CSS grade</th>
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
