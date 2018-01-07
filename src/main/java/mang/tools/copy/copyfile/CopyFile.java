package mang.tools.copy.copyfile;

public interface CopyFile {
	//添加源 
	public void addSource(String source);
	
	//可添加多个目标
	public void addDest(String destDir);
	
	
	//然后才是拷备
	public void doCopy();
}
