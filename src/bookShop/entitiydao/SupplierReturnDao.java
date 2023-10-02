package bookShop.entitiydao;

import bookShop.entities.SupplierReturn;
import bookShop.entities.SupplierReturnDetail;
import javafx.collections.ObservableList;

public interface SupplierReturnDao {

	boolean saveSupplierReturn(SupplierReturn supReturn, ObservableList<SupplierReturnDetail> supReturnDetails);
	
	long saveSupplierReturnWithReturnId(SupplierReturn supReturn, ObservableList<SupplierReturnDetail> supReturnDetails);
	
	
}
