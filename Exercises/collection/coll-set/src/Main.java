//在聊天软件中，发送方发送消息时，遇到网络超时后就会自动重发，
//因此，接收方可能会收到重复的消息，在显示给用户看的时候，需要首先去重。
//请练习使用Set去除重复的消息：

import java.util.*;

public class Main {
  public static void main(String[] args) {
      List<Message> received = List.of(
          new Message(1, "Hello!"),
          new Message(2, "发工资了吗？"),
          new Message(2, "发工资了吗？"),
          new Message(3, "去哪吃饭？"),
          new Message(3, "去哪吃饭？"),
          new Message(4, "Bye")
      );
      List<Message> displayMessages = process(received);
      for (Message message : displayMessages) {
          System.out.println(message.text);
      }
  }

  static List<Message> process(List<Message> received) {
      // TODO: 按sequence去除重复消息
	TreeSet<Message> set = new TreeSet<>(new Comparator<Message>() {
		public int compare(Message m1,Message m2) {
//			if(m1.sequence == m2.sequence) {
//				return 0;
//			}
//			return m1.sequence>m2.sequence ? 1 : -1;
			return Integer.compare(m1.sequence, m2.sequence);
		}
	});
	
  	for(Message message:received) {
  		set.add(message);
  	}
  	List<Message> received2 = new ArrayList<Message>();;
  	for(Message s:set) {
  		received2.add(s);
  	}
  	return received2;
  }
}

class Message {
  public final int sequence;
  public final String text;
  public Message(int sequence, String text) {
      this.sequence = sequence;
      this.text = text;
  }
}