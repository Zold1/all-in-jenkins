class Docker implements Serializable {
  def script
  
  Docker(script) {
    this.script = script
  }
  
  def build(String imageName) {
    script.echo "building the docker image"
    script.sh "docker build -t ${imageName} /var/jenkins_home/workspace/forex/fxcollect"
  }
  
  def login() {
    script.echo "logging to docker..."
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-account', usernameVariable: 'username', passwordVariable: 'password')]) {
      script.sh "echo $script.password | docker login -u $script.username --password-stdin"
    }
  }
  
  def push(String imageName) {
    script.echo "pushing the docker image"
    script.sh "docker push ${imageName}"
  }
}
