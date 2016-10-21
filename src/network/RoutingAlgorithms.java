package network;

import java.util.*;

/**
 * @author Alex Hoecht, Andrew Ward, Mohamed Dahrouj, Shasthra Ranasinghe
 * @version 1.0
 * 
 * Iteration 1: Implementing the Random algorithm
 * 
 * The following algorithms will be used by the Network:
 * 		- Random: When a router receives a message, it forwards it to a random neighbor;
 * 		- Flooding: When a router receives a message, it forwards it to all of its neighbors except the one
 * 					it came from. But must avoid infinite forward loops!
 * 		- Shortest path: The routing tables are configured globally to deliver messages using the least
 * 						amount of intermediate nodes (a.k.a hops), given the complete knowledge of the network. This
 * 						can be done using a depth-first search.
 * 		- Choose your own Algorithm: Feel free to investigate existing routing algorithms or come
 * 						up with one of your own imagination (but in either case you need to document it precisely).
 * 		Don�t worry: we don�t expect you to come up with the best possible algorithm; just something
 * 					that might reasonably be better than Random or Flooding.
 * 
 * When the algorithms are finished running, the method returns the number of hops to the graph
 *
 */
public interface RoutingAlgorithms {

	/**
	 * The default behavior of when a class that implements the RoutingAlgorithms
	 * calls runAlgorithm
	 * 
	 * @param	source	- The vertex the algorithm will start at.
	 * 			destination	- The vertex that the message will end up at.
	 * 			algorithm	-An enum telling the interface which algorithm to run.
	 * 
	 */
	public default void runAlgorithm(Graph graph, int frequency, ALGORITHM algorithm) 
	{
		// The amount of hops
		int hopCounter = 0;
		// If the algorithm is still running
		boolean running = true;
		
		// Create the starting message
		graph.createMessage();
		Message currentMessage = graph.getMessage();
		Node tempSource = currentMessage.getSource();
		Node tempDestination = currentMessage.getDestination();
	
		switch(algorithm)
		{
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// The message will be forwarded to ONE RANDOM neighbor
			case RANDOM:
				
				while(running)
				{
					// Create a random variable
					Random random = new Random();
					
					// Select a random edge from the source vertex
					Edge temp = tempSource.getNeighbor(random.nextInt(tempSource.getNeighborhoodsize()));
					
					// The message will be forwarded to the destination of the random edge
					Node nextNode = temp.getDestination();
					
					
					// Hop
					hopCounter++;
					
					if(hopCounter == frequency)
					{
							graph.createMessage();	
					}
					
					//Check if the the next node is the destination
					if(nextNode == tempDestination)
					{
						//PLACE SOURCE NODE AND NEXTNODE IN TABLE
						//PASS HOP COUNTER TO GRAPH
						graph.addToTable(tempSource, nextNode);
						
						graph.setHops(hopCounter);
						
						if(graph.getMessageList().size() != 0)
						{
							currentMessage = graph.getMessage();
						}
						else
						{
							running = false;
						}
						
					}
					else
					{
							
						//PLACE SOURCE NODE AND NEXTNODE IN TABLE
						// Shift nodes for loop
						graph.addToTable(tempSource, nextNode);
						tempSource = nextNode;
						nextNode = null;
						temp = null;
					}
				//Loop
				}
				
				// End of case
				break;
				
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// The message will be forwarded to ALL neighbors, EXCEPT the one it came from	
			case FLOODING:

				// End of case
				break;
			
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// The message will be forwarded across the shortest path to get to a node(Depth-first)
			case SHORTESTPATH:

				// End of case
				break;
			
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// Undecided on what our own algorithm will be
			case CUSTOM:
		
				// End of case
				break;
				
		}
		
		//RETURN THE HOP COUNT TO THE GRAPH
		

		
	}


}
