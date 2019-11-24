function getAddress(cep) {
	$.ajax({
		url : "https://viacep.com.br/ws/" + cep + "/json/",
		success : function(data) {
			if (data.cep != undefined && data.cep != null && data.cep != "") {
				$("#txtestado").val($("#txtestado").find(`.${data.uf}`).val())
				getCities($("#txtestado").val(), data.localidade)
				$("#txtlogradouro").val(data.logradouro)
			}
		}
	})
}