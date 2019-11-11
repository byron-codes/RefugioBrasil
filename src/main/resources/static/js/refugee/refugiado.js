$(document).ready(function(){
	
	setAllMask(mascaras)
	
	for(i in validacoes) {
		let campo = $(validacoes[i].campo)
		let funcoes = validacoes[i].validacoes 
		$(campo).focusout(function() {
			limpaCampo($(this));
		    funcoes()
		    if(!$(this).hasClass("is-invalid") && $(this).val() != null && $(this).val() != ""){
		        $(this).addClass("is-valid");
		    }
		})
	}
	
	$("#txtdataNascimento").attr("min", getDate(-365  * 100));
	$("#txtdataNascimento").attr("max", getDate());
	
	$("#txtdataChegada").attr("min", getDate(-365  * 100));
	$("#txtdataChegada").attr("max", getDate());
	
})

function proximo(){
    if(!$("#documentos").hasClass("d-none")) {
    	
        $("#documentos").addClass("d-none")
        $("#identificacao").removeClass("d-none")
        $("#dialogoRobot").html("")
        
        $("#title").text("Cadastro de Refugiado - Identificação")
        
        $("#btnvolta").removeClass("d-none")

    } else if(!$("#identificacao").hasClass("d-none")) {
    	
    	//let campos = ["txtnome", "selsexo", "txtdataNascimento", "txtdataChegada", "txtEmail", "selestadocivil"]
    	let campos = [];
    	for(i in campos) {

    		let campo = $(validacoes[campos[i]].campo)
    		let funcoes = validacoes[campos[i]].validacoes 
    		
			limpaCampo($(campo));
		    funcoes()
		    
		    if(!$(campo).hasClass("is-invalid") && $(campo).val() != null && $(campo).val() != ""){
		        $(campo).addClass("is-valid");
		    }
    	}
    	
    	if($("#identificacao").find(".is-invalid").length == 0){
    	
	        $("#identificacao").addClass("d-none")
	        $("#endereco").removeClass("d-none")
	        
	        $("#title").text("Cadastro de Refugiado - Endereço")
        
    	}

    } else if(!$("#endereco").hasClass("d-none")) {

        $("#endereco").addClass("d-none")
        $("#experiencia").removeClass("d-none")
        
        $("#title").text("Cadastro de Refugiado - Experiência")

    } else if(!$("#experiencia").hasClass("d-none")) {

        $("#experiencia").addClass("d-none")
        $("#necessidades").removeClass("d-none")
        
        $("#title").text("Cadastro de Refugiado - Necessidades")
        
    } else if(!$("#necessidades").hasClass("d-none")) {

        $("#necessidades").addClass("d-none")
        $("#dependente").removeClass("d-none")
        
        $("#title").text("Cadastro de Refugiado - Dependentes")
        
        $("#btnprox").addClass("d-none")
        
    }
}

function voltar(){
   if(!$("#identificacao").hasClass("d-none")) {
	   
        $("#btnvolta").addClass("d-none")
        $("#identificacao").addClass("d-none")
        $("#documentos").removeClass("d-none")
        
        $("#title").text("Cadastro de Refugiado - Documentos")
        
    } else if(!$("#endereco").hasClass("d-none")) {
    	
        $("#endereco").addClass("d-none")
        $("#identificacao").removeClass("d-none")
        
        $("#title").text("Cadastro de Refugiado - Identificação")
        
    } else if(!$("#experiencia").hasClass("d-none")) {
    	
        $("#endereco").removeClass("d-none")
        $("#experiencia").addClass("d-none")
        
        $("#title").text("Cadastro de Refugiado - Endereço")
        
    } else if(!$("#necessidades").hasClass("d-none")) {
    	
        $("#necessidades").addClass("d-none")
        $("#experiencia").removeClass("d-none")
        
        $("#title").text("Cadastro de Refugiado - Experiência")
        
    } else if(!$("#dependente").hasClass("d-none")) {
    	
        $("#dependente").addClass("d-none")
        $("#necessidades").removeClass("d-none")
        
        $("#title").text("Cadastro de Refugiado - Necessidades")
        
        $("#btnprox").removeClass("d-none")
        
    }
}


// $(function () {
// $('select').selectpicker();
// });
