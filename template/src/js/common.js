$(document).ready(function() {
	//enable navbar toggle menu
	if ( $('.sidenav').length ) {
		$('.sidenav').sidenav();
	}
	$('#category-select').formSelect();
})