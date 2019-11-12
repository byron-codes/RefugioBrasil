function notNull(e){
   if($(e).val() == null || $(e).val() == ""){
       if(!$(e).hasClass("is-invalid"))
            $(e).addClass("is-invalid");
        $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor preencha esse campo</span>`);
    }
}

function tamanho(e, min , max){
    if($(e).val() != null && $(e).val() != ""){
        if($(e).val().length < min || $(e).val().length > max){
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");

            if(min != max){
                $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira um valor entre ${min} e ${max}</span>`);
            }else{
                $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira ${min} caracteres</span>`);
            }
            
        }
    }
}

function comboBox(e){
	if($(e).val() == 0 || $(e).val() == "0" || $(e).val() == null || $(e).val() == ""){
        if(!$(e).hasClass("is-invalid"))
            $(e).addClass("is-invalid");
        $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor selecione uma opção</span>`);
    }
}

function data(e){
	if($(e).val() == null || $(e).val() == ""){
        if(!$(e).hasClass("is-invalid"))
            $(e).addClass("is-invalid");
        $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira uma data válida</span>`);
    }
}

function dataInicioFim(inicio, fim){
	if($(inicio).val() != null && $(inicio).val() != "" && $(fim).val() != null && $(fim).val() != ""){
		if ($(fim).val() <= $(inicio).val()) {
			if(!$(fim).hasClass("is-invalid"))
	            $(fim).addClass("is-invalid");
	        $(fim).parent().find(".invalid-feedback").append(`<span class="error">Por favor a data de fim deve ser depois da data início</span>`);
		}
	}
}

function numerosPositivos(e){
	if($(e).val() != null && $(e).val() != "" && $(e).val() <= 0){
        if(!$(e).hasClass("is-invalid"))
            $(e).addClass("is-invalid");
        $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira um número válido</span>`);
    }
}

function apenasNumeros(e){
	if($(e).val() != null && $(e).val() != ""){
        var apenasNum = /^([0-9])$/;
        if(!apenasNum.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira apenas numeros</span>`);
        }
    }
}

function apenasNumerosComTracos(e){
	if($(e).val() != null && $(e).val() != ""){
        var apenasNum = /^(([0-9])*(\-|\/)*)*$/;
        if(!apenasNum.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira apenas numeros</span>`);
        }
    }
}

function regexLetras(e){
	if($(e).val() != null && $(e).val() != ""){
        var apenasLetras = /^([A-Za-zÀ-ú](\s){0,1})*$/;
        if(!apenasLetras.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira apenas letras</span>`);
        }
    }
}

function semEspeciais(e){
	if($(e).val() != null && $(e).val() != ""){
        var apenasLetras = /^(([A-Za-z])*([\wÀ-ú])*(\s){0,1})*$/;
        if(!apenasLetras.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira apenas letras</span>`);
        }
    }
}

function email(e){
	if($(e).val() != null && $(e).val() != ""){
		var validadorEmail = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
        if(!validadorEmail.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira um e-mail válido</span>`);
        }
    }
}

function regexPersonalizado(e, regex, mensagem){
	if($(e).val() != null && $(e).val() != ""){
        if(!regex.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">${mensagem}</span>`);
        }
    }
}

function validarCpf(e){
	if($(e).val() != null && $(e).val() != "" && $(e).val().length == 11){
		let cpf = $(e).val()
		if (cpf == ("00000000000") || cpf == ("11111111111") || cpf == ("22222222222")
				|| cpf == ("33333333333") || cpf == ("44444444444") || cpf == ("55555555555")
				|| cpf == ("66666666666") || cpf == ("77777777777") || cpf == ("88888888888")
				|| cpf == ("99999999999") || cpf == ("01234567890")) {

			if(!$(e).hasClass("is-invalid"))
				$(e).addClass("is-invalid");
			$(e).parent().find(".invalid-feedback").append(`<span class="error">CPF inválido</span>`);

		} else {
			if ((getVerificador(cpf, 10) != cpf.charAt(9)) && (getVerificador(cpf, 11) != cpf.charAt(10))) {
				if(!$(e).hasClass("is-invalid"))
					$(e).addClass("is-invalid");
				$(e).parent().find(".invalid-feedback").append(`<span class="error">CPF inválido</span>`);
			}
		}
	}
}

function getVerificador(cpf, peso){
	let soma = 0;
	let resultado = 0;

	let total = (9 + (peso % 10));
	
	for (let i = 0; i < total; i++) {
		soma += (cpf.charAt(i) * peso);
		peso--;
	}

	resultado = 11 - (soma % 11);
	resultado -= (peso % 10) == 1 ? 0 : 2;

	if ((resultado == 10) || (resultado == 11)) {
		return 0;
	}

	return resultado;
}