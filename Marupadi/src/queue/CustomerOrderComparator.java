package queue;

import java.util.Comparator;

public class CustomerOrderComparator implements Comparator<CustomerOrder> {

	@Override
	public int compare(CustomerOrder o1, CustomerOrder o2) {
		// TODO Auto-generated method stub
        return o1.getOrderAmount() < o2.getOrderAmount() ? 1 : -1;

	}

}
