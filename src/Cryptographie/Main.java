//	File Main.java
package Cryptographie;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Main Program entry point.
 *
 * @author UldSkull - 2020 - No copyright.
 */
public class Main {

	public static void main(String[] args) {

		CharSequence str1 = "vive java !";

		CharSequence converted = crypt(str1, getKeyToCrypt());
		System.out.println(converted);

		CharSequence decrypted = crypt(converted, getKeyToDecrypt());

		System.out.println(decrypted);

		getStats(str1, 'a');

	}

	private static Map<Character, Character> getKeyToDecrypt() {

		Map<Character, Character> keyToDecrypt = new HashMap<Character, Character>();
		keyToDecrypt.put('d', 'a');
		keyToDecrypt.put(' ', 'd');
		keyToDecrypt.put('t', 'i');
		keyToDecrypt.put('z', 't');
		keyToDecrypt.put('a', 'v');
		keyToDecrypt.put('i', 'z');
		keyToDecrypt.put('v', ' ');

		return keyToDecrypt;
	}

	private static Map<Character, Character> getKeyToCrypt() {
		Map<Character, Character> keyToCrypt = new HashMap<Character, Character>();

		keyToCrypt.put('a', 'd');
		keyToCrypt.put('d', ' ');
		keyToCrypt.put('i', 't');
		keyToCrypt.put('t', 'z');
		keyToCrypt.put('v', 'a');
		keyToCrypt.put('z', 'i');
		keyToCrypt.put(' ', 'v');
		return keyToCrypt;
	}

	private static CharSequence crypt(CharSequence clear, Map<Character, Character> key) {
		Character[] characterArray = new Character[clear.length()];

		for (int i = 0; i < clear.length(); i++) {
			char a = clear.charAt(i);
			characterArray[i] = ((Character) key.get(a) != null) ? key.get(a) : a;
		}
		CharSequence converted = "";
		for (Character character : characterArray) {
			converted = "" + converted + character;
		}
		return converted;
	}

	private static void getStats(CharSequence text, Character character) {
		int count = 0;
		List<Character> characters = Collections.emptyList();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == character) {
				count++;
			}
		}

		int percent = (count * 100) / text.length();

		System.out.println("percent = " + percent);

	}

}
