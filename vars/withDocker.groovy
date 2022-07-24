import Docker

def call(Map config) {
  /*def docker = new Docker(imageName)
  docker.build()
  docker.login()
  docker.push(imageName)*/
  sh "echo Hello world"
  sh "echo ${config}"
}
