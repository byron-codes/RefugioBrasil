let validacoes = {
	txtprotocolo: {
		campo: "#txtprotocolo",
		validacoes: function() {
			$(validacoes.txtprotocolo.campo).unmask()
			
//			notNull($(validacoes.txtprotocolo.campo))
			tamanho($(validacoes.txtprotocolo.campo), 17, 17)
			
			setMaskListItem(mascaras.txtprotocolo)
		}
	},
	txtrne: {
		campo: "#txtrne",
		validacoes: function() {
			$(validacoes.txtrne.campo).unmask()
			
//			notNull($(validacoes.txtrne.campo))
			tamanho($(validacoes.txtrne.campo), 8, 8)
			
			setMaskListItem(mascaras.txtrne)
		}
	}
}

let mascaras = {
	txtprotocolo: {
		campo: "#txtprotocolo",
		mascara: "00000.000000/0000-00",
	},
	txtrne: {
		campo: "#txtrne",
		mascara: "S000000-A",
	}
}