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
		},
		tipo : "text"
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
		},
		tipo : "text"
	},
	txtnumerodoc : {
		campo : "#txtnumerodoc",
		validacoes : function() {

			let campoSelecionado = $("#seldoc").val()

			$(validacoes.txtnumerodoc.campo).unmask()

			if (campoSelecionado == "CPF") {

				notNull($(validacoes.txtnumerodoc.campo))
				tamanho($(validacoes.txtnumerodoc.campo), 11, 11)
				validarCpf($(validacoes.txtnumerodoc.campo))

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "RG") {

				notNull($(validacoes.txtnumerodoc.campo))
				tamanho($(validacoes.txtnumerodoc.campo), 5, 15)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "PASSAPORTE") {

				notNull($(validacoes.txtnumerodoc.campo))
				tamanho($(validacoes.txtnumerodoc.campo), 8, 8)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "PIS") {

				notNull($(validacoes.txtnumerodoc.campo))
				tamanho($(validacoes.txtnumerodoc.campo), 11, 11)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "CARTEIRADETRABALHO") {

				notNull($(validacoes.txtnumerodoc.campo))
				tamanho($(validacoes.txtnumerodoc.campo), 13, 13)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "CNH") {

				notNull($(validacoes.txtnumerodoc.campo))
				tamanho($(validacoes.txtnumerodoc.campo), 11, 11)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "OUTRO") {

				notNull($(validacoes.txtnumerodoc.campo))
				tamanho($(validacoes.txtnumerodoc.campo), 5, 25)

				setMaskListItem(mascaras[campoSelecionado])

			}
		},
		tipo : "text"
	},
	seldoc : {
		campo : "#seldoc",
		validacoes : function() {
		},
		tipo : "select"
	},
	txtnome : {
		campo : "#txtnome",
		validacoes : function() {
			notNull($(validacoes.txtnome.campo))
			tamanho($(validacoes.txtnome.campo), 5, 100)
			regexLetras($(validacoes.txtnome.campo))
		},
		tipo : "text"
	},
	selsexo : {
		campo : "#selsexo",
		validacoes : function() {
			comboBox($(validacoes.selsexo.campo))
		},
		tipo : "select"
	},
	txtdataNascimento : {
		campo : "#txtdataNascimento",
		validacoes : function() {
			data($(validacoes.txtdataNascimento.campo))
		},
		tipo : "text"
	},
	txtdataChegada : {
		campo : "#txtdataChegada",
		validacoes : function() {
			data($(validacoes.txtdataChegada.campo))
		},
		tipo : "text"
	},
	selPaisNascimento : {
		campo : "#selPaisNascimento",
		validacoes : function() {
			comboBox($(validacoes.selPaisNascimento.campo))
		},
		tipo : "select"
	},
    selPaisOrigem : {
        campo : "#selPaisOrigem",
        validacoes : function() {
            comboBox($(validacoes.selPaisOrigem.campo))
        },
        tipo : "select"
    },
	txtEmail : {
		campo : "#txtEmail",
		validacoes : function() {
			email($(validacoes.txtEmail.campo))
		},
		tipo : "text"
	},
	selestadocivil : {
		campo : "#selestadocivil",
		validacoes : function() {
			comboBox($(validacoes.selestadocivil.campo))
		},
		tipo : "select"
	},
	seltipoendereco : {
		campo : "#seltipoendereco",
		validacoes : function() {
			comboBox($(validacoes.seltipoendereco.campo))
		},
		tipo : "select"
	},
	txtcep : {
		campo : "#txtcep",
		validacoes : function() {

			$(validacoes.txtcep.campo).unmask()

			notNull($(validacoes.txtcep.campo))
			tamanho($(validacoes.txtcep.campo), 8, 8)

			setMaskListItem(mascaras.txtcep)

		},
		tipo : "text"
	},
	txtestado : {
		campo : "#txtestado",
		validacoes : function() {
			comboBox($(validacoes.txtestado.campo))
		},
		tipo : "select"
	},
	txtcidade : {
		campo : "#txtcidade",
		validacoes : function() {
			comboBox($(validacoes.txtcidade.campo))
		},
		tipo : "select"
	},
	txtlogradouro : {
		campo : "#txtlogradouro",
		validacoes : function() {
			notNull($(validacoes.txtlogradouro.campo))
			tamanho($(validacoes.txtlogradouro.campo), 3, 100)
			regexLetras($(validacoes.txtlogradouro.campo))
		},
		tipo : "text"
	},
	txtnumero : {
		campo : "#txtnumero",
		validacoes : function() {
			notNull($(validacoes.txtnumero.campo))
			numerosPositivos($(validacoes.txtnumero.campo))
		},
		tipo : "text"
	},
	txtcomplemento : {
		campo : "#txtcomplemento",
		validacoes : function() {
			tamanho($(validacoes.txtcomplemento.campo), 0, 100)
		},
		tipo : "text"
	},
	selOperadora : {
		campo : "#selOperadora",
		validacoes : function() {
		},
		tipo : "select"
	},
	selTipoTelefone : {
		campo : "#selTipoTelefone",
		validacoes : function() {
		},
		tipo : "select"
	},
	txtNumeroTel : {
		campo : "#txtNumeroTel",
		validacoes : function() {
			if ($("#selOperadora").val() != 0
					&& $("#selOperadora").val() != "0"
					&& $("#selOperadora").val() != null
					&& $("#selOperadora").val() != "") {

				$(validacoes.txtNumeroTel.campo).unmask()

				notNull($(validacoes.txtNumeroTel.campo))
				tamanho($(validacoes.txtNumeroTel.campo), 10, 11)

				setMaskListItem(mascaras.txtNumeroTel)

			}

		},
		tipo : "text"
	},
	txtcargo : {
		campo : "#txtcargo",
		validacoes : function() {
			notNull($(validacoes.txtcargo.campo))
			tamanho($(validacoes.txtcargo.campo), 5, 100)
			regexLetras($(validacoes.txtcargo.campo))
		},
		tipo : "text"
	},
	txtempresa : {
		campo : "#txtempresa",
		validacoes : function() {
			notNull($(validacoes.txtempresa.campo))
			tamanho($(validacoes.txtempresa.campo), 5, 100)
		},
		tipo : "text"
	},
	txtdataInicioExperiencia : {
		campo : "#txtdataInicioExperiencia",
		validacoes : function() {
			data($(validacoes.txtdataInicioExperiencia.campo))
			dataInicioFim($(validacoes.txtdataInicioExperiencia.campo),
					$(validacoes.txtdataFimExperiencia.campo))
		},
		tipo : "text"
	},
	txtdataFimExperiencia : {
		campo : "#txtdataFimExperiencia",
		validacoes : function() {
			data($(validacoes.txtdataFimExperiencia.campo), 5, 100)
			dataInicioFim($(validacoes.txtdataInicioExperiencia.campo),
					$(validacoes.txtdataFimExperiencia.campo))
		},
		tipo : "text"
	},
	selPaisExperiencia : {
		campo : "#selPaisExperiencia",
		validacoes : function() {
			comboBox($(validacoes.selPaisExperiencia.campo))
		},
		tipo : "select"
	},
	obsProfissao : {
		campo : "#obsProfissao",
		validacoes : function() {
			tamanho($(validacoes.obsProfissao.campo), 5, 300)
		},
		tipo : "text"
	},
	txtcurso : {
		campo : "#txtcurso",
		validacoes : function() {
			notNull($(validacoes.txtcurso.campo))
			tamanho($(validacoes.txtcurso.campo), 5, 100)
			regexLetras($(validacoes.txtcurso.campo))
		},
		tipo : "text"
	},
	txtinstituicao : {
		campo : "#txtinstituicao",
		validacoes : function() {
			notNull($(validacoes.txtinstituicao.campo))
			tamanho($(validacoes.txtinstituicao.campo), 5, 100)
			regexLetras($(validacoes.txtinstituicao.campo))
		},
		tipo : "text"
	},
	txtdataInicioFormacao : {
		campo : "#txtdataInicioFormacao",
		validacoes : function() {
			data($(validacoes.txtdataInicioFormacao.campo))
			dataInicioFim($(validacoes.txtdataInicioFormacao.campo),
					$(validacoes.txtdataFimFormacao.campo))
		},
		tipo : "text"
	},
	txtdataFimFormacao : {
		campo : "#txtdataFimFormacao",
		validacoes : function() {
			data($(validacoes.txtdataFimFormacao.campo), 5, 100)
			dataInicioFim($(validacoes.txtdataInicioFormacao.campo),
					$(validacoes.txtdataFimFormacao.campo))
		},
		tipo : "text"
	},
	selgrauAcademico : {
		campo : "#selgrauAcademico",
		validacoes : function() {
			comboBox($(validacoes.selgrauAcademico.campo))
		},
		tipo : "select"
	},
	selsituacaoAcademica : {
		campo : "#selsituacaoAcademica",
		validacoes : function() {
			comboBox($(validacoes.selsituacaoAcademica.campo))
		},
		tipo : "select"
	},
	selPaisFormacao : {
		campo : "#selPaisFormacao",
		validacoes : function() {
			comboBox($(validacoes.selPaisFormacao.campo))
		},
		tipo : "select"
	},
	sellingua : {
		campo : "#sellingua",
		validacoes : function() {
		},
		tipo : "select"
	},
	selnivel : {
		campo : "#selnivel",
		validacoes : function() {
		},
		tipo : "select"
	},
	obs : {
		campo : "#obs",
		validacoes : function() {
			tamanho($(validacoes.obs.campo), 5, 100)
		},
		tipo : "text"
	},
	txtnomeDependente : {
		campo : "#txtnomeDependente",
		validacoes : function() {
			notNull($(validacoes.txtnomeDependente.campo))
			tamanho($(validacoes.txtnomeDependente.campo), 5, 100)
			regexLetras($(validacoes.txtnomeDependente.campo))
		},
		tipo : "text"
	},
	selsexoDependente : {
		campo : "#selsexoDependente",
		validacoes : function() {
			comboBox($(validacoes.selsexoDependente.campo))
		},
		tipo : "select"
	},
	txtdataNascimentoDependente : {
		campo : "#txtdataNascimentoDependente",
		validacoes : function() {
			data($(validacoes.txtdataNascimentoDependente.campo))
		},
		tipo : "text"
	},
	txtdataChegadaDependente : {
		campo : "#txtdataChegadaDependente",
		validacoes : function() {
			data($(validacoes.txtdataChegadaDependente.campo))
		},
		tipo : "text"
	},
	selParentesco : {
		campo : "#selParentesco",
		validacoes : function() {
			comboBox($(validacoes.selParentesco.campo))
		},
		tipo : "select"
	},
	selPaisDependente : {
		campo : "#selPaisDependente",
		validacoes : function() {
			comboBox($(validacoes.selPaisDependente.campo))
		},
		tipo : "select"
	},
	documentoDependente : {
		campo : "#documentoDependente",
		validacoes : function() {

			let campoSelecionado = $("#tipoDocumentoDependente").html()

			$(validacoes.documentoDependente.campo).unmask()

			if (campoSelecionado == "Protocolo") {

				notNull($(validacoes.documentoDependente.campo))
				tamanho($(validacoes.documentoDependente.campo), 17, 17)

				setMaskListItem(mascaras[campoSelecionado])

			} else if (campoSelecionado == "RNM") {

				notNull($(validacoes.documentoDependente.campo))
				tamanho($(validacoes.documentoDependente.campo), 8, 8)

				setMaskListItem(mascaras[campoSelecionado])

			}

		},
		tipo : "text"
	},
	txtcpfDependente : {
		campo : "#txtcpfDependente",
		validacoes : function() {

			$(validacoes.txtcpfDependente.campo).unmask()

			tamanho($(validacoes.txtcpfDependente.campo), 11, 11)
			validarCpf($(validacoes.txtcpfDependente.campo))

			setMaskListItem(mascaras.txtcpfDependente)
		},
		tipo : "text"
	},
	profissaoAtual : {
		campo : "#profissaoAtual",
		validacoes : function() {
			
		},
		tipo : "checkbox"
	},
	profissaoIndicacao : {
		campo : "#profissaoIndicacao",
		validacoes : function() {
			
		},
		tipo : "checkbox"
	},
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
	txtNumeroTel : {
		campo : "#txtNumeroTel",
		mascara : "telefone"
	},
	txtcpfDependente : {
		campo : "#txtcpfDependente",
		mascara : "000.000.000-00"
	},
	Protocolo : {
		campo : "#documentoDependente",
		mascara : "00000.000000/0000-00"
	},
	RNM : {
		campo : "#documentoDependente",
		mascara : "S000000-A"
	}
}