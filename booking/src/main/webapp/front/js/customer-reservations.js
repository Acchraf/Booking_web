$(document).ready(function() {
	
    $('.ui.dropdown').dropdown();

    $('#users-table').DataTable({
    	"id": [[ 1, "desc" ]]
    });
});

function redirect(url){
	window.location.href = url;
}