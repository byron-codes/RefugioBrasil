package br.com.byron.refugioBrasil.strategy.dependent.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.byron.refugioBrasil.domain.Dependent;
import br.com.byron.refugioBrasil.domain.Document;
import br.com.byron.refugioBrasil.enums.DocumentType;
import br.com.byron.refugioBrasil.strategy.dependent.IDependentStrategy;
import br.com.byron.refugioBrasil.strategy.document.validators.CpfStrategy;
import br.com.byron.refugioBrasil.strategy.document.validators.ProtocoloStrategy;
import br.com.byron.refugioBrasil.strategy.document.validators.RnmStrategy;

@Component
public class DocumentDependentStrategy implements IDependentStrategy {

	@Autowired
	CpfStrategy cpfStrategy;

	@Autowired
	ProtocoloStrategy protocoloStrategy;

	@Autowired
	RnmStrategy nrmStrategy;

	@Override
	public String execute(Dependent entity) {
		StringBuilder sb = new StringBuilder();
		boolean temp = false;
		for (Document doc : entity.getDocuments()) {
			if (doc.getType() == DocumentType.CPF) {
				sb.append(cpfStrategy.execute(doc));
			} else if (doc.getType() == DocumentType.PROTOCOLO) {
				temp = true;
				sb.append(protocoloStrategy.execute(doc));
			} else if (doc.getType() == DocumentType.PROTOCOLO) {
				temp = true;
				sb.append(nrmStrategy.execute(doc));
			}
		}

		if (!temp) {
			sb.append("É necessário pelo menos um documento de identificação");
		}

		return sb.toString().trim() == "" ? "" : sb.toString();
	}

}
