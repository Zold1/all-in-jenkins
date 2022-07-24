import Docker

def call(Map config) {
  def docker = new Docker(config)
  docker.build()
  docker.login()
  docker.push(imageName)
}
