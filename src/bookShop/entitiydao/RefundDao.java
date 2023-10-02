package bookShop.entitiydao;

import bookShop.entities.CreditInvoiceVoid;
import bookShop.entities.CreditInvoiceVoidDetail;
import bookShop.entities.CustomerRefundDetail;
import bookShop.entities.CustomerRefunds;
import javafx.collections.ObservableList;

public interface RefundDao {
	
	
	// save poss bill refund and update stock , update sale refund status to true
	boolean savePossBillRefundAndUpdateStock(CustomerRefunds refund,
			ObservableList<CustomerRefundDetail> refunDetailList);
	
	
	boolean saveCreditInvoiceRefundAndUpdateStock(CreditInvoiceVoid refund,
			ObservableList<CreditInvoiceVoidDetail> refunDetailList);

}
