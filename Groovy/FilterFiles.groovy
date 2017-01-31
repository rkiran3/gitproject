def pattern = ".*txt\$"
File dir = new File("C:\\Users\\ravikir\\Dropbox\\y")

def filter = new FilenameFilter() {
	boolean accept(File path, String filename) {
		return filename.matches(pattern)
	}
}

println dir.list(filter)
