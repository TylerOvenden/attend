package chatbotProject;

public class Chatbot {
	private String userName;
	private Topic tyler;
	private boolean chatting;
	public Chatbot()
	{
		ben = new ChatbotTyler();
		userName = "unknown user";
		chatting = true;
	}
	public void startTalking() {
		ChatbotMain.print("welcome to our chatbot! Your nama?");
		userName = ChatbotMain.getInput();
		while (chatting) {
			ChatbotMain.print("What do you want to talk about?")
			String response = ChatbotMain.getInput();
			if (tyler.isTriggered(response)) {
				chatting = false;
				tyler.startChatting();
			} else {
				ChatbotMain.print("I'm sorry. I don't understand");
				
				
			}
		}
	}
	
}
