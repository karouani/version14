<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="read-email well">

				<div class="page-header">
					<div class="actions">
						<button id="backToInbox" class="btn marginR10 tip"
							title="Back to inbox">
							<span class="icon16 entypo-icon-back-2"></span>
						</button>
						<button id="save" class="btn marginR10 tip" title="Reply">
							<span class="icon16 entypo-icon-reply"></span>
						</button>
						<button id="discard" class="right btn btn-danger marginR10 tip"
							title="Delete">
							<span class="icon16 icon16 eco-trashcan white"></span>
						</button>
					</div>
				</div>
				<form class="readmail form-horizontal" />
				<div class="form-row row-fluid">
					<div class="span12">
						<div class="row-fluid">
							<label class="form-label span2" for="to">Subject:</label> <input
								class="span10" id="to" name="to" type="text"
								value="<s:property value='model.getSubject()'/>" readonly="readonly" />
						</div>
					</div>
				</div>

				<div class="form-row row-fluid">
					<div class="span12">
						<div class="row-fluid">
							<label class="form-label span2" for="subject">Sender:</label>
							<div>
								<input class="span10" id="subject" name="subject" type="text"
									value="<s:property value='model.getFrom()'/>" readonly="readonly" />
							</div>
						</div>
					</div>
				</div>

				<div class="form-row row-fluid">
					<div class="span12">
						<div class="row-fluid">
							<label class="form-label span2" for="subject">Date:</label>
							<div style="margin-top: 7px;">
								<span><s:property value="model.getDate()" /></span>
							</div>
						</div>
					</div>
				</div>

				<div class="form-row row-fluid">
					<div class="span12">
						<div class="row-fluid">
							<div class="span12 elastic" id="textarea">
								<s:property value="model.getMessage()"/>
							</div>
						</div>
					</div>
				</div>

				</form>

			</div>
			<!-- End .read-email -->
