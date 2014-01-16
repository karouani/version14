<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row-fluid">

	<div class="span12">

		<div class="page-header">
			<h4>Choisir un fichier Excel SVP !!</h4>
		</div>
		<form class="form-horizontal seperator" method="post"
			action="uploadexcel" enctype="multipart/form-data">

			<s:if test="%{message != null}">
				<div class="alert alert-error">
					<a href="" class="close" data-dismiss="alert">X</a>
					<s:if test=" taile == '0'">
						<h1>Vous donnée sont bien ajout&eacute;</h1>
					</s:if>
					<s:else>
						<h1>Voila la liste des collaborateurs erron&eacute;e</h1>
						<s:iterator value="erreur">
							<ul>
								<li><s:property value="erreur"/></li>
							</ul>
						</s:iterator>
					</s:else>
				</div>
			</s:if>


			<div class="form-row row-fluid">
				<div class="span12">
					<div class="row-fluid">
						<label class="form-label span3" for="username">Choisir :</label> <input
							type="file" name="myFile" id="file" />
						<button type="submit" class="btn btn-info marginR10">Upload</button>
						<button class="btn btn-danger">Cancel</button>
					</div>
				</div>
			</div>
		</form>


	</div>
	<!-- End .span12 -->

</div>
<!-- End .row-fluid -->