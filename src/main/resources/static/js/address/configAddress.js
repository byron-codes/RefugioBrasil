function getCities(state, city){
	$.ajax({
		url: URI + "/city/" + state,
		beforeSend: function(){
			blockUI();
		},
		success: function(data){
			$("#txtcidade").children().remove()
			$("#txtcidade").append(`<option value="0" selected="selected" disabled="disabled">Selecione...</option>`)
			$("#txtcidade").val(0)
			for(i in data){
				$("#txtcidade").append(`<option value="${data[i].id}">${data[i].name}</option>`)
				if(data[i].name == city){
					$("#txtcidade").val(data[i].id)
					
					$("#txtcidade").focus()
					$("#txtcidade").blur()
					
					$("#txtestado").focus()
					$("#txtestado").blur()
					
					$("#txtlogradouro").focus()
					$("#txtlogradouro").blur()
					
					$("#txtcep").blur()
					
					$("#txtnumero").focus()
				}
			}
		}
	}).done(function(){
		unBlockUI();
	})
}