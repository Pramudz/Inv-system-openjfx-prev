package bookShop.entitiydao;

import java.util.List;

import bookShop.entities.GoodReceived;
import bookShop.entities.GoodReceivedDetails;
import bookShop.entities.OrderItems;
import javafx.collections.ObservableList;

public interface GoodReceivedDao {
	
	//save GRN along with updating Purchase Order , On Hand Stock , Average Price of a product
	boolean saveGrn(GoodReceived grn, ObservableList<GoodReceivedDetails> grnDets , List<OrderItems> orderItems ,boolean partialDelStatus, boolean deliverStatus);
	

}
