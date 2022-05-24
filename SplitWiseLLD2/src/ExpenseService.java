import java.util.List;

import SplitWise.models.Expense;
import SplitWise.models.ExpenseMetaData;
import SplitWise.models.ExpenseType;
import SplitWise.models.Split;
import SplitWise.models.User;
import SplitWise.models.impl.EqualExpense;
import SplitWise.models.impl.ExactExpense;
import SplitWise.models.impl.ExactSplit;
import SplitWise.models.impl.PercentExpense;
import SplitWise.models.impl.PercentSplit;

public class ExpenseService {
	public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetaData expenseMetadata) {
		
		switch(expenseType){
			case EXACT:
				return new ExactExpense(amount, paidBy, splits, expenseMetadata);
			
			case PERCENT:
				for(Split split: splits) {
					PercentSplit percentSplit = (PercentSplit)split;
					split.setAmount(amount*percentSplit.getPercent()/100.0);
				}
				return new PercentExpense(amount, paidBy, splits, expenseMetadata);
				
			case EQUAL:	
				int totalSplits = splits.size();
                double splitAmount = ((double) Math.round(amount*100/totalSplits))/100.0;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount + (amount - splitAmount*totalSplits));
                
                return new EqualExpense(amount,paidBy,splits,expenseMetadata);
		}
		return null;
	}
}
