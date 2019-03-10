package com.br4.ms.contacorrente.persistencia.userType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;

public class MoneyUserType implements CompositeUserType {
	private static final String[] PROPERTY_NAMES = { "amount", "currencyUnit" };
	private static final Type[] PROPERTY_TYPES = { StandardBasicTypes.BIG_DECIMAL, StandardBasicTypes.CURRENCY };

	public MoneyUserType() {
		super();
	}

	@Override
	public Serializable disassemble(Object value, SharedSessionContractImplementor session) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, SharedSessionContractImplementor session, Object owner)
			throws HibernateException {
		return cached;
	}

	public String[] getPropertyNames() {
		return PROPERTY_NAMES.clone();
	}

	public Type[] getPropertyTypes() {
		return PROPERTY_TYPES.clone();
	}

	public Object getPropertyValue(final Object component, final int property) throws HibernateException {
		BigMoney money = (BigMoney) component;
		return (property == 0) ? money.getAmount() : money.getCurrencyUnit().toCurrency();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		BigDecimal amount = StandardBasicTypes.BIG_DECIMAL.nullSafeGet(rs, names[0], session);
		Currency currency = StandardBasicTypes.CURRENCY.nullSafeGet(rs, names[1], session);
		return BigMoney.of(CurrencyUnit.of(currency), amount);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		BigMoney money = (BigMoney) value;
		BigDecimal amount = (money == null) ? null : money.getAmount();
		Currency currency = (money == null) ? null : money.getCurrencyUnit().toCurrency();

		StandardBasicTypes.BIG_DECIMAL.nullSafeSet(st, amount, index, session);
		StandardBasicTypes.CURRENCY.nullSafeSet(st, currency, index + 1, session);
	}

	@Override
	public Object replace(Object original, Object target, SharedSessionContractImplementor session, Object owner)
			throws HibernateException {
		// TODO Auto-generated method stub
		return deepCopy(original);
	}

	public void setPropertyValue(final Object component, final int property, final Object value)
			throws HibernateException {
		throw new HibernateException("Money is immutable.");
	}

	public Object deepCopy(final Object value) throws HibernateException {
		return (value != null) ? BigMoney.of(((BigMoney) value).getCurrencyUnit(), ((BigMoney) value).getAmount())
				: null;
	}

	public boolean equals(final Object x, final Object y) throws HibernateException {
		return Objects.equals(x, y);
	}

	public int hashCode(final Object x) throws HibernateException {
		return Objects.hashCode(x);
	}

	public boolean isMutable() {
		return false;
	}

	public Class<?> returnedClass() {
		return BigMoney.class;
	}

}