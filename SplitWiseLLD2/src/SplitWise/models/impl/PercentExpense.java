package SplitWise.models.impl;

import java.util.List;

import SplitWise.models.Expense;
import SplitWise.models.ExpenseMetaData;
import SplitWise.models.Split;
import SplitWise.models.User;

public class PercentExpense extends Expense{

	public PercentExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
		super(amount, paidBy, splits, metaData);
	}

	@Override
	public boolean validate() {
		
		for(Split split: getSplits())
			 if(!(split instanceof ExactSplit))
			return false;
		
		double totalPercent = 100;
		double sumSplitPercent = 0;
		
		for (Split split : getSplits()) {
            PercentSplit exactSplit = (PercentSplit) split;
            sumSplitPercent += exactSplit.getPercent();
        }
		
		if (totalPercent != sumSplitPercent) {
            return false;
        }
		
		return true;
	}
}
