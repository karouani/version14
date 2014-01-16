//window resize events
$(window).resize(function() {
	//get the window size
	var wsize =  $(window).width();
	if (wsize > 980 ) {
		$('.shortcuts.hided').removeClass('hided').attr("style","");
		$('.sidenav.hided').removeClass('hided').attr("style","");
	}

	var size ="Window size is:" + $(window).width();
	/*console.log(size)*/
});

//document ready function
$(document).ready(function() { 	

	//prevent font flickering in some browsers 
	(function(){
		//if firefox 3.5+, hide content till load (or 3 seconds) to prevent FOUT
		var d = document, e = d.documentElement, s = d.createElement('style');
		if (e.style.MozTransform === ''){ // gecko 1.9.1 inference
			s.textContent = 'body{visibility:hidden}';
			e.firstChild.appendChild(s);
			function f(){ s.parentNode && s.parentNode.removeChild(s); }
			addEventListener('load',f,false);
			setTimeout(f,3000); 
		}
	})();

	//Disable certain links
	$('a[href^=#]').click(function (e) {
		e.preventDefault()
	})

	$('.search-btn').addClass('nostyle');//tell uniform to not style this element

	//Simple solution for this bug https://github.com/twitter/bootstrap/issues/4497
	$('body')
	.off('click.dropdown touchstart.dropdown.data-api', '.dropdown')
	.on('click.dropdown touchstart.dropdown.data-api', '.dropdown form', function (e) { e.stopPropagation() })


	//------------- Navigation -------------//

	mainNav = $('.mainnav>ul>li');
	mainNav.find('ul').siblings().addClass('hasUl').append('<span class="hasDrop icon16 icomoon-icon-arrow-down"></span>');
	mainNavLink = mainNav.find('a').not('.sub a');
	mainNavLinkAll = mainNav.find('a');
	mainNavSubLink = mainNav.find('.sub a').not('.sub li .sub a');
	mainNavCurrent = mainNav.find('a.current');

	//remove current class if have
	mainNavCurrent.removeClass('current');
	//set the seleceted menu element
	if ($.cookie("newCurrentMenu")) {
		mainNavLinkAll.each(function(index) {
			if($(this).attr('href') == $.cookie("newCurrentMenu")) {
				//set new current class
				$(this).addClass('current');

				ulElem = $(this).closest('ul');
				if(ulElem.hasClass('sub')) {
					//its a part of sub menu need to expand this menu
					aElem = ulElem.prev('a.hasUl').addClass('drop');
					ulElem.addClass('expand');
				} 
				//destroy cookie	
				$.cookie("newCurrentMenu",null);
			}
		});
	}	

	//hover magic add blue color to icons when hover - remove or change the class if not you like.
	mainNavLinkAll.hover(
			function () {
				$(this).find('span.icon16').addClass('blue');
			}, 
			function () {
				$(this).find('span.icon16').removeClass('blue');
			}
	);

	//click magic
	mainNavLink.click(function(event) {
		$this = $(this);

		if($this.hasClass('hasUl')) {
			event.preventDefault();
			if($this.hasClass('drop')) {
				$(this).siblings('ul.sub').slideUp(500, 'jswing').siblings().removeClass('drop');
			} else {
				$(this).siblings('ul.sub').slideDown(500, 'jswing').siblings().addClass('drop');
			}			
		} else {
			//has no ul so store a cookie for change class.
			$.cookie("newCurrentMenu",$this.attr('href') ,{expires: 1});
		}
	});
	mainNavSubLink.click(function(event) {
		$this = $(this);

		if($this.hasClass('hasUl')) {
			event.preventDefault();
			if($this.hasClass('drop')) {
				$(this).siblings('ul.sub').slideUp(500).siblings().removeClass('drop');
			} else {
				$(this).siblings('ul.sub').slideDown(250).siblings().addClass('drop');
			}			
		} else {
			//has no ul so store a cookie for change class.
			$.cookie("newCurrentMenu",$this.attr('href') ,{expires: 1});
		}
	});

	//responsive buttons
	$('.resBtn>a').click(function(event) {
		$this = $(this);
		if($this.hasClass('drop')) {
			$('#sidebar>.shortcuts').slideUp(500).addClass('hided');
			$('#sidebar>.sidenav').slideUp(500).addClass('hided');
			$this.removeClass('drop');
		} else {
			$('#sidebar>.shortcuts').slideDown(250);
			$('#sidebar>.sidenav').slideDown(250);
			$this.addClass('drop');
		}
	});
	$('.resBtnSearch>a').click(function(event) {
		$this = $(this);
		if($this.hasClass('drop')) {
			$('.search').slideUp(500);
			$this.removeClass('drop');
		} else {
			$('.search').slideDown(250);
			$this.addClass('drop');
		}
	});

	//Hide and show sidebar btn
	$( '.collapseBtn' ).bind( 'click', function(){
		$this = $(this);
		//check if sidebar is show
		if($(this).hasClass('hide')) {
			/*console.log('Sidebar is show');*/
			$('#sidebarbg').css('margin-left','0');
			$('#content').css('margin-left', '213'+'px');
			$('#sidebar').css('left', '0').css('margin-left','0');
			$this.removeClass('hide');
			$('.collapseBtn').css('top', '118'+'px').css('left', '170'+'px').removeClass('shadow');
			$this.children('a').attr('title','Cacher Sidebar');

		} else {
			/*console.log('Sidebar is hided');*/
			//hide sidbar
			$('#sidebarbg').css('margin-left','-299'+'px');
			$('#sidebar').css('margin-left','-299'+'px');
			$('.collapseBtn').animate({ //use .hide() if you experience heavy animation :)
				left: '200',
				top: '20'
			}, 500, 'easeInExpo', function() {
				// Animation complete.

			}).addClass('shadow');
			//expand content
			$this.addClass('hide');
			$this.children('a').attr('title','Afficher Sidebar')
			$('#content').css('margin-left', '0');

		}
	});


	//------------- Tags plugin  -------------//

	$("#tags").select2({
		tags:["Java", "PHP", ".Net", "Python"]
	});

	$("#to").select2({
		tags:["ykarouani@gmail.com", "mouhcineelgarej@gmail.com", "sqli@sqli.com", "e-challange@sqli.com"],
		tokenSeparators: [","]
	});
	//------------- I button  -------------//
	$(".ibutton").iButton({
		labelOn: "Oui",
		labelOff: "Non",
		enableDrag: false
	});

	$(".ibutton-label-off").click(function(){
		//alert("test");
		$("#dateparticipe").removeClass("afficher");
	});

	$(".ibutton-label-on").click(function(){
		//alert("test");
		$("#dateparticipe").addClass("afficher");
	});

	$(".ibutton1").iButton({
		labelOn: "En LIGNE",
		labelOff: "Hors LIGNE",
		enableDrag: false
	});
	$(".ibuttonCheck").iButton({
		labelOn: "<span class='icon16 typ-icon-checkmark white'></span>",
		labelOff: "<span class='icon16 typ-icon-cancel white'></span>",
		enableDrag: false
	});


	//------------- Datepicker -------------//
	$("#datepicker").datepicker({
		showOtherMonths:true,
		dateFormat: "dd/mm/yy"
	});

	$("#dateparticipeseminaire").datepicker({
		showOtherMonths:true,
		dateFormat: "dd/mm/yy"
	});

	$("#datedepart").datepicker({
		showOtherMonths:true,
		dateFormat: "dd/mm/yy"
	});


	//--------------- Form validation ------------------//
	$(".form-horizontal").validate({
		rules: {
			username: {
				required: true,
				minlength: 4
			},

			name: {
				required: true,
				minlength: 4
			},
			prenom: {
				required: true,
				minlength: 4
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			username : {
				required: "Ce champ est obligatoir",
				minlength: "au moin 4 caractères"
			},
			name : {
				required: "Ce champ est obligatoir",
				minlength: "au moin 4 caractères"
			},
			prenom : {
				required: "Ce champ est obligatoir",
				minlength: "au moin 4 caractères"
			},
			password: {
				required: "SVP entrez un password",
				minlength: "Au moins 5 caracteres"
			},
			confirm_password: {
				required: "SVP entrez un password",
				minlength: "Au moins 5 caracteres",
				equalTo: "SVP repeter votre password"
			},
			email: {
				required: "Ce champ est obligatoir",
				email: "Please enter a valid email address"
			}
		}	
	});

	/*-----------------------Formulaire Profile Admin-------------------*/
	$("#nouveauAdmin").validate({
		rules: {
			username2: {
				required: true,
				minlength: 4
			},

			name2: {
				required: true,
				minlength: 4
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			email2: {
				required: true,
				email: true
			}
		},
		messages: {
			username2 : {
				required: "Ce champ est obligatoir",
				minlength: "au moin 4 caractères"
			},
			name2 : {
				required: "Ce champ est obligatoir",
				minlength: "au moin 4 caractères"
			},
			password: {
				required: "SVP entrez un password",
				minlength: "Au moins 5 caracteres"
			},
			confirm_password: {
				required: "SVP entrez un password",
				minlength: "Au moins 5 caracteres",
				equalTo: "SVP repeter votre password"
			},
			email2: {
				required: "Ce champ est obligatoir",
				email: "Please enter a valid email address"
			}
		}	
	});

	/*-----------------------Formulaire collaborateur-------------------*/
	$("#wizzard-form").validate({
		rules: {
			nom: {
				required: true,
				minlength: 4
			},
			prenom: {
				required: true,
				minlength: 4
			},
			abreviation:{
				required: true,
				maxlength: 3,
			},
			gender: {
				required: true,
			},
			matricule:{
				required : true,
				minlength: 5,
				rule : function(element) {

				}
			},
			username1: {
				required: true,
				minlength: 4
			},
			username: {
				required: true,
				minlength: 4
			},
			password1: {
				required: true,
				minlength: 5
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password1: {
				required: true,
				minlength: 5,
				equalTo: "#password1"
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			email1: {
				required: true
			},
			email: {
				required: true
			},
			site:{
				required: true
			},
			bu:{
				required: true
			},
			datepicker:{
				required: true
			},
			posttravail:{
				required: true
			},
			salaireactuel:{
				required: true
			},
			ecole:{
				required: true
			},
			niveau:{
				required: true
			},
			promotion:{
				required: true
			},
			type_diplome:{
				required: true
			},
			type_ecole:{
				required: true
			},
			desctechno:{
				required: true
			},
			comp:{
				required: true
			},
			level:{
				required: true
			},
			profile:{
				required: true
			}
		},
		messages: {
			nom: {
				required: "Ce champ est obligatoir",
				minlength: "au moin 4 caractères"
			},
			prenom: {
				required: "Ce champ est obligatoir",
				minlength: "au moin 4 caractères"
			},
			abreviation:{
				required: "Ce champ est obligatoir",
				maxlength: "au maximum 3 caractères"
			},
			matricule :{
				required: "Ce champ est obligatoir",
				minlength: jQuery.format("Au moins {0} nombres"),
			},
			password1: {
				required: "SVP entrez un password",
				minlength: "Au moins 5 caracteres"
			},
			password: {
				required: "SVP entrez un password",
				minlength: "Au moins 5 caracteres"
			},
			confirm_password1: {
				required: "SVP entrez un password",
				minlength: "Au moins 5 caracteres",
				equalTo: "SVP repeter votre password"
			},
			confirm_password: {
				required: "SVP entrez un password",
				minlength: "Au moins 5 caracteres",
				equalTo: "SVP repeter votre password"
			},
			username1 : {
				required: "Ce champ est obligatoir",
				minlength: "au moin 4 caractères"
			},
			username : {
				required: "Ce champ est obligatoir",
				minlength: "au moin 4 caractères"
			},
			email1: "SVP entrez un email Valid !!",
			gender: "Choisir le sexe",
			email: {
				required:"Ce champ est obligatoir",
				email : "SVP entrez un email Valid !!"
			},
			site:{
				required: "Ce champ est obligatoir"
			},
			bu:{
				required: "Ce champ est obligatoir"
			},
			datepicker:{
				required: "Ce champ est obligatoir"
			},
			posttravail:{
				required: "Ce champ est obligatoir"
			},
			salaireactuel:{
				required: "Ce champ est obligatoir"
			},
			ecole:{
				required: "Ce champ est obligatoir"
			},
			niveau:{
				required: "Ce champ est obligatoir"
			},
			promotion:{
				required: "Ce champ est obligatoir"
			},
			type_diplome:{
				required: "Ce champ est obligatoir"
			},
			type_ecole:{
				required: "Ce champ est obligatoir"
			},
			desctechno:{
				required: "Ce champ est obligatoir"
			},
			comp:{
				required: "Ce champ est obligatoir"
			},
			level:{
				required: "Ce champ est obligatoir"
			},
			profile:{
				required: "Ce champ est obligatoir"
			}
		}	
	});

	//--------------- button state demo ------------------//
	$('#fat-btn').click(function () {
		var btn = $(this)
		btn.button('loading')
		setTimeout(function () {
			btn.button('reset')
		}, 3000);
	})


	//--------------- Accordion ------------------//
	var acc = $('.accordion'); //get all accordions
	var accHeading = acc.find('.accordion-heading');
	var accBody = acc.find('.accordion-body');

	//function to put icons
	accPutIcon = function () {
		acc.each(function(index) {
			accExp = $(this).find('.accordion-body.in');
			accExp.prev().find('a.accordion-toggle').append($('<span class="icon12 entypo-icon-minus-2 gray"></span>'));

			accNor = $(this).find('.accordion-body').not('.accordion-body.in');
			accNor.prev().find('a.accordion-toggle').append($('<span class="icon12 entypo-icon-plus-2 gray"></span>'));


		});
	}

	//function to update icons
	accUpdIcon = function() {
		acc.each(function(index) {
			accExp = $(this).find('.accordion-body.in');
			accExp.prev().find('span').remove();
			accExp.prev().find('a.accordion-toggle').append($('<span class="icon12 entypo-icon-minus-2 gray"></span>'));

			accNor = $(this).find('.accordion-body').not('.accordion-body.in');
			accNor.prev().find('span').remove();
			accNor.prev().find('a.accordion-toggle').append($('<span class="icon12 entypo-icon-plus-2 gray"></span>'));


		});
	}

	accPutIcon();

	$('.accordion').on('shown', function () {
		accUpdIcon();
	}).on('hidden', function () {
		accUpdIcon();
	})


	//--------------- Dialogs ------------------//
	$('#openDialog').click(function(){
		$('#dialog').dialog('open');
		return false;
	});

	$('#openModalDialog').click(function(){
		$('#modal').dialog('open');
		return false;
	});

	// JQuery Dialog			
	$('#dialog').dialog({
		autoOpen: false,
		dialogClass: 'dialog',
		buttons: {
			"Close": function() { 
				$(this).dialog("close"); 
			}
		}
	});

	// JQuery UI Modal Dialog			
	$('#modal').dialog({
		autoOpen: false,
		modal: true,
		dialogClass: 'dialog',
		buttons: {
			"Close": function() { 
				$(this).dialog("close"); 
			}
		}
	});

	$("div.dialog button").addClass("btn");

	//Boostrap modal
	$('#myModal').modal({ show: false});
	//add event to modal after closed
	$('#myModal').on('hidden', function () {
		$.pnotify({
			title: 'Modal',
			text: 'Modal window is closed',
			icon: 'picon icon16 entypo-icon-warning white',
			opacity: 0.95,
			sticker: false,
			history: false
		});
	})


	//--------------- Data tables ------------------//
	if($('table').hasClass('dynamicTable')){
		$('.dynamicTable').dataTable({
			"sPaginationType": "full_numbers",
			"bJQueryUI": false,
			"bAutoWidth": false,
			"bLengthChange": false
		});
	}
	if($('table').hasClass('contactTable')){
		$('.contactTable').dataTable({
			"bJQueryUI": false,
			"bAutoWidth": false,
			"iDisplayLength": 5,
			"bLengthChange": false,
			"aoColumnDefs": [{ 
				"bSortable": false, "aTargets": [ 0, 1, 2, 3 ] 
			}],
		});
	}
	if($('table').hasClass('emailTable')){
		$('.emailTable').dataTable({
			"bJQueryUI": false,
			"bAutoWidth": false,
			"bLengthChange": false,
			"oLanguage": {
				"sSearch": "",
				"sInfo": "Allez au total de _TOTAL_ emails pour afficher (_START_ to _END_)"
			},
			"fnDrawCallback": function(){
				$("input[type=checkbox]").uniform();
			},
			"aoColumns": [
			              { 
			            	  "sWidth": "10px",
			            	  "bSortable": false
			              },
			              { 
			            	  "sWidth": "10px", 
			            	  "bSortable": false
			              },
			              { 
			            	  "bSortable": false
			              },
			              { 
			            	  "bSortable": false
			              },
			              { 
			            	  "sWidth": "20px",
			            	  "bSortable": false
			              },
			              { 
			            	  "sWidth": "80px", 
			            	  "bSortable": false
			              }
			              ]
		});
	}		


//	------------- Email page  -------------//

	var emailTable = $('.emailTable');
	var emailStar = emailTable.find('td.star>span.icon16');

	//setup the star in click
	emailStar.click(function() {
		if($(this).hasClass('icomoon-icon-star-3')) {
			$(this).removeClass('icomoon-icon-star-3').addClass('icomoon-icon-star');
			//make callback here

		} else {
			$(this).removeClass('icomoon-icon-star').addClass('icomoon-icon-star-3');
			//make callback here
		}
	});

	//auto complete for compose To form field
	$('#to').typeahead({
		source: ['ykarouani@gmail.com','sqli@sqli.com','mouhcine.elgerej@gmail.com','sqli-e-chalange@gmail.com']
	})

	//check all checkboxes in email table
	$(".checkAll").click(function() {
		var $this = $(this);
		var checkedStatus = $this.find('span').hasClass('checked');
		$(".emailTable tr .check input:checkbox").each(function() {
			this.checked = checkedStatus;
			if (checkedStatus == this.checked) {
				$(this).closest('.checker > span').removeClass('checked');
			}
			if (this.checked) {
				$(this).closest('.checker > span').addClass('checked');
			}
		});
	});

	//show compose form
	$('.composeBtn>.btn').click(function() {
		$('.email-content>.box.plain').fadeOut(200);
		$('.compose').fadeIn();
	});

	//show compose form
	$('#today').click(function() {
		$('.email-content>.box.plain').fadeOut(200);
		$('.read-email').fadeIn();
	});

	//close compose form on discard click
	$('#discard').click(function() {
		$('.compose').fadeOut(200);
		$('.email-content>.box.plain').fadeIn(300);
	});

	//save click event
	$('#save').click(function() {
		$('.compose').fadeOut(200);
		$('.email-content>.box.plain').fadeIn(300);
		$.pnotify({
			type: 'success',
			title: 'Done',
			text: 'Email is saved',
			icon: 'picon icon16 iconic-icon-check-alt white',
			opacity: 0.95,
			history: false,
			sticker: false
		});
		//save callback here
	});

	//on send msg click
	$('#send').click(function() {
		$('.compose').fadeOut(200);
		$('.email-content>.box.plain').fadeIn(300);
		//add some notification
		$.pnotify({
			type: 'success',
			title: 'Ok !!',
			text: '<input type="text" />Email Envoye avec success',
			icon: 'picon icon16 iconic-icon-check-alt white',
			opacity: 0.95,
			history: false,
			sticker: false
		});
		//calback function here
	});

	//on send msg click
	$('#backToInbox').click(function() {
		$('.read-email').fadeOut(200);
		$('.email-content>.box.plain').fadeIn(300);
		//calback function here
	});

	emailTable.find('td a.link').click(function() {
		$('.email-content>.box.plain').fadeOut(200);
		$('.read-email').fadeIn(300);
		//calback function here
	});


	//------------- Smart Wizzard Formulaire d'ajout Collaborateur  -------------//	

	$('#wizard-validation').smartWizard({
		//selected: 0,//Commencer par 0
		saveState:true, // Remembers tab selection
		//contentURL:null, // content url, Enables Ajax content loading. ex: 'service.php'  
		//contentCache:true, // Cache Ajax content
		keyNavigation:true, // Enable/Disable keyboard navigation(left and right keys are used if enabled)
		autoProgress:false, // Auto navigate tabs on interval
		progressInterval: 3500, // Auto navigate Interval (used only if "autoProgress" is set to true)
		stopOnFocus:false, // Stop auto navigation on focus and resume on outfocus
		transitionSpeed:'400', // Transition animation speed
		transitionEasing:'easeInOutExpo', // Transition animation easing
		autoHeight:true, // Automatically adjust content height
		onLeaveTab: null, // triggers when leaving a tab
		onShowTab: null , // triggers when showing a tab
		transitionEffect: 'fade', // Effect on navigation, none/hslide/vslide/slide/fade
		onLeaveStep:leaveAStepCallbackValidation,
		onFinish:onFinishCallbackValidaton,

	});

	$('#prenom').bind('input',function(){ 
		var val1 = $('#nom').val(); 
		var val2 = $('#prenom').val(); 
		var var1 = val1.substring(0,2);
		var var2 = val2.substring(0,1);
		var result = var2+""+var1;

		$("#abreviation").val(result);
		$('label[class="error"]').remove();
		$('label[generated="true"]').remove();
	});

	/*******************Ajouter Plusieur Diplome *************************/
	var diplome = 1;
	var clonedDiplome;
	if(diplome == 1){ $(".supprimerDiplome").hide(); }


	$(".ajouterDiplome").click(function(){
		$(".supprimerDiplome").show();
		clonedDiplome = $("#diplome").clone().appendTo("#diplome1");
		clonedDiplome.each(function() {
			//alert($(this).find("label").html("karouani"));
			diplome++;
			var valeur = "Dipl&ocirc;me "+diplome+" : ";
			$(this).find("label").html(valeur);
			$(this).find("i").remove();
			$(this).attr("id","");

			$("#diplome1 .ecole").attr("name","ecole");
			$("#diplome1 .niveau").attr("name","niveau");
			$("#diplome1 .type-ecole").attr("name","type_ecole");
			$("#diplome1 .type-diplome").attr("name","type_diplome");
			$("#diplome1 .promotion").attr("name","promotion");

			$(this).addClass("cloner");
			$(this).removeClass("afficher");
		});

	});
	$(".supprimerDiplome").click(function(){ 
		//alert(clonedDiplome.attr('id'));
		// alert(diplome);
		$(".cloner:last").remove();
		diplome--;
		if(diplome == 1){ $(".supprimerDiplome").hide(); }
	}); 
	/*********************Ajouter plusieur Technologie***********************/
	var technologie = 1;
	var clonedTechnologie;

	if(technologie == 1){$(".supprimertechnologie").hide();  }
	$(".Ajoutertechnologie").click(function(){
		$(".supprimertechnologie").show(); 
		clonedTechnologie = $("#technologie").clone().appendTo("#technologie1");
		clonedTechnologie.each(function() {
			//alert($(this).find("label").html("karouani"));
			technologie++;
			var valeur = "Technologie "+technologie+" : ";
			$(this).find("label").html(valeur);
			$(this).find("i").remove();
			$(this).attr("id",$(this).attr('id')+technologie).end();

			$("#technologie1 .desctechno").attr("name","desctechno");
			$("#technologie1 .comp").attr("name","comp");
			$("#technologie1 .level").attr("name","level");

			$(this).addClass("cloner");
			$(this).removeClass("afficher");
		});

	});

	$(".supprimertechnologie").click(function(){ 
		//alert(clonedDiplome.attr('id'));
		// alert(diplome);
		$(".cloner:last").remove();
		technologie--;
		if(technologie == 1){ $(".supprimertechnologie").hide(); }
	}); 

	/*********************Date Picker ****************************/ 
	$('#datepicker').on('keyup change',function(){ 
		var val1 = $('#datepicker').val(); 
		var var1 = val1.substring(0,2);
		var var2 = val1.substring(3,5);
		//alert("jour :"+var1+"--- mois :"+var2);
		var moisBAP = [ "Janvier", "Fevrier","Mars","Avril",
		                "Mai","Juin","Juillet","Aout",
		                "Septembre","October","Novembre","Decembre" ];
		var var3 = var2-1;
		//alert("var 3 = "+var3);	
		if(var2 <10){
			var2 = var2.substring(1,2);
		}
		if(var1 < 15){
			$("#moisBAP").attr("value",moisBAP[var3]);
			$("#moisBAP").val(moisBAP[var3]);
		}else{
			if(var2 == 12){
				$("#moisBAP").attr("value",moisBAP[0]);
				$("#moisBAP").val(moisBAP[0]);
			}
			else{
				//alert("var 2 = "+var2);
				$("#moisBAP").attr("value",moisBAP[var2]);
				$("#moisBAP").val(moisBAP[var2]);
			}
		}

	});

	$("#niveau").change(function(){
		//alert("yes");
		$("#type-ecole").chained("#niveau");
		$("#type-diplome").chained("#type-ecole");
	});

	function leaveAStepCallbackValidation(obj){
		var step = obj;
		var stepN = step.attr('rel')

		if(stepN == 3) { 
			$("#testeur").val("non");

			if ($("#posttravail").valid() == true ) {
				var validate1 = true;
			} else {
				var validate1 = false;
			}

			if ($("#salaireactuel").valid() == true ) {
				var validate2 = true;
			} else {
				var validate2 = false;
			}

			if ($(".desctechno").valid() == true ) {
				var validate3 = true;
			} else {
				var validate3 = false;
			}

			if ($(".comp").valid() == true ) {
				var validate4 = true;
			} else {
				var validate4 = false;
			}

			if ($(".level").valid() == true ) {
				var validate5 = true;
			} else {
				var validate5 = false;
			}

			if(validate1 == true && validate3 == true && validate4 == true && validate5 == true && validate2 == true){
				step.find('.stepNumber').stop(true, true).remove();
				step.find('.stepDesc').stop(true, true).before('<span class="stepNumber"><span class="icon16 iconic-icon-checkmark"></span></span>');
				return true;
			}else {
				return false;
			}
		} 
		//validate step 1

		//validate step 2
		if(stepN == 1) {
			if ($("#matricule").valid() == true ) {
				var value = $('#matricule').val(); // retourne une chaine
				if((parseFloat(value) == parseInt(value)) && !isNaN(value)){
					var validate7 = true;
				}else{
					$("label").removeClass("error");
					$('label[for="matricule"]').remove();
					var validate7 = false;
					$("#matricule").after("<label class='error' for='matricule'" +
							" generated='true' style='display: block;'>" +
					"Ce champ contient les valeurs numeriques seulments</label>");
				}
			} else {
				var validate7 = false;
			}

			if ($("#nom").valid() == true ) {
				var validate3 = true;
			} else {
				var validate3 = false;
			}
			if ($("#prenom").valid() == true ) {
				var validate4 = true;
			} else {
				var validate4 = false;
			}

			if ($("#abreviation").valid() == true ) {
				var validate6 = true;
			} else {
				var validate6 = false;
			}

			if ($("#gender").valid() == true ) {
				var validate5 = true;
			} else {
				var validate5 = false;
			}

			if ($("#email").valid() == true ) {
				var validate1 = true;
			} else {
				var validate1 = false;
			}

			if(validate1 == true && validate3 == true && validate4 == true && validate5 == true && validate6 == true && validate7 == true ) {
				step.find('.stepNumber').stop(true, true).remove();
				step.find('.stepDesc').stop(true, true).before('<span class="stepNumber"><span class="icon16 iconic-icon-checkmark"></span></span>');
				return true;
			} else {
				return false;
			}
		}


		//validate step 2
		if(stepN == 2) {
			if ($(".ecole").valid() == true ) {
				var validate1 = true;
			} else {
				var validate1 = false;
			}
			
			if ($(".niveau").valid() == true ) {
				var validate2 = true;
			} else {
				var validate2 = false;
			}
			
			if ($(".promotion").valid() == true ) {
				var validate3 = true;
			} else {
				var validate3 = false;
			}
			
			if ($(".type_diplome").valid() == true ) {
				var validate4 = true;
			} else {
				var validate4 = false;
			}
			
			if ($(".type_ecole").valid() == true ) {
				var validate5 = true;
			} else {
				var validate5 = false;
			}
			
			if ($("#datepicker").valid() == true ) {
				var validate6 = true;
			} else {
				var validate6 = false;
			}
			
			if(validate1 == true && validate3 == true && validate4 == true && validate5 == true && validate2 == true && validate6 == true){
			step.find('.stepNumber').stop(true, true).remove();
			step.find('.stepDesc').stop(true, true).before('<span class="stepNumber"><span class="icon16 iconic-icon-checkmark"></span></span>');
			return true;
			}else {
				return false;
			}

		}



	}
	function onFinishCallbackValidaton(obj){
		var step = obj;
		//var stepN = step.attr('rel')
		//alert($("#testeur").val());

		if($("#testeur").val() == "yes"){

			step.find('.stepNumber').stop(true, true).remove();
			step.find('.stepDesc').stop(true, true).before('<span class="stepNumber"><span class="icon16 iconic-icon-checkmark"></span></span>');
			$.pnotify({
				type: 'succèss',
				title: 'Ok !!',
				text: 'Enregistrement avec succèss !!',
				icon: 'picon icon16 iconic-icon-check-alt white',
				opacity: 1,
				history: false,
				sticker: false
			});
			//alert("test dyal myEditeur");
		}
		if($("#testeur").val() == "non"){

			if ($("#username1").valid() == true ) {
				var validate = true;
			} else {
				var validate = false;
			}
			
			if ($("#password1").valid() == true ) {
				var validate1 = true;
			} 
			else {
				var validate1 = false;
			}
			if ($("#passwordConfirm1").valid() == true ) {
				var validate2 = true;
			} 
			else {
				var validate2 = false;
			}

			if(validate == true && validate1 == true && validate2 == true) {
				//alert("test dyal Login");
				step.find('.stepNumber').stop(true, true).remove();
				step.find('.stepDesc').stop(true, true).before('<span class="stepNumber"><span class="icon16 iconic-icon-checkmark"></span></span>');
				$.pnotify({
					type: 'succèss',
					title: 'Ok !!',
					text: 'Enregistrement avec succèss !!',
					icon: 'picon icon16 iconic-icon-check-alt white',
					opacity: 1,
					history: false,
					sticker: false
				});
			} else {
				return false;
			}
		}

		$('#wizzard-form').submit();
	}

	//------------- Uniform  -------------//
	//add class .nostyle if not want uniform to style field
	$("input,select").not('.nostyle').uniform();

	/********************Tiny MCE*****************************/
	tinymce.init({
		mode : "specific_textareas",
		editor_selector : "myEmail",
		body_id: "karouani",
		content_css: "tinymce/template.css",
		plugins: [
		          "advlist autolink autosave link image lists charmap print preview hr anchor pagebreak spellchecker",
		          "searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
		          "table contextmenu directionality emoticons template textcolor paste fullpage textcolor"
		          ],

		          toolbar1: "bold italic underline strikethrough | alignleft aligncenter alignright alignjustify | styleselect formatselect fontselect fontsizeselect",
		          toolbar2: "newdocument fullpage | cut copy paste | searchreplace | bullist numlist | outdent indent blockquote | undo redo | link unlink anchor image media code ",
		          toolbar3: "table | hr removeformat | subscript superscript | charmap emoticons | visualchars visualblocks nonbreaking pagebreak restoredraft | inserttime preview | forecolor backcolor",

		          menubar: false,
		          toolbar_items_size: 'medium',

		          style_formats: [
		                          {title: 'Bold text', inline: 'b'},
		                          {title: 'Red text', inline: 'span', styles: {color: '#ff0000'}},
		                          {title: 'Red header', block: 'h1', styles: {color: '#ff0000'}},
		                          {title: 'Example 1', inline: 'span', classes: 'example1'},
		                          {title: 'Example 2', inline: 'span', classes: 'example2'},
		                          {title: 'Table styles'},
		                          {title: 'Table row 1', selector: 'tr', classes: 'tablerow1'}
		                          ]
	});

	//remove loadstate class from body and show the page
	setTimeout('$("html").removeClass("loadstate")',500);

	//--------------- Dual multi select ------------------//
	$.configureBoxes();

});
