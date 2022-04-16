package com.design.adapter;

import java.util.Arrays;

public class ObjectAdapterDemo {

	public static void main(String[] args) {
		// I want English speaker to say hallo in german
		// I do not want any English speaker here strictly!!!

		EnglishSpeaker englishSpeaker = new AmericanGuy(); // I am scared of sergeant

		GermanSpeaker germanSpeaker = new GermanGuy();
		System.out.println(germanSpeaker.sayHallo());

		// where is the other engllish soldier!!

		// adapter says come I'll help you just lip sync with me
		GermanSpeaker englishMixSpeaker = new EnglishToGermanAdapter(englishSpeaker);

		// seargeant : where were you englishMen???
		System.out.println(englishMixSpeaker.sayHallo());

		// sergeant: hallo there boy, that was great!! welcome aboard

		Arrays.asList(1, 2, 3, 4, 4);// this follows adapter
	}

}

interface EnglishSpeaker {
	public String saySupDude();
}

class AmericanGuy implements EnglishSpeaker {

	@Override
	public String saySupDude() {
		return "yo wassup in american";
	}

}

interface GermanSpeaker {
	public String sayHallo();
}

class GermanGuy implements GermanSpeaker {

	@Override
	public String sayHallo() {
		return "Hallo in german";
	}

}

class EnglishToGermanAdapter implements GermanSpeaker {

	private EnglishSpeaker englishSpeaker;

	// this is an object adapter since we are implementing target interface and
	// warping the adapttee in variable
	public EnglishToGermanAdapter(EnglishSpeaker englishSpeaker) {
		super();
		this.englishSpeaker = englishSpeaker;
	}

	@Override
	public String sayHallo() {
		// since without hallo it's not correct in german
		return "hallo" + englishSpeaker.saySupDude();
	}

}
