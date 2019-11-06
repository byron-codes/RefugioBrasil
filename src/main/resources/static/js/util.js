function setMask(id, mask){
	$(id).mask(mask, {reverse: false});
}

function setAllMask(lista){
	for(i in lista){
		$(lista[i].campo).mask(lista[i].mascara, {reverse: false});
	}
}

function setMaskListItem(item){
	$(item.campo).mask(item.mascara, {reverse: false});
}

function limpaCampo(e){
	$(e).removeClass('is-invalid is-valid');
    $(e).parent().find(".invalid-feedback").children().remove();
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