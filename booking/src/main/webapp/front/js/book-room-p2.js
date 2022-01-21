$(document).ready(function() {
	
    $('.ui.dropdown').dropdown();

	$('.ui.calendar').calendar({

				type: 'date',
				text: {
					days: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
					months: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 
							 'Août', 'Septembre', 'Octobre', 'Novembre', 'Decembre'],
					monthsShort: ['Jan', 'Fev', 'Mar', 'Avr', 'Mai', 'Juin', 'Juil', 'Aou', 'Sep', 'Oct', 'Nov', 'Dec'],
					today: 'Aujourd\'hui',
					now: 'Maintenant',
					am: 'AM',
					pm: 'PM'
				},
				formatter:{

					date : function(date, settings){

						if(!date) return '';
						
						var day = date.getDate();
						var month = date.getMonth() + 1;
						var year = date.getFullYear();

						return year + '-' + month + '-' + day;
					}
				}   

	});
});

function redirect(url){
	window.location.href = url;
}

function persistReservation(id){
	
	var array = id.split("-");
	
	var room = array[0]; 
	var price = array[1];
	
	document.getElementById('room').value = room;
	document.getElementById('price').value = price;
	
    document.getElementById('data-form').submit();
}