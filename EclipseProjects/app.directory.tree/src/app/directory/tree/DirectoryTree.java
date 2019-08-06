package app.directory.tree;

import java.io.File;

public class DirectoryTree {
	
	File root;
	
	public DirectoryTree() {
		this(".");
	}
	
	public DirectoryTree(String rootPath) {
		this.root=new File(rootPath);
	}
	

	public void print() {
		// TODO Auto-generated method stub
		System.out.println(root.getAbsolutePath());
		printTree(root,"");
	}

	private void printTree(File dir, String indent) {
		// TODO Auto-generated method stub
		System.out.printf("%s[ %s ]\n",indent, dir.getName());
		
		File [] children= dir.listFiles();
		indent+="\t";
		
		for(File child : children) {
			if(child.isFile()) {
				System.out.printf("%s ( %s )\n",indent, child.getName());
			}
			else if(child.getName().equals(".") || child.getName().equals(".."))
				continue; //ignore special symoblic name
			else
				printTree(child, indent);
		}
		
		
	}
	
	
	
	
	

}
