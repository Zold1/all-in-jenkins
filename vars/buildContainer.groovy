import containers.Docker

def call(String imageName) {
    /*def docker = new Docker(this)
    docker.build()
    docker.login()*/
    //return new Docker(this).buildDockerImage(imageName)
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-account', usernameVariable: USER, passwordVariable: PASS)]) {
      sh "docker build -t $imageName ."
      sh "echo $PASS | docker login -u $USER --password-stdin"
      sh "docker push $imageName"
    }
}