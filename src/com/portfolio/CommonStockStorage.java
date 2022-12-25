package com.portfolio;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CommonStockStorage {

	public static List<CommonStock> commonstocks = Arrays.asList(
			new CommonStock("goog", "google", new BigDecimal(89.23), new BigDecimal(89.23), 2.46, new BigDecimal(122.20), 2),
			new CommonStock("aapl", "apple", new BigDecimal(131.86), new BigDecimal(131.86), 0.86, new BigDecimal(175), 2)
			);
}
