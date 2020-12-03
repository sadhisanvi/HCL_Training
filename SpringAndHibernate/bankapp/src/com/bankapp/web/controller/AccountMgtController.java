package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entity.Account;
import com.bankapp.model.entity.AccountType;
import com.bankapp.model.entity.User;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.web.formbeans.AccountBean;
import com.bankapp.web.formbeans.DepositBean;
import com.bankapp.web.formbeans.TransferBean;
import com.bankapp.web.formbeans.UserBean;
import com.bankapp.web.formbeans.WithdrawBean;

@Controller
public class AccountMgtController {

	private AccountService accountService;
	private TransactionLogService transactionLogService;

	@Autowired
	public AccountMgtController(AccountService accountService,TransactionLogService transactionLogService) {
		this.accountService = accountService;
		this.transactionLogService = transactionLogService;
	}

	@GetMapping("success")
	public String success() {

		return "success";
	}

	@GetMapping("home")
	public String homePage(ModelMap model) {
		// model.addAttribute("withdrawBean",new TransferBean());
		return "home";
	}
	
	@GetMapping("showalltransactions")
	public ModelAndView showalltransactions(ModelAndView mv) {
		mv.setViewName("showalltransactions");
		mv.addObject("transactions", transactionLogService.getAllTransactions());
		return mv;
	}

	@GetMapping("showallaccounts")
	public ModelAndView showallaccounts(ModelAndView mv) {
		mv.setViewName("showallaccounts");
		mv.addObject("accounts", accountService.getAllAccounts());
		return mv;
	}

	// del the book
	@GetMapping("deleteaccount")
	public String delAccountBook(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		accountService.delAccount(id);
		return "redirect:/showallaccounts";
	}

	// update the book: get and post

	// add an new book
	@GetMapping("updateaccount")
	public String addAccountGet(HttpServletRequest req, ModelMap map) {
		int id = Integer.parseInt(req.getParameter("id"));
		Account account = accountService.getAccountById(id);
		map.addAttribute("account", account);
		return "updateaccount";
	}

	@GetMapping("addaccount")
	public String addAccountGet(ModelMap map) {
		map.addAttribute("accountBean", new AccountBean());
		return "addaccount";
	}

	@PostMapping("addaccount")
	public String addAccountPost(@Valid @ModelAttribute("accountBean") Account accountBean, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/addaccount";
		} else {
			if (accountBean.getAccountId() == 0) {
				accountService.addAccount(accountBean);
			} else {
				accountService.updateAccount(accountBean.getAccountId(), accountBean);
			}
			return "redirect:/showallaccounts";
		}
	}

	@GetMapping("transfer")
	public String transferAmountGet(ModelMap model) {
		model.addAttribute("transferBean", new TransferBean());
		return "transfer";
	}

	@PostMapping("transfer")
	public String transferAmountPost(@Valid @ModelAttribute(name = "transferBean") TransferBean transferBean,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "transfer";
		} else {
			int fromAccountId = transferBean.getFromAccountId();
			int toAccountId = transferBean.getToAccountId();
			double amount = transferBean.getAmount();
			accountService.transfer(fromAccountId, toAccountId, amount);
			return "redirect:/success";
		}
	}

	@GetMapping("withdraw")
	public String withdrawGet(ModelMap map) {
		map.addAttribute("withdrawBean", new WithdrawBean());
		return "withdraw";
	}

	@PostMapping("withdraw")
	public String withdrawPost(@Valid @ModelAttribute("withdrawBean") WithdrawBean withdrawBean, BindingResult result) {
		if (result.hasErrors()) {
			return "withdraw";
		} else {
			int accountId = withdrawBean.getAccountId();
			Double amount = withdrawBean.getAmount();
			accountService.withdraw(accountId, amount);
			return "success";
		}
	}

	@GetMapping("deposit")
	public String depositGet(ModelMap map) {
		map.addAttribute("depositBean", new DepositBean());
		return "deposit";
	}

	@PostMapping("deposit")
	public String depositPost(@Valid @ModelAttribute("depositBean") DepositBean depositBean, BindingResult result) {
		if (result.hasErrors()) {
			return "deposit";
		} else {
			int accountId = depositBean.getAccountId();
			Double amount = depositBean.getAmount();
			accountService.deposit(accountId, amount);
			return "success";
		}
	}
}
