
/* Shreyash Appikatla cs610 6456 prp */
public class DirectedGraph6456 {
	double[][] graph;
	double[] a,preva;
	double[] h,prevh;
	double[] initial,pr,prevpr,prex;
	int vertex,counter=0;
	private double count,count1,d=0.85,errorrate = 0.00005;
	private double[] h1;
	public DirectedGraph6456(int vertices) {
		// TODO Auto-generated constructor stub
		vertex = vertices;
		graph = new double[vertices][vertices];
		a = new double[vertices];
		h = new double[vertices];
		pr = new double[vertices];
		preva = new double[vertices];
		prevh = new double[vertices];
		prevpr = new double[vertices];
 		initial = new double[vertices];
 		prex = new double[vertices];
 		h1 = new double[vertices];
		for(int i=0;i<vertices;i++) {
			for(int j=0;j<vertices;j++) {
					graph[i][j]=0;
			}
		}
	}
	public void createdge(int u, int v) {
		// TODO Auto-generated method stub
		graph[u][v]=1;
		a[v]++;
		h[u]++;
		h1[u]++;
		//System.out.println(h[u]+" "+u);
		
	}
	public void printmatrix(int k) {
		// TODO Auto-generated method stub
	if(k==0&&vertex<10) {
		System.out.print("Base :"+k);
		for(int i=0;i<vertex;i++) {
			System.out.print(" [A/H]"+"["+i+"]="+a[i]+"/"+h[i]);
		}System.out.println();		
	}else if(k==0&&vertex>=10) {
		System.out.print("Base :"+k);
		for(int i=0;i<vertex;i++) {
			System.out.println(" [A/H]"+"["+i+"]="+a[i]+"/"+h[i]);
		}System.out.println();
	}
	if(vertex<10&&k!=0){
		System.out.print("Iter :"+k);
		for(int i=0;i<vertex;i++) {
			System.out.print(" [A/H]"+"["+i+"]="+a[i]+"/"+h[i]);
		}
		System.out.println();
	}else if(k!=0){
		System.out.println("Iter :"+k);
		for(int i=0;i<vertex;i++) {
			System.out.println(" [A/H]"+"["+i+"]="+a[i]+"/"+h[i]);
		}System.out.println();
	}
		
		
	}
	public void hitscalculate() {
		// TODO Auto-generated method stub
		printmatrix(0);
		int o=0;
		do{
			o++;
			 counter=0;
			 for(int i=0;i<vertex;i++) {
				 preva[i]=a[i];
				 prevh[i]=h[i];
			 }		 
			 if(o==1) {
				 for(int i=0;i<vertex;i++) {
					 a[i]=0;
					 h[i]=0;
				 }
				 firstiteration();
				 printmatrix(o);
			 }else {
				 seconditeration();	
			printmatrix(o);
			 }
			}while(check());
	}
	
 
private boolean check() {
	boolean val = true;
	int count=0;
	for(int i=0;i<vertex;i++) {
		if((Math.abs((prevh[i]-h[i]))<errorrate)||(Math.abs((preva[i]-a[i]))<errorrate)) {
			count++;
		}
	}
	if(count==vertex)
		return false;
	return val;
}
	
	private void seconditeration() {
		// TODO Auto-generated method stub
		count=0;
		count1=0;
		for(int i=0;i<vertex;i++) {
			count+=(a[i]*a[i]);
			count1+=(h[i]*h[i]);
		}
		for(int i=0;i<vertex;i++) {
			a[i]=a[i]/(Math.sqrt(count));
			h[i]=h[i]/(Math.sqrt(count1));
		}
	}
	private void firstiteration() {
		// TODO Auto-generated method stub
		for(int i=0;i<vertex;i++) {
			for(int j=0;j<vertex;j++) {
				a[i]+=(initial[j]*graph[j][i]);
			}
		}
		for(int i=0;i<vertex;i++) {
			for(int j=0;j<vertex;j++) {
				h[i]+=(a[j]*graph[i][j]);
			}
		}		
	}
	public void settpara(int k, int init) {
		double initval=init;		
		// TODO Auto-generated method stub
		if(vertex>10){
			initval=0;
			initval-=1.00000;
		}
		if(initval==0){
			initval=0.00000;
		}else if(initval==1){
			initval=1.00000;
		}else if(initval==-1){
			initval=(1.00000)/vertex;
		}else if(initval==-2){
			initval=(1.00000)/(Math.sqrt(vertex));
		}
		for(int i=0;i<vertex;i++) {
			initial[i] = initval;
			a[i]=initval;
			h[i]=initval;
			pr[i]=initval;
		}
		if(k!=0&&k<0)
		errorrate = Math.pow(10,k);
	}
	
	public void pagerank() {
		// TODO Auto-generated method stub
		int o=0;
		for(int i=0;i<vertex;i++) {
			 prevpr[i]=pr[i];
		 }	
		printmatrixpr(o);
		
		do{
			o++;
			 counter=0;
			  for(int i=0;i<vertex;i++) {
				 pr[i]=0;
				 prex[i]=0;
			 }
				 firstiterationpr();	
	//			 System.out.println(o);
			printmatrixpr(o);
			}while(checkpr());
	
	}
	private void printmatrixpr(int o) {
		// TODO Auto-generated method stub
		if(o==0&&vertex<10) {
			System.out.print("Base :"+o);
			for(int i=0;i<vertex;i++) {
				System.out.print(" P"+"["+i+"]="+pr[i]);
			}System.out.println();		
		}else if(o==0&&vertex>=10) {
			System.out.print("Base :"+o);
			for(int i=0;i<vertex;i++) {
				System.out.println(" P"+"["+i+"]="+pr[i]);
			}System.out.println();
		}
		if(vertex<10&&o!=0){
			System.out.print("Iter :"+o);
			for(int i=0;i<vertex;i++) {
				System.out.print(" P"+"["+i+"]="+pr[i]);
			}
			System.out.println();
		}else if(o!=0){
			System.out.println("Iter :"+o);
			for(int i=0;i<vertex;i++) {
				System.out.println(" P"+"["+i+"]="+pr[i]);
			}System.out.println();
		}
			

		
	}
	private boolean checkpr() {
		// TODO Auto-generated method stub
		boolean vals = true;
		int count=0;
		for(int i=0;i<vertex;i++) {
		if(Math.abs(prevpr[i]-pr[i])<errorrate) {
			count++;
		//System.out.println(count);
		}
		}
		if(count==vertex)
			return false;
		return vals;
	}
	private void firstiterationpr() {
		// TODO Auto-generated method stub
		for(int i=0;i<vertex;i++) {
			for(int j=0;j<vertex;j++) {
				if(graph[j][i]==1) {
					prex[i]+=(prevpr[j]/h1[j]);
				}
			}
			pr[i]=(1-d)+d*prex[i];
			prevpr[i]=pr[i];
		}
	}
}
