function consultarDocumento(e){
	
	if(!$("#txtprotocolo").hasClass("is-invalid") || !$("#txtrne").hasClass("is-invalid")){
	
		limpaCampo($("#txtprotocolo"))
		limpaCampo($("#txtrne"))
		
		notNull($("#txtprotocolo"))
		notNull($("#txtrne"))
		
		let flag;
		let unico = true;
		
		if(!$("#txtprotocolo").hasClass("is-invalid") && $("#txtprotocolo").val() != ""){
			flag = true;
			let number = $("#txtprotocolo").unmask();
			$("#novosDocumentos").append(`
				<input name="documents[0].type" type="hidden" value="PROTOCOLO">
				<input name="documents[0].number" type="hidden" value="${number}.val()">
			`)
			setMaskListItem(mascaras.txtprotocolo)
			quantidadeDocumentos++;
		} else {
			$(validacoes.txtprotocolo.campo).unmask()
			$(validacoes.txtprotocolo.campo).val("Campo não preenchido")
		}
		
		if(!$("#txtrne").hasClass("is-invalid") && $("#txtrne").val() != ""){
			flag = true;
			let number = $("#txtrne").unmask();
			$("#novosDocumentos").append(`
				<input name="documents[0].type" type="hidden" value="RNE">
				<input name="documents[0].number" type="hidden" value="${number}.val()">
			`)
			setMaskListItem(mascaras.txtrne)
			quantidadeDocumentos++;
		} else {
			$(validacoes.txtrne.campo).unmask()
			$(validacoes.txtrne.campo).val("Campo não preenchido")
		}
		
		
		
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
		              alert("vai para edição");
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
	
}

$("#seldoc").change(function(){
	limpaCampo($("#txtnumerodoc"))
	$("#txtnumerodoc").val("")	
	setMaskListItem(mascaras[$(this).val()])
})
