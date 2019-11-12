function adicionarLingua(){
	let campos = ["selOperadora", "txtNumeroTel"];
	
	for(i in campos) {

		let campo = $(validacoes[campos[i]].campo)
		let funcoes = validacoes[campos[i]].validacoes 
		
		limpaCampo($(campo));
	    funcoes()
	    
	    if(!$(campo).hasClass("is-invalid") && $(campo).val() != null && $(campo).val() != ""){
	        $(campo).addClass("is-valid");
	    }
	}
	
	if($("#telefoneDiv").find(".is-invalid").length == 0){
//	    let lingua = $("#sellingua").val();
//	    // let lingua = $("#selnivel").find(`[val=${valuelingua}]`).text();
//	
//	    let nivel = $("#selnivel").val();
//	    // let nivel = $("#selnivel").find(`[val=${valueNivel}]`).text();
//	    $("#sellingua").val("");
//	    $("#selnivel").val("");
//	    $("#linguas").append(
//	        `<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
//	            <div class="m-3">${lingua} - ${nivel}</div>
//	        </div>`
//	    )
	    for(i in campos) {
	    	let campo = $(validacoes[campos[i]].campo)
	    	limpaCampo($(campo));
	    }
		$("#selOperadora").val("0")
		$("#txtNumeroTel").val("")
	}
}

function adicionarExperiencia(){
	let campos = ["txtcargo", "txtempresa", "txtdataInicioExperiencia", "txtdataFimExperiencia", "selPaisExperiencia"];
	
	for(i in campos) {

		let campo = $(validacoes[campos[i]].campo)
		let funcoes = validacoes[campos[i]].validacoes 
		
		limpaCampo($(campo));
	    funcoes()
	    
	    if(!$(campo).hasClass("is-invalid") && $(campo).val() != null && $(campo).val() != ""){
	        $(campo).addClass("is-valid");
	    }
	}
	
	if($("#modalExperiencia").find(".is-invalid").length == 0){
		
		//TODO Adicionar card da modal
		
		console.log("ADICIONADO")
		
		for(i in campos) {
	    	let campo = $(validacoes[campos[i]].campo)
	    	limpaCampo($(campo));
	    	$(campo).val("")
	    }
		
		$("#selPaisExperiencia").val("0")
		
	}
}