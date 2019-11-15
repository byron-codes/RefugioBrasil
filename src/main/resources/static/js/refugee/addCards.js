function adicionarTelefone(){
	let campos = ["selOperadora", "txtNumeroTel"];
	
	validaListaCampos(campos)
	
	if($("#telefoneDiv").find(".is-invalid").length == 0){

		limpaDadosErrosCampos(campos)
	}
}

let quantidadeLinguas = 0;
function adicionarLingua() {
	
	let campos = ["sellingua", "selnivel"]
	
	comboBox($("#sellingua"))
	comboBox($("#selnivel"))
	
	if($("#linguaDiv").find(".is-invalid").length == 0){
		
	    let lingua = $("#sellingua").val();
	    // let lingua = $("#selnivel").find(`[val=${valuelingua}]`).text();
	
	    let nivel = $("#selnivel").val();
	    // let nivel = $("#selnivel").find(`[val=${valueNivel}]`).text();
	    $("#sellingua").val("");
	    $("#selnivel").val("");	    
	    $("#linguas").append(
	        `<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
	            <div class="m-3">${lingua} - ${nivel}</div>
	            <input type="hidden" name="languages[${quantidadeLinguas}].name" value="${lingua}">
	            <input type="hidden" name="languages[${quantidadeLinguas}].fluency" value="${nivel}">
	        </div>`
	    )
	    
	    quantidadeLinguas++;
		
		limpaDadosErrosCampos(campos)
		
		
	}
	
}

function adicionarExperiencia(){
	let campos = ["txtcargo", "txtempresa", "txtdataInicioExperiencia", "txtdataFimExperiencia", "selPaisExperiencia"];
	
	validaListaCampos(campos)
	
	if($("#modalExperiencia").find(".is-invalid").length == 0){
		
		// TODO Adicionar card da modal
		
		console.log("ADICIONADO")
		
		limpaDadosErrosCampos(campos)
		
	}
}

function adicionarFormacao(){
	let campos = ["txtcurso", "txtinstituicao", "txtdataInicioFormacao", "txtdataFimFormacao", "selgrauAcademico", "selsituacaoAcademica", "selPaisFormacao"];
	
	validaListaCampos(campos);
	
	if($("#modalFormacao").find(".is-invalid").length == 0){
		
		// TODO Adicionar card da modal
		
		console.log("ADICIONADO")
		
		limpaDadosErrosCampos(campos)
				
	}
}

function adicionarDependente() {
	let campos = ["txtnomeDependente", "selsexoDependente", "txtdataNascimentoDependente", "txtdataChegadaDependente", "selParentesco", "selPaisDependente", "documentoDependente", "txtcpfDependente"];
	
	validaListaCampos(campos);
	
	if($("#documentosAdd").find(".is-invalid").length == 0){
		
		// TODO Adicionar card da modal
		
		console.log("ADICIONADO")
		
		limpaDadosErrosCampos(campos)
				
	}
}

let quantidadeDocumentos = 0;
function adicionarDocumento(){
	
	let campos = ["seldoc", "txtnumerodoc"]
	
	validaListaCampos(["txtnumerodoc"]);
	comboBox($("#seldoc"))
	
	if($("#documentosAdd").find(".is-invalid").length == 0) {
		
		let num = $("#txtnumerodoc").val();
		let tipo = $("#seldoc").val();
		
		$("#novosDocumentos").append(
			`<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
				<input type="hidden" name="documents[${quantidadeDocumentos}].number" value="${num}">
				<input type="hidden" name="documents[${quantidadeDocumentos}].type" value="${tipo}"> 
				<div class="m-3">${tipo} - ${num}</div>
			</div>`
		)
		
		quantidadeDocumentos++;
		
		limpaDadosErrosCampos(campos)
		
	}
	
// if($("#txtnumerodoc").val() != null && $("#txtnumerodoc").val() != "" &&
// !$("#txtnumerodoc").hasClass("is-invalid")){
// let num = $("#txtnumerodoc").val();
// let valueTipo = $("#seldoc").val();
// let tipo = $("#seldoc").find(`[value=${valueTipo}]`).text();
// $("#txtnumerodoc").val("");
// $("#documentosAdd").val("");
// $("#novosDocumentos").append(
// `<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
// <div class="m-3">${tipo} - ${num}</div>
// </div>`
// )
// limpaCampo($("#txtnumerodoc"));
// $("#seldoc").val("0")
// } else {
// Swal.fire({
// type: 'error',
// title: 'Número de documento inválido para adição',
// allowOutsideClick: false
// })
// }
}