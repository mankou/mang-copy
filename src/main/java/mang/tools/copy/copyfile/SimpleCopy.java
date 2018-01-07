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
		FileUtil.forceMkdir(processDest);
		FileUtil.copyFoldfilesToAnotherFold(source, processDest);
	}

	public String processDest(String dest) {
		return dest;
	}

}
