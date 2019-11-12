function limpaModalExperiencia(){
	
	let campos = ["txtcargo", "txtempresa", "txtdataInicioExperiencia", "txtdataFimExperiencia", "selPaisExperiencia"];
	
	for(i in campos) {
    	let campo = $(validacoes[campos[i]].campo)
    	limpaCampo($(campo));
    	$(campo).val("")
    }
	
	$("#selPaisExperiencia").val("0")
}