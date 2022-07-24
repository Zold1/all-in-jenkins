import Docker

def call() {
  def docker = new Docker(this, Map config)
  docker.build()
  docker.login()
  docker.push(imageName)
}
