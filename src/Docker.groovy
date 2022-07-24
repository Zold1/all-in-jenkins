class Docker implements Serializable {
  def script
  def config
  
  Docker(script, Map config) {
    this.script = script
    this.config = config
  }
  
  def build() {
    script.echo "building the docker image"
    script.sh "docker build -t ${config.imageName} ."
  }
  
  def login() {
    script.echo "logging to docker..."
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-account', usernameVariable: 'username', passwordVariable: 'password')]) {
      script.sh "echo $script.password | docker login -u $script.username --password-stdin"
    }
  }
  
  def push(String imageName) {
    script.echo "pushing the docker image"
    script.sh "docker push $imageName"
  }
}