package SplitWise.models.impl;

import SplitWise.models.Split;
import SplitWise.models.User;

public class ExactSplit extends Split{

	public ExactSplit(User user,double amount) {
		super(user);
		this.amount=amount;
	}
}
