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

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * This class is used to receive the text message from the queue.
 */
public class MessageSender extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * URL of the JMS server. DEFAULT_BROKER_URL will just mean that JMS server is on localhost
	 * 
	 * default broker URL is : tcp://localhost:61616"
	 */
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	/*
	 * Name of the queue we will receive messages from
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
						"From", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		frame.getContentPane().add(panelFrom);
		panelFrom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		txtFrom = new JTextField();
		txtFrom.setText("Ma");
		txtFrom.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panelFrom.add(txtFrom);
		txtFrom.setColumns(35);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);


		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);

		btnNewButton = new JButton("Send");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		
		btnNewButton.addActionListener(t -> {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			Connection connection = null;
			try {
				connection = connectionFactory.createConnection();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.start();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * Creating a non transactional session to send/receive JMS message.
			 */
			Session session = null;
			try {
				session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * The queue will be created automatically on the server.
			 */
			Destination destination = null;
			try {
				destination = session.createQueue(queueName);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * Destination represents here our queue 'MESSAGE_QUEUE' on the JMS server.
			 * 
			 * MessageProducer is used for sending messages to the queue.
			 */
			MessageProducer producer = null;
			try {
				producer = session.createProducer(destination);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String messageText = txtFrom.getText();
			
			TextMessage message = null;
			try {
				message = session.createTextMessage(messageText);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * Here we are sending our message!
			 */
			try {
				producer.send(message);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				System.out.println("Message '" + message.getText() + ", Sent Successfully to the Queue");
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		});
	
		
		
		
	}
	
	public MessageSender() {
		ui();
	}

	public static void main(String[] args) throws JMSException
	
	{
		MessageSender window = new MessageSender();
		window.frame.setVisible(true);
		
//		System.out.println("url = " + url);
//
//		/*
//		 * Getting JMS connection from the JMS server and starting it
//		 */
//		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
//		Connection connection = connectionFactory.createConnection();
//		connection.start();
//
//		/*
//		 * Creating session for receiving messages
//		 */
//		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//
//		/*
//		 * Destination represents here our queue 'MESSAGE_QUEUE' on the JMS server.
//		 * 
//		 * MessageConsumer is used for receiving messages from the queue.
//		 */
//		Destination destination = session.createQueue(queueName);
//
//		/*
//		 * MessageConsumer is used for receiving (consuming) messages
//		 */
//		MessageConsumer consumer = session.createConsumer(destination);
//
//		/*
//		 * Here we receive the message.
//		 */
//		Message message = consumer.receive();
//
//		if (message instanceof TextMessage)
//		{
//			TextMessage textMessage = (TextMessage) message;
//			System.out.println("Received message '" + textMessage.getText() + "'");
//		}
//		connection.close();
	}
}
