/* Shreyash Appikatla cs610 6456 prp */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Hits6456 {

	private static int i,k,init;
	private static int Vertices;
	private static int Edges;

	public static void main(String args[]) throws NumberFormatException, IOException {
		DirectedGraph6456 digraph = null;
		    k = Integer.parseInt(args[0]);
        init = Integer.parseInt(args[1]);
	  String filename = args[2];
    FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedstream = new BufferedReader(fileReader);
              String line=null;
	            while((line=bufferedstream.readLine()) !=null){
	    	    	String[] str=line.split(" ");	
			    	if(i==0){ //If first line
			    		Vertices=Integer.parseInt(str[0]);
			    		Edges=Integer.parseInt(str[1]);
			    		digraph = new DirectedGraph6456(Vertices);
			    	}else{ // For all other Lines	    		
			    		int u=Integer.parseInt(str[0]);
			    		int v=Integer.parseInt(str[1]);
			    		digraph.createdge(u,v);			    		
			    	}
			    	i++;
	            }
	            digraph.settpara(k,init);
	            digraph.hitscalculate();
	            bufferedstream.close();
	}
	
}
