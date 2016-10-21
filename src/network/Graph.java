package network;

import java.util.*;

/**
 * @author Alex Hoecht, Andrew Ward, Mohamed Dahrouj, Shasthra Ranasinghe
 * @version 1.0
 * 
 * Graph implements the "Network" consisting of Nodes that are linked together by edges
 */

public class Graph implements RoutingAlgorithms
{
	
	private ArrayList<Node> vertices; // ArrayList of Nodes for testing purposes
	private ArrayList<Table> table; // Table used to record the route
	private ArrayList<Message> messageList; // Messages
	
	private int hops; //counter
	private int totalHops; // total amount of hops
	private int totalmessages; // total amount of messages
	
	
	/**
	 *Graph constructor creates a network
	 */
	public Graph()
	{

		this.table = new ArrayList<Table>();
		this.vertices = new ArrayList<Node>();
		this.messageList = new ArrayList<Message>();
		this.hops = 0;
		totalHops = 0;
		totalmessages = 0;
		
		
	}

	/**
	 * @param vertices
	 * Graph constructor accepts an ArrayList<Node> to create the network
	 */
	public Graph(ArrayList<Node> vertices)
	{
		this.vertices = new ArrayList<Node>();
		this.table = new ArrayList<Table>();
		this.messageList = new ArrayList<Message>();
		
		this.hops = 0;
		totalHops = 0;
		totalmessages = 0;
		
		for(Node v: vertices)
		{
			this.vertices.add(v);
		}
	}
	
	
	/**
	 * @return a message at index 0
	 */
	public Message getMessage()
	{
		Message temp = messageList.get(0);
		messageList.remove(0);
		return temp;
	}
	
	/**
	 * Generates a random message to be injected into the network 
	 */
	public void createMessage()
	{
		Random random = new Random();
		Node tempS = vertices.get(random.nextInt(vertices.size()));
		Node tempD = vertices.get(random.nextInt(vertices.size()));
		while(tempS.equals(tempD))
		{
			tempD = vertices.get(random.nextInt(vertices.size()));
		}
		Message message = new Message(tempS,tempD);
		messageList.add(message);
		
		totalmessages++;
		
	}
	
	/**
	 * 
	 * @param c - The Current node of the pair being added
	 * @param n - The Next node of the pair being added
	 */
	public void addToTable(Node c, Node n)
	{
		// Creating a pair to add to the table
		Table currentHop = new Table(c,n);
		table.add(currentHop);
	}
	
	/**
	 * Prints the table of the route for testing purposes and MILESTONE 1 
	 */
	public void printTable()
	{
		for(Table t: table)
		{
			System.out.println(t.makeString());
		}
	}
	
	/**
	 * 
	 * @param i - A passed int from the algorithm that counted how many
	 * hops took place.
	 */
	public void setHops(int i)
	{
		hops = i;
		totalHops = totalHops + hops;
	}
	
	/**
	 * Prints out the number of hops
	 */
	public void printHops()
	{
		System.out.println(hops);
	}
	
	public int getHops()
	{
		return hops;
	}
	public int getTotalHops()
	{
		return totalHops;
	}
	
	/**
	 * @param A Node 
	 * @param B Node
	 * Creates a link between the two nodes. IE adds an edge to each nodes "hood" (ArrayList)
	 */
	public void createLink(Node A, Node B)
	{
		Edge e = new Edge(A.getID() + "->" + B.getID(),A,B);
		Edge e2 = new Edge(B.getID() + "->" + A.getID(),B,A);
		A.addNeighbor(e);
		B.addNeighbor(e2);
	}
	
	public ArrayList<Message> getMessageList()
	{
		return messageList;
	}
	
	public int getTotalMessages()
	{
		return totalmessages;
	}

}