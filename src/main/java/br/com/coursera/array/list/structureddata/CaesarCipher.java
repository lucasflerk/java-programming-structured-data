package br.com.coursera.array.list.structureddata;

public class CaesarCipher {

	public static void main(String[] args) {
		String input = "First Legion";
		System.out.println(encrypt(input, 23));
		System.out.println(encryptTwoKeys(input, 23, 17));
	}

	public static String encrypt(String input, int key) {
		StringBuilder builder = new StringBuilder();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftedAlphabet = generateShiftedAlphabet(key, alphabet);
		for (int i = 0; i < input.length(); i++) {

			Character c = (char) (input.charAt(i));
			char shiftedChar = cipherChar(alphabet, shiftedAlphabet, c);
			builder.append(shiftedChar);
		}
		return builder.toString();
	}

	private static String generateShiftedAlphabet(int key, String alphabet) {
		String shiftedAlphabet = alphabet.substring(key);
		shiftedAlphabet += alphabet.subSequence(0, key);
		return shiftedAlphabet;
	}

	private static char cipherChar(String alphabet, String shiftedAlphabet,
			Character c) {
		if (!isALetterOfAlphabet(alphabet, c)) {
			return c;
		}
		int positionChar = alphabet.indexOf(Character.toUpperCase(c));
		char shiftedChar = shiftedAlphabet.charAt(positionChar);
		if (Character.isLowerCase(c)) {
			shiftedChar = Character.toLowerCase(shiftedChar);
		}
		return shiftedChar;
	}
	
	public static String encryptTwoKeys(String input, int key1, int key2){
		StringBuilder builder = new StringBuilder();
		Character ch = ' ';
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftedAlphabet1 = generateShiftedAlphabet(key1, alphabet);
		String shiftedAlphabet2 = generateShiftedAlphabet(key2, alphabet);
		for (int i = 0; i < input.length(); i++) {
			Character c = (char) (input.charAt(i));
			if (i % 2 == 0) {
				ch  = cipherChar(alphabet, shiftedAlphabet1, c);
			}else{
				ch = cipherChar(alphabet, shiftedAlphabet2, c);
			}
			builder.append(ch);
		}
		
		return builder.toString();
		
	}

	private static boolean isALetterOfAlphabet(String alphabet, Character c) {
		return alphabet.contains(String.valueOf(Character.toUpperCase(c)));
	}
	
//	public void testCaesar(){
//		 try{
//	         BufferedReader br = new BufferedReader(new FileReader("c:/arquivo.html"));
//	         while(br.ready()){
//	            String linha = br.readLine();
////	            System.out.println(linha);
//	         }
//	         br.close();
//	      }catch(IOException ioe){
//	         ioe.printStackTrace();
//	      }
//		String encrypted = encrypt(message, key);
//		System.out.println("key is " + key + "\n" + encrypted);
//	}
}