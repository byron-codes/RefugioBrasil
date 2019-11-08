let validacoes = {
	txtprotocolo : {
		campo : "#txtprotocolo",
		validacoes : function() {
			$(validacoes.txtprotocolo.campo).unmask()

			 tamanho($(validacoes.txtprotocolo.campo), 17, 17)

			setMaskListItem(mascaras.txtprotocolo)
		}
	},
	txtrne : {
		campo : "#txtrne",
		validacoes : function() {
			$(validacoes.txtrne.campo).unmask()

			 tamanho($(validacoes.txtrne.campo), 8, 8)

			setMaskListItem(mascaras.txtrne)
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
	}
}