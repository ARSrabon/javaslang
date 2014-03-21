package javaslang.text;

import static javaslang.lang.Lang.require;
import javaslang.lang.Strings;

class Literal implements Parser {

	final String literal;

	Literal(String literal) {
		require(!Strings.isNullOrEmpty(literal), "literal is null or empty");
		this.literal = literal;
	}

	@Override
	public Tree<Token> parse(String text, int index) {
		return text.startsWith(literal, index)
				? new Tree<Token>("Literal", new Token(text, index, index + literal.length()))
				: null;
	}

}