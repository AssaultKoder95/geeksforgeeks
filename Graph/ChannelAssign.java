public class ChannelAssign {
	/*
	There are M transmitter and N receiver stations. Given a matrix that keeps track of the number of packets to be transmitted from a given transmitter to a receiver. If the (i; j)-th entry of the matrix is k, it means at that time the station i has k packets for transmission to station j.
During a time slot, a transmitter can send only one packet and a receiver can receive only one packet. Find the channel assignments so that maximum number of packets are transferred from transmitters to receivers during the next time slot.
    */
    public static void assign(int[][] matrix) {
    	//match: match[0] = 1: 1 send msg to 0
        int[] match = new int[matrix[0].length];
        for(int i = 0; i < match.length; i++) {
        	match[i] = -1;
        } 
        int result = 0;
        for(int u = 0; u < matrix.length; u++) {
        	boolean seen[] = new boolean[matrix[0].length];
        	if(bmp(matrix, u, seen, match)) {
        		result++;
        	}
        }
        for(int i = 0; i < matrix[0].length; i++) {
        	System.out.println(match[i] + " -> " + i);
        }
    }
    public static boolean bmp(int[][] matrix, int u, boolean[] seen, int[] match) {
    	for(int i = 0; i < matrix[0].length; i++) {
    		if(matrix[u][i] > 0 && !seen[i]) {
    			seen[i] = true;
    			if(match[i] < 0 || bmp(matrix, match[i], seen, match)) {
    				match[i] = u;
    				return true;
    			}
    		}
    	}
    	return false;
    }
    public static void main(String[] args) {
    	int[][] table = {{0,2,0},{3,0,1},{2,4,0}};
    	assign(table);
    }
}