package uk.co.certait.waracle.util;

import org.hibernate.dialect.HSQLDialect;

public class ImprovedHsqlDialect extends HSQLDialect {

	@Override
	protected String getDropSequenceString(String sequenceName) {
		return "drop sequence if exists " + sequenceName;
	}

	@Override
	public boolean dropConstraints() {
		return false;
	}
}
