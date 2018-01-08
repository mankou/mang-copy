package mang.tools.copy.copyfile;

import java.io.File;
import java.util.List;
import mang.util.common.FileUtil;

public class SimpleCopy extends AdapterCopy {

	@Override
	public void doCopy() {
		List<String> sourceList = this.getSource();
		List<String> destList = this.getDest();
		for (String source : sourceList) {
			for (String dest : destList) {
				File sourceFile = new File(source);
				if (sourceFile.isDirectory()) {
					realCopyDirectoryFilesToDestDirectory(source, dest);
				}
			}
		}
	}

	public void realCopyDirectoryFilesToDestDirectory(String source, String dest) {
		String processDest = this.processDest(dest);
		//如果源目录存在 并且源目录下有文件才拷备 否则不拷备
		if(isHaveFiles(source)){
			FileUtil.forceMkdir(processDest);
			FileUtil.copyFoldfilesToAnotherFold(source, processDest);
		}
	}
	
	private boolean isHaveFiles(String path){
		File sourceFile=new File(path);
		if(sourceFile.exists()){
			String[] files=sourceFile.list();
			if(files!=null && files.length>0){
				return true;
			}
		}
		return false;
	}

	public String processDest(String dest) {
		return dest;
	}

}
