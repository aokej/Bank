# Bank

Franciszek 

Account.java – klasa bazowa; pola number, balance; metody deposit(), withdraw(), gettery/settery.

BusinessAccount.java – klasa dziedzicząca po Account; dodatkowe pole companyName; nadpisanie withdraw().

Transferable.java – interfejs; metoda transfer(Account from, Account to, double amount).

BankUtils.java – klasa pomocnicza; metody statyczne np. printAccountInfo(), walidacje operacji.

Jan 

Transaction.java – klasa reprezentująca pojedynczą transakcję; pola amount, type, date; metoda toString().

SavingsAccount.java – dziedzicząca po Account; dodatkowe pole interestRate; nadpisanie withdraw() (np. limit wypłat).

CheckingAccount.java – dziedzicząca po Account; dodatkowe pole overdraftLimit; nadpisanie withdraw().

Main.java – klasa startowa; tworzy obiekty kont; wykonuje wpłaty, wypłaty, przelewy; wypisuje wyniki w konsoli.

Olek 

TransactionHistory.java – klasa przechowująca listę transakcji (ArrayList<Transaction>); metody addTransaction(), printHistory().

Logger.java – prosta klasa do wypisywania komunikatów (np. operacje na kontach).

BankReport.java – klasa raportująca; np. metoda generateReport(List<Account>) wypisująca sumę sald i podstawowe info o kontach.
