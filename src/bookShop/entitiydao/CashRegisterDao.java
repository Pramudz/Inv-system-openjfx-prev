package bookShop.entitiydao;

import java.util.List;

import bookShop.entities.CashRegister;
import bookShop.entities.Users;
import bookShop.entities.compositkeys.CashRegisterId;

public interface CashRegisterDao {
	
	CashRegister getCashRegister(CashRegisterId id);
	boolean saveRegister(CashRegister cashReg);
	CashRegister updateCashRegister(CashRegister updateRegister);
	List<Object[]> getPaymentDetailsForCashRegistryNative(long userId, java.sql.Date date);
	List<CashRegister> getNotSignOffCashRegisters(Users user);

}
