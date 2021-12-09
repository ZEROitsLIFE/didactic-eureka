package com.doc.web;


import com.doc.exception.ModelNotFoundExeption;
import com.doc.model.Account;
import com.doc.model.InformatoinOfAccount;
import com.doc.servise.AccaunInformationServis;
import com.doc.servise.AccountServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/accounts")
public class AccountControler {

    @Autowired
    private AccountServise accountService;
    private AccaunInformationServis accaunInformationServis;
    @GetMapping
    public List<Account> getAll() {
            return accountService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Account get(@PathVariable Long id) {
        Account account=accountService.findById(id);
    return account;
    }
    @GetMapping
    public InformatoinOfAccount sucsesvulLogin(@RequestBody Account account)
    {
       InformatoinOfAccount account2=accaunInformationServis.findByUser(account.getUser_name());

       if(account.getUser_name()!=account2.getUser_name())
        {
            if (account2.getPassword()==account.getPassword())
                return account2;
            else throw new ModelNotFoundExeption("Incorect Password");
        }
         throw new ModelNotFoundExeption("Incorect User");
    }
    @PostMapping
    public void postUser(@RequestBody Account account) {
        accountService.save(account);
    }
    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody Account account) {
        if (!Objects.equals(id, account.getId())) {
            throw new IllegalStateException("Invalid account id");
        }
        accountService.save(account);
    }
    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable Long id) {
        Account account = accountService.findById(id);
        accountService.remove(account);
    }

}
