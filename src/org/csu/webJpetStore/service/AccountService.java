package org.csu.webJpetStore.service;

import org.csu.webJpetStore.domain.Account;
import org.csu.webJpetStore.persistence.BannerDataDAO;
import org.csu.webJpetStore.persistence.Impl.AccountDao;
import org.csu.webJpetStore.persistence.Impl.BannerDataDAOImpl;

public class AccountService {
    public AccountService(){
    }
    Account account=null;

    public Account getAccount(String username) {
        AccountDao accountDAO=new AccountDao();
        return accountDAO.getAccountByUsername(username);
    }

    public Account getaccount(String username,String password){
        AccountDao accountDao=new AccountDao();
        Account account=accountDao.SearchAccountByUsernameAndPassword(username,password);
        return account;
    }
    public boolean insertAccount(Account account){
        boolean result=false;
        AccountDao accountDao=new AccountDao();
        result=accountDao.insertAccount(account);
        return  result;
    }

    public Account updateAccount(Account account,Account account2){
        AccountDao accountDao=new AccountDao();
        Account account1=accountDao.UpdateAccount1(account, account2);
        return account;
    }

    public String searchBannerName(String favcategory) {
        BannerDataDAO bannerDataDAO = new BannerDataDAOImpl() ;
        return bannerDataDAO.SearchBannerNameByFavcategory( favcategory);
    }

}
