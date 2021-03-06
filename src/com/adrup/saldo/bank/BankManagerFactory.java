/*
 * Saldo - http://github.com/kria/saldo
 * 
 * Copyright (C) 2010 Kristian Adrup
 * 
 * This file is part of Saldo.
 * 
 * Saldo is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Saldo is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.adrup.saldo.bank;

import com.adrup.saldo.bank.ica.IcaManager;
import com.adrup.saldo.bank.lf.LfBankManager;
import com.adrup.saldo.bank.nordea.NordeaManager;
import com.adrup.saldo.bank.swedbank.SwedbankManager;
import com.adrup.saldo.bank.icabanken.IcabankenManager;
import com.adrup.saldo.bank.coop.CoopManager;
import com.adrup.saldo.bank.firstcard.FirstcardManager;
import com.adrup.saldo.bank.preem.PreemManager;
import com.adrup.saldo.bank.statoil.StatoilManager;

import android.content.Context;

/**
 * A {@link BankManager} factory.
 * 
 * @author Kristian Adrup
 *
 */
public class BankManagerFactory {

	
	/**
	 * Creates the appropriate {@link BankManager} depending on the value of {@link BankLogin#getBankId() bankLogin.getBankId()}.
	 * 
	 * @param bankLogin 
	 * @return a {@link BankManager}
	 * @throws BankException
	 */
	public static BankManager createBankManager(Context context, BankLogin bankLogin) throws BankException {
		switch (bankLogin.getBankId()) {

		case BankManager.SWEDBANK:
			return new SwedbankManager(bankLogin, context);
		case BankManager.NORDEA:
			return new NordeaManager(bankLogin, context);
		case BankManager.LANSFORSAKRINGAR:
			return new LfBankManager(bankLogin, context);
		case BankManager.ICA:
			return new IcaManager(bankLogin, context);
		case BankManager.ICABANKEN:
			return new IcabankenManager(bankLogin, context);
		case BankManager.COOP:
			return new CoopManager(bankLogin, context);
		case BankManager.FIRSTCARD:
			return new FirstcardManager(bankLogin, context);
		case BankManager.PREEM:
			return new PreemManager(bankLogin, context);
		case BankManager.STATOIL:
			return new StatoilManager(bankLogin, context);
		default:
			throw new BankException("Illegal Bank type.");
		}
	}
}
