function setMask(id, mask){
	$(id).mask(mask, {reverse: false});
}

function setAllMask(lista){
	for(i in lista){
		if(lista[i].mascara == "telefone")
			setTelMask(lista[i].campo)
		else if(lista[i].mascara != "")
			$(lista[i].campo).mask(lista[i].mascara, {reverse: false});
		else
			$(lista[i].campo).removeAttr("maxlength")
	}
}

function setMaskListItem(item){
	if(item.mascara == "telefone")
		setTelMask(item.campo)
	else if(item.mascara != "")
		$(item.campo).mask(item.mascara, {reverse: false});
	else {
		$(item.campo).unmask();
		$(item.campo).removeAttr("maxlength")
	}
}

function limpaCampo(e){
	$(e).removeClass('is-invalid is-valid');
    $(e).parent().find(".invalid-feedback").children().remove();
}

function limpaDadosErrosCampos(lista){
	for(i in lista) {
    	let campo = $(validacoes[lista[i]].campo)
    	limpaCampo($(campo));
    	if(validacoes[lista[i]].tipo == "text") {
    		$(campo).val("")
    	} else if(validacoes[lista[i]].tipo == "select") {
    		$(campo).val("0")
    	}
    }
}

function validaListaCampos(campos){
	for(i in campos) {

		let campo = $(validacoes[campos[i]].campo)
		let funcoes = validacoes[campos[i]].validacoes 
		
		limpaCampo($(campo));
	    funcoes()
	    
	    if(!$(campo).hasClass("is-invalid") && $(campo).val() != null && $(campo).val() != ""){
	        $(campo).addClass("is-valid");
	    }
	}
}

function getDate(plus = 0){
	let d = new Date();
	d.setDate(d.getDate() + plus);

	let month = d.getMonth()+1;
	let day = d.getDate();

	return d.getFullYear() + '-' +
	    (month<10 ? '0' : '') + month + '-' +
	    (day<10 ? '0' : '') + day;
}

function setTelMask(campo) {
	let SPMaskBehavior = function (val) {
	return val.replace(/\D/g, '').length === 11 ? '(00) 0 0000-0000' : '(00) 0000-00009';
	},
	spOptions = {
		onKeyPress: function(val, e, field, options) {
			field.mask(SPMaskBehavior.apply({}, arguments), options);
		}
	};
	$(campo).mask(SPMaskBehavior, spOptions);
}

function formatDateToBr(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [day, month, year].join('/');
}

//MASCARA PARA CAMPO COM MULTIVALOR
