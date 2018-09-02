/* Shreyash Appikatla cs610 6456 prp */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Pagerank6456 {
	private static int i,k,init;
	private static int Vertices;
	private static int Edges;

	public static void main(String args[]) throws NumberFormatException, IOException {
	String filename = args[2];
	DirectedGraph6456 digraph = null;
	  k = Integer.parseInt(args[0]);
    init = Integer.parseInt(args[1]);
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
         //   digraph.creatmatrix();
           digraph.settpara(k, init);
           digraph.pagerank();
           bufferedstream.close();
	}
    
}
