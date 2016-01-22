package com.cnf.esb.utils;

import java.io.Serializable;
import java.util.HashMap;

import java.util.Map;

public class RandomNumberFactory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7390386576882854797L;
	private Map<String, RandomNumberGen> registry;
	private static RandomNumberFactory randomNumberFactory;

	private RandomNumberFactory() {
		registry = new HashMap<>();

	}

	public RandomNumberGen registerAndGetSequence(String sequenceName) {
		RandomNumberGen randomNumberGen = RandomNumberGen.getInstance();
		if (registry.containsKey(sequenceName)) {
			return registry.get(sequenceName);
		} else {
			registry.put(sequenceName, randomNumberGen);
			return randomNumberGen;
		}
	}

	public static RandomNumberFactory getInstance() {
		if (randomNumberFactory == null)
			randomNumberFactory = new RandomNumberFactory();

		return randomNumberFactory;
	}

}
