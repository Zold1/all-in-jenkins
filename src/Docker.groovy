class Docker implements Serializable {
  def script
  //Map config
  String imageName
  
  Docker(script, String imageName) {
    this.script = script
    this.config = config
    this.imageName = imageName
  }
  
  def build() {
    script.echo "building the docker image"
    script.sh "docker build -t ${imageName} ."
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