function notNull(e){
   if($(e).val() == null || $(e).val() == ""){
       if(!$(e).hasClass("is-invalid"))
            $(e).addClass("is-invalid");
        $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor preencha esse campo</span>`);
    }
}

function tamanho(e, min , max){
    if($(e).val() != null){
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

function apenasNumeros(e){
    if($(e).val() != null){
        var apenasNum = /^([0-9])$/;
        if(!apenasNum.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira apenas numeros</span>`);
        }
    }
}

function apenasNumerosComTracos(e){
    if($(e).val() != null){
        var apenasNum = /^(([0-9])*(\-|\/)*)*$/;
        if(!apenasNum.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira apenas numeros</span>`);
        }
    }
}

function regexNome(e){
    if($(e).val() != null){
        var apenasLetras = /^(([A-Za-z])*([\wÀ-ú])*(\s){0,1})*$/;
        if(!apenasLetras.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira apenas letras</span>`);
        }
    }
}

function semEspeciais(e){
    if($(e).val() != null){
        var apenasLetras = /^(([A-Za-z])*([\wÀ-ú])*(\s){0,1})*$/;
        if(!apenasLetras.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">Por favor insira apenas letras</span>`);
        }
    }
}


function regexPersonalizado(e, regex, mensagem){
    if($(e).val() != null){
        var regext = regex;
        if(!regext.test(e.val())) {
            if(!$(e).hasClass("is-invalid"))
                $(e).addClass("is-invalid");
            $(e).parent().find(".invalid-feedback").append(`<span class="error">${mensagem}</span>`);
        }
    }
}