import containers.Docker

def call(String imageName) {
    /*def docker = new Docker(this)
    docker.build()
    docker.login()*/
    //return new Docker(this).buildDockerImage(imageName)
    script.echo "building the docker image..."
    script.withCredentials([script.usernamePassword(credentialsId: 'docker-account', usernameVariable: USER, passwordVariable: PASS)]) {
      script.sh "docker build -t $imageName ."
      script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
      script.sh "docker push $imageName"
    }
}