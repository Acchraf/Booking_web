$(document).ready(function() {
	
    $('.ui.dropdown').dropdown();

    $('#users-table').DataTable({
    	"id": [[ 1, "desc" ]]
    });
});

function redirect(url){
	window.location.href = url;
}

function activateUser(id){
	document.getElementById('userID').value = id;	
    document.getElementById('data-form').submit();
}