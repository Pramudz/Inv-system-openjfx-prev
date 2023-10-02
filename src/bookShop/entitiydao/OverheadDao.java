package bookShop.entitiydao;

import bookShop.entities.MonthlyOverheads;
import bookShop.entities.OverheadCategory;
import bookShop.entities.compositkeys.MonthlyOverheadId;
import javafx.collections.ObservableList;

public interface OverheadDao {
	
	//Create Overhead Category
	boolean saveNewOverheadCategory(OverheadCategory overheadCategory);
	
	//Save Monthly Overhead values
	boolean saveMonthlyOverhead(MonthlyOverheads overhead);
	
	MonthlyOverheads getMonthlyOverheadById(MonthlyOverheadId id);
	
	boolean updateMonthlyOverhead(MonthlyOverheads monthlyOverhead);
	
	OverheadCategory getOverheadCategoryByName(String overhead);
	
	ObservableList<String> getOverheadCatNames();

}
