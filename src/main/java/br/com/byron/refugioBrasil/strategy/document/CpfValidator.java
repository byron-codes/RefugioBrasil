package br.com.byron.refugioBrasil.strategy.document;

public class CpfValidator implements IDocumentStrategy {

	@Override
	public String execute(String cpf) {

		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");

		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || cpf.equals("01234567890")) {

			return "CPF inválido";

		} else if ((cpf.length() != 11)) {
			return "CPF inválido";
		} else {
			if ((verificador(cpf, 10) == cpf.charAt(9)) && (verificador(cpf, 11) == cpf.charAt(10))) {
				return "";
			} else {
				return "CPF Inválido";
			}
		}

	}

	private char verificador(String cpf, int peso) {

		int soma = 0;
		int resultado = 0;

		int total = (9 + (peso % 10));
		
		for (int i = 0; i < total; i++) {
			soma += (Integer.parseInt(String.valueOf(cpf.charAt(i))) * peso);
			peso--;
		}

		resultado = 11 - (soma % 11);
		resultado -= (peso % 10) == 1 ? 0 : 2;

		if ((resultado == 10) || (resultado == 11)) {
			return '0';
		}

		return String.valueOf(resultado).charAt(0);

	}

}
