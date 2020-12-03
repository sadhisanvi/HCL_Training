package com.bankapp.model.dao;
import java.util.*;

import com.bankapp.model.entity.TransactionLog;
import com.bankapp.model.entity.TxType;
public interface TransactionLogDao {

	public TransactionLog addTransactionLog(int accountId,String txInfo, Double amount, TxType txType);
	public List<TransactionLog> getAllTransactions();
	public List<TransactionLog> getAllTransactionLogsForAccount(int accountId);
}
