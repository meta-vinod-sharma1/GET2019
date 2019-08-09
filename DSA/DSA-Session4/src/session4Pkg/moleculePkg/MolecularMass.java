package session4Pkg.moleculePkg;

import java.util.*;
/**
 * This class contains method to compute molecular mass of compound
 * @author Vinod
 * Dated 08/03/2019
 */
public class MolecularMass {

	static Map<Character, Integer> compoundData = new HashMap<>();
	static {
		compoundData.put('H', 1);
		compoundData.put('C', 12);
		compoundData.put('O', 16);
	}

	/**
	 * methods to compute molecular mass of compound
	 * @param compound is the compound formulae
	 * @return the molecular mass of compound
	 */
	int calculateMass(String compound) {
		compound = compound.toUpperCase();

		int moleculerMass = 0;
		for (int index1 = 0; index1 < compound.length(); index1++) {

			if (compoundData.containsKey(compound.charAt(index1))) {
				String number = "1";
				int index2 = index1;
				while (index2 < compound.length() - 1 && Character.isDigit(compound.charAt(index2 + 1))) {
					number += compound.charAt(index2 + 1);
					index2++;
				}
				if (number.length() > 1) {
					number = number.substring(1, number.length());
				}
				moleculerMass += compoundData.get(compound.charAt(index1)) * (Integer.parseInt(number));
				index1 = index2;
			} else if (compound.charAt(index1) == '(') {
				String number = "1";
				int cnt = 0;
				String sub = "";
				int subResult = 0;
				index1++;
				while (index1 < compound.length()) {

					if (compound.charAt(index1) == '(') {
						cnt++;
						sub += '(';
					} else if (compound.charAt(index1) == ')' && cnt == 0) {

						subResult += calculateMass(sub);
						break;
					} else if (compound.charAt(index1) == ')' && cnt != 0) {
						cnt--;
						sub += compound.charAt(index1);

					} else
						sub += compound.charAt(index1);
					index1++;
				}

				int index2 = index1 + 1;

				while(index2 < compound.length() && Character.isDigit(compound.charAt(index2))) {
					number += compound.charAt(index2);
					index2++;
				}
				if(number.length() > 1) {
					number = number.substring(1, number.length());
				}
				moleculerMass += subResult * (Integer.parseInt(number));
				index1 = index2 - 1;

			}
		}
		return moleculerMass;
	}

}
