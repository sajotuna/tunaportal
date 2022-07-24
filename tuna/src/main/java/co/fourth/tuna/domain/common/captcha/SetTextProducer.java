package co.fourth.tuna.domain.common.captcha;

import nl.captcha.text.producer.TextProducer;

public class SetTextProducer implements TextProducer{
	private final String str;
	
	public SetTextProducer(String getAnswer) {
		this.str = getAnswer;
	}

	@Override
	public String getText() {
		return this.str;
	}
}
