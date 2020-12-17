$(document).ready(function () {
  initTable();

  let msg = getParam("status");

  if (msg == "sucesso") {
    Swal.fire({
      title: "Refugiado cadastrado com sucesso",
      type: "success",
      confirmButtonColor: "#3085d6",
      confirmButtonText: "Ok",
    });
  }
});

function formatDocumentType(type) {
  const docType = {
    PROTOCOLO: "Protocolo",
    RNM: "RNM",
    CPF: "CPF",
    RG: "RG",
    PASSAPORTE: "Passaporte",
    CNH: "CNH",
    PIS: "PIS",
    CARTEIRADETRABALHO: "Carteira de trabalho",
  };
  return docType[type];
}

function initTable() {
  $.ajax({
    url: URI + "/refugee/table",
    success: function (data) {
      for (i in data) {
        let telefones = "<td>";
        for (j in data[i].documents) {
          if (data[i].documents[j].status) {
            telefones += `
							<div class='tel-row row'>
								${formatDocumentType(data[i].documents[j].type)} - ${
              data[i].documents[j].number
            }
							</div>
						`;
          }
        }
        telefones += "</td>";

        let numDep = 0;
        for (k in data[i].dependents) {
          if (data[i].dependents[k].status) numDep++;
        }

        $("#bodyTabela").append(`
					<tr>
						<td onclick='fireSwal(${data[i].id})'><img class"pointer" src='${URI}/refugee/${
          data[i].id
        }/image' height=80 width=80></img></td>
						<td>${data[i].name}</td>
						<td>${data[i].birthCountry.name}</td>
						<td>${
              data[i].cpp
                ? '<i class="fas fa-check"></i>'
                : '<i class="fas fa-times"></i>'
            }</td>
						<td>${formatDateToBr(data[i].bornDate)}</td>
						${telefones}
						<td class="row"><div class="col-lg-6"><i onclick="window.location = '/refugee/' + ${
              data[i].id
            }" class="fas fa-user-edit pl-4"></i></div><div class="col-lg-6"><i class="fas fa-trash" onclick="deletar('${
          data[i].id
        }')"></i></div></td>
					</tr>
				`);
      }
      $("#example").DataTable({
        language: {
          url:
            "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Portuguese-Brasil.json",
        },
      });
    },
  });
}

function fireSwal(id) {
  Swal.fire({
    html: `<img src='${URI}/refugee/${id}/image' height=350 width=350></img>`,
    confirmButtonColor: "#3085d6",
    confirmButtonText: "Ok",
  });
}

function deletar(id) {
  $.ajax({
    url: URI + "/refugee/delete",
    data: { id: id },
    type: "POST",
    success: function (data) {
      if (data) {
        Swal.fire({
          title: "Refugiado excluido com sucesso!",
          type: "success",
          confirmButtonColor: "#3085d6",
          confirmButtonText: "Ok",
        }).then((result) => {
          window.location = "/refugee";
        });
      }
    },
  });
}
