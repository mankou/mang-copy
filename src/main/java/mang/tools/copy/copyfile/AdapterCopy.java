package mang.tools.copy.copyfile;

import java.util.ArrayList;
import java.util.List;

public abstract class AdapterCopy implements CopyFile {
	private List<String> source=new ArrayList<String>();
	
	private List<String> dest=new ArrayList<String>();

	@Override
	public void addSource(String source) {
		this.source.add(source);
	}

	@Override
	public void addDest(String destDir) {
		this.dest.add(destDir);
	}

	@Override
	public abstract void doCopy();

	public List<String> getSource() {
		return source;
	}

	public List<String> getDest() {
		return dest;
	}


}
