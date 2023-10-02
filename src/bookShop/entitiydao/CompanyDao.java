package bookShop.entitiydao;

import bookShop.entities.Company;

public interface CompanyDao {

	
	
	boolean saveCompanyInfo(Company company);
	
	boolean updateCompanyInfo(Company company);
	
	Company getCompany(Company company);
	
	//get last companyId
	Company getCompanyLast();
}
