package bookShop.entitiydao.impl;

import org.hibernate.Session;

import bookShop.controllers.database.HibernateUtil;
import bookShop.controllers.formvalidation.AlertHandler;
import bookShop.entities.CreditInvoiceVoid;
import bookShop.entities.CreditInvoiceVoidDetail;
import bookShop.entities.CustomerRefundDetail;
import bookShop.entities.CustomerRefunds;
import bookShop.entities.Products;
import bookShop.entitiydao.RefundDao;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;

public class RefundDaoImpl implements RefundDao {

	private static Session session;
	private static RefundDaoImpl daoHandler;

	// formalize method to access static method dao class
	public static RefundDaoImpl getDao() {
		if (daoHandler == null) {
			daoHandler = new RefundDaoImpl();
		}
		return daoHandler;

	}

	// save poss bill refund and update stock , update sale refund status to true
	public boolean savePossBillRefundAndUpdateStock(CustomerRefunds refund,
			ObservableList<CustomerRefundDetail> refunDetailList) {
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(refund);
			refund.getSales().setRefundStatus(true);
			session.update(refund.getSales());

			for (int i = 0; i < refunDetailList.toArray().length; i++) {
				session.save(refunDetailList.get(i));
				long prdId = refunDetailList.get(i).getProduct().getPrd_id();
				Products prdToUpdate = session.get(Products.class, prdId);
				prdToUpdate.setOnHandQty(prdToUpdate.getOnHandQty() + refunDetailList.get(i).getRefundQty());
				session.update(prdToUpdate);

				if (i % 50 == 0) {
					session.flush();
					session.clear();
				}

			}

			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			AlertHandler.getAlert(AlertType.ERROR, "Hibernate Error",
					"Somthing went wrong please contact your administrator");
			e.printStackTrace();
			return false;
		}
	}

	// save poss bill refund and update stock , update sale refund status to true
	public boolean saveCreditInvoiceRefundAndUpdateStock(CreditInvoiceVoid refund,
			ObservableList<CreditInvoiceVoidDetail> refunDetailList) {
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(refund);
			refund.getCreditInvoice().setRefundStatus(true);
			session.update(refund.getCreditInvoice());

			for (int i = 0; i < refunDetailList.toArray().length; i++) {
				session.save(refunDetailList.get(i));
				long prdId = refunDetailList.get(i).getProduct().getPrd_id();
				Products prdToUpdate = session.get(Products.class, prdId);
				prdToUpdate.setOnHandQty(prdToUpdate.getOnHandQty() + refunDetailList.get(i).getSalesQty());
				session.update(prdToUpdate);

				if (i % 50 == 0) {
					session.flush();
					session.clear();
				}

			}

			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			AlertHandler.getAlert(AlertType.ERROR, "Hibernate Error",
					"Somthing went wrong please contact your administrator");
			e.printStackTrace();
			return false;
		}
	}

}
