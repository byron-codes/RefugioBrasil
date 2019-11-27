let quantidadeTelefone = 0;
let quantidadeLinguas = 0;
let quantidadeExperiencia = 0;
let quantidadeFormacao = 0;
let quantidadeDependente = 0;
let quantidadeDocumentos = 0;

function somaDoc() {
	quantidadeDocumentos++;
}

function subDoc() {
	quantidadeDocumentos--;
}

function getQuantidadeDoc() {
	return quantidadeDocumentos;
}

$(document).ready(function(){
	
	$("#novosTelefones").children().each(function(){
		if($(this).children().length <= 0){
			$(this).remove();
		} else {
			quantidadeTelefone++;
		}
	})
	
	$("#linguas").children().each(function(){
		if($(this).children().length <= 0){
			$(this).remove();
		} else {
			quantidadeLinguas++;
		}
	})
	
	$("#experienciaDeck").children().each(function(){
		if($(this).children().length <= 0){
			$(this).remove();
		} else {
			quantidadeExperiencia++;
		}
	})
	
	$("#formacao").children().each(function(){
		if($(this).children().length <= 0){
			$(this).remove();
		} else {
			quantidadeFormacao++;
		}
	})
	
	$("#novosDependentes").children().each(function(){
		if($(this).children().length <= 0){
			$(this).remove();
		} else {
			quantidadeDependente++
		}
	})
	
	$("#novosDocumentos").children().each(function(){
		if($(this).children().length <= 0){
			$(this).remove();
		} else {
			quantidadeDocumentos++
		}
		
	})
	
	console.log(quantidadeDocumentos)
	
})

function adicionarTelefone(){
	let campos = ["selTipoTelefone", "selOperadora", "txtNumeroTel"];
	
	validaListaCampos(campos)
	comboBox($("#selOperadora"))
	comboBox($("#selTipoTelefone"))
	
	if($("#telefoneDiv").find(".is-invalid").length == 0){

		let num = $("#txtNumeroTel").val();
		
		$("#txtNumeroTel").unmask();
		
		let numSemMask = $("#txtNumeroTel").val();
		
		let operadoras = $("#selOperadora").val();
		
		let tipo = $("#selTipoTelefone").val();
		
		setMaskListItem(mascaras.txtNumeroTel)
		
		// ok
		$("#novosTelefones").append(`
			<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
	            <div class="m-3">${$("#selTipoTelefone").children("option:selected").html()} - ${num}<i class="fas fa-times ml-3 text-dark pointer" onclick="$(this).parent().parent().remove()"></i></div>
	            <input type="hidden" name="phones[${quantidadeTelefone}].idd" value="${numSemMask.substring(0, 2)}">
	            <input type="hidden" name="phones[${quantidadeTelefone}].number" value="${numSemMask.substring(2)}">
	            <input type="hidden" name="phones[${quantidadeTelefone}].operators" value="${operadoras}">
	            <input type="hidden" name="phones[${quantidadeTelefone}].type" value="${tipo}">
	        </div>
		`)
		
		quantidadeTelefone++;
		
		limpaDadosErrosCampos(campos)
	}
}

function adicionarLingua() {
	
	let campos = ["sellingua", "selnivel"]
	
	comboBox($("#sellingua"))
	comboBox($("#selnivel"))
	
	if($("#linguaDiv").find(".is-invalid").length == 0){
		// ok
	    $("#linguas").append(
	        `<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
	            <div class="m-3">${$("#sellingua").children("option:selected").html()} - ${$("#selnivel").children("option:selected").html()}<i class="fas fa-times ml-3 text-dark pointer" onclick="$(this).parent().parent().remove()"></i></div>
	            <input type="hidden" name="languages[${quantidadeLinguas}].name" value="${$("#sellingua").val()}">
	            <input type="hidden" name="languages[${quantidadeLinguas}].fluency" value="${$("#selnivel").val()}">
	        </div>`
	    )
	    
	    quantidadeLinguas++;
		
		limpaDadosErrosCampos(campos)
		
		
	}
	
}

function adicionarExperiencia(){
	let campos = ["txtcargo", "txtempresa", "txtdataInicioExperiencia", "txtdataFimExperiencia", "selPaisExperiencia", "obsProfissao"];
	
	validaListaCampos(campos)
	
	if($("#modalExperiencia").find(".is-invalid").length == 0){
		
		// ok
		$("#experienciaDeck").append(
		        `<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
			        <div class="m-3">${$("#txtcargo").val()} - ${$("#txtempresa").val()}<i class="fas fa-times ml-3 text-dark pointer" onclick="$(this).parent().parent().remove()"></i></div>
			        <input type="hidden" name="professions[${quantidadeExperiencia}].workload" value="${$("#txtcargo").val()}">
			        <input type="hidden" name="professions[${quantidadeExperiencia}].company" value="${$("#txtempresa").val()}">
			        <input type="hidden" name="professions[${quantidadeExperiencia}].description" value="${$("#obsProfissao").val()}">
			        <input type="hidden" name="professions[${quantidadeExperiencia}].current" value="${$("#profissaoAtual").prop("checked")}">
			        <input type="hidden" name="professions[${quantidadeExperiencia}].recommendation" value="${$("#profissaoIndicacao").prop("checked")}">
			        <input type="hidden" name="professions[${quantidadeExperiencia}].startDate" value="${$("#txtdataInicioExperiencia").val()}">
			        <input type="hidden" name="professions[${quantidadeExperiencia}].endDate" value="${$("#txtdataFimExperiencia").val()}">
			        <input type="hidden" name="professions[${quantidadeExperiencia}].country.id" value="${$("#selPaisExperiencia").val()}">
			    </div>`
			)
		
		quantidadeExperiencia++
		
		$("#modalExperiencia").modal("hide");
		
		limpaDadosErrosCampos(campos)
		
	}
}

