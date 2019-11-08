function setMask(id, mask){
	$(id).mask(mask, {reverse: false});
}

function setAllMask(lista){
	for(i in lista){
		if(lista[i].mascara != "")
			$(lista[i].campo).mask(lista[i].mascara, {reverse: false});
		else
			$(lista[i].campo).removeAttr("maxlength")
	}
}

function setMaskListItem(item){
	if(item.mascara != "")
		$(item.campo).mask(item.mascara, {reverse: false});
	else
		$(item.campo).removeAttr("maxlength")
}

function limpaCampo(e){
	$(e).removeClass('is-invalid is-valid');
    $(e).parent().find(".invalid-feedback").children().remove();
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

//MASCARA PARA CAMPO COM MULTIVALOR
//var SPMaskBehavior = function (val) {
//return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
//},
//spOptions = {
//	onKeyPress: function(val, e, field, options) {
//		field.mask(SPMaskBehavior.apply({}, arguments), options);
//	}
//};
//
////ATRIBUI-SE A SEGUINTE MÁSCARA PARA O CAMPO PERTANCENTE AO TELEFONE;
//$("#txtUsuarioTelefone").mask(SPMaskBehavior, spOptions);