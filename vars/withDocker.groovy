import Docker

def call(String imageName) {
  def docker = new Docker(imageName)
  docker.build()
  docker.login()
  docker.push(imageName)
}
