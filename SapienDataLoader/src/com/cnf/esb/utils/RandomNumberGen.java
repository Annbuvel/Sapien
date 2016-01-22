package com.cnf.esb.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.concurrent.atomic.AtomicLong;

public class RandomNumberGen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4610619568783024258L;
	private AtomicLong randomNumber;
	private Random seedRandom;
	private int seedValue;

	public RandomNumberGen() {
		seedRandom = new Random();
		seedValue = seedRandom.nextInt();
		if (seedValue < 0) {
			seedValue = seedValue * -1;
		}

		randomNumber = new AtomicLong(seedValue);
	}

	public long getRandomNumber() {
		return randomNumber.getAndIncrement();
	}

	public static RandomNumberGen getInstance() {
		return new RandomNumberGen();
	}

	public static void main(String[] args) {

		List<Long> randomList1 = new ArrayList<Long>();
		List<Long> randomList2 = new ArrayList<Long>();

		RandomNumberGen ranSeq1 = new RandomNumberGen();
		RandomNumberGen ranSeq2 = new RandomNumberGen();

		for (long i = 0; i < 9999; i++) {
			randomList1.add(ranSeq1.getRandomNumber());
		}

		for (long i = 0; i < 9999; i++) {
			randomList2.add(ranSeq2.getRandomNumber());
		}

		for (Long l1 : randomList1) {
			for (Long l2 : randomList2) {
				if (l1 == l2) {
					System.out.println("Compare --" + l1 + " and " + l2);
					System.out.println("Match Found ");
					System.out.println("The Number is --->" + l1);
				} else {
					System.out.println("Compare --" + l1 + " and " + l2);
				}
			}
		}

	}

}