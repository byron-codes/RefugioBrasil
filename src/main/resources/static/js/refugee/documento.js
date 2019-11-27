function consultarDocumento(e){
	
	if(!$("#txtprotocolo").hasClass("is-invalid") || !$("#txtrne").hasClass("is-invalid")){
	
		limpaCampo($("#txtprotocolo"))
		limpaCampo($("#txtrne"))
		
		notNull($("#txtprotocolo"))
		notNull($("#txtrne"))
		
		let flag;
		
		let numberProtocolo = "null"
		if(!$("#txtprotocolo").hasClass("is-invalid") && $("#txtprotocolo").val() != ""){
			flag = true;
			numberProtocolo = $("#txtprotocolo").unmask().val();
			$("#novosDocumentos").append(`
				<input name="documents[0].type" type="hidden" value="PROTOCOLO">
				<input name="documents[0].number" type="hidden" value="${numberProtocolo}">
			`)
			setMaskListItem(mascaras.txtprotocolo)
			quantidadeDocumentos++;
		} else {
			$(validacoes.txtprotocolo.campo).unmask()
			$(validacoes.txtprotocolo.campo).val("Campo não preenchido")
		}
		
		let numberRne = "null";
		if(!$("#txtrne").hasClass("is-invalid") && $("#txtrne").val() != ""){
			flag = true;
			numberRne = $("#txtrne").unmask().val();
			$("#novosDocumentos").append(`
				<input name="documents[0].type" type="hidden" value="RNE">
				<input name="documents[0].number" type="hidden" value="${numberRne}">
			`)
			setMaskListItem(mascaras.txtrne)
			quantidadeDocumentos++;
		} else {
			$(validacoes.txtrne.campo).unmask()
			$(validacoes.txtrne.campo).val("Campo não preenchido")
		}
		
		let unico = true;
		let id = null;
		
		$.ajax({
			url: URI + "/refugee/unique/" + numberProtocolo,
			success: function(data){
				if(data == null){
					unico = true;
				} else {
					unico = false;
					id = data.id
				}
			},
			beforeSend: function(){
				blockUI();
			}
		}).done(function(){
			unBlockUI();
			if(unico){
				$.ajax({
					url: URI + "/refugee/unique/" + numberRne,
					success: function(data){
						if(data == null){
							unico = true;
						} else {
							unico = false;
							id = data.id
						}
					},
					beforeSend: function(){
						blockUI();
					}
				}).done(function(){
					posInseridoDoc(flag, unico, id)
					unBlockUI();
				})
			} else {
				posInseridoDoc(flag, unico, id)
			}
		})
		
	}
	
}

function posInseridoDoc(flag, unico, id = null){
	if(flag){
		
		limpaCampo($("#txtprotocolo"))
		limpaCampo($("#txtrne"))
		
		if(unico){
	        Swal.fire({
	            title: 'Agora sim vamos lá',
	            type: 'success',
	            confirmButtonColor: '#3085d6',
	            confirmButtonText: 'vamos',
	          }).then((result) => {
	            $(e).remove();
	            $("#documentosAdd").removeClass("d-none");
	            // $("#btnvolta").removeClass("d-none");
	            $("#btnprox").removeClass("d-none");
	            $("#containerRobot").remove();
	            $("#txtrne").prop("disabled", true);
	            $("#txtprotocolo").prop("disabled", true);
	            $("#title").text("Cadastro de Refugiado - Documentos")
	        })
	    }else{
	        Swal.fire({
	            title: 'O dono desse documento já existe no sistema!',
	            html: "Deseja alterar o registro?",
	            type: 'warning',
	            showCancelButton: true,
	            cancelButtonColor: '#d33',
	            confirmButtonColor: '#3085d6',
	            confirmButtonText: 'ir',
	            cancelButtonText: 'cancelar',
	            reverseButtons: true,
	          }).then((result) => {
	            if (result.value) {
	              window.location = URI + "/refugee/" + id
	            }else{
	                $("#txtprotocolo").val("");
	                $("#txtrne").val("");
	            }
	        })
	    } 
	} else {
		$(validacoes.txtprotocolo.campo).val("")
		$(validacoes.txtrne.campo).val("")
		setMaskListItem(mascaras.txtprotocolo)
		setMaskListItem(mascaras.txtrne)
	}
}

$("#seldoc").change(function(){
	limpaCampo($("#txtnumerodoc"))
	$("#txtnumerodoc").val("")	
	setMaskListItem(mascaras[$(this).val()])
})
