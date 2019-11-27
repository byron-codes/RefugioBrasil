$(document).ready(function(){
	
	if(window.location.href.split("/")[window.location.href.split("/").length - 1] == "/salvar"){
		
	}
	
	config();
	
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
	
	 $(window).keydown(function(event){
	    if((event.keyCode == 13)) {
	      event.preventDefault();
	      return false;
	    }
	  });
	 
	 $(".docAtualizarMaster").each(function(){
		 let numero = $(this).find(".numero").val()
		 let tipo = $(this).find(".tipo").val()
		 if(tipo != "PROTOCOLO" && tipo != "RNE"){
			 let formatter = new StringMask(mascaras[tipo].mascara, { reverse: true });
			 $(this).find(".docAtualizar").prepend(tipo + " - " + formatter.apply(numero)) 
		 } else {
			 $(this).remove()
		 }
	 })
	 
	 $(".telAtualizarMaster").each(function(){
		 let numero = $(this).find(".idd").val() + $(this).find(".number").val();
		 let tipo = $(this).find(".type").val().charAt(0).toUpperCase() + $(this).find(".type").val().slice(1).toLowerCase();
		 let mask = "(00) 0000-0000";
		 if(numero.length == 11) {
			 mask = "(00) 0 0000-0000"
		 }
		 let formatter = new StringMask(mask, { reverse: true });
		 $(this).find(".telAtualizar").prepend(tipo + " - " + formatter.apply(numero));
	 })
	
})

$("#formRefugiado").submit(function(){
	debugger
	for(i in validacoes){
		$(validacoes[i].campo).unmask();
	}
})

function proximo(){
    if(!$("#documentos").hasClass("d-none")) {
    	
        $("#documentos").addClass("d-none")
        $("#identificacao").removeClass("d-none")
        $("#dialogoRobot").html("")
        
        $("#title").text("Cadastro de Refugiado - Identificação")
        
        $("#btnvolta").removeClass("d-none")

    } else if(!$("#identificacao").hasClass("d-none")) {
    	
//    	let campos = ["txtnome", "selsexo", "txtdataNascimento", "txtdataChegada", "txtEmail", "selestadocivil", "selPaisOrigem"]
//    	validaListaCampos(campos);
    	
    	if($("#identificacao").find(".is-invalid").length == 0){
    	
	        $("#identificacao").addClass("d-none")
	        $("#endereco").removeClass("d-none")
	        
	        $("#title").text("Cadastro de Refugiado - Endereço")
        
    	}

    } else if(!$("#endereco").hasClass("d-none")) {

//    	let campos = ["seltipoendereco", "txtcep", "txtestado", "txtcidade", "txtlogradouro", "txtnumero", "txtcomplemento"]
//    	validaListaCampos(campos);
    	
    	if($("#camposEndereco").find(".is-invalid").length == 0){
    	
	        $("#endereco").addClass("d-none")
	        $("#experiencia").removeClass("d-none")
	        
	        $("#title").text("Cadastro de Refugiado - Experiência")
	        
    	}

    } else if(!$("#experiencia").hasClass("d-none")) {

        $("#experiencia").addClass("d-none")
        $("#necessidades").removeClass("d-none")
        
        $("#title").text("Cadastro de Refugiado - Necessidades")
        
    } else if(!$("#necessidades").hasClass("d-none")) {

        $("#necessidades").addClass("d-none")
        $("#dependente").removeClass("d-none")
        
        $("#title").text("Cadastro de Refugiado - Dependentes")
        
        $("#btnprox").addClass("d-none")
        $("#btnsalvar").removeClass("d-none")
        
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
        $("#btnsalvar").addClass("d-none")
        
    }
}

$("input[name='situacao']").click(function(){
	$("#situacao").val($(this).val())
})

$('.dropdown-menu a').click(function () {
	limpaCampo($("#documentoDependente"))
	$("#documentoDependente").val("")
	if($(this).html() == "Protocolo"){
		$("#documentoDependente").attr("placeholder", "XXXXX.XXXXXX/XXXX-XX")
	} else if($(this).html() == "RNM"){
		$("#documentoDependente").attr("placeholder", "XXXXXXX-X")
	}
	setMaskListItem(mascaras[$(this).html()])
})
