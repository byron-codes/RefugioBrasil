$("#modalExperiencia").on('hidden.bs.modal', function () {
	let campos = ["txtcargo", "txtempresa", "txtdataInicioExperiencia", "txtdataFimExperiencia", "selPaisExperiencia"];
	
	limpaDadosErrosCampos(campos)
	
})

$("#modalFormacao").on('hidden.bs.modal', function () {
	let campos = ["txtcurso", "txtinstituicao", "txtdataInicioFormacao", "txtdataFimFormacao", "selgrauAcademico", "selsituacaoAcademica", "selPaisFormacao", "profissaoAtual", "profissaoIndicacao"];
	
	limpaDadosErrosCampos(campos)
	
})