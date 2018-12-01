package model1;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
public class ChatBot
{
	
	private static final String Voice_Name_Kevin="kevin16";
	private final Voice voice;

	public ChatBot() 
	{
		VoiceManager vm=VoiceManager.getInstance();
		voice=vm.getVoice(Voice_Name_Kevin);
		voice.allocate();
	}

	public void speak(String inputText)
	{
		if(inputText!=null && !inputText.isEmpty())
		{
			voice.speak(inputText);
		}
		
	}
}

