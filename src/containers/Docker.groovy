package containers

class Docker implements Serializable {
  def script
  
  Docker(script) {
    this.script = script
  }

  def buildDockerImage(String imageName) {
    script.echo "building the docker image..."
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-account', usernameVariable: USER, passwordVariable: PASS)]) {
      script.sh "docker build -t $imageName ."
      script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
      script.sh "docker push $imageName"
    }
  }
  
  def build(String imageName) {
    script.echo "building the docker image..."
    script.sh "docker build -t $imageName ."
  }
  
  def login() {
    script.echo "logging in to docker..."
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-account', usernameVariable: USER, passwordVariable: PASS)]) {
      script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
    }
  }
  
  def push(String $imageName) {
    script.echo "pushing the docker image..."
    script.sh "docker push $imageName"
  }
}