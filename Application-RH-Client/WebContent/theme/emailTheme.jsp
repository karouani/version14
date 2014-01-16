<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Build page from here: -->
<div class="row-fluid">

	<div class="span2">
		<div class="email-nav well">
			<div class="composeBtn">
				<button href="menu?menu=message" class="btn btn-danger btn-block">Compose</button>
			</div>
			<ul class="nav nav-list">
				<li class="nav-header">Inbox()</li>
				<li class="active"><a href="currentEmail?menu=newMessage"
					id="today">Today</a></li>
				<li><a href="#">Important</a></li>
				<li><a href="#">Last week</a></li>
				<li><a href="#">All emails</a></li>
				<li class="nav-header">Outbox</li>
				<li><a href="#">Sent mail</a></li>
				<li class="divider"></li>
				<li><a href="#">Drafts</a></li>
				<li class="divider"></li>
				<li><a href="#">Archive</a></li>
			</ul>
		</div>
		<!-- End .email-nav-->
	</div>
	<!-- End .span2-->

	<div class="span10">

		<div class="email-content">

			<div class="email-header">

				<div class="btn-toolbar" style="margin: 0;">
					<div class="btn-group">
						<button class="btn tip" title="Refresh inbox">
							<span class="icon16 wpzoom-refresh"></span>
						</button>
					</div>
					<div class="btn-group">
						<button class="btn tip" title="Archive">
							<span class="icon16 eco-archive-3"></span>
						</button>
						<button class="btn tip" title="Mark as spam">
							<span class="icon16 brocco-icon-stop"></span>
						</button>
						<button class="btn tip" title="Delete">
							<span class="icon16 eco-trashcan"></span>
						</button>
					</div>
					<div class="btn-group">
						<button class="btn dropdown-toggle" data-toggle="dropdown">
							More <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">Mark as unread</a></li>
							<li><a href="#">Add star</a></li>
							<li><a href="#">Filter message</a></li>
							<li><a href="#">Mute</a></li>
						</ul>
					</div>
				</div>

			</div>