package com.doc.servise;

import com.doc.exception.ModelNotFoundExeption;
import com.doc.model.InformatoinOfAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccaunInformationServis {

    private Map<Long, InformatoinOfAccount> accountInformationMap = new HashMap<>();

    public List<InformatoinOfAccount> findAll() {
        return new ArrayList<>(accountInformationMap.values());
    }

    public void save(InformatoinOfAccount account) {
        if (!(account.getId() != null)) {
            long id = accountInformationMap.size() + 1;
            account.setId(id);
            accountInformationMap.put(account.getId(), account);
        }
    }

    public void save(Long id, InformatoinOfAccount account){
        accountInformationMap.put(id, account);
    }

    public InformatoinOfAccount findById(Long id) {
        InformatoinOfAccount account = accountInformationMap.get(id);
        if (account == null) {
            throw new ModelNotFoundExeption("AccountInformation not found by id=" + id);
        } else {
            return account;
        }
    }

    public InformatoinOfAccount findByUser(String user_name) {
        InformatoinOfAccount account = accountInformationMap.get(user_name);
        if (account == null) {
            throw new ModelNotFoundExeption("Account not found by user=" + user_name);
        } else {
            return account;
        }
    }

    public void remove(InformatoinOfAccount account) {
        if (account.getId() != null) {
            accountInformationMap.remove(account.getId());
        }
    }

}
