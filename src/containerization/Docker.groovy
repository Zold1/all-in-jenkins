package containerization

class Docker implements Serializable {
  def script
  
  Docker(script) {
    this.script = script
    /*script.sh "sudo yum update -y && sudo yum install -y docker"
    script.sh "sudo systemctl start docker"
    script.sh "sudo usermod -aG docker jenkins"*/
    
  }

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
  
  def buildDockerImage(String imageName) {
    script.echo "building the docker image..."
    //script.sh "docker build -t $imageName ."
    script.sh readFile("scripts.sh")
  }
  
  def dockerLogin() {
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-credentials', usernameVariable: USER, passwordVariable: PASS)]) {
      script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
    }
  }
  
  def dockerPush(String $imageName) {
    script.sh "docker push $imageName"

    // Read text from a file.
  }
}