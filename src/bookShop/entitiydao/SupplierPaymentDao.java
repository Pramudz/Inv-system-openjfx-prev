package bookShop.entitiydao;

import bookShop.entities.GoodReceived;
import bookShop.entities.Supplier;
import bookShop.entities.SupplierPaymentDetail;
import bookShop.entities.SupplierPayments;
import bookShop.entities.SupplierReturn;
import javafx.collections.ObservableList;

public interface SupplierPaymentDao {
	
	boolean savePayment(SupplierPayments supMassPayment , ObservableList<SupplierPaymentDetail> payDetailList);
	
	 double getSumOfGrnPayableToSupplier(Supplier supplier);
	 
	 double getSumRonReturnableToSupplier(Supplier supplier);
	 
	 //for table view
	 ObservableList<Object[]> getGrnForPayments(Supplier supplier);
	
	 
	 //for text field criterias
	 GoodReceived getSingleGrnObjectForPayment(Supplier supplier , long grnId);
	 
	 
	 //for table views
	 ObservableList<Object[]> getRonForSupplierPayments(Supplier supplier);
	 
	 //for text field criterias
	 SupplierReturn getSingleRonObjectForPayment(Supplier supplier , long ronId);
	 
	 

}
