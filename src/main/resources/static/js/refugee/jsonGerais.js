let validacoes = {
	txtprotocolo : {
		campo : "#txtprotocolo",
		validacoes : function() {
			$(validacoes.txtprotocolo.campo).unmask()

			if ($("#txtrne").val() == null || $("#txtrne").val() == "") {
				limpaCampo($("#txtrne"));
			}

			tamanho($(validacoes.txtprotocolo.campo), 17, 17)

			setMaskListItem(mascaras.txtprotocolo)
		}
	},
	txtrne : {
		campo : "#txtrne",
		validacoes : function() {
			$(validacoes.txtrne.campo).unmask()

			if ($("#txtprotocolo").val() == null
					|| $("#txtprotocolo").val() == "") {
				limpaCampo($("#txtprotocolo"));
			}

			tamanho($(validacoes.txtrne.campo), 8, 8)

			setMaskListItem(mascaras.txtrne)
		}
	},
	txtnumerodoc : {
		campo : "#txtnumerodoc",
		validacoes : function() {

			let campoSelecionado = $("#seldoc").val()

			$(validacoes.txtnumerodoc.campo).unmask()

			if (campoSelecionado == "CPF") {

				tamanho($(validacoes.txtnumerodoc.campo), 11, 11)
				validarCpf($(validacoes.txtnumerodoc.campo))

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "RG") {

				tamanho($(validacoes.txtnumerodoc.campo), 5, 15)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "PASSAPORTE") {

				tamanho($(validacoes.txtnumerodoc.campo), 8, 8)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "PIS") {

				tamanho($(validacoes.txtnumerodoc.campo), 11, 11)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "CARTEIRADETRABALHO") {

				tamanho($(validacoes.txtnumerodoc.campo), 13, 13)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "CNH") {

				tamanho($(validacoes.txtnumerodoc.campo), 11, 11)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "OUTRO") {

				tamanho($(validacoes.txtnumerodoc.campo), 5, 25)

				setMaskListItem(mascaras[campoSelecionado])

			}
		}
	},
	txtnome : {
		campo : "#txtnome",
		validacoes : function() {
			notNull($(validacoes.txtnome.campo))
			tamanho($(validacoes.txtnome.campo), 5, 100)
			regexLetras($(validacoes.txtnome.campo))
		}
	},
	selsexo : {
		campo : "#selsexo",
		validacoes : function() {
			comboBox($(validacoes.selsexo.campo))
		}
	},
	txtdataNascimento : {
		campo : "#txtdataNascimento",
		validacoes : function() {
			data($(validacoes.txtdataNascimento.campo))
		}
	},
	txtdataChegada : {
		campo : "#txtdataChegada",
		validacoes : function() {
			data($(validacoes.txtdataChegada.campo))
		}
	},
	txtEmail : {
		campo : "#txtEmail",
		validacoes : function() {
			notNull($(validacoes.txtEmail.campo))
			email($(validacoes.txtEmail.campo))
		}
	},
	selestadocivil : {
		campo : "#selestadocivil",
		validacoes : function() {
			comboBox($(validacoes.selestadocivil.campo))
		}
	},
	seltipoendereco : {
		campo : "#seltipoendereco",
		validacoes : function() {
			comboBox($(validacoes.seltipoendereco.campo))
		}
	},
	txtcep : {
		campo : "#txtcep",
		validacoes : function() {

			$(validacoes.txtcep.campo).unmask()

			notNull($(validacoes.txtcep.campo))
			tamanho($(validacoes.txtcep.campo), 8, 8)

			setMaskListItem(mascaras.txtcep)

		}
	},
	txtestado : {
		campo : "#txtestado",
		validacoes : function() {
			notNull($(validacoes.txtestado.campo))
			tamanho($(validacoes.txtestado.campo), 4, 20)
			regexLetras($(validacoes.txtestado.campo))
		}
	},
	txtcidade : {
		campo : "#txtcidade",
		validacoes : function() {
			notNull($(validacoes.txtcidade.campo))
			tamanho($(validacoes.txtcidade.campo), 3, 50)
			regexLetras($(validacoes.txtcidade.campo))
		}
	},
	txtlogradouro : {
		campo : "#txtlogradouro",
		validacoes : function() {
			notNull($(validacoes.txtlogradouro.campo))
			tamanho($(validacoes.txtlogradouro.campo), 3, 100)
			regexLetras($(validacoes.txtlogradouro.campo))
		}
	},
	txtnumero : {
		campo : "#txtnumero",
		validacoes : function() {
			notNull($(validacoes.txtnumero.campo))
			numerosPositivos($(validacoes.txtnumero.campo))
		}
	},
	txtcomplemento : {
		campo : "#txtcomplemento",
		validacoes : function() {
			tamanho($(validacoes.txtcomplemento.campo), 0, 100)
		}
	},
	selOperadora : {
		campo : "#selOperadora",
		validacoes : function() {
			comboBox($(validacoes.selOperadora.campo))
		}
	},
	txtNumeroTel : {
		campo : "#txtNumeroTel",
		validacoes : function() {
			
			$(validacoes.txtNumeroTel.campo).unmask()
			
			notNull($(validacoes.txtNumeroTel.campo))
			tamanho($(validacoes.txtNumeroTel.campo), 10, 11)
			
			setMaskListItem(mascaras.txtNumeroTel)
		}
	}
}

let mascaras = {
	txtprotocolo : {
		campo : "#txtprotocolo",
		mascara : "00000.000000/0000-00"
	},
	txtrne : {
		campo : "#txtrne",
		mascara : "S000000-A"
	},
	CPF : {
		campo : "#txtnumerodoc",
		mascara : "000.000.000-00"
	},
	RG : {
		campo : "#txtnumerodoc",
		mascara : ""
	},
	PASSAPORTE : {
		campo : "#txtnumerodoc",
		mascara : "AAAAAAAA"
	},
	PIS : {
		campo : "#txtnumerodoc",
		mascara : "0.000.000.000-0"
	},
	CARTEIRADETRABALHO : {
		campo : "#txtnumerodoc",
		mascara : "000000/00000-SS"
	},
	CNH : {
		campo : "#txtnumerodoc",
		mascara : "00000000000"
	},
	OUTRO : {
		campo : "#txtnumerodoc",
		mascara : ""
	},
	txtcep : {
		campo : "#txtcep",
		mascara : "00000-000"
	},
	txtNumeroTel: {
		campo : "#txtNumeroTel",
		mascara : "telefone"
	}
}