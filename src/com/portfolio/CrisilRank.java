package com.portfolio;

public enum CrisilRank {
	UNRANKED(0),
	RANK1(1),
	RANK2(2),
	RANK3(3),
	RANK4(4),
	RANK5(5);
	
	private int rank;
	private CrisilRank(int rank) {
		this.rank = rank;
	}
}
