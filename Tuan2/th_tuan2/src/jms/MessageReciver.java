package jms;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


/*
 * This class is used to send a text message to the queue.
 */
public class MessageReciver extends JFrame
{

	/*
	 * URL of the JMS server. DEFAULT_BROKER_URL will just mean that JMS server is on localhost
	 * 
	 * default broker URL is : tcp://localhost:61616"
	 */
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	

	/*
	 * Queue Name.You can create any/many queue names as per your requirement.
	 */
	private static String queueName = "MESSAGE_QUEUE";
	private JFrame frame;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JButton btnNewButton;
	
	private void ui() {
		frame = new JFrame();
		frame.setBounds(100, 100, 442, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		JPanel panelFrom = new JPanel();
		panelFrom
				.setBorder(new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"To", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		frame.getContentPane().add(panelFrom);
		panelFrom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		txtFrom = new JTextField();
		txtFrom.setText("Ma");
		txtFrom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panelFrom.add(txtFrom);
		txtFrom.setColumns(35);
		
		ConnectionFactory connectionFactory1 = new ActiveMQConnectionFactory(url);
		Connection connection1 = null;
		try {
			connection1 = connectionFactory1.createConnection();
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection1.start();
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Session session1 = null;
		try {
			session1 = connection1.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * Destination represents here our queue 'MESSAGE_QUEUE' on the JMS server.
		 * 
		 * MessageConsumer is used for receiving messages from the queue.
		 */
		Destination destination1 = null;
		try {
			destination1 = session1.createQueue(queueName);
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		MessageConsumer consumer = null;
		TextMessage textMessage1 = null;
		
		try {
			consumer = session1.createConsumer(destination1);
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Message messageReceive = consumer.receive();
			if (messageReceive instanceof TextMessage)
			{
				textMessage1 = (TextMessage) messageReceive;
				String a = textMessage1.getText();
				txtFrom.setText(a);
			}
			connection1.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
				

		
	}
	public MessageReciver() {
		ui();
	}

	public static void main(String[] args) throws JMSException
	{
		MessageReciver window = new MessageReciver();
		window.frame.setVisible(true);
		
	}
}
