function proximo(){
    if(!$("#documentos").hasClass("d-none")){
        
        $("#documentos").addClass("d-none")
        $("#identificacao").removeClass("d-none")
        $("#dialogoRobot").html("")
        $("#btnvolta").removeClass("d-none")
        $("#title").text("Cadastro de Refugiado - Identificação")

    }else if(!$("#identificacao").hasClass("d-none")){

        $("#identificacao").addClass("d-none")
        $("#endereco").removeClass("d-none")
        $("#title").text("Cadastro de Refugiado - Endereço")

    }else if(!$("#endereco").hasClass("d-none")){

        $("#endereco").addClass("d-none")
        $("#experiencia").removeClass("d-none")
        $("#title").text("Cadastro de Refugiado - Experiência")

    }else if(!$("#experiencia").hasClass("d-none")){

        $("#experiencia").addClass("d-none")
        $("#necessidades").removeClass("d-none")
        $("#title").text("Cadastro de Refugiado - Necessidades")
        
    }
}

function voltar(){
   if(!$("#identificacao").hasClass("d-none")){
        $("#btnvolta").addClass("d-none")
        $("#identificacao").addClass("d-none")
        $("#documentos").removeClass("d-none")
    }else if(!$("#endereco").hasClass("d-none")){
        $("#endereco").addClass("d-none")
        $("#identificacao").removeClass("d-none")
    }else if(!$("#experiencia").hasClass("d-none")){
        $("#endereco").removeClass("d-none")
        $("#experiencia").addClass("d-none")
    }else if(!$("#necessidades").hasClass("d-none")){
        $("#necessidades").addClass("d-none")
        $("#experiencia").removeClass("d-none")
    }
}

function adicionarLingua(){
    debugger
    let lingua = $("#sellingua").val();
    //let lingua = $("#selnivel").find(`[val=${valuelingua}]`).text();

    let nivel = $("#selnivel").val();
    //let nivel = $("#selnivel").find(`[val=${valueNivel}]`).text();
    $("#sellingua").val("");
    $("#selnivel").val("");
    $("#linguas").append(
        `<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
            <div class="m-3">${lingua}-${nivel}</div>
        </div>`
    )
}


// $(function () {
//     $('select').selectpicker();
// });