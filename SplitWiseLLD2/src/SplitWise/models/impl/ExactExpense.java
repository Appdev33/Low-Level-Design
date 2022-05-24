package SplitWise.models.impl;

import java.util.List;

import SplitWise.models.Expense;
import SplitWise.models.ExpenseMetaData;
import SplitWise.models.Split;
import SplitWise.models.User;

public class ExactExpense extends Expense{

	public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
		super(amount, paidBy, splits, metaData);
	}

	@Override
	public boolean validate() {
		for(Split split: getSplits())
			 if(!(split instanceof ExactSplit))
			return false;
		
		double totalAmount = getAmount();
		double sumSplitAmount = 0;
		
		for (Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }
        if (totalAmount != sumSplitAmount) {
            return false;
        }
		return true;
	}
}
