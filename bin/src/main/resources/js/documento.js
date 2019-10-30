function consultarDocumento(e){
    let unico = true;
    
    if($("#txtrne").val() != "111111"){
        Swal.fire({
            title: 'Agora sim vamos lá',
            type: 'success',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'vamos',
          }).then((result) => {
            $(e).remove();
            $("#documentosAdd").removeClass("d-none");
            //$("#btnvolta").removeClass("d-none");
            $("#btnprox").removeClass("d-none");
            $("#containerRobot").remove();
            $("#txtrne").prop("disabled", true);
            $("#txtprotocolo").prop("disabled", true);
            $("#title").text("Cadastro de Refugiado - Documentos")
        })
    }else{
        Swal.fire({
            title: 'O dono desse documento já existe no sistema!',
            html: "Deseja alterar o registro?",
            type: 'warning',
            showCancelButton: true,
            cancelButtonColor: '#d33',
            confirmButtonColor: '#3085d6',
            confirmButtonText: 'ir',
            cancelButtonText: 'cancelar',
            reverseButtons: true,
          }).then((result) => {
            if (result.value) {
              alert("vai para edição");
            }else{
                $("#txtprotocolo").val("");
                $("#txtrne").val("");
            }
        })
    } 
}

function inicializaMasks(){
    $('#txtprotocolo').mask('00000-00');
    $("#txtrne").mask('000000-00');
}

$("#txtprotocolo").focusout(function() {
    $(this).removeClass('is-invalid is-valid');
    $(this).parent().find(".invalid-feedback").children().remove();
    apenasNumerosComtracos($(this));
    tamanho($(this), 6 , 6);
    if(!$(this).hasClass("is-invalid")){
        $(this).addClass("is-valid");
    }
})


function adicionarDoc(){
    let num = $("#txtnumerodoc").val();
    let valueTipo = $("#seldoc").val();
    let tipo = $("#seldoc").find(`[val=${valueTipo}]`).text();
    $("#txtnumerodoc").val("");
    $("#documentosAdd").val("");
    $("#novosDocumentos").append(
        `<div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
            <div class="m-3">${tipo} - ${num}</div>
        </div>`
    )
}
