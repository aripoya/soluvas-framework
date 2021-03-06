package org.soluvas.commons.mongo;

import javax.annotation.Nullable;

import org.joda.money.CurrencyUnit;

import com.google.code.morphia.converters.SimpleValueConverter;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;
import com.mongodb.DBObject;

/**
 * Converts {@link CurrencyUnit} to/from {@link DBObject}.
 * @author atang
 */
public class CurrencyUnitConverter extends TypeConverter implements SimpleValueConverter {

	public CurrencyUnitConverter() {
		super(CurrencyUnit.class);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.morphia.converters.TypeConverter#decode(java.lang.Class, java.lang.Object, com.google.code.morphia.mapping.MappedField)
	 */
	@SuppressWarnings("null")
	@Override
	public CurrencyUnit decode(Class targetClass, Object fromDBObject,
			MappedField optionalExtraInfo) throws MappingException {
		if (fromDBObject == null)
			return null;
		else
			return CurrencyUnit.of((String) fromDBObject);
	}

	@Override
	public @Nullable String encode(Object value, MappedField optionalExtraInfo) {
		return value != null ? value.toString() : null;
	}

}
