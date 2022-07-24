import Docker

def call(String imageName) {
  def docker = new Docker(imageName)
  docker.build(imageName)
  docker.login()
  docker.push(imageName)
}
