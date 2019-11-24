function config(){
	$.ajax({
		url: URI + "/state",
		success: function(data){
			for(i in data){
				$("#txtestado").append(`<option class="${data[i].initials}" value="${data[i].id}">${data[i].name}</option>`)
			}
		},
		beforeSend: function(){
			blockUI();
		}
	}).done(function () {
		unBlockUI();
	})
	
	$.ajax({
		url: URI + "/country",
		success: function(data){
			for(i in data){
				$("#selPaisOrigem").append(`<option value="${data[i].id}">${data[i].name}</option>`)
				if(data[i].id == $("#tempValCountry").val()){
					$("#selPaisOrigem").val(data[i].id)
				}
				$("#selPaisDependente").append(`<option value="${data[i].id}">${data[i].name}</option>`)
				$("#selPaisExperiencia").append(`<option value="${data[i].id}">${data[i].name}</option>`)
				$("#selPaisFormacao").append(`<option value="${data[i].id}">${data[i].name}</option>`)
			}
		},
		beforeSend: function(){
			blockUI();
		}
	}).done(function () {
		unBlockUI();
		
		if($("#tempValCep").val() != undefined && $("#tempValCep").val() != null && $("#tempValCep").val() != "")
			getAddress($("#tempValCep").val())
		
		let campos = ["txtnome", "selsexo", "txtdataNascimento", "txtdataChegada", "txtEmail", "selestadocivil", "selPaisOrigem", "seltipoendereco", "txtcep", "txtestado", "txtcidade", "txtlogradouro", "txtnumero", "txtcomplemento"]
		validaListaCampos(campos);
		
		let check = $("#situacao").val()
		$("#situacao").parent().find(`input[value="${check}"]`).prop("checked", true)
		
	})
	
}

$("#txtcep").on('input',function(e){
	if($(this).val().length == 9){
		$(this).unmask()
		getAddress($(this).val())
		setMaskListItem(mascaras.txtcep)
	}
})