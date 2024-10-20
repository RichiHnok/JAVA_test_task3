package com.figures_pack.other;

import com.figures_pack.configs.ConfigLoader;

public class AreDoublesEqual {
	
	public static boolean check(double val1, double val2){
		if(Math.abs(val1 - val2) > ConfigLoader.EPSILON)
			return false;
		return true;
	}
}
