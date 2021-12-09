package com.doc.servise;

import com.doc.exception.ModelNotFoundExeption;
import com.doc.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountServise {

    private Map<Long, Account> accountMap = new HashMap<>();

    public List<Account> findAll() {
        return new ArrayList<>(accountMap.values());
    }

    public void save(Account account) {
        if (account.getId() == null) {
            long id = accountMap.size() + 1;
            account.setId(id);
            accountMap.put(id, account);
        } else {
            accountMap.put(account.getId(), account);
        }
    }

    public void save(Long id, Account account){
            accountMap.put(id, account);
    }

    public Account findById(Long id) {
        Account account = accountMap.get(id);
        if (account == null) {
            throw new ModelNotFoundExeption("Account not found by id=" + id);
        } else {
            return account;
        }
    }

    public Account findByUser(String user_name) {
        Account account = accountMap.get(user_name);
        if (account == null) {
            throw new ModelNotFoundExeption("Account not found by user=" + user_name);
        } else {
            return account;
        }
    }

    public void remove(Account account) {
        if (account.getId() != null) {
            accountMap.remove(account.getId());
        }
    }


}
