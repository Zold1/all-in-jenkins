package containerization

class Docker implements Serializable {
  def script
  
  Docker(script) {
    this.script = script
    /*script.sh "sudo yum update -y && sudo yum install -y docker"
    script.sh "sudo systemctl start docker"
    script.sh "sudo usermod -aG docker jenkins"*/
    /*script.sh """
    if command -v apt >/dev/null; then
      echo "apt is used here"
    elif command -v yum >/dev/null; then
      echo "yum is used here"
    else
      echo "I have no Idea what im doing here"
    fi
    """*/
  }
  
  def buildDockerImage(String imageName) {
    script.echo "building the docker image..."
    //script.sh "docker build -t $imageName ."
  }
  
  def dockerLogin() {
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-credentials', usernameVariable: USER, passwordVariable: PASS)]) {
      script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
    }
  }
  
  def dockerPush(String $imageName) {
    script.sh "docker push $imageName"
  }
}