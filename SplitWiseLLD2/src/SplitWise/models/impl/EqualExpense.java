package SplitWise.models.impl;

import java.util.List;

import SplitWise.models.Expense;
import SplitWise.models.ExpenseMetaData;
import SplitWise.models.Split;
import SplitWise.models.User;

public class EqualExpense extends Expense{

	public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
		super(amount, paidBy, splits, metaData);
	}

	@Override
	public boolean validate() {
		for(Split split: getSplits())
		 if(!(split instanceof EqualSplit))
		return false;
		
		return true;
	}
}
