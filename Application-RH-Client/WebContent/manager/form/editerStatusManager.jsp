<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row-fluid">
	<div class="span12">

		<div class="box">

			<div class="title">

				<h4>
					<span>Associ&eacute; les collaborateurs a le manager actuel</span>
				</h4>
			</div>
			<div class="content">

				<form class="form-horizontal" action="affectationManagerRh">
					<input type="hidden" name="code" value='<s:property value="code"/>' />
					<div class="form-row row-fluid">
						<div class="span12">
							<s:if test="%{message != null}">
								<div class="alert alert-error">
									<a href="" class="close" data-dismiss="alert">X</a>
									<p>
										<s:property value="message" />
									</p>
								</div>
							</s:if>
							<div class="leftBox">
								<div class="searchBox">
									<input type="text" id="box1Filter" class="span9 searchField"
										placeholder="filtrer ..." />
									<button id="box1Clear" type="button" class="btn">
										<span class="icon12 entypo-icon-cancel"></span>
									</button>
								</div>

								<select id="box1View" multiple="multiple"
									class="multiple nostyle" style="height: 300px;">
									<s:iterator value="nonlist">
										<option value="<s:property value="codecol"/>">
											<s:property value="nom" />
											<s:property value="prenom" />
										</option>
									</s:iterator>
								</select> <br /> <span id="box1Counter" class="count"></span>

								<div class="dn">
									<select id="box1Storage" name="box1Storage" class="nostyle"></select>
								</div>
							</div>

							<div class="dualBtn">
								<button id="to2" type="button" class="btn">
									<span class="icon12 minia-icon-arrow-right-3"></span>
								</button>
								<button id="to1" type="button" class="btn marginT5">
									<span class="icon12 minia-icon-arrow-left-3"></span>
								</button>
							</div>

							<div class="rightBox">
								<div class="searchBox">
									<input type="text" id="box2Filter" class="span9 searchField"
										placeholder="filtrer ..." />
									<button id="box2Clear" type="button" class="btn">
										<span class="icon12 entypo-icon-cancel"></span>
									</button>
								</div>
								<select id="box2View" multiple="multiple"
									class="multiple nostyle" style="height: 300px;"
									name="managerYes">
									<s:iterator value="list">
										<option value="<s:property value="codecol"/>">
											<s:property value="nom" />
											<s:property value="prenom" />
										</option>
									</s:iterator>
								</select><br /> <span id="box2Counter" class="count"></span>

								<div class="dn">
									<select id="box2Storage" class="nostyle">
									</select>
								</div>
							</div>

						</div>
					</div>
					<div class="form-row row-fluid">
						<div class="span12">
							<div class="row-fluid">
								<div class="form-actions">
									<div class="span6 controls">
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
		</div>
		<!-- End .box -->

	</div>
	<!-- End .span6 -->

</div>
<!-- End .row-fluid -->