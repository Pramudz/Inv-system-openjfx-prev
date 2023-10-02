package bookShop.entitiydao;

import java.util.List;

import bookShop.entities.CreditInvoice;
import bookShop.entities.CreditInvoiceDetail;
import bookShop.entities.Users;
import javafx.collections.ObservableList;

public interface CreditInvoiceDao {
	
	boolean saveCreditInvoice(CreditInvoice sale, ObservableList<CreditInvoiceDetail> salesDetails);
	
	long  getLastBillNo(Users user,java.sql.Date date);
	
	List<CreditInvoiceDetail> getInvoiceDetailsByBillNoDateUser(long billNo,java.sql.Date date, Users user);
	
	boolean settleCreditInvoice(CreditInvoice settleInvoice);
}
