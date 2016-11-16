package network;

import java.awt.Dimension;
import java.awt.Toolkit;

final class Constants {

	/**
	 * Private constructor that doesnt do anything as this class is for constants only
	 */
	private Constants(){}
	
	
	protected static final String ABOUT = "SYSC 3110 Group Project: Network Routing Simulator\n"
			+ "Group Members: Alex Hoecht, Andrew Ward, Mohamed Dahrouj, Shasthra Ranasinghe\n\n"
			+ "Summary:\n"
			+ "----------------------------------------------\n"
			+ "The goal of this team project is to build a simulator to evaluate the performance of various routing\n"
			+ "algorithms. This project will implement the following routing algorithms:\n"
			+ "* Random\n"
			+ "* Flooding\n"
			+ "* Shortest path\n"
			+ "* Custom method\n\n"
			+ "Version: Milestone 3";
	
	protected static final String README = "UserManual.txt";
	
	protected static final String UML = "Milestone2_UML.pdf";
	
	protected static final String JAVADOC1 = "doc\\index.html";
	
	protected static final String JAVADOC2 = "doc\\network\\Simulation.html";
	
	protected static final String COUTLD_NOT_OPEN_FILE = "Could not open file properly";
	
	protected static final String FILE_DOES_NOT_EXIST = "Could Not Find Files Required";
	
	protected static final String WARNING = "WARNING";

	protected static final String FREQUENCY_NOT_SPECIFIED = "Frequency not specified, Please set to a number greater then 1.";

	protected static final String ALGORITHM_NOT_SPECIFIED = "Algorithm not specified, Please set and try again.";

	protected static final String NODE_ALREADY_EXISTS = "Node Already Exists";

	protected static final String EDGE_ALREADY_EXISTS = "Edge Already Exists";

	protected static final String NODE_S_SPECIFIED_DOES_NOT_EXIST = "Node(s) Specified Does not Exist";

	protected static final String EDGE_DOESNT_EXIST = "Edge Doesnt Exist";
	
	protected static final int METRIC_FIELD_SIZE = 5;
	
	protected static final int ALGORITHM_METRIC_FIEL_SIZE = 15;
	
	protected static final int FREQUENCY_OPTIONS_MAX = 30;
	
	protected static final int FREQUENCY_OPTIONS_MIN = 2;
	
	protected static final int FRAME_HEIGHT = 600;
	
	protected static final int FRAME_WIDTH = 1000;
	
	protected static final int INITIAL_ROW_COUNT = 0;
	
	protected static final Dimension SCREEN_DIMENTIONS  = Toolkit.getDefaultToolkit().getScreenSize();
	
}