def readFile(String fileName) {
  File file = new File(fileName)
  StringBuilder sb = new StringBuilder()
  try {
    BufferedReader br = new BufferedReader(new FileReader(file))
    String line;
    while ((line = br.readLine()) != null) {
      sb.append(line)
      sb.append("\n")
    }
    br.close()
  } catch (IOException e) {
    e.printStackTrace()
  }
  return sb.toString()
}