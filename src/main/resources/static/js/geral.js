var URI = window.location.protocol + "//" + window.location.host;

function blockUI() {
	$.blockUI({
		message : '<i class="fa fa-spinner fa-spin fa-5x">',
		css : {
			border : 'none',
			backgroundColor : 'transparent',
			color : '#f6f6f6'
		}
	});
}

function unBlockUI() {
	$.unblockUI();
}
