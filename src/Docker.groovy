class Docker implements Serializable {
  def script
  
  Docker(script) {
    this.script = script
  }
  
  def build(String imageName) {
    script.echo "building the docker image..."
    script.sh "docker build -t $imageName ."
  }
  
  def login() {
    script.echo "logging to docker..."
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-account', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
      script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
    }
  }
  
  def push(String imageName) {
    script.sh "docker push $imageName"
  }
}