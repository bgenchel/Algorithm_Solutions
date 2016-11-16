// Huffman Decoding

// Given a Huffman encoding e of a string s output s.

// The first line of the input contains the number k 
// of different symbols in s and the length l of the 
// encoding e of s. Each of the following k lines 
// define a binary encoding of a symbol in the 
// format "<symbol>: <code>". None of the codes is a 
// prefix of another. The symbols are lower case 
// latin letters. Each of the given k symbols 
// appears in s. The last line of the input contains 
// the encoding e. Output the string s. The length 
// of s is at most 10^4.

// Sample Input 1:
// 1 1
// a: 0
// 0
// Sample Output 1:
// a

// Sample Input 2:
// 4 14
// a: 0
// b: 10
// c: 110
// d: 111
// 01001100100111
// Sample Output 2:
// abacabad

import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num_symbols = sc.nextInt();
		int len_encoding = sc.nextInt();

		HashMap<String, Character> codewords = new HashMap<String, Character>();
		for(int i = 0; i < num_symbols; i++){
			char letter = sc.next().charAt(0);
			String codeword = sc.next();
			codewords.put(codeword, letter);
		}

		String encoded = sc.next();
		String unencoded = new String();
		String word = new String();
		for(int i = 0; i < encoded.length(); i++){
			word += encoded.charAt(i);
			if(codewords.containsKey(word)){
				unencoded += codewords.get(word);
				word = new String();
			}
		}
		System.out.println(unencoded);
	}
}