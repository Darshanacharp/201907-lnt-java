package app.directory.tree;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path= args.length>0? args[0] : ".";
		
		DirectoryTree tree=new DirectoryTree(path);
		
		tree.print();
		
		
	}

}