function adicionarFormacao() {
	let campos = ["txtcurso", "txtinstituicao", "txtdataInicioFormacao", "txtdataFimFormacao", "selgrauAcademico", "selsituacaoAcademica", "selPaisFormacao"];
	
	validaListaCampos(campos);
	
	if($("#modalFormacao").find(".is-invalid").length == 0){
		// ok
		 $("#formacao").append(
	        `<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
		        <div class="m-3">${$("#txtcurso").val()} - ${$("#txtinstituicao").val()}<i class="fas fa-times ml-3 text-dark pointer" onclick="$(this).parent().parent().remove()"></i></div>
		        <input type="hidden" name="academics[${quantidadeFormacao}].course" value="${$("#txtcurso").val()}">
		        <input type="hidden" name="academics[${quantidadeFormacao}].instituation" value="${$("#txtinstituicao").val()}">
		        <input type="hidden" name="academics[${quantidadeFormacao}].startDate" value="${$("#txtdataInicioFormacao").val()}">
		        <input type="hidden" name="academics[${quantidadeFormacao}].endDate" value="${$("#txtdataFimFormacao").val()}">
		        <input type="hidden" name="academics[${quantidadeFormacao}].level" value="${$("#selgrauAcademico").val()}">
		        <input type="hidden" name="academics[${quantidadeFormacao}].situation" value="${$("#selsituacaoAcademica").val()}">
		        <input type="hidden" name="academics[${quantidadeFormacao}].country.id" value="${$("#selPaisFormacao").val()}">
		    </div>`
		)
		
		
		quantidadeFormacao++;
		
		$("#modalFormacao").modal("hide");
		
		limpaDadosErrosCampos(campos)
				
	}
}

function adicionarDependente() {
	let campos = ["txtnomeDependente", "selsexoDependente", "txtdataNascimentoDependente", "txtdataChegadaDependente", "selParentesco", "selPaisDependente", "documentoDependente"];
	let flag = false;
	if($("#txtcpfDependente").val() != null && $("#txtcpfDependente").val() != "" && $("#txtcpfDependente").val() != undefined){
		flag = true;
		campos[campos.length] = "txtcpfDependente"
	}
	
	validaListaCampos(campos);
	
	if($("#dependente").find(".is-invalid").length == 0){
		
		$("#documentoDependente").unmask();
		$("#txtcpfDependente").unmask();
		// ok
		let htmlAdd = (
	        `<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
		        <div class="m-3">${$("#txtnomeDependente").val()} - ${$("#selParentesco").children("option:selected").html()}<i class="fas fa-times ml-3 text-dark pointer" onclick="$(this).parent().parent().remove()"></i></div>
		        <input type="hidden" name="dependents[${quantidadeDependente}].name" value="${$("#txtnomeDependente").val()}">
		        <input type="hidden" name="dependents[${quantidadeDependente}].bornDate" value="${$("#txtdataNascimentoDependente").val()}">
		        <input type="hidden" name="dependents[${quantidadeDependente}].gender" value="${$("#selsexoDependente").val()}">
		        <input type="hidden" name="dependents[${quantidadeDependente}].arrivalDate" value="${$("#txtdataChegadaDependente").val()}">
		        <input type="hidden" name="dependents[${quantidadeDependente}].kinship" value="${$("#selParentesco").val()}">
		        <input type="hidden" name="dependents[${quantidadeDependente}].birthCountry.id" value="${$("#selPaisDependente").val()}">
		        <input type="hidden" name="dependents[${quantidadeDependente}].documents[0].number" value="${$("#documentoDependente").val().toUpperCase()}">
		        <input type="hidden" name="dependents[${quantidadeDependente}].documents[0].type" value="${$("#tipoDocumentoDependente").html().toUpperCase()}">`
		)
		
		if(flag){
			htmlAdd += `
				<input type="hidden" name="dependents[${quantidadeDependente}].documents[1].number" value="${$("#txtcpfDependente").val()}">
		        <input type="hidden" name="dependents[${quantidadeDependente}].documents[1].type" value="CPF">
			`
		}
		
		htmlAdd += "</div>" 
		
		$("#novosDependentes").append(htmlAdd)
		
		quantidadeDependente++;
		 
		setMaskListItem(mascaras.txtcpfDependente)
		setMaskListItem(mascaras.RNM)
		
		$("#tipoDocumentoDependente").html("RNM")
		$("#documentoDependente").attr("placeholder", "XXXXXXX-X");
		
		limpaDadosErrosCampos(campos)
				
	}
}

function adicionarDocumento(){

	let campos = ["seldoc", "txtnumerodoc"]
	
	validaListaCampos(["txtnumerodoc"]);
	comboBox($("#seldoc"))
	
	if($("#documentosAdd").find(".is-invalid").length == 0) {
		
		let num = $("#txtnumerodoc").val();
		
		$("#txtnumerodoc").unmask();
		
		let numSemMask = $("#txtnumerodoc").val();
		
		let tipo = $("#seldoc").val();
		// ok
		$("#novosDocumentos").append(
			`<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
				<div class="m-3">${$("#seldoc").children("option:selected").html()} - ${num}<i class="fas fa-times ml-3 text-dark pointer" onclick="$(this).parent().parent().remove()"></i></div>
				<input type="hidden" name="documents[${quantidadeDocumentos}].number" value="${numSemMask}">
				<input type="hidden" name="documents[${quantidadeDocumentos}].type" value="${tipo}"> 
			</div>`
		)
		
		quantidadeDocumentos++;
		
		limpaDadosErrosCampos(campos)
		
	}	
}