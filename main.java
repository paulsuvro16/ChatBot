package model1;
import java.util.*;
import java.io.*;
public class main
{
	public static void main(String[] args) throws IOException
	{
	
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ChatBot cbot=new ChatBot();
		
		String Chatbot[][]={
				{"i have to go now","i gota go","i gota go now","bye talk to u later","bye","good bye"},
				{"okay bye","bye","okay talk to u later","see you tommorow then"},
				
				{"hi","hello","hola","ola","hey","oe","hey bro","hey man","yo"},
				{"hi,bro","hey","hello","hey,  long time no see"},
				
				{"whats up","what,s up bro","whats up","whats up bro","wassup","wassup bro","hey whats up bro","hey whats up man","what are you up to","what are you doing"},
				{"nothing much,same old same old","nothing much, whats up with u"},
				
				{"how are you","how r u","how are u","how are you man","how r u man","how r u bro","how are you bro","how are u bro"},
				{"good","doing well","i am fine,thank u"},
				
				{"same here","good"},
				{"okay","okay dokay"},

				{"shut up","nooooob","do not disturb","stop it","have u lost your mind","leave me alone","busy here,talk to u later"}
			};
		
		while(true)
		{
			System.out.print("You-->");
			String in=br.readLine();
			in=in.toLowerCase();
			while(true)
			{
				if(in.length()==0)
					break;
				if(Character.isAlphabetic(in.charAt(in.length()-1)))
					break;
				else
					in=in.substring(0,in.length()-1);
			}
			in=in.trim();
			if(in.equals("good morning") || in.equals("good afternoon") || in.equals("good evening") || in.equals("good night"))
			{
				in="same to you";
				System.out.println("Ro-->"+in);				
				cbot.speak(in);
				break;
			}
			byte response=0;
			
			int j=0;
			while(response==0)
			{
				boolean match=false;
				String str1[]=Chatbot[j*2];
				
				for(int i=0;i<str1.length;i++)
				{
					if(str1[i].equals(in)==true)
						match=true;
				}
				if(match==true)
				{
					if(j*2==0)
					{
						int r=(int)(Math.floor(Math.random()*Chatbot[(j*2)+1].length));
						System.out.print("Ro-->"+Chatbot[(j*2)+1][r]);
						String str=Chatbot[(j*2)+1][r];
						cbot.speak(str);
						response=3;
						break;
					}
					response=2;
					int r=(int)(Math.floor(Math.random()*Chatbot[(j*2)+1].length));
					System.out.print("Ro-->"+Chatbot[(j*2)+1][r]);
					String str=Chatbot[(j*2)+1][r];
					cbot.speak(str);					
				}
				j++;
				if(j*2==Chatbot.length-1 && response==0)
					response=1;			
			}
			if(response==1)
			{
				int r=(int)(Math.floor(Math.random()*Chatbot[Chatbot.length-1].length));
				System.out.print("Ro-->"+Chatbot[Chatbot.length-1][r]);
				String str=Chatbot[Chatbot.length-1][r];
				cbot.speak(str);				
			}
			if(response==3)
				break;
			System.out.println();
		}
		
		
	}

}